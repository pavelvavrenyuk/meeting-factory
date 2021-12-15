package com.learning.meetingfactory.web.controller;

import com.learning.meetingfactory.domain.dto.EmployeeDto;
import com.learning.meetingfactory.service.EmployeeService;
import com.learning.meetingfactory.web.swagger.EmployeeControllerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements EmployeeControllerEndpoint {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> getAllEmployees(){

        return employeeService.findAllOrderByLastName();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")  int id){

        EmployeeDto employee = employeeService.findById(id);

        return ResponseEntity.ok(employee);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employee){

        employee = employeeService.create(employee);

        return ResponseEntity.ok(employee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto){

        employeeDto.setId(id);
        employeeService.update(employeeDto, id);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEmployee(@PathVariable int id){

        employeeService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
