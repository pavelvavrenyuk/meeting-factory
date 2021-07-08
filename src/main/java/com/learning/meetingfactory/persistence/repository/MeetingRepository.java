package com.learning.meetingfactory.persistence.repository;

import com.learning.meetingfactory.persistence.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

    // order by Date
    List<Meeting> findByEmployee_IdOrderByDateDesc(int employeeId);
}
