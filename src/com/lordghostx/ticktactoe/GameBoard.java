package com.lordghostx.ticktactoe;

public class GameBoard {
    private final PlayerCharacters[][] board;

    public GameBoard() {
        board = new PlayerCharacters[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = PlayerCharacters.PlayerEmpty;
            }
        }
    }

    public String visualizeBoard() {
        StringBuilder gameBoardString = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoardString.append(board[i][j]).append("|");
            }
            gameBoardString.append("\n");
        }
        return gameBoardString.substring(0, gameBoardString.length() - 1);
    }
}
