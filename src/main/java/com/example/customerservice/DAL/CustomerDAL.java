package com.example.customerservice.DAL;



import com.example.customerservice.model.Customer;

import java.util.List;

public interface CustomerDAL {

    List<Customer> getAllCustomers();

    Customer getCustomer(String CustomerId);

    //public Object getAllCustomerSettings(String CustomerId);

    Customer addNewCustomer(Customer Customer);
}
