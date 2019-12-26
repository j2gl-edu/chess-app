package edu.project.chess;

import edu.project.chess.model.*;

public class ChessBoard {

    private static final char WHITE = 'W';
    private static final char BLACK = 'B';

    private ChessPiece board[][];
    private ChessPiece blackCapturedPieces[];
    private ChessPiece whiteCapturedPieces[];
    private boolean whiteTurn;

    public ChessBoard() {
        whiteTurn = true;
        board = new ChessPiece[8][8];
        initBoard(board);
    }

    private void putPirces(int x, char color) {
        board[0][x] = new Rook(color);
        board[1][x] = new Knight(color);
        board[2][x] = new Bishop(color);
        board[3][x] = new Queen(color);
        board[4][x] = new King(color);
        board[5][x] = new Bishop(color);
        board[6][x] = new Knight(color);
        board[7][x] = new Rook(color);
    }

    private void initBoard(ChessPiece[][] board) {
        putPirces(0, WHITE);
        putPirces(7, BLACK);

        // Pawns
        for (int i = 0; i < board.length; i++) {
            board[i][1] = new Pawn(WHITE);
            board[i][6] = new Pawn(BLACK);
        }
    }

    /**
     * Creates a representation of the board in a String
     */
    public String convertBoardToString() {
        String linea = "";
        String displayPiece;

        for (int y = 7; y >= 0; y--) {
            linea += "  +----+----+----+----+----+----+----+----+\n";
            linea += (y + 1) + " ";
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
    }


    private boolean validatePosition(int number) {
        return number >= 0 && number <= 7;
    }

    /**
     * Moves a piece
     *
     * @param initialPosition The initial position
     * @param finalPosition   The final position
     */
    public boolean move(String initialPosition, String finalPosition) {
        // Example
        //   initialPosition = "E2",
        //   finalPosition = "E4"

        char x1Char = initialPosition.charAt(0);
        int x1 = convertColumn(x1Char);
        int y1 = convertRow(initialPosition.charAt(1) - 48);

        int x2 = convertColumn(finalPosition.charAt(0));
        int y2 = convertRow(finalPosition.charAt(1) - 48);

        boolean valid = validatePosition(x1) && validatePosition(y1)
                && validatePosition(x2) && validatePosition(y2);

        if (!valid || board[x1][y1] == null) {
            return false;
        }

        // DO the move
        ChessPiece temp = board[x1][y1];
        board[x2][y2] = temp;
        board[x1][y1] = null;

        whiteTurn = !whiteTurn;
        return true;
    }

    /**
     * Move a chess piece.
     *
     * @param input
     * @return true if the move was successfull
     */
    boolean move(String input) {
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
     * W if white is the winner
     * N if there is no winner
     */
    public char checkWinner() {
        char winner;
        if (!hasKing(BLACK)) {
            winner = WHITE;
        } else if (!hasKing(WHITE)) {
            winner = BLACK;
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
        if (row >= 1 && row <= 8) {
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

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

}