package tictactoe;

import static tictactoe.CommonMethod.*;
import static tictactoe.Main.*;

public interface Modes {
    void operation(String level);

    default void selectLevel(String level, char piece) {
        CommonMethod player = new CommonMethod();
        switch (level) {
            case "easy" -> {
                switch (piece) {
                    case 'X' -> player.AutoSetXEasyUser();
                    case 'O' -> player.AutoSetOEasyUser();
                }
            }
            case "medium" -> {
                switch (piece) {
                    case 'X' -> player.AutoSetXMediumUser();
                    case 'O' -> player.AutoSetOMediumUser();
                }
            }
        }
    }
}

class AIxAI implements Modes {

    @Override
    public void operation(String level) {
        displayBoard();
        while (true) {
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'X');
            displayBoard();
            if (checkBoard()) break;
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class UserAI implements Modes {

    @Override
    public void operation(String level) {
        displayBoard();
        while (true) {
            takeInput('X');
            displayBoard();
            if (checkBoard()) break;
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class AIUser implements Modes {

    @Override
    public void operation(String level) {
        displayBoard();
        while (true) {
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'X');
            displayBoard();
            if (checkBoard()) break;
            takeInput('O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class UserUser implements Modes {
    @Override
    public void operation(String level) {
        displayBoard();
        while (true) {
            takeInput('X');
            displayBoard();
            if (checkBoard()) break;
            takeInput('O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}
