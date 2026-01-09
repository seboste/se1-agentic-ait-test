package com.example;

import java.math.BigInteger;

/**
 * A calculator for computing factorial values.
 */
public class FactorialCalculator {

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public BigInteger calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result;
    }
}
