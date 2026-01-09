package com.example;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the web application endpoints.
 */
class MainTest {

    @Test
    void testFactorialEndpointWithValidNumber() {
        // Given: The web application
        Javalin app = Main.createApp();
        
        // When: Requesting factorial of 5
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/factorial/5");
            
            // Then: Response should be 200 OK with correct factorial
            assertEquals(200, response.code());
            String body = response.body().string();
            assertTrue(body.contains("\"number\":5"));
            assertTrue(body.contains("\"factorial\":\"120\""));
        });
    }

    @Test
    void testFactorialEndpointWithZero() {
        // Given: The web application
        Javalin app = Main.createApp();
        
        // When: Requesting factorial of 0
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/factorial/0");
            
            // Then: Response should be 200 OK with factorial 1
            assertEquals(200, response.code());
            String body = response.body().string();
            assertTrue(body.contains("\"number\":0"));
            assertTrue(body.contains("\"factorial\":\"1\""));
        });
    }

    @Test
    void testFactorialEndpointWithLargeNumber() {
        // Given: The web application
        Javalin app = Main.createApp();
        
        // When: Requesting factorial of 20
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/factorial/20");
            
            // Then: Response should be 200 OK with correct large factorial
            assertEquals(200, response.code());
            String body = response.body().string();
            assertTrue(body.contains("\"number\":20"));
            assertTrue(body.contains("\"factorial\":\"2432902008176640000\""));
        });
    }

    @Test
    void testFactorialEndpointWithNegativeNumber() {
        // Given: The web application
        Javalin app = Main.createApp();
        
        // When: Requesting factorial of -5
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/factorial/-5");
            
            // Then: Response should be 400 Bad Request with error message
            assertEquals(400, response.code());
            String body = response.body().string();
            assertTrue(body.contains("error"));
            assertTrue(body.contains("negative"));
        });
    }

    @Test
    void testFactorialEndpointWithInvalidInput() {
        // Given: The web application
        Javalin app = Main.createApp();
        
        // When: Requesting factorial with invalid input
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/factorial/abc");
            
            // Then: Response should be 400 Bad Request with error message
            assertEquals(400, response.code());
            String body = response.body().string();
            assertTrue(body.contains("error"));
            assertTrue(body.contains("Invalid number format"));
        });
    }
}
