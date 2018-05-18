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
        String linea = "";
        String displayPiece;

        for (int y = 7; y >= 0; y--) {
            linea += "  +----+----+----+----+----+----+----+----+\n";
            linea += (y+1) + " ";
            for (int x = 0; x < 8; x++) {
                ChessPiece piece = board[x][y];
                if (piece == null) {
                    displayPiece = "  ";
                } else {
                    displayPiece = piece.getColor() + piece.display();
                }
                linea = linea + "| " + displayPiece + " ";
            }
            linea += "|\n";
        }
        linea += "  +----+----+----+----+----+----+----+----+\n";
        linea += "     A    B    C    D    E    F    G    H";



        return linea;
        // TODO: Use several loops statements to iterate over board matrix to return a String.

//        String s =
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 8 | bR | bN | bB | bQ | bK | bB | bN | bR |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 7 | bP | bP | bP | bP | bP | bP | bP | bP |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 6 |    |    |    |    |    |    |    |    |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 5 |    |    |    |    |    |    |    |    |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 4 |    |    |    |    |    |    |    |    |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 3 |    |    |    |    |    |    |    |    |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 2 | wP | wP | wP | wP | wP | wP | wP | wP |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        " 1 | wR | wN | wB | wQ | wK | wB | wN | wR |\n" +
//        "   +----+----+----+----+----+----+----+----+\n" +
//        "      A    B    C    D    E    F    G    H";
//        return s;
    }


    private boolean validatePosition(int number) {
        if (number >= 0 && number <= 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Moves a piece
     * @param initialPosition The initial position
     * @param finalPosition The final position
     */
    public boolean move(String initialPosition, String finalPosition) {
        // TODO implement any move separated by comma.
        // Example
        //   initialPosition = "E2",
        //   finalPosition = "E4"

        char x1Char = initialPosition.charAt(0);
        int x1 = convertColumn(x1Char);
        int y1 = convertRow(initialPosition.charAt(1) - 48);

        int x2 = convertColumn(finalPosition.charAt(0));
        int y2 = convertRow(finalPosition.charAt(1) - 48);

        System.out.println("Initial Pos: " + x1 + ", " + y1);
        System.out.println("Final Pos: " + x2 + ", " + y2);

        boolean valid = validatePosition(x1) && validatePosition(y1)
                            && validatePosition(x2) && validatePosition(y2);

        if (valid == false || board[x1][y1] == null) {
            return false;
        }


        // DO the move
        ChessPiece temp = board[x1][y1];
        board[x2][y2] = temp;
        board[x1][y1] = null;


        return true;
    }

    /**
     * Move a chess piece.
     * @param input
     * @return true if the move was successfull
     */
    public boolean move(String input) {
        // input = "e2, e4"l
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


    private boolean hasKing(char color) {
        boolean exists = false;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ChessPiece current = board[x][y];
                if (current != null) {
                    if (current.getName().equalsIgnoreCase("King") && current.getColor() == color) {
                        exists = true;
                        break;
                    }
                }
            }
        }
        return exists;
    }

    /**
     * Check if there is a winner
     *
     * @return B if black is winner
     *         W if white is the winner
     *         N if there is no winner
     */
    public char checkWinner() {
        // TODO Check for winner
        char winner;
        if (!hasKing('B')) {
            winner = 'W';
        } else if (!hasKing('W')) {
            winner = 'B';
        } else {
            winner = 'N';
        }


        return winner;
    }

   /**
     * Converts a row number to a matrix coordinate in "Y"
     */
    private int convertRow(int row) {
        int rowNumber;
        if (row >=1 && row <= 8) {
            rowNumber = row - 1;
        } else {
            rowNumber = -1;
        }
        return rowNumber;
    }

    /**
     * Converts a column number to a matrix coordinate in "X"
     */
    private int convertColumn(char col) {
        int columnNumber;
        switch (col) {
            case 'A':
                columnNumber = 0;
                break;
            case 'B':
                columnNumber = 1;
                break;
            case 'C':
                columnNumber = 2;
                break;
            case 'D':
                columnNumber = 3;
                break;
            case 'E':
                columnNumber = 4;
                break;
            case 'F':
                columnNumber = 5;
                break;
            case 'G':
                columnNumber = 6;
                break;
            case 'H':
                columnNumber = 7;
                break;
            default:
                columnNumber = -1;

        }
        return columnNumber;
    }

}