package com.udacity.jdnd.course3.critter.user.modelo;

import com.udacity.jdnd.course3.critter.ModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends ModelMapper<Employee, EmployeeDTO> {

    EmployeeRequest toEntity(EmployeeRequestDTO employeeRequestDTO);
}
