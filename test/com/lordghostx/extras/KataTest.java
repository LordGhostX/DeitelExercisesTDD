package com.lordghostx.extras;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    @DisplayName("Get Testdriller Cost Test")
    void getTestdrillerCostTest() {
        Kata kata = new Kata();

        assertEquals(0, kata.getTestdrillerCost(0));
        assertEquals(0, kata.getTestdrillerCost(-10));

        assertEquals(1500, kata.getTestdrillerCost(1));
        assertEquals(3000, kata.getTestdrillerCost(2));
        assertEquals(4500, kata.getTestdrillerCost(3));
        assertEquals(6000, kata.getTestdrillerCost(4));

        assertEquals(7000, kata.getTestdrillerCost(5));
        assertEquals(9800, kata.getTestdrillerCost(7));
        assertEquals(12600, kata.getTestdrillerCost(9));

        assertEquals(12000, kata.getTestdrillerCost(10));
        assertEquals(24000, kata.getTestdrillerCost(20));
        assertEquals(34800, kata.getTestdrillerCost(29));

        assertEquals(33000, kata.getTestdrillerCost(30));
        assertEquals(38500, kata.getTestdrillerCost(35));
        assertEquals(53900, kata.getTestdrillerCost(49));

        assertEquals(50000, kata.getTestdrillerCost(50));
        assertEquals(60000, kata.getTestdrillerCost(60));
        assertEquals(75000, kata.getTestdrillerCost(75));
        assertEquals(99000, kata.getTestdrillerCost(99));

        assertEquals(90000, kata.getTestdrillerCost(100));
        assertEquals(117000, kata.getTestdrillerCost(130));
        assertEquals(162000, kata.getTestdrillerCost(180));
        assertEquals(179100, kata.getTestdrillerCost(199));

        assertEquals(160000, kata.getTestdrillerCost(200));
        assertEquals(164000, kata.getTestdrillerCost(205));
        assertEquals(200000, kata.getTestdrillerCost(250));
        assertEquals(800000, kata.getTestdrillerCost(1000));
    }

    @Test
    void factorsOfNumberTest() {
        Kata kata = new Kata();
        assertEquals("1", kata.getFactorsOfNumber(1));
        assertEquals("1,2", kata.getFactorsOfNumber(2));
        assertEquals("1,2,5,10", kata.getFactorsOfNumber(10));
        assertEquals("1,3,5,15", kata.getFactorsOfNumber(15));
        assertEquals("1,2,4,5,10,20", kata.getFactorsOfNumber(20));
        assertEquals("1,5,11,55", kata.getFactorsOfNumber(55));
    }
}
