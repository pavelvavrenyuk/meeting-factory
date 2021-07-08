package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.EmployeeDto;
import com.learning.meetingfactory.domain.mapper.EmployeeMapper;
import com.learning.meetingfactory.exception.ErrorMessages;
import com.learning.meetingfactory.persistence.repository.EmployeeRepository;
import com.learning.meetingfactory.persistence.model.Employee;
import com.learning.meetingfactory.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> findAllOrderByLastName() {
        List<EmployeeDto> employeeDTOS = employeeRepository.findAllByOrderByLastNameAsc()
                .stream()
                .map(EmployeeMapper.INSTANCE::toEmployeeDto)
                .collect(Collectors.toList());

        return employeeDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDto findById(int id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        ErrorMessages.EMPLOYEE_WITH_ID_DOES_NOT_EXIST, id)));

        return EmployeeMapper.INSTANCE.toEmployeeDto(employee);
    }


    @Override
    public EmployeeDto create(@Valid EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);
        employee = employeeRepository.save(employee);

        return EmployeeMapper.INSTANCE.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto update(@Valid EmployeeDto employeeDto, int id) {
        return patch(employeeDto, id);
    }

    @Override
    public EmployeeDto patch(EmployeeDto employeeDto, int id) {

        EmployeeDto updated = employeeRepository.findById(id)
                .map(employee -> EmployeeMapper.INSTANCE.updateEmployee(employeeDto, employee))
                .map(EmployeeMapper.INSTANCE::toEmployeeDto)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format(ErrorMessages.EMPLOYEE_WITH_ID_DOES_NOT_EXIST, id))
                );

        return updated;
    }

    @Override
    public void deleteById(int id) {

        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.EMPLOYEE_WITH_ID_DOES_NOT_EXIST, id));
        }

        employeeRepository.deleteById(id);
    }
}
