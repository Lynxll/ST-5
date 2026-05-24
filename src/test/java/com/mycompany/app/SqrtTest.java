package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SqrtTest {

    private Sqrt sqrt;

    @BeforeEach
    void setUp() {
        sqrt = new Sqrt(2.0);
    }

    @Test
    void testAverage() {
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-10);
    }

    @Test
    void testAverageWithNegativeValues() {
        assertEquals(0.0, sqrt.average(-2.0, 2.0), 1e-10);
    }

    @Test
    void testGoodWhenGuessIsAccurate() {
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void testGoodWhenGuessIsInaccurate() {
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void testImproveMovesGuessCloser() {
        double improved = sqrt.improve(1.0, 4.0);
        assertTrue(improved > 1.0 && improved < 4.0);
    }

    @Test
    void testIterReturnsGuessWhenAlreadyGood() {
        assertEquals(2.0, sqrt.iter(2.0, 4.0), 1e-10);
    }

    @Test
    void testIterConvergesToSquareRoot() {
        assertEquals(3.0, sqrt.iter(1.0, 9.0), 1e-6);
    }

    @Test
    void testCalcForTwo() {
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcForNine() {
        Sqrt sqrtNine = new Sqrt(9.0);
        assertEquals(3.0, sqrtNine.calc(), 1e-6);
    }

    @Test
    void testCalcForOne() {
        Sqrt sqrtOne = new Sqrt(1.0);
        assertEquals(1.0, sqrtOne.calc(), 1e-6);
    }

    @Test
    void testCalcForTwentyFive() {
        Sqrt sqrtTwentyFive = new Sqrt(25.0);
        assertEquals(5.0, sqrtTwentyFive.calc(), 1e-6);
    }
}
