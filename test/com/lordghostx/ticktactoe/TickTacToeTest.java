package com.lordghostx.ticktactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TickTacToeTest {
    TickTacToe game;

    @BeforeEach
    void beforeEach() {
        game = new TickTacToe();
    }

    @AfterEach
    void afterEach() {
        game = null;
    }

    @Test
    void gameBoardCanBeVisualized() {
        assertEquals("| | | |\n| | | |\n| | | |", game.visualizeBoard());
    }

    @Test
    void gameCanAllowUserToPlay() {
        game.playMove(1);
        assertEquals("|X| | |\n| | | |\n| | | |", game.visualizeBoard());

        game.playMove(8);
        assertEquals("|X| | |\n| | | |\n| |X| |", game.visualizeBoard());

        game.playMove(6);
        assertEquals("|X| | |\n| | |X|\n| |X| |", game.visualizeBoard());
    }

    @Test
    void gameCanOnlyPlayInEmptyPosition() {
        game.playMove(1);
        game.playMove(1);
        assertEquals("|X| | |\n| | | |\n| | | |", game.visualizeBoard());
    }

    @Test
    void gameKnowsWhenTheBoardIsFilled() {
        assertFalse(game.hasEnded());

        game.playMove(1);
        assertFalse(game.hasEnded());

        for (int i = 2; i <= 9; i++) {
            game.playMove(i);
        }
        assertTrue(game.hasEnded());
    }

    @Test
    void gameCanDetectPlayerHorizontalWinAttempt() {
        assertEquals(-1, game.detectWinAttempt('X'));

        game.playMove(1);
        assertEquals(-1, game.detectWinAttempt('X'));
        game.playMove(2);
        assertEquals(0, game.detectWinAttempt('X'));

        TickTacToe secondGame = new TickTacToe();
        secondGame.playMove(1);
        assertEquals(-1, secondGame.detectWinAttempt('X'));
        secondGame.playMove(3);
        assertEquals(0, secondGame.detectWinAttempt('X'));

        TickTacToe thirdGame = new TickTacToe();
        thirdGame.playMove(2);
        assertEquals(-1, thirdGame.detectWinAttempt('X'));
        thirdGame.playMove(3);
        assertEquals(0, thirdGame.detectWinAttempt('X'));

        TickTacToe forthGame = new TickTacToe();
        forthGame.playMove(7);
        assertEquals(-1, forthGame.detectWinAttempt('X'));
        forthGame.playMove(9);
        assertEquals(2, forthGame.detectWinAttempt('X'));
    }
}