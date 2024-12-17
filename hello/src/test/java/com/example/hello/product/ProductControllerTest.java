package com.example.hello.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("ทำการทดสอบดึงข้อมูลรายละเอียด product  ด้วย id=1 สำเร็จ")
    void case01() {
        ProductResponse actualResult = restTemplate.getForObject(
                "/product/1", ProductResponse.class);
        assertEquals(1, actualResult.getId());
        assertEquals("XXX", actualResult.getName());
    }

    @Test
    @DisplayName("เมื่อใส่ id ที่ไม่ใช่ตัวเลข จะต้อง return code = 400 พร้อม message = Bad request")
    void case02() {
        ResponseEntity<ErrorResponse> actualResult = restTemplate.getForEntity(
                "/product/1xxxx", ErrorResponse.class);
        assertEquals(400, actualResult.getStatusCode().value());
        assertEquals("Bad request", actualResult.getBody().getMessage());
    }
}