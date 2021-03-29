package com.lordghostx.extras;

import java.util.Arrays;

public class Kata {

    public int getTestdrillerCost(int numberOfUnits) {
        int cost;
        if (numberOfUnits >= 200) {
            cost = 800;
        } else if (numberOfUnits >= 100) {
            cost = 900;
        } else if (numberOfUnits >= 50) {
            cost = 1000;
        } else if (numberOfUnits >= 30) {
            cost = 1100;
        } else if (numberOfUnits >= 10) {
            cost = 1200;
        } else if (numberOfUnits >= 5) {
            cost = 1400;
        } else if (numberOfUnits >= 1) {
            cost = 1500;
        } else {
            cost = 0;
        }
        return cost * numberOfUnits;
    }

    public String getFactorsOfNumber(int number) {
        StringBuilder factors = new StringBuilder();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.append(i).append(",");
            }
        }
        factors.append(number);
        return factors.toString();
    }

    public static int getSumOfNumbers(int[] numbers) {
        int sumOfNumbers = 0;
        for (int i:numbers) {
            sumOfNumbers += i;
        }
        return sumOfNumbers;
    }

    public static double getAverageOfNumbers(int[] numbers) {
        return getSumOfNumbers(numbers) / (double) numbers.length;
    }

    public static int getMaximumOfNumbers(int[] numbers) {
        int maximumNumber = numbers[0];
        for (int i:numbers) {
            if (i > maximumNumber) {
                maximumNumber = i;
            }
        }
        return maximumNumber;
    }

    public static int getMinimumOfNumbers(int[] numbers) {
        int minimumNumber = numbers[0];
        for (int i:numbers) {
            if (i < minimumNumber) {
                minimumNumber = i;
            }
        }
        return minimumNumber;
    }

    public static int getMaximumCombinationSum(int[] numbers) {
        return getSumOfNumbers(numbers) - getMinimumOfNumbers(numbers);
    }

    public static int getMinimumCombinationSum(int[] numbers) {
        return getSumOfNumbers(numbers) - getMaximumOfNumbers(numbers);
    }
}
