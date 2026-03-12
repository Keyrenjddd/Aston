package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorial(int input, long expected) {
        assertEquals(expected, FactorialCalculator.factorial(input));
    }

    @Test
    void testFactorialRecursive() {
        assertAll(
                () -> assertEquals(1, FactorialCalculator.factorialRecursive(0)),
                () -> assertEquals(1, FactorialCalculator.factorialRecursive(1)),
                () -> assertEquals(2, FactorialCalculator.factorialRecursive(2)),
                () -> assertEquals(6, FactorialCalculator.factorialRecursive(3))
        );
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.factorial(-5));
    }
}