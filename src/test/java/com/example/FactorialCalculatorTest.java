package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for FactorialCalculator.
 */
class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeEach
    void setUp() {
        // Given: A fresh FactorialCalculator instance
        calculator = new FactorialCalculator();
    }

    @Test
    void testFactorialOfZero() {
        // Given: A calculator
        // When: Calculating factorial of 0
        BigInteger result = calculator.calculate(0);
        
        // Then: Result should be 1
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testFactorialOfOne() {
        // Given: A calculator
        // When: Calculating factorial of 1
        BigInteger result = calculator.calculate(1);
        
        // Then: Result should be 1
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testFactorialOfFive() {
        // Given: A calculator
        // When: Calculating factorial of 5
        BigInteger result = calculator.calculate(5);
        
        // Then: Result should be 120 (5! = 5 * 4 * 3 * 2 * 1)
        assertEquals(BigInteger.valueOf(120), result);
    }

    @Test
    void testFactorialOfTen() {
        // Given: A calculator
        // When: Calculating factorial of 10
        BigInteger result = calculator.calculate(10);
        
        // Then: Result should be 3628800
        assertEquals(BigInteger.valueOf(3628800), result);
    }

    @Test
    void testFactorialOfLargeNumber() {
        // Given: A calculator
        // When: Calculating factorial of 20
        BigInteger result = calculator.calculate(20);
        
        // Then: Result should be 2432902008176640000
        assertEquals(new BigInteger("2432902008176640000"), result);
    }

    @Test
    void testFactorialOfNegativeNumber() {
        // Given: A calculator
        // When: Attempting to calculate factorial of -1
        // Then: Should throw IllegalArgumentException
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.calculate(-1)
        );
        
        assertTrue(exception.getMessage().contains("negative"));
    }
}
