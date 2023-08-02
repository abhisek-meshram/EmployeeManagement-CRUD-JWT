package com.demo.employeemanagement.entities;

import com.demo.employeemanagement.payloads.AddressDTO;
import com.demo.employeemanagement.utilities.AddressType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private Employee employee;

    @Column(name = "type")
    private AddressType addressType;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    public Address(AddressDTO addressDTO,Employee employee) {
        this.employee = employee;
        this.addressType = addressDTO.getAddressType();
        this.city = addressDTO.getCity();
        this.country = addressDTO.getCountry();
        this.postalCode = addressDTO.getPostalCode();
        this.state = addressDTO.getState();
        this.street = addressDTO.getStreet();
    }
}
