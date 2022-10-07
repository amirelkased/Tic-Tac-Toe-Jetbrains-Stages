package tictactoe;

import java.util.Scanner;

import static tictactoe.CommonMethod.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CommonMethod ticTacToe = new CommonMethod();

    public static void main(String[] args) {
        String CL;
        while (true) {
            System.out.print("Input command: > ");
            CL = scanner.nextLine();
            if (CL.equals("exit") || checkCommandLine(CL)) {
                break;
            }
            System.out.println("Bad parameters!");
        }
        switch (CL) {
            case "start easy easy" -> new EasyEasy().operation();
            case "start user easy" -> new UserEasy().operation();
            case "start easy user" -> new EasyUser().operation();
            case "start user user" -> new UserUser().operation();
            default -> {
            }
        }
    }

    private static boolean checkCommandLine(String CL) {
        String[] allCL = CL.split(" ");
        return allCL.length == 3 && allCL[0].equals("start")
                && (allCL[1].contains("easy") || allCL[1].contains("user"))
                && (allCL[2].contains("easy") || allCL[2].contains("user"));
    }

    public static void takeInput(char xOro) {
        while (true) {
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
            if (checkOccupied(x, y)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            if (xOro == 'X') {
                ticTacToe.setXUser(x, y);
            } else {
                ticTacToe.setOUser(x, y);
            }
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
