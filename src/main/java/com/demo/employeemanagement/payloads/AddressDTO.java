package com.demo.employeemanagement.payloads;

import com.demo.employeemanagement.utilities.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private AddressType addressType;
    private String city;
    private String country;
    private String postalCode;
    private String state;
    private String street;

}
