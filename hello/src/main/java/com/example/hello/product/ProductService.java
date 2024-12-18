package com.example.hello.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse get(int id) {
        // Get data from database
        Optional<Product> result = productRepository.findById(id);
        // Product not found
        if(result.isEmpty()) {
            throw new ProductNotFoundException("Product id=" + id + " not found");
        }
        // Success
        ProductResponse response = new ProductResponse();
        response.setId(id);
        response.setName(result.get().getName());
        response.setPrice(result.get().getPrice());
        return response;
    }

}
