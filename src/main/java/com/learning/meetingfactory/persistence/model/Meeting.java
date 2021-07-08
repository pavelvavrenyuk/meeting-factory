package com.learning.meetingfactory.persistence.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "employee")
@ToString(exclude = "employee")
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //@NotBlank
    //@JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private OffsetDateTime date;

//    @Column(name = "questions")
//    private String questions;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
