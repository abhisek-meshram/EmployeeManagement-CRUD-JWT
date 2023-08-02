package com.demo.employeemanagement.services;

import com.demo.employeemanagement.payloads.EmployeeDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeById(Long empId);
    void updateEmployee(@RequestBody EmployeeDTO employeeDTO, Long empId);
    void deleteEmployee(Long empId);

}
