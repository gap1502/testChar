package com.example.testchar;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCharControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testStringConverter() {
        String input = "aaaaabcccc";
        String expectedResult = "\"a\": 5, \"c\": 4, \"b\": 1";
        String result = this.restTemplate.getForObject("/param?input={input}", String.class, input);
        assertEquals(expectedResult, result);
    }
}
