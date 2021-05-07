package com.lordghostx;

public class Luhn {
    public static boolean isValid(String number) {
        boolean isCardTypeValid = prefixMatched(number, "4") || prefixMatched(number, "5") || prefixMatched(number, "37") || prefixMatched(number, "6");
        if (!isCardTypeValid) {
            return false;
        }

        int evenPlaceSum = sumOfDoubleEvenPlace(number);
        int oddPlaceSum = sumOfOddPlace(number);
        int totalSum = evenPlaceSum + oddPlaceSum;

        return totalSum % 10 == 0;
    }

    public static int sumOfDoubleEvenPlace(String number) {
        StringBuilder reversedNumberBuilder = new StringBuilder();
        for (int i = getSize(number) - 1; i >= 0; i--) {
            reversedNumberBuilder.append(number.charAt(i));
        }
        String reversedNumber = reversedNumberBuilder.toString();

        int doubleEvenPlaceSum = 0;
        for (int i = 1; i < getSize(number); i+=2) {
            doubleEvenPlaceSum += getDigit(((int) reversedNumber.charAt(i) - 48) * 2);
        }
        return doubleEvenPlaceSum;
    }

    public static int sumOfOddPlace(String number) {
        int numberSum = 0;
        for (int i = 1; i < getSize(number); i+=2) {
            numberSum += (int) number.charAt(i) - 48;
        }
        return numberSum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        }
        else {
            return (number / 10) + (number % 10);
        }
    }

    public static int getSize(String d) {
        return d.length();
    }

    public static boolean prefixMatched(String number, String d) {
        return getPrefix(number, getSize(d)).equals(d);
    }

    public static String getPrefix(String number, int k) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < Math.min(getSize(number), k); i++) {
            prefix.append(number.charAt(i));
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(isValid("4388576018402626"));
        System.out.println(isValid("4388576018410707"));
    }
}
