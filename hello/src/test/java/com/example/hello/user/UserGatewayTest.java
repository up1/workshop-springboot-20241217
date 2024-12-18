package com.example.hello.user;

import com.example.hello.user.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

    @Autowired
    UserGateway userGateway;

    @Test
    void getUserDetail() {
        // Act
        UserResponse result = userGateway.getUserDetail(1);
        // Assert
        assertEquals("Sincere@april.biz", result.getEmail());
    }
}