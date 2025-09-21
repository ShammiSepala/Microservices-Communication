package com.pos.employee_service.service;

import com.pos.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081/", value = "department-service")
public interface APIClient {
    @GetMapping("api/v1/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable(value="department-code") String departmentCode);
}
