package com.example;

import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class FactorialService {
    
    /**
     * Calculates the factorial of a given non-negative integer.
     * 
     * @param n the non-negative integer to calculate factorial for
     * @return the factorial of n as a BigInteger
     * @throws IllegalArgumentException if n is negative
     */
    public BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
