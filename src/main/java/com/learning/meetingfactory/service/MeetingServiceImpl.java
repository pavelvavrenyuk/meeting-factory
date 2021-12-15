package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.MeetingDto;
import com.learning.meetingfactory.domain.mapper.MeetingMapper;
import com.learning.meetingfactory.exception.ErrorMessages;
import com.learning.meetingfactory.persistence.model.Employee;
import com.learning.meetingfactory.persistence.repository.EmployeeRepository;
import com.learning.meetingfactory.persistence.repository.MeetingRepository;
import com.learning.meetingfactory.persistence.model.Meeting;
import com.learning.meetingfactory.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MeetingDto> getMeetingsForEmployee(int employeeId) {

        List<MeetingDto> meetingDTOS = meetingRepository.findByEmployee_IdOrderByDateDesc(employeeId)
                    .stream()
                .map(MeetingMapper.INSTANCE::toMeetingDto)
                .collect(Collectors.toList());

        return meetingDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public MeetingDto getLastMeetingForUser(int employeeId) {
        //todo getLastMeetingForUser
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public MeetingDto findById(int id) {

        Meeting meeting = meetingRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(String.format(
                        ErrorMessages.MEETING_WITH_ID_DOES_NOT_EXIST, id)));

        return MeetingMapper.INSTANCE.toMeetingDto(meeting);
    }

    @Override
    public MeetingDto create(@Valid MeetingDto meetingDto) {

        int employeeId = meetingDto.getEmployeeId();

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorMessages.EMPLOYEE_WITH_ID_DOES_NOT_EXIST, employeeId)));

        Meeting meeting = MeetingMapper.INSTANCE.toMeeting(meetingDto);
        meeting.setEmployee(employee);

        meeting = meetingRepository.save(meeting);

        return MeetingMapper.INSTANCE.toMeetingDto(meeting);
    }

    @Override
    public MeetingDto update(@Valid MeetingDto meetingDto, int id) {
        return patch(meetingDto, id);
    }

    @Override
    public MeetingDto patch(MeetingDto meetingDto, int id) {

        MeetingDto updatedMeetingDto = meetingRepository.findById(id)
                .map(meeting -> MeetingMapper.INSTANCE.updateMeeting(meetingDto, meeting))
                .map(MeetingMapper.INSTANCE::toMeetingDto)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format(ErrorMessages.MEETING_WITH_ID_DOES_NOT_EXIST, id))
                );

        return updatedMeetingDto;
    }

    @Override
    public void deleteById(int id) {
        if (!meetingRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.MEETING_WITH_ID_DOES_NOT_EXIST, id));
        }

        meetingRepository.deleteById(id);
    }
}
