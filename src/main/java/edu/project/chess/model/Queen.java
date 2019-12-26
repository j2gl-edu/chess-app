package edu.project.chess.model;

public class Queen extends ChessPiece {

    public Queen(char color) {
        super("Queen", color);
    }

    @Override
    public String display() {
        return "Q";
    }

}
