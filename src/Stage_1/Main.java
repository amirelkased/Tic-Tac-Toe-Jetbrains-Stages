package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CommonMethod ticTacToe = new CommonMethod();

    public static void main(String[] args) {
        // write your code here
        System.out.print("Enter the cells: > ");
        ticTacToe.fetchInput(scanner.nextLine().replace('_', ' '));
        ticTacToe.displayBoard();
        System.out.println("Enter the coordinates: > ");
        while (true) {
            String first = scanner.next();
            int x = checkDigit(first);
            if (x == Integer.MIN_VALUE) {
                continue;
            }
            String second = scanner.next();
            int y = checkDigit(second);
            if (y == Integer.MIN_VALUE) {
                continue;
            }
            if (x > 3 || y > 3 || x < 1 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (ticTacToe.checkOccupied(x - 1, y - 1)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            ticTacToe.setBoard(x - 1, y - 1);
            ticTacToe.displayBoard();
            ticTacToe.checkBoard();
            break;
        }
    }


    private static int checkDigit(String ch) {
        try {
            return Integer.parseInt(ch);
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return Integer.MIN_VALUE;
        }
    }
}
