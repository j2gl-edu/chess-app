package edu.project.chess.model;

public class Bishop extends ChessPiece {

    public Bishop(char color) {
        super("Bishop", color);
    }

    @Override
    public String display() {
        return "B";
    }

}
