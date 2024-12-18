package com.example.hello.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class UserGatewayTest {

    @Autowired
    UserGateway userGateway;

    @Test
    void getUserDetail() {
        stubFor(get(urlPathEqualTo("/users/1"))
                .willReturn(aResponse()
                        .withStatus(500)));
        try {
            userGateway.getUserDetail(1);
            fail("External no error !!");
        } catch (RuntimeException e) {
            // OK
        }
    }
}