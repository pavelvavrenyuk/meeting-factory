package com.custom.project.meetingfactory.web.controller;

import com.custom.project.meetingfactory.persistence.model.Employee;
import com.custom.project.meetingfactory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.findAllOrderByLastName();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(/*@Min (1)*/ @PathVariable("id")  int id){

        Employee employee = employeeService.findById(id);

        return ResponseEntity.ok(employee);
    }


    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){

        employeeService.create(employee);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable int id, @RequestBody Employee employee){

        employee.setId(id);
        employeeService.update(employee);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEmployee(@PathVariable int id){

        employeeService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
