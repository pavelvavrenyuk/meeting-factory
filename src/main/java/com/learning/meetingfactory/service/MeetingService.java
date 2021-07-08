package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.MeetingDto;

import java.util.List;

public interface MeetingService {

    List<MeetingDto> getMeetingsForEmployee(int employeeId);

    MeetingDto getLastMeetingForUser(int employeeId);

    MeetingDto findById(int id);

    MeetingDto create(MeetingDto meetingDto);

    MeetingDto update(MeetingDto meetingDto, int id);

    MeetingDto patch(MeetingDto meetingDto, int id);

    void deleteById(int id);
}
