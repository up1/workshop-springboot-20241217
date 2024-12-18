package com.example.hello.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("Product id=1000 not found in database")
    void case03() {
        // Act
        try {
            productService.get(1000);
            fail("Product id =1000 found in database");
        } catch (ProductNotFoundException e) {
            assertEquals("Product id=1000 not found", e.getMessage());
        }

    }
}