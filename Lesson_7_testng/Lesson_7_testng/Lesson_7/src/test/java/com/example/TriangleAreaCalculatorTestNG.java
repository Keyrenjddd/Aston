package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleAreaCalculatorTestNG {

    private static final double DELTA = 0.0001;

    @Test
    public void testAreaByBaseAndHeight() {
        Assert.assertEquals(TriangleAreaCalculator.areaByBaseAndHeight(5, 4), 10.0, DELTA);
        Assert.assertEquals(TriangleAreaCalculator.areaByBaseAndHeight(5, 3), 7.5, DELTA);
    }

    @Test(dataProvider = "heronData")
    public void testAreaByThreeSides(double a, double b, double c, double expected) {
        Assert.assertEquals(TriangleAreaCalculator.areaByThreeSides(a, b, c), expected, DELTA);
    }

    @DataProvider(name = "heronData")
    public Object[][] heronData() {
        return new Object[][]{
                {3, 4, 5, 6.0},
                {5, 5, 6, 12.0}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeSides() {
        TriangleAreaCalculator.areaByBaseAndHeight(-5, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleExistence() {
        TriangleAreaCalculator.areaByThreeSides(1, 1, 3);
    }
}