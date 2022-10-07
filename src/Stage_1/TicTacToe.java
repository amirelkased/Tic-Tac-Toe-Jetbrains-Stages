package tictactoe;


public class TicTacToe {
    protected static char[][] board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    protected static int xCounter = 0;
    protected static int oCounter = 0;

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
            board[x][y] = 'X';
        } else {
            board[x][y] = 'O';
        }
    }
}
