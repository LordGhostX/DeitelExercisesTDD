package com.lordghostx.diary;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    Diary diary;
    User user;

    @BeforeEach
    void beforeEach() {
        diary = new Diary();
        user = new User("LordGhostX", diary);
    }

    @AfterEach
    void afterEach() {
        diary = null;
        user = null;
    }

    @Test
    void userCanOwnADiary() {
        assertNotNull(user.getDiary());
    }

    @Test
    void userCanCreateDiaryEntry() {
        user.createDiaryEntry("Test Entry");
        assertEquals(1, user.getTotalDiaryEntries());
    }

    @Test
    void userCanCreateMultipleDiaryEntries() {
        user.createDiaryEntry("Test Entry");
        user.createDiaryEntry("Another Test Entry");
        assertEquals(2, user.getTotalDiaryEntries());
    }
}