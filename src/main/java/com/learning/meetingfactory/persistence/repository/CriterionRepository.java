package com.learning.meetingfactory.persistence.repository;

import com.learning.meetingfactory.persistence.model.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriterionRepository extends JpaRepository<Criterion, Integer> {

    List<Criterion> findByGroup_Id(int groupId);
}
