package com.lordghostx.extras;

public class PI {
    public static void main(String[] args) {
        int limit = 200_000;

        int denominator = 1;
        double piValue = 0;
        boolean isFound = false;
        int value = 0;
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 1) {
                piValue += 4.0 / denominator;
            } else {
                piValue -= 4.0 / denominator;
            }
            if ((int)(piValue * 100000) == 314159 && isFound == false) {
                value = i;
                isFound = true;
            }
            denominator += 2;
            System.out.printf("%d\t%f%n", i, piValue);
        }
        System.out.println("PI Value: " + piValue);
        System.out.println(value);
    }
}
