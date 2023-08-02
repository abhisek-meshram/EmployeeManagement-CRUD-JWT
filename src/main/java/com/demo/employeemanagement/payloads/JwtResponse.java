package com.demo.employeemanagement.payloads;

import lombok.*;

@Data
@Builder
public class JwtResponse {
    private String jwtToken;
    private String username;
}
