package edu.project.chess.model;

public class Rook extends ChessPiece {

    public Rook(char color) {
        super("Rook", color);
    }

    public String display() {
        return "R";
    }
}
