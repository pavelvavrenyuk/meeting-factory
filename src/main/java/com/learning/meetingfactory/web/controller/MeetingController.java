package com.learning.meetingfactory.web.controller;

import com.learning.meetingfactory.domain.dto.MeetingDto;
import com.learning.meetingfactory.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDto> getMeetingById(@PathVariable("id")  int id){
        MeetingDto meeting = meetingService.findById(id);
        return ResponseEntity.ok(meeting);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<MeetingDto>> getMeetingsByEmployeeId(@PathVariable("employeeId")  int employeeId){

        List<MeetingDto> meetings = meetingService.getMeetingsForEmployee(employeeId);
        return ResponseEntity.ok(meetings);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MeetingDto> addMeeting(/*@Valid*/ @RequestBody MeetingDto meeting){

        meeting = meetingService.create(meeting);

        return ResponseEntity.ok(meeting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMeeting(@PathVariable int id, @RequestBody MeetingDto meetingDto){

        meetingDto.setId(id);
        meetingService.update(meetingDto, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMeeting(@PathVariable int id){

        meetingService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
