package com.example.hello.user;

// https://jsonplaceholder.typicode.com/users/1

import com.example.hello.user.dto.UserResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {
    private final RestTemplate restTemplate;

    public UserGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse getUserDetail(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        try {
            return restTemplate.getForObject(url, UserResponse.class);
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
