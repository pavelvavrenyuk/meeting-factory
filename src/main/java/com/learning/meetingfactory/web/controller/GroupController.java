package com.learning.meetingfactory.web.controller;

import com.learning.meetingfactory.domain.dto.EmployeeDto;
import com.learning.meetingfactory.domain.dto.GroupDto;
import com.learning.meetingfactory.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GroupDto> getAllGroups(
            @RequestParam(value = "include", required = false) Collection<String> includeAttributes
    ){

        return groupService.getAllGroups(includeAttributes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getGroupById(
            @PathVariable("id")  int id,
            @RequestParam(value = "include", required = false) Collection<String> includeAttributes){

        GroupDto groupDto = groupService.findById(id, includeAttributes);

        return ResponseEntity.ok(groupDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> addGroup(@RequestBody GroupDto groupDto){

        groupDto = groupService.create(groupDto);

        return ResponseEntity.ok(groupDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGroup(@PathVariable int id, @RequestBody GroupDto groupDto){

        groupDto.setId(id);
        groupService.update(groupDto, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeGroup(@PathVariable int id){

        groupService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
