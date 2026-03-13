package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    private static final double DELTA = 0.0001;

    @Test
    void testAreaByBaseAndHeight() {
        assertEquals(10.0, TriangleAreaCalculator.areaByBaseAndHeight(5, 4), DELTA);
        assertEquals(7.5, TriangleAreaCalculator.areaByBaseAndHeight(5, 3), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6.0",
            "5, 5, 6, 12.0"
    })
    void testAreaByThreeSides(double a, double b, double c, double expected) {
        assertEquals(expected, TriangleAreaCalculator.areaByThreeSides(a, b, c), DELTA);
    }

    @Test
    void testNegativeSides() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.areaByBaseAndHeight(-5, 4));
    }

    @Test
    void testTriangleExistence() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.areaByThreeSides(1, 1, 3));
    }
}