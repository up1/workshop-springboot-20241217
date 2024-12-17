package com.example.hello.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse get(int id) {
        // Get data from database
        productRepository.findById(id);
        // Success
        // Product not found
        // Database error
        ProductResponse response = new ProductResponse();
        response.setId(id);
        response.setName("XXX");
        response.setPrice(100.50);
        return response;
    }

}
