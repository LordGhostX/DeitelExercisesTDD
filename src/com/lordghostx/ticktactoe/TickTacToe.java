package com.lordghostx.ticktactoe;

public class TickTacToe {
    private final char[][] gameBoard;

    public TickTacToe() {
        gameBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }


    public String visualizeBoard() {
        StringBuilder gameBoardString = new StringBuilder("|");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoardString.append(gameBoard[i][j]).append("|");
            }
            if (i != 2) {
                gameBoardString.append("\n|");
            }
        }
        return gameBoardString.toString();
    }

    public void playMove(int gamePosition) {
        int xAxis = (gamePosition - 1) / 3;
        int yAxis = (gamePosition - 1) % 3;
        if (gameBoard[xAxis][yAxis] == ' ')
            gameBoard[xAxis][yAxis] = 'X';
    }

    public boolean hasEnded() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(gameBoard[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public int[] detectWinAttempt(char playerChar) {
        return new int[] {detectHorizontalWinAttempt('X'), 1};
    }

    private int detectHorizontalWinAttempt(char playerChar) {
        for (int i = 0; i < 3; i++) {
            int playerMoveCount = 0;
            int whiteSpaceCount = 0;
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == playerChar) playerMoveCount++;
                if (gameBoard[i][j] == ' ') whiteSpaceCount++;
            }
            if (playerMoveCount == 2 && whiteSpaceCount == 1) return i;
        }

        return -1;
    }
}
