package com.pos.department_service.controller;

import com.pos.department_service.dto.DepartmentDto;
import com.pos.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
   @Autowired
   private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    };

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByID(@PathVariable(value = "department-code") String code) {
       DepartmentDto departmentDto= departmentService.getDepartmentByCode(code);

       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
