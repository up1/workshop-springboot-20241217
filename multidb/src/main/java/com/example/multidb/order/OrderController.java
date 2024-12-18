package com.example.multidb.order;

import com.example.multidb.primary.ProductRepository;
import com.example.multidb.secondary.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/orders")
    public String getOrders() {
        productRepository.findById(1L);
        orderRepository.findById(1L);
        return "OK";
    }

}
