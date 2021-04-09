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
}