package com.learning.meetingfactory.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriterionRecordDto {

    @NotBlank(message = "{criterion.name.mandatory}")
    private String name;

    @Pattern(regexp = "-2|-1|0|1|2", message = "{criterion.record.grade.not.allowed}")
    private String grade;

    private String comment;
}
