package com.lordghostx.ticktactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TickTacToeTest {
    TickTacToe game;
    GameBoard board;

    @BeforeEach
    void setUp() {
        board = new GameBoard();
        game = new TickTacToe(board);
    }

    @AfterEach
    void tearDown() {
        game = null;
        board = null;
    }

    @Test
    void gameBoardCanBeVisualized() {
        assertEquals("", board.visualizeBoard());
    }
}