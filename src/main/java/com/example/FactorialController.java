package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/factorial")
public class FactorialController {

    private final FactorialService factorialService;

    @Autowired
    public FactorialController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    /**
     * Calculates the factorial of the given number.
     * 
     * @param n the number to calculate factorial for
     * @return ResponseEntity with the factorial result or error message
     */
    @GetMapping("/{n}")
    public ResponseEntity<?> getFactorial(@PathVariable int n) {
        try {
            BigInteger result = factorialService.calculateFactorial(n);
            return ResponseEntity.ok(new FactorialResponse(n, result.toString()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

    /**
     * Response record for factorial calculations.
     */
    public record FactorialResponse(int number, String factorial) {}

    /**
     * Response record for error messages.
     */
    public record ErrorResponse(String error) {}
}
