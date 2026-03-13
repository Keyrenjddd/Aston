package com.example;

import org.testng.Assert;
import org.testng.annotations.*;

public class FactorialCalculatorTestNG {

    @BeforeClass
    public void setUp() {
        System.out.println("Начинаем тестирование FactorialCalculator");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Завершили тестирование FactorialCalculator");
    }

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1L);
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1L);
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, long expected) {
        Assert.assertEquals(FactorialCalculator.factorial(input), expected);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {2, 2L},
                {3, 6L},
                {4, 24L},
                {5, 120L}
        };
    }

    @Test
    public void testFactorialRecursive() {
        Assert.assertEquals(FactorialCalculator.factorialRecursive(0), 1L);
        Assert.assertEquals(FactorialCalculator.factorialRecursive(1), 1L);
        Assert.assertEquals(FactorialCalculator.factorialRecursive(2), 2L);
        Assert.assertEquals(FactorialCalculator.factorialRecursive(3), 6L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.factorial(-5);
    }
}