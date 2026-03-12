package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @ParameterizedTest
    @CsvSource({
            "5, 3, 1",
            "3, 5, -1",
            "5, 5, 0",
            "-2, -5, 1",
            "-5, -2, -1"
    })
    void testCompare(int a, int b, int expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, true",
            "5, 3, false",
            "-2, -2, true"
    })
    void testIsEqual(int a, int b, boolean expected) {
        assertEquals(expected, NumberComparator.isEqual(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 5",
            "3, 5, 5",
            "-2, -5, -2",
            "0, 0, 0"
    })
    void testMax(int a, int b, int expected) {
        assertEquals(expected, NumberComparator.max(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 3",
            "3, 5, 3",
            "-2, -5, -5",
            "0, 0, 0"
    })
    void testMin(int a, int b, int expected) {
        assertEquals(expected, NumberComparator.min(a, b));
    }

    @Test
    void testAllOperations() {
        assertAll(
                () -> assertTrue(NumberComparator.isEqual(5, 5)),
                () -> assertFalse(NumberComparator.isEqual(5, 3)),
                () -> assertEquals(5, NumberComparator.max(5, 3)),
                () -> assertEquals(3, NumberComparator.min(5, 3))
        );
    }
}