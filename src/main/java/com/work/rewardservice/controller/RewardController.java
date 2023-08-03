package com.work.rewardservice.controller;

import com.work.rewardservice.model.OrderResponse;
import com.work.rewardservice.model.RewardResponse;
import com.work.rewardservice.service.RewardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bilal Ishaq
 * @email ishaq.bilal@gmail.com
 */
@RestController
@Log4j2
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/list")
    public ResponseEntity<List<RewardResponse>> listAllCustomerRewardPoints(){

        log.info("List Reward Points of all customers");

        List<RewardResponse> allCustomerRewardPoints = rewardService.listAllCustomerRewardPoints();

        return new ResponseEntity<>(allCustomerRewardPoints, HttpStatus.OK);

    }
}
