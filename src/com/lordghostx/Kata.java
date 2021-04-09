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
}
