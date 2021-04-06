package com.lordghostx.stack;

public class Stack {
    private final StackElement[] stackBlocks;

    public Stack(int stackSize) {
        if (stackSize <= 0) throw new IllegalArgumentException();
        stackBlocks = new StackElement[stackSize];
    }

    public int getSize() {
        return stackBlocks.length;
    }

    public void push(int number) {
        int freeBlock = getFreeBlockIndex();
        if (freeBlock == -1) throw new StackOverflowError();

        stackBlocks[freeBlock] = new StackElement(number);
    }

    private int getFreeBlockIndex() {
        for (int i = 0; i < stackBlocks.length; i++) {
            if (stackBlocks[i] == null) return i;
        }
        return -1;
    }

    public int getFreeBlocksCount() {
        int freeBlocks = 0;
        for (StackElement element : stackBlocks) {
            if (element == null) freeBlocks++;
        }
        return freeBlocks;
    }

    public int pop() {
        int blockToPop = getFreeBlockIndex() - 1;
        if (blockToPop < 0) throw new IllegalArgumentException();

        int elementToBePopped = stackBlocks[blockToPop].getValue();
        stackBlocks[blockToPop] = null;
        return elementToBePopped;
    }

    public int peek() {
        int blockToPeek = getFreeBlockIndex() - 1;
        if (blockToPeek < 0) throw new IllegalArgumentException();

        return stackBlocks[blockToPeek].getValue();
    }
}
