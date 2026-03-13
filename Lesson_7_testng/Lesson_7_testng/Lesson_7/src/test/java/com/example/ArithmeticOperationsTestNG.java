package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticOperationsTestNG {

    private static final double DELTA = 0.0001;

    @Test(dataProvider = "addData")
    public void testAdd(int a, int b, int expected) {
        Assert.assertEquals(ArithmeticOperations.add(a, b), expected);
    }

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {2, 3, 5},
                {0, 5, 5},
                {-2, 3, 1},
                {-5, -3, -8}
        };
    }

    @Test(dataProvider = "subtractData")
    public void testSubtract(int a, int b, int expected) {
        Assert.assertEquals(ArithmeticOperations.subtract(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][]{
                {5, 3, 2},
                {3, 5, -2},
                {0, 5, -5},
                {-2, -3, 1}
        };
    }

    @Test(dataProvider = "multiplyData")
    public void testMultiply(int a, int b, int expected) {
        Assert.assertEquals(ArithmeticOperations.multiply(a, b), expected);
    }

    @DataProvider(name = "multiplyData")
    public Object[][] multiplyData() {
        return new Object[][]{
                {2, 3, 6},
                {0, 5, 0},
                {-2, 3, -6},
                {-4, -3, 12}
        };
    }

    @Test(dataProvider = "divideData")
    public void testDivide(int a, int b, double expected) {
        Assert.assertEquals(ArithmeticOperations.divide(a, b), expected, DELTA);
    }

    @DataProvider(name = "divideData")
    public Object[][] divideData() {
        return new Object[][]{
                {6, 3, 2.0},
                {5, 2, 2.5},
                {-6, 3, -2.0},
                {0, 5, 0.0}
        };
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(5, 0);
    }
}