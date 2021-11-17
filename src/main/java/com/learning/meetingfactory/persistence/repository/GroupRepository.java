package com.learning.meetingfactory.persistence.repository;

import com.learning.meetingfactory.persistence.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
