package com.pos.department_service.repository;

import com.pos.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentCode(String departmentCode);
}
