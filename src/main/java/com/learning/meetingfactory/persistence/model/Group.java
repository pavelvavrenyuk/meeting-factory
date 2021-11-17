package com.learning.meetingfactory.persistence.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "criteria")
@ToString(exclude = "criteria")
@Entity
@Table(name = "group_of_criteria")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Group name is a mandatory field")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = {CascadeType.ALL})
    private List<Criterion> criteria;
}
