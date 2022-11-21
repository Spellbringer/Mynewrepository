import java.util.Objects;
import java.util.Scanner;

public class Main {
    static boolean winnerSet = false;
    static String winner = "Meh";
    static byte turns = 0;
    static byte number;
    static Scanner scan = new Scanner(System.in);
    static String[][] gameBoard = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};

    public static void main(String[] args) {
    gameStart();

    }

    private static void boardCreate() {
        for (byte i = 0; i < gameBoard.length; i++) {
            for (byte j = 0; j < gameBoard.length; j++) {
                if (Objects.equals(gameBoard[i][j], String.valueOf(number))) {
                        if (turns % 2 == 0) {
                            gameBoard[i][j] = "X";
                        } else {
                            gameBoard[i][j] = "O";
                        }
                    turns++;
                    }
                    System.out.print(" " + gameBoard[i][j] + " ");
                }
                System.out.println();
            }
        winCombinations();
    }

    private static void inputScanner() {
        if (turns % 2 == 0) {
            System.out.println();
            System.out.println("It's player X turn. Please, enter a number on the board to fill it with 'X':");
        } else {
            System.out.println();
            System.out.println("It's player O turn. Please, enter a number on the board to fill it with 'O':");
        }
        char buffnum = scan.next().charAt(0);
        if (Character.isDigit(buffnum)) {
            byte num = Byte.parseByte(String.valueOf(buffnum));
            if (num <= 0 || num >= 10) {
                System.out.println("Wrong board position. Repeat your input:");
                boardCreate();
                inputScanner();
            }
            number = num;
            boardCreate();
        }
        else {
            System.out.println("Entered value is NaN! Please, repeat your input.");
            boardCreate();
        }
    }

    static void winCombinations() {
        //gameBoard = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
        String str = null;
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case (0):
                 str =  gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2];
                 break;
                case (1):
                 str =  gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2];
                 break;
                case (2):
                 str =  gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2];
                 break;
                case (3):
                 str =  gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0];
                 break;
                case(4):
                 str =  gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1];
                 break;
                case(5):
                 str =  gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2];
                 break;
                case(6):
                 str = gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2];
                 break;
                case (7):
                 str = gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0];
                 break;
            }
            if (str.equals("XXX")) {
                winner = "X";
                setWinner();
            }
            else if (str.equals("OOO")) {
                winner = "O";
                setWinner();
            }

        }
        if (turns == 9) {
            winner = "DRAW";
            setWinner();
        }
        while(!winnerSet) {
            inputScanner();
        }
    }
    private static void setWinner(){
        if (winner.equals("X")) {
            System.out.println("The X player has won! Congratulations! Thank you for playing!");
            winnerSet = true;
        } else if (winner.equals("O")) {
            System.out.println("The O player has won! Congratulations! Thank you for playing!");
            winnerSet = true;
        } else {
            winner.equals("DRAW");
            System.out.println("DRAW!");
            winnerSet = true;
        }
    }
    public static void gameStart(){
        System.out.println("Welcome to 3x3 Tic-Tac-Toe by me! If you want to start to play, just type 'Y', otherwise game will finish itself");
        char answer = scan.next().charAt(0);
        if (Character.toLowerCase(answer) == 'y' || Character.toLowerCase(answer) == 'н') {
            System.out.println("Wise decision...Starting the game.");
            boardCreate();

        } else {
            System.out.println("No you couldn't refuse. I think you just missed the right key. Let's try again...");
            gameStart();
        }
    }
}
