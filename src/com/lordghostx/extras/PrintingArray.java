package com.lordghostx.extras;

public class PrintingArray {
    public static void main(String[] args) {
        int[] intArray = {86, 20, 4, 10, -37};

        System.out.println("Printing with a foreach");
        for (int i:intArray) {
            System.out.println(i);
        }

        System.out.println("\nPrinting with a for loop");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        System.out.println("\nPrinting with a while loop");
        int index = -1;
        while (++index < intArray.length) {
            System.out.println(intArray[index]);
        }
    }
}
