package com.learning.meetingfactory.domain.mapper;

import com.learning.meetingfactory.domain.dto.CriterionDto;
import com.learning.meetingfactory.domain.dto.GroupDto;
import com.learning.meetingfactory.persistence.model.Criterion;
import com.learning.meetingfactory.persistence.model.Group;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group toGroup(GroupDto groupDto);

    @Mapping(target = "criteria", ignore = true)
    GroupDto toGroupDto(Group group);

    @Mapping(target = "criteria", source = "group.criteria", qualifiedByName = "includeCriteria")
    GroupDto toGroupDto(Group group, @Context Collection<String> includedAttributes);

    Group updateGroup(GroupDto groupDto, @MappingTarget Group group);


    @Named("includeCriteria")
    static List<CriterionDto> includeCriteria(List<Criterion> criteria, @Context Collection<String> includedAttributes){
        if (includedAttributes == null || !includedAttributes.contains("criteria")) {
            return null;
        }
        return criteria.stream().map(CriterionMapper.INSTANCE::toCriterionDto).collect(Collectors.toList());
    }
}
