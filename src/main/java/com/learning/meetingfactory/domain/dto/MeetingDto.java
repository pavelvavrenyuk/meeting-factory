package com.learning.meetingfactory.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotNull(message = "{meeting.date.not.null}")
    private OffsetDateTime date;

    private String questions;

    private String agreements;

    private List<@Valid GroupRecordDto> groupRecords;

    @NotNull(message = "{meeting.employee.id.empty}")
    private int employeeId;
}
