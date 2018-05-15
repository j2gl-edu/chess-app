package edu.project.chess.model;

public class King extends ChessPiece {

    public King(char color) {
        super("King", color);
    }

    public String display() {
        return "K";
    }

}
