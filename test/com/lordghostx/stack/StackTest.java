package com.lordghostx.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;

    @BeforeEach
    void beforeEach() {
        stack = new Stack(10);
    }

    @AfterEach
    void afterEach() {
        stack = null;
    }

    @Test
    void stackCanBeCreatedWithFixedLength() {
        assertEquals(10, stack.getSize());

        Stack secondStack = new Stack(5);
        assertEquals(5, secondStack.getSize());

        Stack thirdStack = new Stack(100);
        assertEquals(100, thirdStack.getSize());
    }

    @Test
    void stackCannotBeCreatedWithNegativeLength() {
        assertThrows(IllegalArgumentException.class, ()-> new Stack(-10));
    }

    @Test
    void stackCannotBeCreatedWithZeroLength() {
        assertThrows(IllegalArgumentException.class, ()-> new Stack(0));
    }

    @Test
    void stackCanPushElements() {
        stack.push(10);
        assertEquals(9, stack.getFreeBlocksCount());

        stack.push(5);
        assertEquals(8, stack.getFreeBlocksCount());
    }

    @Test
    void stackCanPushZeroValue() {
        stack.push(0);
        assertEquals(9, stack.getFreeBlocksCount());
    }

    @Test
    void stackCannotPushElementsIfFull() {
        for (int i = 0; i < 10; i++) {
            stack.push(10);
        }

        assertThrows(StackOverflowError.class, ()-> stack.push(10));
    }

    @Test
    void stackCanPopElements() {
        stack.push(10);
        stack.pop();
        assertEquals(10, stack.getFreeBlocksCount());
    }

    @Test
    void stackCanGetElementThatWasPopped() {
        stack.push(10);
        assertEquals(10, stack.pop());

        stack.push(5);
        stack.push(7);
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void stackCannotPopElementsWhenEmpty() {
        assertThrows(IllegalArgumentException.class, ()-> stack.pop());
    }

    @Test
    void stackCanPeekElement() {
        stack.push(10);
        assertEquals(10, stack.peek());

        stack.push(5);
        stack.push(7);
        assertEquals(7, stack.peek());
    }

    @Test
    void stackCannotPeekEmptyStack() {
        assertThrows(IllegalArgumentException.class, ()-> stack.peek());
    }
}