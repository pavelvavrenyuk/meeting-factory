package com.learning.meetingfactory.domain.mapper;

import com.learning.meetingfactory.domain.dto.CriterionDto;
import com.learning.meetingfactory.domain.dto.GroupDto;
import com.learning.meetingfactory.persistence.model.Criterion;
import com.learning.meetingfactory.persistence.model.Group;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CriterionMapper {

    CriterionMapper INSTANCE = Mappers.getMapper(CriterionMapper.class);

    @Mapping(target = "group", source = "groupId", ignore = true)
    Criterion toCriterion(CriterionDto criterionDto);

    @Mapping(target = "groupId", source= "group.id")
    CriterionDto toCriterionDto(Criterion criterion);

    Criterion updateCriterion(CriterionDto criterionDto, @MappingTarget Criterion criterion);
}
