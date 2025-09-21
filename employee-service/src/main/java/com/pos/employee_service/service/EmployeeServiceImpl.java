package com.pos.employee_service.service;

import com.pos.employee_service.dto.APIResponseDto;
import com.pos.employee_service.dto.DepartmentDto;
import com.pos.employee_service.dto.EmployeeDto;
import com.pos.employee_service.entity.Employee;
import com.pos.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
private RestTemplate restTemplate;



    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
      Employee savedEmployee=  employeeRepository.save(employee);

      return new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail(),savedEmployee.getDepartmentCode());

    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        EmployeeDto employeeDto= new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());

        assert employee != null;

        ResponseEntity<DepartmentDto> responseEntity =restTemplate.getForEntity("http://localhost:8081/api/v1/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
        DepartmentDto departmentDto= responseEntity.getBody();



        return new APIResponseDto(employeeDto,departmentDto);

    }


}
