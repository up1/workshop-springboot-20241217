package com.example.hello.init;


import com.example.hello.product.Product;
import com.example.hello.product.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataDBforTest {

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    void initialData() {
        Product p100 = new Product();
        p100.setId(100);
        p100.setName("Product 100");
        productRepository.save(p100);
    }
}
