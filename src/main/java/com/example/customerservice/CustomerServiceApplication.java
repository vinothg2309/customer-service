package com.example.customerservice;

import com.example.customerservice.DAL.CustomerDAL;
import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private CustomerDAL customerDAL;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDAL.addNewCustomer(new Customer("1","John","john@email.com","New York",
				"Male","+18975464551","IT","30000"));

		customerDAL.addNewCustomer(new Customer("2","Julie","julie@email.com","New Jersey",
				"Female","+1889565522","Accountant","20000"));

		LOG.info("Saving MongoDB records on startup");
	}
}
