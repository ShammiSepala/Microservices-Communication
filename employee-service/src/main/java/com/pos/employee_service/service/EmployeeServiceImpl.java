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
    //For RestTemplate Internal communication
//private RestTemplate restTemplate;
    //For Web Client Internal Communication
 //   private WebClient webClient;
    private APIClient apiClient;



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

        // For RestTemplate Internal communication
//        assert employee != null;
//
//        ResponseEntity<DepartmentDto> responseEntity =restTemplate.
//        getForEntity("http://localhost:8081/api/v1/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
//        DepartmentDto departmentDto= responseEntity.getBody();

        //Internal Microservices communication with WebClient
//      DepartmentDto departmentDto=  webClient.get()
//                .uri("http://localhost:8081/api/v1/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();//using for synchronized calls

        //Internal Communication with Spring  Cloud Open Feign
        DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());
        return new APIResponseDto(employeeDto,departmentDto);

    }


}
