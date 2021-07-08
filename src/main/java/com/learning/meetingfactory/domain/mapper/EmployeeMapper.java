package com.learning.meetingfactory.domain.mapper;

import com.learning.meetingfactory.domain.dto.EmployeeDto;
import com.learning.meetingfactory.persistence.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);

    Employee updateEmployee(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
