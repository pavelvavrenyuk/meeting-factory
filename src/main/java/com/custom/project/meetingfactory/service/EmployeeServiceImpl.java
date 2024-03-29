package com.custom.project.meetingfactory.service;

import com.custom.project.meetingfactory.dao.EmployeeRepository;
import com.custom.project.meetingfactory.entity.Employee;
import com.custom.project.meetingfactory.exception.EntityNotFoundException;
import com.custom.project.meetingfactory.exception.WrongParameterValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllOrderByLastName() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {

        if(!isIdCorrect(id)){
            throw new WrongParameterValueException("Wrong employee id: "+ id +". It must be more then 0.");
        }

        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee;
        if(result.isPresent()){
            employee = result.get();
        }
        else {
            throw new EntityNotFoundException("Didn't find employee with id: " + id);
        }

        return employee;
    }


    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {

        findById(employee.getId());

        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {

        findById(id);
        employeeRepository.deleteById(id);
    }




    /**
     * Check if id more then 0.
     * @param id Value to check
     * @return true - if value more then 0, false - if equals or less 0
     */
    private boolean isIdCorrect(int id) {
        boolean isCorrect = true;
        if(id <= 0){
            isCorrect = false;
        }

        return isCorrect;
    }
}
