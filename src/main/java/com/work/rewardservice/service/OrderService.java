package com.work.rewardservice.service;

import com.work.rewardservice.model.OrderRequest;
import com.work.rewardservice.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);

    void reduceQuantity(long productId, long quantity);
}
