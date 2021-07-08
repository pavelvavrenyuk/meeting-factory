package com.learning.meetingfactory.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.meetingfactory.persistence.model.Meeting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotBlank(message = "{employee.first.name.mandatory}")
    private String firstName;

    @NotBlank(message = "{employee.last.name.mandatory}")
    private String lastName;

    @JsonIgnore
    private List<Meeting> meetings;
}
