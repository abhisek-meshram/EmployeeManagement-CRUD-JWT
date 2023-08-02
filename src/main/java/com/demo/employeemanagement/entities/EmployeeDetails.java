package com.demo.employeemanagement.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee_details")
@Data
@NoArgsConstructor
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal salary;

    private int age;

    private String gender;

    @Column(name = "joining_date")
    private Date joiningDate;

    public EmployeeDetails(BigDecimal salary,int age,String gender,Date joiningDate) {
        this.salary  = salary;
        this.age = age;
        this.gender = gender;
        this.joiningDate = joiningDate;
    }
}
