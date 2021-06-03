package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * */
public class Exercise1 {

    boolean isNumeric(String s) {
        try {
            int number = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @DataProvider(name = "data")
    Object[][] data() {
        // +ve tests
        return new Object [][] {
            {"123"},
            {"-123"}
        };
    }

    @Test(dataProvider = "data")
    void isNumericTest(String input) {
        Assert.assertTrue(isNumeric(input));
    }

    // negative tests
    @DataProvider(name = "invalid-data")
    Object[][] invalidData() {
        // -ve tests
        return new Object [][] {
                {"abc"},
                {"abc123"},
                {""},
                {null},
                {"21474836479"},
                {"123.123"}
        };
    }

    @Test(dataProvider = "invalid-data")
    void isNumericTestWithInvalidData(String input) {
        Assert.assertFalse(isNumeric(input));
    }
}
