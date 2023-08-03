package com.work.rewardservice.controller;

import com.work.rewardservice.model.OrderRequest;
import com.work.rewardservice.model.OrderResponse;
import com.work.rewardservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){

        log.info("Placing Order");

        long orderId = orderService.placeOrder(orderRequest);

        log.info("Order Id : {}",orderId);

        return new ResponseEntity<>(orderId, HttpStatus.OK);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long orderId){

        OrderResponse orderResponse = orderService.getOrderDetails(orderId);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);

    }
}
