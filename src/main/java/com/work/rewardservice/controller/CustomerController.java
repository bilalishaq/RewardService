package com.work.rewardservice.controller;

import com.work.rewardservice.model.CustomerRequest;
import com.work.rewardservice.model.ProductRequest;
import com.work.rewardservice.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<Long> addCustomer(@RequestBody CustomerRequest customerRequest){

        log.info("Adding New Customer");

        long customerId = customerService.addCustomer(customerRequest);

        log.info("Customer Id : {}",customerId);

        return new ResponseEntity<>(customerId, HttpStatus.CREATED);
    }
}
