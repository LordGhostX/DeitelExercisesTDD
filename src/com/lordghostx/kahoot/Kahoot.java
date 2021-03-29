package com.lordghostx.kahoot;

import java.util.ArrayList;
import java.util.Random;

public class Kahoot {
    ArrayList<Question> questions = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();
    private int globalQuestionID;
    private int globalGameID;

    public void createQuestion(String title, String[] options, char answer) {
        Question question = new Question(globalQuestionID++, title, options, answer);
        questions.add(question);
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public void deleteQuestion(int questionID) {
        questions.remove(findQuestionWithID(questionID));
    }

    private Question findQuestionWithID(int questionID) {
        for (Question question : questions) {
            if (question.getQuestionID() == questionID) {
                return question;
            }
        }
        return null;
    }

    public void createGame(int gameTimer, int gameQuestionCount) {
        boolean gameCanBeCreated = gameTimer > 0 && gameQuestionCount > 0 && gameQuestionCount <= getTotalQuestions();
        if (gameCanBeCreated) {
            Question[] gameQuestions = generateQuestions(gameQuestionCount);
            Game game = new Game(globalGameID++, gameTimer, gameQuestions);
            games.add(game);
        }
    }

    private Question[] generateQuestions(int gameQuestionCount) {
        Question[] generatedQuestions = new Question[gameQuestionCount];
        ArrayList<Question> tempQuestions = (ArrayList<Question>) questions.clone();

        Random rand = new Random();
        for (int i = 0; i < gameQuestionCount; i++) {
            int randomIndex = rand.nextInt(tempQuestions.size());
            generatedQuestions[i] = tempQuestions.get(randomIndex);
            tempQuestions.remove(randomIndex);
        }

        return generatedQuestions;
    }

    public int getTotalGames() {
        return games.size();
    }

    public void deleteGame(int gameID) {
        games.remove(findGameWithID(gameID));
    }

    public Game getGame(int gameID) {
        return findGameWithID(gameID);
    }

    private Game findGameWithID(int gameID) {
        for (Game game : games) {
            if (game.getGameID() == gameID) {
                return game;
            }
        }
        return null;
    }
}
