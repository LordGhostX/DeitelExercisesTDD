package com.lordghostx.kahoot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KahootTest {
    Kahoot kahoot;
    Player player;
    String[] sampleOptions = new String[]{"Opt 1", "Opt 2", "Opt 3"};

    @BeforeEach
    void beforeEach() {
        kahoot = new Kahoot();
        player = new Player();
    }

    @AfterEach
    void afterEach() {
        kahoot = null;
        player = null;
    }

    @Test
    void kahootCanCreateQuestion() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        assertEquals(1, kahoot.getTotalQuestions());
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        assertEquals(3, kahoot.getTotalQuestions());
    }

    @Test
    void kahootCanDeleteQuestion() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.deleteQuestion(0);
        assertEquals(1, kahoot.getTotalQuestions());
    }

    @Test
    void kahootCannotDelete404Question() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.deleteQuestion(10);
        assertEquals(1, kahoot.getTotalQuestions());
    }

    @Test
    void kahootCanCreateGame() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        assertEquals(1, kahoot.getTotalGames());
        kahoot.createGame(1, 1);
        kahoot.createGame(1, 1);
        assertEquals(3, kahoot.getTotalGames());
    }

    @Test
    void kahootCanDeleteGame() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        kahoot.createGame(1, 1);
        kahoot.deleteGame(0);
        assertEquals(1, kahoot.getTotalGames());
    }

    @Test
    void kahootCannotDelete404Game() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        kahoot.deleteGame(5);
        assertEquals(1, kahoot.getTotalGames());
    }

    @Test
    void kahootGameCanShowTimer() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(30, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals(30, currentGame.getGameTimer());

        kahoot.createGame(15, 1);
        currentGame = kahoot.getGame(1);
        assertEquals(15, currentGame.getGameTimer());
    }

    @Test
    void kahootGameCannotBeSetToNegativeTimer() {
        for (int i = 0; i < 10; i++) {
            kahoot.createQuestion("Sample Question", sampleOptions, '2');
        }

        kahoot.createGame(-10, 5);
        assertEquals(0, kahoot.getTotalGames());

        kahoot.createGame(10, 5);
        kahoot.createGame(-10, 5);
        assertEquals(1, kahoot.getTotalGames());
    }

    @Test
    void kahootGameCanGenerateQuestions() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(30, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals(1, currentGame.getQuestions().length);

        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(30, 2);
        currentGame = kahoot.getGame(1);
        assertEquals(2, currentGame.getQuestions().length);
    }

    @Test
    void kahootGameGeneratesRandomSetOfQuestions() {
        for (int i = 0; i < 10; i++) {
            kahoot.createQuestion("Sample Question", sampleOptions, '2');
        }

        for (int i = 0; i < 100; i++) {
            kahoot.createGame(1, 2);
            Game currentGame = kahoot.getGame(i);
            assertNotEquals(currentGame.getQuestions()[1].getQuestionID(), currentGame.getQuestions()[0].getQuestionID());
        }
    }

    @Test
    void kahootGameCannotGenerateQuestionsWithNegativeLength() {
        kahoot.createGame(1, -10);
        assertEquals(0, kahoot.getTotalGames());

        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        kahoot.createGame(1, -5);
        assertEquals(1, kahoot.getTotalGames());
    }

    @Test
    void kahootCannotCreateGameWithInsufficientQuestions() {
        kahoot.createGame(1, 1);
        assertEquals(0, kahoot.getTotalGames());
    }

    @Test
    void kahootGameCanEvaluateUserSubmission() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals(1, currentGame.evaluateSubmission("2"));
    }

    @Test
    void kahootGameCanEvaluateWrongSubmissionToZero() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals(0, currentGame.evaluateSubmission("1"));
    }

    @Test
    void kahootGameSubmissionMustBeSameAsQuestions() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals(0, currentGame.evaluateSubmission("111111"));
        assertEquals(0, currentGame.evaluateSubmission(""));
    }

    @Test
    void kahootGameSubmissionMustFollowValidFormat() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals(0, currentGame.evaluateSubmission(" "));
    }

    @Test
    void kahootGameCanGetQuestionInfo() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);
        assertEquals("ID=0\ntitle=Sample Question\noptions=[Opt 1, Opt 2, Opt 3]", currentGame.getQuestions()[0].toString());
    }

    @Test
    void kahootPlayerCanStartGame() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);

        assertNull(player.getCurrentGame());
        player.playGame(currentGame);
        assertNotNull(player.getCurrentGame());
    }

    @Test
    void kahootPlayerCanStopCurrentGame() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);

        player.playGame(currentGame);
        player.stopCurrentGame();
        assertNull(player.getCurrentGame());
    }

    @Test
    void kahootPlayerCanGetGameQuestions() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);

        player.playGame(currentGame);
        assertEquals(1, player.getCurrentGameQuestions().length);
    }

    @Test
    void kahootPlayerCannotGetQuestionsIfThereIsNoGame() {
        assertEquals(0, player.getCurrentGameQuestions().length);
    }

    @Test
    void kahootPlayerCanSubmitGame() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);

        player.playGame(currentGame);
        player.submitGame("2");
        assertEquals(1, player.getScores());

        player.playGame(currentGame);
        player.submitGame("2");
        assertEquals(2, player.getScores());
    }

    @Test
    void kahootPlayerGameIsResetAfterSubmission() {
        kahoot.createQuestion("Sample Question", sampleOptions, '2');
        kahoot.createGame(1, 1);
        Game currentGame = kahoot.getGame(0);

        player.playGame(currentGame);
        assertNotNull(player.getCurrentGame());
        player.submitGame("2");
        assertNull(player.getCurrentGame());
    }
}