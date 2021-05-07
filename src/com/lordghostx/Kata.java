package com.lordghostx;

import java.util.ArrayList;

public class Kata {
    public int countUnique(int ... args) {
        ArrayList<Integer> uniqueItems = new ArrayList<>();
        for (int i : args) {
            if (!uniqueItems.contains(i)) uniqueItems.add(i);
        }
        return uniqueItems.size();
    }

    public static String formatPhoneNumber(String phoneNumber) {
        // extract the last 3 numbers
        String lastThree = phoneNumber.substring(phoneNumber.length() - 3);

        // reverse the input excluding the last 3 digits
        StringBuilder reversedPhoneBuilder = new StringBuilder(lastThree);
        for (int i = phoneNumber.length() - 4; i >= 0; i--) {
            reversedPhoneBuilder.append(phoneNumber.charAt(i));
        }

        // format the initial output
        StringBuilder formattedPhoneBuilder = new StringBuilder(lastThree);
        formattedPhoneBuilder.insert(0, "(+");
        formattedPhoneBuilder.append(") ");

        // format rest of the string
        for (int i = 3; i < reversedPhoneBuilder.length(); i+=3) {
            int end = Math.min(reversedPhoneBuilder.length(), i + 3);
            formattedPhoneBuilder.append(reversedPhoneBuilder.substring(i, end)).append("-");
        }

        return formattedPhoneBuilder.substring(0, formattedPhoneBuilder.length() - 1);
    }

    public static String reverseWord(String word) {
        StringBuilder newWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            newWord.append(word.charAt(i));
        }
        return newWord.toString();
    }

    public static boolean checkPalindrome(String word) {
        String newWord = reverseWord(word);
        return word.equals(newWord);
    }
}
