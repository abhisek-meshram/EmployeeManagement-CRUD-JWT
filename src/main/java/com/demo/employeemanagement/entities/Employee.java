package com.demo.employeemanagement.entities;

import com.demo.employeemanagement.payloads.EmployeeDTO;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id",unique = true,nullable = false)
    private Long empId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_detail", referencedColumnName = "id")
    private EmployeeDetails employeeDetails;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Employee(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.middleName = employeeDTO.getMiddleName();
        this.lastName = employeeDTO.getLastName();
        this.employeeDetails = new EmployeeDetails(employeeDTO.getSalary(),
                employeeDTO.getAge(),employeeDTO.getGender(),employeeDTO.getJoiningDate());
        employeeDTO.getAddresses().forEach( addressDTO ->
            this.addresses.add(new Address(addressDTO,this)));
    }


}
