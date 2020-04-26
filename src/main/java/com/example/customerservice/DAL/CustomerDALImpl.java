package com.example.customerservice.DAL;

import com.example.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDALImpl implements CustomerDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        return mongoTemplate.findAll(Customer.class);
    }

    @Override
    public Customer getCustomer(String loanId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("loanId").is(loanId));
        return mongoTemplate.findOne(query, Customer.class);
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        mongoTemplate.save(customer);
        return customer;
    }

   /* @Override
    public Object getAllCustomerSettings(String loanId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("loanId").is(loanId));
        User user = mongoTemplate.findOne(query, User.class);
        return user != null ? user.getUserSettings() : "User not found.";
    }*/
}
