package com.example.customerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String email;
    private String address;
    private String gender;
    private String mobileNumber;
    private String occupation;
    private String salary;
    private Date creationDate = new Date();
    private List<Loan> loans;
    private Map<String, String> customerSettings = new HashMap<>();


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getCustomerSettings() {
        return customerSettings;
    }

    public void setCustomerSettings(Map<String, String> customerSettings) {
        this.customerSettings = customerSettings;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public Customer(String customerId, String name, String email, String address, String gender, String mobileNumber, String occupation, String salary) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.occupation = occupation;
        this.salary = salary;
    }
}
