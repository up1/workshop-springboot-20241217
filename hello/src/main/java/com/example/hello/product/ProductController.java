package com.example.hello.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product/{id}")
    public ProductResponse getBy(@PathVariable int id) {
        ProductResponse response = new ProductResponse();
        response.setId(id);
        response.setName("product name");
        response.setPrice(100.50);
        return response;
    }

}
