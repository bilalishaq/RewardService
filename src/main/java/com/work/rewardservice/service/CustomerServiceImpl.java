package com.work.rewardservice.service;

import com.work.rewardservice.entity.Customer;
import com.work.rewardservice.entity.Product;
import com.work.rewardservice.model.CustomerRequest;
import com.work.rewardservice.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public long addCustomer(CustomerRequest customerRequest) {
        log.info("Adding Customer");
        Customer customer
                = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .address(customerRequest.getAddress())
                .build();

        customerRepository.save(customer);

        log.info("Customer created");

        return customer.getId();
    }
}
