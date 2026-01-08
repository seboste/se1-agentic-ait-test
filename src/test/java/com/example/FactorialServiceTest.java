package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialServiceTest {

    private FactorialService factorialService;

    @BeforeEach
    void setUp() {
        factorialService = new FactorialService();
    }

    @Test
    void testCalculateFactorial_Zero() {
        // Given
        int n = 0;
        
        // When
        BigInteger result = factorialService.calculateFactorial(n);
        
        // Then
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testCalculateFactorial_One() {
        // Given
        int n = 1;
        
        // When
        BigInteger result = factorialService.calculateFactorial(n);
        
        // Then
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testCalculateFactorial_Five() {
        // Given
        int n = 5;
        
        // When
        BigInteger result = factorialService.calculateFactorial(n);
        
        // Then
        assertEquals(BigInteger.valueOf(120), result);
    }

    @Test
    void testCalculateFactorial_Ten() {
        // Given
        int n = 10;
        
        // When
        BigInteger result = factorialService.calculateFactorial(n);
        
        // Then
        assertEquals(BigInteger.valueOf(3628800), result);
    }

    @Test
    void testCalculateFactorial_LargeNumber() {
        // Given
        int n = 20;
        
        // When
        BigInteger result = factorialService.calculateFactorial(n);
        
        // Then
        assertEquals(new BigInteger("2432902008176640000"), result);
    }

    @Test
    void testCalculateFactorial_NegativeNumber() {
        // Given
        int n = -1;
        
        // When & Then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> factorialService.calculateFactorial(n)
        );
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }
}
