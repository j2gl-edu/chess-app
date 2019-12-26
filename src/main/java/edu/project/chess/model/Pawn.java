package edu.project.chess.model;

public class Pawn extends ChessPiece {

    public Pawn(char color) {
        super("Pawn", color);
    }

    @Override
    public String display() {
        return "P";
    }

}
