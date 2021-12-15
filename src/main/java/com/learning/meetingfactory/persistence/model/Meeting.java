package com.learning.meetingfactory.persistence.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"employee", "groupRecords"})
@ToString(exclude = {"employee", "groupRecords"})
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)

public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private OffsetDateTime date;

    private String questions;

    private String agreements;

    @Column(columnDefinition = "json")
    @Type(type = "json")
    private JsonNode groupRecords;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
