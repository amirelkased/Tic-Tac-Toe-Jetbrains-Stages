package tictactoe;

import java.util.Arrays;

public class CommonMethod extends TicTacToe {

    public boolean checkOccupied(int x, int y) {
        return board[x][y] != ' ';
    }

    public void displayBoard() {
        System.out.println("---------");
        for (char[] chars : board) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.printf(" %c", chars[j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public void checkBoard() {
        if (xoWinChecker('X')) {
            System.out.println("X wins");
        } else if (xoWinChecker('O')) {
            System.out.println("O wins");
        } else if (xCounter + oCounter == 9) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    private boolean xoWinChecker(char xo) {
        // check rows
        for (char[] chars : board) {
            if (Arrays.equals(new char[]{xo, xo, xo}, chars)) {
                return true;
            }
        }
        // check columns
        for (int j = 0, i = 0; j < board.length; ++j) {
            if (Arrays.equals(new char[]{xo, xo, xo}, new char[]{board[i][j], board[i + 1][j], board[i + 2][j]})) {
                return true;
            }
        }
        // check diagonal
        return Arrays.equals(new char[]{xo, xo, xo}, new char[]{board[0][0], board[1][1], board[2][2]})
                || Arrays.equals(new char[]{xo, xo, xo}, new char[]{board[0][2], board[1][1], board[2][0]});
    }
}
