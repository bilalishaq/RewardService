package com.work.rewardservice.service;

import com.work.rewardservice.model.RewardResponse;

import java.math.BigDecimal;
import java.util.List;

public interface RewardService {

    public long calculateRewardPoints(BigDecimal orderAmount);

    List<RewardResponse> listAllCustomerRewardPoints();


}
