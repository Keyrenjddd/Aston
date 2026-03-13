package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberComparatorTestNG {

    @Test(dataProvider = "compareData")
    public void testCompare(int a, int b, int expected) {
        Assert.assertEquals(NumberComparator.compare(a, b), expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][]{
                {5, 3, 1},
                {3, 5, -1},
                {5, 5, 0},
                {-2, -5, 1},
                {-5, -2, -1}
        };
    }

    @Test(dataProvider = "equalData")
    public void testIsEqual(int a, int b, boolean expected) {
        Assert.assertEquals(NumberComparator.isEqual(a, b), expected);
    }

    @DataProvider(name = "equalData")
    public Object[][] equalData() {
        return new Object[][]{
                {5, 5, true},
                {5, 3, false},
                {-2, -2, true}
        };
    }

    @Test(dataProvider = "maxData")
    public void testMax(int a, int b, int expected) {
        Assert.assertEquals(NumberComparator.max(a, b), expected);
    }

    @DataProvider(name = "maxData")
    public Object[][] maxData() {
        return new Object[][]{
                {5, 3, 5},
                {3, 5, 5},
                {-2, -5, -2},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "minData")
    public void testMin(int a, int b, int expected) {
        Assert.assertEquals(NumberComparator.min(a, b), expected);
    }

    @DataProvider(name = "minData")
    public Object[][] minData() {
        return new Object[][]{
                {5, 3, 3},
                {3, 5, 3},
                {-2, -5, -5},
                {0, 0, 0}
        };
    }
}