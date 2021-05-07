package com.lordghostx;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    Kata kata;

    @BeforeEach
    void beforeEach() {
        kata = new Kata();
    }

    @AfterEach
    void afterEach() {
        kata = null;
    }

    @Test
    void kataCanCountUniqueElementsInArray() {
        assertEquals(5, kata.countUnique(0, 0, 1, 1, 2, 2, 3, 3, 4));
    }

    @Test
    void kataCanFormatPhoneNumber() {
        assertEquals("(+234) 565-375-86", Kata.formatPhoneNumber("68573565234"));
    }

    @Test
    void kataCanCheckIfWordIsPalindrome() {
        assertTrue(Kata.checkPalindrome("racecar"));
        assertTrue(Kata.checkPalindrome("radar"));
        assertTrue(Kata.checkPalindrome("madam"));
        assertFalse(Kata.checkPalindrome("solomon"));
        assertFalse(Kata.checkPalindrome("semicolon"));
    }
}