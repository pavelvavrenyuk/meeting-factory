package com.custom.project.meetingfactory.persistence.repository;

import com.custom.project.meetingfactory.persistence.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
        List<Employee> findAllByOrderByLastNameAsc();
}
