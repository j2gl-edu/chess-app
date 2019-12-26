package edu.project.chess.model;

public class King extends ChessPiece {

    public King(char color) {
        super("King", color);
    }

    @Override
    public String display() {
        return "K";
    }

}
