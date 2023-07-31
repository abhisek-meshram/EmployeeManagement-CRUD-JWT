package com.demo.employeemanagement.utilities;

public enum AddressType {
    PERMANENT(1), OFFICE(2), RESIDENTIAL(3);

    private int value;
    private AddressType(int value){
        this.value=value;
    }
}
