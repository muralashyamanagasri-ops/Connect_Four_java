 import java.util.Scanner;

public class ConnectFour {

    static final int ROWS = 6;
    static final int COLS = 7;
    static char[][] board = new char[ROWS][COLS];

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    initializeBoard();

    char currentPlayer = 'X';

    while (true) {

        printBoard();

        System.out.print("Player " + currentPlayer + ", enter column (1-7) or 0 to quit: ");
int col = sc.nextInt();

if (col == 0) {
    System.out.println("Game Ended!");
    break;
}

dropPiece(col - 1, currentPlayer);
if (checkWin(currentPlayer)) {
    printBoard();
    System.out.println("Player " + currentPlayer + " Wins!");
    break;
}

        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}

    static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("1 2 3 4 5 6 7");
    }

static void dropPiece(int col, char piece) {

    for (int row = ROWS - 1; row >= 0; row--) {

        if (board[row][col] == '.') {
            board[row][col] = piece;
            break;
        }
    }
}
static boolean checkWin(char player) {

    // Horizontal
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col <= COLS - 4; col++) {

            if (board[row][col] == player &&
                board[row][col + 1] == player &&
                board[row][col + 2] == player &&
                board[row][col + 3] == player) {

                return true;
            }
        }
    }

    // Vertical
    for (int col = 0; col < COLS; col++) {
        for (int row = 0; row <= ROWS - 4; row++) {

            if (board[row][col] == player &&
                board[row + 1][col] == player &&
                board[row + 2][col] == player &&
                board[row + 3][col] == player) {

                return true;
            }
        }
    }

    // Diagonal ↘
    for (int row = 0; row <= ROWS - 4; row++) {
        for (int col = 0; col <= COLS - 4; col++) {

            if (board[row][col] == player &&
                board[row + 1][col + 1] == player &&
                board[row + 2][col + 2] == player &&
                board[row + 3][col + 3] == player) {

                return true;
            }
        }
    }

    // Diagonal ↗
    for (int row = 3; row < ROWS; row++) {
        for (int col = 0; col <= COLS - 4; col++) {

            if (board[row][col] == player &&
                board[row - 1][col + 1] == player &&
                board[row - 2][col + 2] == player &&
                board[row - 3][col + 3] == player) {

                return true;
            }
        }
    }

    return false;
}
}
    

