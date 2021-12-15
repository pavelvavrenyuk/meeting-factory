package com.learning.meetingfactory.domain.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.learning.meetingfactory.domain.dto.GroupRecordDto;
import lombok.extern.log4j.Log4j2;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.List;

@Log4j2
@Converter
public class GroupRecordConverter implements AttributeConverter<List<GroupRecordDto>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public String convertToDatabaseColumn(List<GroupRecordDto> groupRecordDtoList) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(groupRecordDtoList);
        } catch (final JsonProcessingException e) {
            log.error("JSON writing error", e);
        }

        return customerInfoJson;
    }

    @Override
    public List<GroupRecordDto> convertToEntityAttribute(String groupRecordJSON) {
        List<GroupRecordDto> groupRecordDtoList = null;
        try {
            groupRecordDtoList = objectMapper.readValue(groupRecordJSON, new TypeReference<List<GroupRecordDto>>() {});
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }

        return groupRecordDtoList;
    }
}
