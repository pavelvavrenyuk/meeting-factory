package com.learning.meetingfactory.domain.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.learning.meetingfactory.domain.dto.GroupRecordDto;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
@Log4j2
public abstract class GroupRecordMapper {

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public List<GroupRecordDto> map(JsonNode node) {
        if (node != null) {
            try {
                return objectMapper.readValue(
                        node.toString(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, GroupRecordDto.class)
                );
            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public ArrayNode map(List<GroupRecordDto> list) {
        if (list != null) {
            return objectMapper.valueToTree(list);
        }
        return null;
    }

}