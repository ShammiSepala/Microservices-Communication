package com.pos.department_service.service.impl;


import com.pos.department_service.dto.DepartmentDto;
import com.pos.department_service.entity.Department;
import com.pos.department_service.repository.DepartmentRepository;
import com.pos.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DepartmentServiceImpl implements DepartmentService {
@Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department= new Department(departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());
        Department savedDepartment= departmentRepository.save(department);

        return new DepartmentDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
       Department department= departmentRepository.findDepartmentByDepartmentCode(departmentCode);
       return new DepartmentDto(department.getId(),
               department.getDepartmentName(),
               department.getDepartmentDescription(),
               department.getDepartmentCode());
    }
}
