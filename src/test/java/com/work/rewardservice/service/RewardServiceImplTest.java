package com.work.rewardservice.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RewardServiceImplTest {

    @Test
    void OneTwentyDollarPurchaseShouldCreateNinetyPoints() {
        var rewardService = new RewardServiceImpl();
       assertEquals(90, rewardService.calculateRewardPoints(BigDecimal.valueOf(120)));
    }

    @Test
    void OneFiftyDollarPurchaseShouldCreateOneFiftyPoints() {
        var rewardService = new RewardServiceImpl();
        assertEquals(150, rewardService.calculateRewardPoints(BigDecimal.valueOf(150)));
    }

    @Test
    void TwoHundredDollarPurchaseShouldCreateTwoFiftyPoints() {
        var rewardService = new RewardServiceImpl();
        assertEquals(250, rewardService.calculateRewardPoints(BigDecimal.valueOf(200)));
    }

    @Test
    void OneThousandDollarPurchaseShouldCreateEighteenHundredFiftyPoints() {
        var rewardService = new RewardServiceImpl();
        assertEquals(1850, rewardService.calculateRewardPoints(BigDecimal.valueOf(1000)));
    }

    @Test
    void OneHundredDollarPurchaseShouldCreateFiftyPoints() {
        var rewardService = new RewardServiceImpl();
        assertEquals(50, rewardService.calculateRewardPoints(BigDecimal.valueOf(100)));
    }

    @Test
    void FiftyOneDollarPurchaseShouldCreateOnePoint() {
        var rewardService = new RewardServiceImpl();
        assertEquals(1, rewardService.calculateRewardPoints(BigDecimal.valueOf(51)));
    }

    @Test
    void FiftyDollarPurchaseShouldCreateZeroPoint() {
        var rewardService = new RewardServiceImpl();
        assertEquals(0, rewardService.calculateRewardPoints(BigDecimal.valueOf(50)));
    }

    @Test
    void TenDollarPurchaseShouldCreateZeroPoint() {
        var rewardService = new RewardServiceImpl();
        assertEquals(0, rewardService.calculateRewardPoints(BigDecimal.valueOf(10)));
    }

    @Test
    void ZeroDollarPurchaseShouldCreateZeroPoint() {
        var rewardService = new RewardServiceImpl();
        assertEquals(0, rewardService.calculateRewardPoints(BigDecimal.valueOf(0)));
    }

    // edge case for negative amount given
    @Test
    void NegativeDollarPurchaseShouldCreateIllegalArgumentException() {
        var rewardService = new RewardServiceImpl();
        assertThrows(IllegalArgumentException.class,
                ()->{
                    rewardService.calculateRewardPoints(BigDecimal.valueOf(-1));
                });
    }
}