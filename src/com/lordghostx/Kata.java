package com.lordghostx;

import java.util.ArrayList;

public class Kata {

    public int countUnique(int ... args) {
        ArrayList<Integer> countedItems = new ArrayList<Integer>();
        for (int i : args) {
            if (!countedItems.contains(i)) countedItems.add(i);
        }
        return countedItems.size();
    }
}
