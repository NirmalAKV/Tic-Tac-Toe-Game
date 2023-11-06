package project;

import java.util.Scanner;

public class TicTacToe {
    // Create a 3x3 game board
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public TicTacToe() {
        // Initialize the game board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }
        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    public char checkWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }

        return ' ';
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic-Tac-Toe Game");
        System.out.println("Player X goes first.");

        while (true) {
            System.out.println("\nCurrent board:");
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ", enter your move (row and colum): ");

            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (game.makeMove(row, col)) {
                char winner = game.checkWinner();
                if (winner != ' ') {
                    System.out.println("\nPlayer " + winner + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    System.out.println("\nThe game is a draw!");
                    break;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}
