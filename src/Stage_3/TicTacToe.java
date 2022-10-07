package tictactoe;

import static tictactoe.CommonMethod.*;

public class TicTacToe {
    protected static char[][] board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    protected static int xCounter = 0;
    protected static int oCounter = 0;

    public void setXUser(int x, int y) {
        board[x - 1][y - 1] = 'X';
        ++xCounter;
    }

    public void setOUser(int x, int y) {
        board[x - 1][y - 1] = 'O';
        ++oCounter;
    }

    public void AutoSetXUser() {
        int x;
        int y;
        do {
            x = easyLevel();
            y = easyLevel();
        } while (checkOccupied(x + 1, y + 1));
        board[x][y] = 'X';
        ++xCounter;
    }

    public void AutoSetOUser() {
        int x;
        int y;
        do {
            x = easyLevel();
            y = easyLevel();
        } while (checkOccupied(x + 1, y + 1));
        board[x][y] = 'O';
        ++oCounter;
    }

    public void fetchInput(String xo) {
        for (int i = 0, j = 0, k = 0; i < xo.length(); j++, i++) {
            if (j == 3) {
                j = 0;
                ++k;
            }
            board[k][j] = xo.charAt(i);
            switch (xo.charAt(i)) {
                case 'X' -> ++xCounter;
                case 'O' -> ++oCounter;
                default -> {
                }
            }
        }
    }

    public void setBoard(int x, int y) {
        if (xCounter <= oCounter) {
            board[x - 1][y - 1] = 'X';
        } else {
            board[x - 1][y - 1] = 'O';
        }
    }
}
