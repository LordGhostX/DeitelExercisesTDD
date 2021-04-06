package com.lordghostx.stack;

public class Stack {
    private final int[] stackBlocks;

    public Stack(int stackSize) {
        if (stackSize <= 0) throw new IllegalArgumentException();
        stackBlocks = new int[stackSize];
    }

    public int getSize() {
        return stackBlocks.length;
    }

    public void push(int number) {
        if (number == 0) throw new IllegalArgumentException();

        int freeBlock = getFreeBlockIndex();
        if (freeBlock == -1) throw new StackOverflowError();

        stackBlocks[freeBlock] = number;
    }

    private int getFreeBlockIndex() {
        for (int i = 0; i < stackBlocks.length; i++) {
            if (stackBlocks[i] == 0) return i;
        }
        return -1;
    }

    public int getFreeBlocksCount() {
        int freeBlocks = 0;
        for (int i : stackBlocks) {
            if (i == 0) freeBlocks++;
        }
        return freeBlocks;
    }

    public int pop() {
        int blockToPop = getFreeBlockIndex() - 1;
        if (blockToPop < 0) throw new IllegalArgumentException();

        int elementToBePopped = stackBlocks[blockToPop];
        stackBlocks[blockToPop] = 0;
        return elementToBePopped;
    }

    public int peek() {
        int blockToPeek = getFreeBlockIndex() - 1;
        if (blockToPeek < 0) throw new IllegalArgumentException();

        return stackBlocks[blockToPeek];
    }
}
