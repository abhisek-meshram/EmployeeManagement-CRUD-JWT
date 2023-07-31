package com.demo.employeemanagement.services.impl;

import com.demo.employeemanagement.entities.Address;
import com.demo.employeemanagement.entities.Employee;
import com.demo.employeemanagement.exceptions.ResourceNotFoundException;
import com.demo.employeemanagement.payloads.EmployeeDTO;
import com.demo.employeemanagement.repositories.EmployeeRepository;
import com.demo.employeemanagement.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        List<Address> address = employeeDTO.getAddresses()
                .stream().map( addressDTO -> modelMapper.map(addressDTO , Address.class )).toList();
        employee.setAddresses(address);
        Employee finalEmployee = employee;
        address.forEach(address1 -> address1.setEmployee(finalEmployee));
        employee = this.employeeRepository.save(employee);
        employeeDTO = modelMapper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employeeList = this.employeeRepository.findAll();
        return employeeList.stream()
                .map(employee -> modelMapper.map(employee,EmployeeDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long empId) {
        Employee employee = this.employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employee","empId",empId));
        return modelMapper.map(employee,EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long empId) {
        Employee employee = this.employeeRepository
                .findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee","empId",empId));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        updateEmployeeDetails(employee, employeeDTO);
        //TODO handle address in new API or same
        this.employeeRepository.save(employee);
        return this.modelMapper.map(employee,EmployeeDTO.class);
    }

    private void updateEmployeeDetails(Employee employee, EmployeeDTO employeeDTO) {
        employee.getEmployeeDetails().setAge(employeeDTO.getEmployeeDetails().getAge());
        employee.getEmployeeDetails().setGender(employeeDTO.getEmployeeDetails().getGender());
        employee.getEmployeeDetails().setJoiningDate(employeeDTO.getEmployeeDetails().getJoiningDate());
        employee.getEmployeeDetails().setSalary(employeeDTO.getEmployeeDetails().getSalary());
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee = this.employeeRepository
                .findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee","empId",empId));
        this.employeeRepository.delete(employee);
    }
}
