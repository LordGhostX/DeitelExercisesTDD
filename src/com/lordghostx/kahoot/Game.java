package com.lordghostx.kahoot;

public class Game {
    private final int gameID;
    private final int gameTimer;
    private final Question[] gameQuestions;

    public Game(int gameID, int gameTimer, Question[] gameQuestions) {
        this.gameID = gameID;
        this.gameTimer = gameTimer;
        this.gameQuestions = gameQuestions;
    }

    public int getGameID() {
        return gameID;
    }

    public int getGameTimer() {
        return gameTimer;
    }

    public Question[] getQuestions() {
        return gameQuestions;
    }

    public int evaluateSubmission(String submission) {
        if (submission.length() != gameQuestions.length) return 0;
        int score = 0;
        for (int i = 0; i < gameQuestions.length; i++) {
            if (submission.charAt(i) == gameQuestions[i].getAnswer()) score++;
        }
        return score;
    }
}
