package com.lordghostx.mp3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mp3PlayerTest {
    Mp3Player mp3Player;
    Music music;

    @BeforeEach
    void beforeEach() {
        mp3Player = new Mp3Player();
        music = new Music();
    }

    @AfterEach
    void afterEach() {
        mp3Player = null;
        music = null;
    }

    @Test
    void mp3PlayerCanBeCreated() {
        assertNotNull(mp3Player);
    }

    @Test
    void mp3PlayerCanBeTurnedOnWithSwitch() {
        assertFalse(mp3Player.isOn());
        mp3Player.turnMp3OnOrOff();
        assertTrue(mp3Player.isOn());
    }

    @Test
    void mp3PlayerCanBeTurnedOffWithSwitch() {
        mp3Player.turnMp3OnOrOff();
        assertTrue(mp3Player.isOn());
        mp3Player.turnMp3OnOrOff();
        assertFalse(mp3Player.isOn());
    }

    @Test
    void mp3PlayerCanDownloadMusic() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCannotDownloadMusicIfOff() {
        mp3Player.downloadMusic(music);
        assertEquals(0, mp3Player.getTotalMusic());
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCanSaveMusic() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
        Music secondMusic = new Music();
        mp3Player.downloadMusic(secondMusic);
        assertEquals(2, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCannotDownloadTheSameMusic() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCanDeleteMusic() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
        mp3Player.deleteMusic(music);
        assertEquals(0, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCannotDeleteMusicIfOff() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.turnMp3OnOrOff();
        mp3Player.deleteMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
        mp3Player.turnMp3OnOrOff();
        mp3Player.deleteMusic(music);
        assertEquals(0, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCannotDelete404Music() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        assertEquals(1, mp3Player.getTotalMusic());
        mp3Player.deleteMusic(music);
        assertEquals(0, mp3Player.getTotalMusic());
        mp3Player.deleteMusic(music);
        assertEquals(0, mp3Player.getTotalMusic());
    }

    @Test
    void mp3PlayerCanStartPlaying() {
        mp3Player.turnMp3OnOrOff();
        assertFalse(mp3Player.isPlaying());
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerCannotPlayIfOff() {
        mp3Player.pauseOrPlayMusic(music);
        assertFalse(mp3Player.isPlaying());
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerCannotPlay404Song() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.pauseOrPlayMusic(music);
        assertFalse(mp3Player.isPlaying());
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerCanKnowIfPlaying() {
        mp3Player.turnMp3OnOrOff();
        assertFalse(mp3Player.isPlaying());
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerCanBePaused() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
        mp3Player.pauseOrPlayMusic(music);
        assertFalse(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerMusicCanBeStopped() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
        mp3Player.stopCurrentMusic();
        assertFalse(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerIsNotStoppedWhenPlaying() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
        assertFalse(mp3Player.isStopped());
        mp3Player.stopCurrentMusic();
        assertTrue(mp3Player.isStopped());
    }

    @Test
    void mp3PlayerIsNotStoppedWhenPaused() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertFalse(mp3Player.isStopped());
        mp3Player.pauseOrPlayMusic(music);
        assertFalse(mp3Player.isStopped());
        mp3Player.pauseOrPlayMusic(music);
    }

    @Test
    void mp3PlayerIsNotPlayingWhenStopped() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
        mp3Player.stopCurrentMusic();
        assertTrue(mp3Player.isStopped());
        assertFalse(mp3Player.isPlaying());
    }

    @Test
    void mp3PlayerCannotStopMusicIfOff() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertTrue(mp3Player.isPlaying());
        mp3Player.turnMp3OnOrOff();
        mp3Player.stopCurrentMusic();
        assertFalse(mp3Player.isStopped());
    }

    @Test
    void mp3PlayerCanGetCurrentlyPlayingMusic() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.downloadMusic(music);
        mp3Player.pauseOrPlayMusic(music);
        assertEquals(music, mp3Player.getCurrentMusic());
    }

    @Test
    void mp3PlayerVolumeCanBeIncreased() {
        mp3Player.turnMp3OnOrOff();
        assertEquals(0, mp3Player.getVolume());
        mp3Player.increaseMp3Volume();
        assertEquals(1, mp3Player.getVolume());
    }

    @Test
    void mp3PlayerVolumeCannotIncreasedIfOff() {
        assertEquals(0, mp3Player.getVolume());
        mp3Player.increaseMp3Volume();
        assertEquals(0, mp3Player.getVolume());
        mp3Player.turnMp3OnOrOff();
        mp3Player.increaseMp3Volume();
        assertEquals(1, mp3Player.getVolume());
    }

    @Test
    void mp3PlayerVolumeCannotExceedTen() {
        mp3Player.turnMp3OnOrOff();
        for (int i = 0; i < 15; i++) {
            mp3Player.increaseMp3Volume();
        }
        assertEquals(10, mp3Player.getVolume());
    }

    @Test
    void mp3PlayerVolumeCanBeDecreased() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.increaseMp3Volume();
        mp3Player.increaseMp3Volume();
        assertEquals(2, mp3Player.getVolume());
        mp3Player.decreaseMp3Volume();
        assertEquals(1, mp3Player.getVolume());
    }

    @Test
    void mp3PlayerVolumeCannotDecreasedIfOff() {
        mp3Player.turnMp3OnOrOff();
        mp3Player.increaseMp3Volume();
        mp3Player.increaseMp3Volume();
        assertEquals(2, mp3Player.getVolume());
        mp3Player.turnMp3OnOrOff();
        mp3Player.decreaseMp3Volume();
        assertEquals(2, mp3Player.getVolume());
        mp3Player.turnMp3OnOrOff();
        mp3Player.decreaseMp3Volume();
        assertEquals(1, mp3Player.getVolume());
    }

    @Test
    void mp3PlayerVolumeCannotExceedZero() {
        mp3Player.turnMp3OnOrOff();
        for (int i = 0; i < 5; i++) {
            mp3Player.decreaseMp3Volume();
        }
        assertEquals(0, mp3Player.getVolume());
    }

    @Test
    void mp3PlayerMusicCanBeMovedToTheNext() {
        mp3Player.turnMp3OnOrOff();
        Music secondMusic = new Music();
        mp3Player.downloadMusic(music);
        mp3Player.downloadMusic(secondMusic);
        mp3Player.pauseOrPlayMusic(music);
        mp3Player.playNextMusic();
        assertEquals(secondMusic, mp3Player.getCurrentMusic());
    }
}