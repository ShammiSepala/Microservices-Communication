package com.pos.employee_service.controller;

import com.pos.employee_service.dto.EmployeeDto;
import com.pos.employee_service.entity.Employee;
import com.pos.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping
    ResponseEntity <EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
       EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>( employeeDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    ResponseEntity<EmployeeDto> getAllEmployees(@PathVariable Long id) {

        EmployeeDto employeeDto = employeeService.getEmployeeById(id);

        return new ResponseEntity<> (employeeDto,HttpStatus.OK);

    }

}
