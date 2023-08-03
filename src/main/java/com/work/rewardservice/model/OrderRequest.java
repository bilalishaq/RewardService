package com.work.rewardservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private long productId;

    private long customerId;
    private BigDecimal totalAmount;
    private long quantity;
    private PaymentMode paymentMode;
}
