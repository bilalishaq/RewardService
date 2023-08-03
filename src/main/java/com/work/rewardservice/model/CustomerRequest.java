package com.work.rewardservice.model;

import lombok.Data;

@Data
public class CustomerRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
}
