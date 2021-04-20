package com.custom.project.meetingfactory.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = {"meetings"})
//@ToString(exclude = {"meetings"})
@Entity
@Table(name = "employee")
@TypeDef(name = "json", typeClass = JsonStringType.class)
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

    // mappedBy if reference to "employee" property in "Employee" class
    // mappedBy tels Hibernate:
    // 1. look at the "employee" property in the "Employee" class
    // 2. Use information from the "Employee" class @JoinColumne
    // 3. Find associated meetings for this employee
//    @JsonIgnore
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = {CascadeType.ALL})
//    @JsonBackReference
//    @OrderBy("date")
//    private List<Meeting> meetings;
}
