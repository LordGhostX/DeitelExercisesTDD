package com.lordghostx.extras;

public class Diamond {
    public static void main(String[] args) {
        int length = 9;

        for (int counter = 1; counter <= length; counter +=2) {
            generateDiamondLine(length, counter);
        }
        for (int counter = length - 2; counter > 0; counter -=2) {
            generateDiamondLine(length, counter);
        }
    }

    public static void generateDiamondLine(int length, int counter) {
        for (int i = 0; i < (length / 2) - (counter / 2); i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= counter; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
