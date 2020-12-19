package com.custom.project.meetingfactory.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "First name is a mandatory field")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is a mandatory field")
    @Column(name = "last_name")
    private String lastName;

}
