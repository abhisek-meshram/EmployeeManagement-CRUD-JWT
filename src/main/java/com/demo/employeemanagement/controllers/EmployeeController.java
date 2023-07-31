package com.demo.employeemanagement.controllers;

import com.demo.employeemanagement.payloads.ApiResponse;
import com.demo.employeemanagement.payloads.EmployeeDTO;
import com.demo.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO = this.employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> employeeDTOList = this.employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeDTOList,HttpStatus.OK);
    }
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("empId") Long empId){
        EmployeeDTO employeeDTO = this.employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
    }
    @PutMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long empId) {
        employeeDTO = this.employeeService.updateEmployee(employeeDTO,empId);
        return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
    }

    @PostMapping("/{empId}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable("empId") Long empId){
        this.employeeService.deleteEmployee(empId);
        return new ResponseEntity<>(new ApiResponse("Employee Deleted",Boolean.TRUE),HttpStatus.OK);
    }
}
