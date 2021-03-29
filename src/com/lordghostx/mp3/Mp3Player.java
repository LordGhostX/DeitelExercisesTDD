package com.lordghostx.mp3;

import java.util.ArrayList;

public class Mp3Player {
    private boolean isOn;
    private final ArrayList<Music> musicList;
    private Music currentPlayingMusic;
    private boolean isPlaying;
    private boolean isStopped;
    private short volume;

    public Mp3Player() {
        musicList = new ArrayList<>();
        currentPlayingMusic = null;
    }

    public boolean isOn() {
        return isOn;
    }

    private void turnOn() {
        isOn = true;
    }

    private void turnOff() {
        isOn = false;
    }

    public void turnMp3OnOrOff() {
        if (isOn)
            turnOff();
        else
            turnOn();
    }

    public void downloadMusic(Music music) {
        boolean canDownloadCurrentMusic = isOn && !musicList.contains(music);
        if (canDownloadCurrentMusic) musicList.add(music);
    }

    public int getTotalMusic() {
        return musicList.size();
    }

    public void deleteMusic(Music music) {
        boolean canDeleteCurrentMusic = isOn && musicList.contains(music);
        if (canDeleteCurrentMusic) musicList.remove(music);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void pauseOrPlayMusic(Music music) {
        boolean canPauseOrPlayCurrentMusic = isOn && musicList.contains(music);
        boolean musicIsTheSame = isPlaying && music.equals(getCurrentMusic());
        if (canPauseOrPlayCurrentMusic)
            if (musicIsTheSame) pauseMusic();
            else playMusic(music);
    }

    private void playMusic(Music music) {
        isPlaying = true;
        isStopped = false;
        currentPlayingMusic = music;
    }

    private void pauseMusic() {
        isPlaying = false;
    }

    public void stopCurrentMusic() {
        if (isOn) stopMusic();
    }

    private void stopMusic() {
        pauseMusic();
        isStopped = true;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public Music getCurrentMusic() {
        return currentPlayingMusic;
    }

    public int getVolume() {
        return volume;
    }

    public void increaseMp3Volume() {
        if (isOn) increaseVolume();
    }

    private void increaseVolume() {
        boolean volumeCanBeIncreased = volume < 10;
        if (volumeCanBeIncreased) volume++;
    }

    public void decreaseMp3Volume() {
        if (isOn) decreaseVolume();
    }

    private void decreaseVolume() {
        boolean volumeCanBeDecreased = volume > 0;
        if (volumeCanBeDecreased) volume--;
    }

    public void playNextMusic() {
        int currentMusicIndex = getCurrentMusicIndex();
        if (musicList.size() > currentMusicIndex + 1) pauseOrPlayMusic(musicList.get(currentMusicIndex + 1));
    }

    private int getCurrentMusicIndex() {
        Music currentMusic;
        currentMusic = getCurrentMusic();
        return musicList.indexOf(currentMusic);
    }
}
