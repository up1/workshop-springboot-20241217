package com.example.hello.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(dontRollbackOn = ProductNotFoundException.class)
    public ProductResponse get(int id) {
        Product p10 = new Product();
        p10.setId(10);
        p10.setName("p10");
        productRepository.save(p10);

        productRepository.deleteAll();

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
