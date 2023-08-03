package com.work.rewardservice.service;

import com.work.rewardservice.model.ProductRequest;
import com.work.rewardservice.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
