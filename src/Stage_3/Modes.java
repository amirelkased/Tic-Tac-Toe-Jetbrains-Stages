package tictactoe;

import static tictactoe.CommonMethod.*;
import static tictactoe.Main.*;

public interface Modes {
    void operation();
}

class EasyEasy implements Modes {
    CommonMethod player = new CommonMethod();

    @Override
    public void operation() {
        displayBoard();
        while (true) {
            System.out.println("Making move level \"easy\"");
            player.AutoSetXUser();
            displayBoard();
            if (checkBoard()) break;
            System.out.println("Making move level \"easy\"");
            player.AutoSetOUser();
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class UserEasy implements Modes {
    CommonMethod player = new CommonMethod();

    @Override
    public void operation() {
        displayBoard();
        while (true) {
            takeInput('X');
            displayBoard();
            if (checkBoard()) break;
            System.out.println("Making move level \"easy\"");
            player.AutoSetOUser();
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class EasyUser implements Modes {
    CommonMethod player = new CommonMethod();

    @Override
    public void operation() {
        displayBoard();
        while (true) {
            System.out.println("Making move level \"easy\"");
            player.AutoSetXUser();
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
    public void operation() {
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
