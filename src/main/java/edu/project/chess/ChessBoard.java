package edu.project.chess;

import edu.project.chess.model.ChessPiece;
import edu.project.chess.model.King;
import edu.project.chess.model.Rook;

public class ChessBoard {

    public static final char WHITE = 'W';
    public static final char BLACK = 'B';

    private ChessPiece board[][];
    private ChessPiece blackCapturedPieces[];
    private ChessPiece whiteCapturedPieces[];
    private boolean whiteTurn;

    public ChessBoard() {
        whiteTurn = true;
        board = new ChessPiece[8][8];
        initBoard(board);
    }

    private void initBoard(ChessPiece[][] board) {
        // TODO Setup the board
        board[0][0] = new Rook(WHITE);
        board[4][0] = new King(WHITE);

        board[0][7] = new Rook(BLACK);
        board[4][7] = new King(BLACK);
    }

    /**
     * Creates a representation of the board in a String
     */
    public String convertBoardToString() {
        // TODO: Use several loops statements to iterate over board matrix to return a String.

        String s = 
        "   +----+----+----+----+----+----+----+----+\n" +
        " 8 | bR | bN | bB | bQ | bK | bB | bN | bR |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 7 | bP | bP | bP | bP | bP | bP | bP | bP |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 6 |    |    |    |    |    |    |    |    |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 5 |    |    |    |    |    |    |    |    |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 4 |    |    |    |    |    |    |    |    |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 3 |    |    |    |    |    |    |    |    |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 2 | wP | wP | wP | wP | wP | wP | wP | wP |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        " 1 | wR | wN | wB | wQ | wK | wB | wN | wR |\n" +
        "   +----+----+----+----+----+----+----+----+\n" +
        "      A    B    C    D    E    F    G    H";
        return s;
    }


    /**
     * Moves a piece
     * @param initialPosition The initial position
     * @param finalPosition The final position
     */
    public boolean move(String initialPosition, String finalPosition) {
        // TODO implement any move separated by comma.
        // Example "E2,E4"
        return true;
    }

    /**
     * Move a chess piece.
     * @param input
     * @return true if the move was successfull
     */
    public boolean move(String input) {
        String s[] = input.split(",");
        boolean valid = true;
        if (s.length != 2) {
            valid = false;
        } else {
            String initialPos = s[0].trim().toUpperCase();
            String finalPos = s[1].trim().toUpperCase();
            valid = move(initialPos, finalPos);
        }
        return valid;
    }


    /**
     * Check if there is a winner
     *
     * @return B if black is winner
     *         W if white is the winner
     *         N if there is on winner
     */
    public char checkWinner() {
        // TODO Check for winner
        return 'N';
    }

   /**
     * Converts a row number to a matrix coordinate in "Y"
     */
    private int convertRow(int row) {
        // TODO Implement
        return 0;
    }

    /**
     * Converts a column number to a matrix coordinate in "X"
     */
    private int converColumn(char col) {
        // TODO Implement
        return 0;
    }

}