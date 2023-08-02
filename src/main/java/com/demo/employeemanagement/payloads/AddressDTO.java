package com.demo.employeemanagement.payloads;

import com.demo.employeemanagement.entities.Address;
import com.demo.employeemanagement.utilities.AddressType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private AddressType addressType;
    private String city;
    private String country;
    private String postalCode;
    private String state;
    private String street;

    public AddressDTO(Address address) {
        this.addressType = address.getAddressType();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.postalCode = address.getPostalCode();
        this.state = address.getState();
        this.street = address.getStreet();
    }
}
