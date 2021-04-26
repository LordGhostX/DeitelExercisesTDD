package com.lordghostx.diary;

import java.util.ArrayList;

public class Diary {
    ArrayList<DiaryEntry> entries = new ArrayList<>();

    public void createEntry(String diaryEntry) {
        DiaryEntry newEntry = new DiaryEntry(diaryEntry);
        entries.add(newEntry);
    }

    public int getEntries() {
        return entries.size();
    }
}
