package com.custom.project.meetingfactory.service;

import com.custom.project.meetingfactory.persistence.model.Employee;

import java.util.List;

public interface EmployeeService {

//    List<Employee> findAll();

    List<Employee> findAllOrderByLastName();

    Employee findById(int id);

    void create(Employee employee);

    void update(Employee employee);

    void deleteById(int id);

}
