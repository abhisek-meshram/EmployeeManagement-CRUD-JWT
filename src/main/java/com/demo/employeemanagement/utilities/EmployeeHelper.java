package com.demo.employeemanagement.utilities;

import com.demo.employeemanagement.entities.Address;
import com.demo.employeemanagement.entities.Employee;
import com.demo.employeemanagement.entities.EmployeeDetails;
import com.demo.employeemanagement.payloads.AddressDTO;
import com.demo.employeemanagement.payloads.EmployeeDTO;

import java.util.List;

public class EmployeeHelper {

    private static EmployeeHelper employeeHelper = null;

    public static EmployeeHelper getEmployeeHelperInstance() {
        if(employeeHelper == null) {
            employeeHelper = new EmployeeHelper();
        }
        return employeeHelper;
    }

    public void dtoToEmployeeMapper(EmployeeDTO employeeDTO, Employee employee) {
        if(employeeDTO.getFirstName() != null )
            employee.setFirstName(employeeDTO.getFirstName());
        if(employeeDTO.getMiddleName() != null )
            employee.setMiddleName(employeeDTO.getMiddleName());
        if(employeeDTO.getLastName() != null )
            employee.setLastName(employeeDTO.getLastName());
        if(employeeDTO.getEmail() != null) {
            employee.setEmail(employeeDTO.getEmail());
        }
        updateEmployeeDetails(employeeDTO, employee.getEmployeeDetails());
        updateEmployeeAddress(employeeDTO,employee.getAddresses());
    }

    private void updateEmployeeAddress(EmployeeDTO employeeDTO, List<Address> addresses) {
        employeeDTO.getAddresses().forEach(addressDTO -> {
                    var communicationAddress = addresses.stream()
                                .filter(address -> address.getAddressType().compareTo(addressDTO.getAddressType()) == 0)
                                .findAny();
                    communicationAddress.ifPresent(address -> updateAddress(address, addressDTO));
                }
        );
    }

    private void updateAddress(Address address, AddressDTO addressDTO) {
        if (addressDTO.getCity() != null)
            address.setCity(addressDTO.getCity());
        if (addressDTO.getCountry() != null)
            address.setCountry(addressDTO.getCountry());
        if (addressDTO.getPostalCode() != null)
            address.setPostalCode(addressDTO.getPostalCode());
        if (addressDTO.getState() != null)
            address.setState(addressDTO.getState());
        if (addressDTO.getStreet() != null)
            address.setStreet(addressDTO.getStreet());
    }

    public void updateEmployeeDetails(EmployeeDTO employeeDTO, EmployeeDetails employeeDetails) {
        employeeDetails.setAge(employeeDTO.getAge());
        if(employeeDTO.getSalary() != null)
            employeeDetails.setSalary(employeeDTO.getSalary());
        if(employeeDTO.getGender() != null)
            employeeDetails.setGender(employeeDTO.getGender());
        if(employeeDTO.getJoiningDate() != null)
            employeeDetails.setJoiningDate(employeeDTO.getJoiningDate());
    }

    public void generateEmail(Employee employee) {
        StringBuilder emailBuilder = new StringBuilder();
        String empFName = employee.getFirstName().toLowerCase();
        String empLName = employee.getLastName().toLowerCase();
        emailBuilder.append(empFName)
                .append(".")
                .append(empLName)
                .append("@myorgmail.in");
        employee.setEmail(emailBuilder.toString());
        //TODO: handle duplicate email
    }

}
