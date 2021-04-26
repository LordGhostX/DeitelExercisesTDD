package com.lordghostx.diary;

import java.time.LocalDateTime;

public class DiaryEntry {
    private String entryBody;
    private LocalDateTime entryDate;

    public DiaryEntry(String entryBody) {
        this.entryBody = entryBody;
        this.entryDate = LocalDateTime.now();
    }
}
