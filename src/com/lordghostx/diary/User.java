package com.lordghostx.diary;

public class User {
    private Diary diary;
    private String username;

    public User(String username, Diary diary) {
        this.username = username;
        this.diary = diary;
    }

    public Diary getDiary() {
        return diary;
    }

    public void createDiaryEntry(String diaryEntry) {
        diary.createEntry(diaryEntry);
    }

    public int getTotalDiaryEntries() {
        return diary.getEntries();
    }
}
