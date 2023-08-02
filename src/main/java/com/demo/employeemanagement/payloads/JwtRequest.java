package com.demo.employeemanagement.payloads;

import lombok.*;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
