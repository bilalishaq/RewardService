package com.work.rewardservice.service;


import com.work.rewardservice.entity.Product;
import com.work.rewardservice.exception.CustomException;
import com.work.rewardservice.model.ProductRequest;
import com.work.rewardservice.model.ProductResponse;
import com.work.rewardservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product");
        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product created");

        return product.getId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("get the product for ProductId: {}", productId);
        Product product
                = productRepository.findById(productId)
                .orElseThrow(()-> new CustomException("Product with given id not found","PRODUCT_NOT_FOUND",HttpStatus.NOT_FOUND.value()));

        ProductResponse productResponse
                = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity,productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(()-> new CustomException("Product with given Id not found",
                        "PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND.value()));

        if(product.getQuantity() < quantity){
            throw new CustomException("Product does not have sufficient quantity",
                    "INSUFFICIENT_QUANTITY",HttpStatus.BAD_REQUEST.value());
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        log.info("Product Quantity updated successfully");
    }
}
