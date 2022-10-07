package tictactoe;

import java.util.Scanner;

import static tictactoe.CommonMethod.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CommonMethod ticTacToe = new CommonMethod();

    public static void main(String[] args) {
        while (true) {
            displayBoard();
            System.out.println("Enter the coordinates: > ");
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
            if (ticTacToe.checkOccupied(x, y)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            ticTacToe.setXUser(x, y);
            displayBoard();
            if (checkBoard()) {
                break;
            }
            System.out.println("Making move level \"easy\"");
            ticTacToe.setOUser();
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
