package com.demo.employeemanagement.services.impl;

import com.demo.employeemanagement.entities.Employee;
import com.demo.employeemanagement.exceptions.ResourceNotFoundException;
import com.demo.employeemanagement.payloads.EmployeeDTO;
import com.demo.employeemanagement.repositories.EmployeeRepository;
import com.demo.employeemanagement.services.EmployeeService;
import com.demo.employeemanagement.utilities.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        generateEmail(employee);
        this.employeeRepository.save(employee);
    }

    private void generateEmail(Employee employee) {
        StringBuilder emailBuilder = new StringBuilder();
        String empFName = employee.getFirstName().toLowerCase();
        String empLName = employee.getLastName().toLowerCase();
        emailBuilder.append(empFName)
                .append(".")
                .append(empLName)
                .append("@myorgmail.in");
        employee.setEmail(emailBuilder.toString());
        //TODO: handle duplicate email
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employeeList = this.employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        employeeList.forEach(employee ->
            employeeDTOList.add(new EmployeeDTO(employee))
        );
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long empId) {
        Employee employee = this.employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employee","empId",empId));
        return new EmployeeDTO(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO, Long empId) {
        Employee employee = this.employeeRepository
                .findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employee","empId",empId));
        EmployeeHelper.getEmployeeHelperInstance().dtoToEmployeeMapper(employeeDTO,employee);
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee = this.employeeRepository
                .findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee","empId",empId));
        this.employeeRepository.delete(employee);
    }
}
