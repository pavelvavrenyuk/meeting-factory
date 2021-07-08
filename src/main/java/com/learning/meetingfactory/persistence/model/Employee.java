package com.learning.meetingfactory.persistence.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "meetings")
@ToString(exclude = "meetings")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name is a mandatory field")
    private String firstName;

    @NotBlank(message = "Last name is a mandatory field")
    private String lastName;

    // mappedBy if reference to "employee" property in "Employee" class
    // mappedBy tels Hibernate:
    // 1. look at the "employee" property in the "Employee" class
    // 2. Use information from the "Employee" class @JoinColumne
    // 3. Find associated meetings for this employee

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = {CascadeType.ALL})
    private List<Meeting> meetings;
}
