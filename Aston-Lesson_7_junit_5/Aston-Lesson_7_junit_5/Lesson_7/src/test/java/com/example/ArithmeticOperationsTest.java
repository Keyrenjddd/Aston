package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    private static final double DELTA = 0.0001;

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "0, 5, 5",
            "-2, 3, 1",
            "-5, -3, -8"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "3, 5, -2",
            "0, 5, -5",
            "-2, -3, 1"
    })
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "0, 5, 0",
            "-2, 3, -6",
            "-4, -3, 12"
    })
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2.0",
            "5, 2, 2.5",
            "-6, 3, -2.0",
            "0, 5, 0.0"
    })
    void testDivide(int a, int b, double expected) {
        assertEquals(expected, ArithmeticOperations.divide(a, b), DELTA);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(5, 0));
    }
}