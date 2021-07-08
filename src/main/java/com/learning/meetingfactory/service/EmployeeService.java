package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.EmployeeDto;
import com.learning.meetingfactory.persistence.model.Employee;

import java.util.List;

public interface EmployeeService {

//    List<Employee> findAll();

    List<EmployeeDto> findAllOrderByLastName();

    EmployeeDto findById(int id);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto, int id);

    EmployeeDto patch(EmployeeDto employeeDto, int id);

    void deleteById(int id);

}
