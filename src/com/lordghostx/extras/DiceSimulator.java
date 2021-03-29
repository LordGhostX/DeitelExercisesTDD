package com.lordghostx.extras;

public class DiceSimulator {
    public static void main(String[] args) {
        long[] diceNumbers = new long[6];
        for (int i = 0; i < 60_000_000; i++) {
            diceNumbers[generateDiceNumber()] += 1;
        }

        System.out.println("Number\tCount");
        for (int i = 0; i < diceNumbers.length; i++) {
            System.out.printf("%d\t\t%d%n", i + 1, diceNumbers[i]);
        }
    }

    public static int generateDiceNumber() {
        int diceNumber = (int) Math.round(Math.random() * 1000);
        return diceNumber % 6;
    }
}
