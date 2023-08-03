package com.work.rewardservice.controller;


import com.work.rewardservice.model.ProductRequest;
import com.work.rewardservice.model.ProductResponse;
import com.work.rewardservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Ishaq
 * @email ishaq.bilal@gmail.com
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        long productId = productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){

        ProductResponse productResponse = productService.getProductById(productId);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity){
        productService.reduceQuantity(productId,quantity);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
