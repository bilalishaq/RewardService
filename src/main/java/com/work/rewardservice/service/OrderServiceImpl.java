package com.work.rewardservice.service;

import com.work.rewardservice.entity.Customer;
import com.work.rewardservice.entity.Order;
import com.work.rewardservice.entity.Product;
import com.work.rewardservice.entity.Reward;
import com.work.rewardservice.exception.CustomException;
import com.work.rewardservice.model.OrderRequest;
import com.work.rewardservice.model.OrderResponse;
import com.work.rewardservice.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private RewardService rewardService;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        log.info("Place Order");

        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        log.info("creating order with status CREATED");

        Product product =
                Product.builder()
                        .id(orderRequest.getProductId())
                        .build();

        Customer customer =
                Customer.builder()
                        .id(orderRequest.getCustomerId())
                        .build();
        // calculate reward based on order amount

        long rewardPoints = rewardService.calculateRewardPoints(orderRequest.getTotalAmount());

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .product(product)
                .customer(customer)
                .quantity(orderRequest.getQuantity())
                .build();

        Reward reward =
                Reward.builder()
                        .pointsEarned(rewardPoints)
                        .order(order)
                        .build();

        order.setReward(reward);

        order = orderRepository.save(order);

        log.info("Order placed successfully with Order Id:{}",order.getId());

        return order.getId();
    }

    @Override
    public OrderResponse getOrderDetails(long orderId) {
        log.info("Get order details for order id: {}",orderId);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()->new CustomException("Order not found","NOT_FOUND", HttpStatus.NOT_FOUND.value()));

        OrderResponse orderResponse
                = OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .build();

        return orderResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {

    }
}
