package com.pos.employee_service.service;

import com.pos.employee_service.dto.APIResponseDto;
import com.pos.employee_service.dto.DepartmentDto;
import com.pos.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);


}
