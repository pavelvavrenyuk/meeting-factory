package com.learning.meetingfactory.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupRecordDto {

    @NotBlank(message = "{group.name.mandatory}")
    private String name;

    private List<@Valid CriterionRecordDto> criteria;
}
