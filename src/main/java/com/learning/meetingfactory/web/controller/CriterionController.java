package com.learning.meetingfactory.web.controller;

import com.learning.meetingfactory.domain.dto.CriterionDto;
import com.learning.meetingfactory.service.CriterionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/criteria")
public class CriterionController {

    @Autowired
    CriterionService criterionService;

    @GetMapping("/{id}")
    public ResponseEntity<CriterionDto> getCriterionById(@PathVariable("id")  int id){
        CriterionDto criterionDto = criterionService.findById(id);
        return ResponseEntity.ok(criterionDto);
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<CriterionDto>> getCriteriaByGroupId(@PathVariable("groupId")  int groupId){

        List<CriterionDto> criteria = criterionService.getCriteriaForGroup(groupId);
        return ResponseEntity.ok(criteria);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CriterionDto> addCriterion(@Valid @RequestBody CriterionDto criterionDto){

        criterionDto = criterionService.create(criterionDto);

        return ResponseEntity.ok(criterionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCriterion(@PathVariable int id, @RequestBody CriterionDto criterionDto){

        criterionDto.setId(id);
        criterionService.update(criterionDto, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCriterion(@PathVariable int id){

        criterionService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
