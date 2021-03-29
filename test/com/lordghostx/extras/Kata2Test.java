package com.lordghostx.extras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Kata2Test {

    @BeforeEach

    @Test
    void getSumOfNumbersTest() {
        assertEquals(6,Kata.getSumOfNumbers(new int[]{1, 2, 3}));
        assertEquals( 20,Kata.getSumOfNumbers(new int[]{5, 10, 2, 3}));
    }

    @Test
    void getAverageOfNumbersTest() {
        assertEquals(2, Kata.getAverageOfNumbers(new int[]{1, 2, 3}));
        assertEquals(6, Kata.getAverageOfNumbers(new int[]{5, 10, 3}));
    }

    @Test
    void getMaximumOfNumbersTest() {
        assertEquals(5, Kata.getMaximumOfNumbers(new int[]{1, 2, 3, 4, 5}));
        assertEquals(8, Kata.getMaximumOfNumbers(new int[]{-100, -10, 0, -2, -3, 8}));
    }

    @Test
    void getMinimumOfNumbersTest() {
        assertEquals(1, Kata.getMinimumOfNumbers(new int[]{1, 2, 3, 4, 5}));
        assertEquals(-10, Kata.getMinimumOfNumbers(new int[]{-10, 2, 3}));
    }

    @Test
    void getMaximumCombinationSumTest() {
        assertEquals(14, Kata.getMaximumCombinationSum(new int[]{5, 4, 3, 1, 2}));
        assertEquals(16, Kata.getMaximumCombinationSum(new int[]{3, 5, 2, 0, -10, 6}));
    }

    @Test
    void getMinimumCombinationSumTest() {
        assertEquals(10, Kata.getMinimumCombinationSum(new int[]{5, 4, 3, 1, 2}));
        assertEquals(0, Kata.getMinimumCombinationSum(new int[]{3, 5, 2, 0, -10, 6}));
    }
}
