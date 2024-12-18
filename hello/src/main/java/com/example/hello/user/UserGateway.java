package com.example.hello.user;

// https://jsonplaceholder.typicode.com/users/1

import com.example.hello.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {
    private final RestTemplate restTemplate;
    private final String userUrl;

    public UserGateway(RestTemplate restTemplate,
                       @Value("${user.url}") String userUrl) {
        this.restTemplate = restTemplate;
        this.userUrl = userUrl;
    }

    public UserResponse getUserDetail(int id) {
        String url = userUrl + "/users/" + id;
        try {
            return restTemplate.getForObject(url, UserResponse.class);
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
