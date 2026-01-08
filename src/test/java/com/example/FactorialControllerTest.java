package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FactorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetFactorial_Zero() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/factorial/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(0))
                .andExpect(jsonPath("$.factorial").value("1"));
    }

    @Test
    void testGetFactorial_Five() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/factorial/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(5))
                .andExpect(jsonPath("$.factorial").value("120"));
    }

    @Test
    void testGetFactorial_Ten() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/factorial/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(10))
                .andExpect(jsonPath("$.factorial").value("3628800"));
    }

    @Test
    void testGetFactorial_LargeNumber() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/factorial/20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(20))
                .andExpect(jsonPath("$.factorial").value("2432902008176640000"));
    }

    @Test
    void testGetFactorial_NegativeNumber() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/factorial/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Factorial is not defined for negative numbers"));
    }
}
