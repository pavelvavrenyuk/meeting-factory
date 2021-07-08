package com.learning.meetingfactory.domain.mapper;

import com.learning.meetingfactory.domain.dto.MeetingDto;
import com.learning.meetingfactory.persistence.model.Meeting;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MeetingMapper {

    MeetingMapper INSTANCE = Mappers.getMapper(MeetingMapper.class);

    @Mapping(target = "employee", source = "employeeId", ignore = true)
    Meeting toMeeting(MeetingDto meetingDto);

    @Mapping(target = "employeeId", source = "employee.id")
    MeetingDto toMeetingDto(Meeting meeting);

    Meeting updateMeeting(MeetingDto meetingDto, @MappingTarget Meeting meeting);
}
