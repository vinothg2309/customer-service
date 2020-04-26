package com.example.customerservice.controller;


import com.example.customerservice.DAL.CustomerDAL;
import com.example.customerservice.model.Customer;
import com.example.customerservice.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private final CustomerDAL customerDAL;

    @Autowired
    private RestTemplate restTemplate;

    public CustomerController(CustomerDAL customerDAL) {
        this.customerDAL = customerDAL;
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        LOG.info("Getting all Customers from ------v1-------.");
        return customerDAL.getAllCustomers();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String customerId) {
        LOG.info("Getting Customer with ID: {}.", customerId);
        Customer customer = customerDAL.getCustomer(customerId);
        if(customer !=null)
        {
            getCustomerLoan(customer);
        }
        return customer;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Customer addNewCustomer(@RequestBody Customer customer) {
        LOG.info("Saving Customer.");
        return customerDAL.addNewCustomer(customer);
    }

    @RequestMapping(value = "/getAllCustomersLoan")
    public List<Customer> getAllCustomersLoan() {
       List<Customer> customerList = customerDAL.getAllCustomers();
       for(Customer customer : customerList){
           getCustomerLoan(customer);
       }
        return customerList;
    }

    @RequestMapping(value = "/version")
    public String version() {
        String version = System.getenv("VERSION");
        String ver = version!=null?version: "v1";
        LOG.info("Version ----> " + ver);
        return "Hi from Customer service version ---> " + ver;
    }

    private void getCustomerLoan(Customer customer){
        String loanServiceURL = System.getenv("LOAN_SERVICE_URL");
        LOG.info("loanServiceURL---> {}.", loanServiceURL);
        ResponseEntity<Loan[]> response = restTemplate.getForEntity(loanServiceURL!=null?
                        loanServiceURL:"http://loan-service:8102/loan/getLoansByCustomer/"+customer.getCustomerId(),Loan[].class);
        List<Loan> loans = Arrays.asList(response.getBody());
        if(loans!=null && !loans.isEmpty())
            customer.setLoans(loans);
    }
}
