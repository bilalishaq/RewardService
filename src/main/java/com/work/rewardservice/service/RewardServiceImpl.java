package com.work.rewardservice.service;

import com.work.rewardservice.entity.RewardData;
import com.work.rewardservice.model.RewardResponse;
import com.work.rewardservice.repository.RewardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RewardServiceImpl implements RewardService{

    @Autowired
    private RewardRepository rewardRepository;
    @Override
    public long calculateRewardPoints(BigDecimal orderAmount) {

        log.info("Compute function for reward points for order amount: {}",orderAmount);

        if(orderAmount.doubleValue() < 0)
            throw new IllegalArgumentException("Amount should be greater than equal to zero");

        long rewardPoints = 0;
        double amountOver100 = Math.max(orderAmount.doubleValue() - 100, 0);

        double amountOver50 = Math.max(orderAmount.doubleValue() - 50, 0);

        if(amountOver50 > 50)
            amountOver50 = 50;

        // Calculate reward points for dollars spent over $100
        long pointsOver100 = (long) (amountOver100 * 2);

        // Calculate reward points for dollars spent over $50
        long pointsOver50 = (long) (amountOver50);

        // Total reward points
        rewardPoints = pointsOver100 + pointsOver50;

        log.info("Total computed reward points: {}",rewardPoints);
        return rewardPoints;
    }

    @Override
    public List<RewardResponse> listAllCustomerRewardPoints() {
        String startDate = "2023-08-03";
        String endDate = "2023-08-04";

        Collection<RewardData> allRewardPointsGroupByCustomer = rewardRepository.findAllRewardPointsGroupByCustomer(startDate, endDate);

        List<RewardResponse> rewardResponses = allRewardPointsGroupByCustomer
                .stream()
                .map(objA -> {
                    RewardResponse response = new RewardResponse();
                    response.setTotalRewardPoints(objA.getTotalRewardPoints());
                    response.setCustomerFirstName(objA.getCustomerFirstName());
                    return response;

                }).collect(Collectors.toList());

        return rewardResponses;
    }
}
