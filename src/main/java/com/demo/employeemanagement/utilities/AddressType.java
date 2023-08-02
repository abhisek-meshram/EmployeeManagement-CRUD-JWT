package com.demo.employeemanagement.utilities;

public enum AddressType {
    COMMUNICATION(0), PERMANENT(1);

    private int value;
    private AddressType(int value){
        this.value=value;
    }
}
