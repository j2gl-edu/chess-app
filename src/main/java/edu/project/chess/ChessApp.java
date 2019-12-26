package edu.project.chess;

import java.util.Scanner;

public class ChessApp {

    private void playChess() {
        ChessBoard chessBoard = new ChessBoard();
        Scanner reader = new Scanner(System.in);
        
        int playNumber = 0;
        boolean matchDone = false;

        while (!matchDone) {
            playNumber++;

            System.out.println(chessBoard.convertBoardToString());
            System.out.println();

            boolean validMove;
            do {
                String command = playNumber + ": ";
                command += (chessBoard.isWhiteTurn() ? "White" : "Black");
                command += " turn ---> ";
                System.out.print(command);
                String playerInput = reader.nextLine();

                if (playerInput.equalsIgnoreCase("exit")) {
                    matchDone = true;
                    validMove = true;
                } else {
                    validMove = chessBoard.move(playerInput);
                }

            } while (!validMove);

            switch (chessBoard.checkWinner()) {
                case 'W':
                    System.out.println("White pieces won.");
                    matchDone = true;
                    break;
                case 'B':
                    System.out.println("Black pieces won.");
                    matchDone = true;
                    break;
            }
        }
        reader.close();

    }

    public static void main(String[] args) {

        System.out.println("Chess App");
        ChessApp chess = new ChessApp();
        chess.playChess();
    }

}
