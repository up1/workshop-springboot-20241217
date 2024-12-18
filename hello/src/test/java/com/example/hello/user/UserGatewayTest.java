package com.example.hello.user;

import com.example.hello.user.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class UserGatewayTest {

    @Autowired
    UserGateway userGateway;

    @Test
    void case_fail() {
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

    @Test
    void case_success() throws IOException {
        stubFor(get(urlPathEqualTo("/users/2"))
                .willReturn(aResponse()
                        .withBody(read("classpath:2.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)));
        UserResponse actualResult = userGateway.getUserDetail(2);
        // Assert
        assertEquals("somkiat", actualResult.getName());
    }

    public static String read(String filePath) throws IOException {
        File file = ResourceUtils.getFile(filePath);
        return new String(Files.readAllBytes(file.toPath()));
    }
}