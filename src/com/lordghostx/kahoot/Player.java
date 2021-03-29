package com.lordghostx.kahoot;

public class Player {
    private int gameScore;
    private Game currentGame;

    public Game getCurrentGame() {
        return currentGame;
    }

    public void playGame(Game game) {
        currentGame = game;
    }

    public void stopCurrentGame() {
        currentGame = null;
    }

    public Question[] getCurrentGameQuestions() {
        if (currentGame == null) return new Question[0];
        else return currentGame.getQuestions();
    }

    public void submitGame(String submission) {
        gameScore += currentGame.evaluateSubmission(submission);
        stopCurrentGame();
    }

    public int getScores() {
        return gameScore;
    }
}
