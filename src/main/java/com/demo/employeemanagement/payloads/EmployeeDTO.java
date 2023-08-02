package com.demo.employeemanagement.payloads;

import com.demo.employeemanagement.entities.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDTO {

    private Long empId;
    private String firstName;
    private String middleName;
    private String lastName;

    private String email;
    private BigDecimal salary;
    private int age;
    private String gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date joiningDate;

    private List<AddressDTO> addresses = new ArrayList<>();
    public EmployeeDTO(Employee employee){
        this.empId = employee.getEmpId();
        this.firstName = employee.getFirstName();
        this.middleName = employee.getMiddleName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.salary = employee.getEmployeeDetails().getSalary();
        this.age = employee.getEmployeeDetails().getAge();
        this.gender = employee.getEmployeeDetails().getGender();
        this.joiningDate = employee.getEmployeeDetails().getJoiningDate();

        if (!employee.getAddresses().isEmpty()) {
            employee.getAddresses().forEach(address ->
                this.addresses.add(new AddressDTO(address))
            );
        }
    }
}
