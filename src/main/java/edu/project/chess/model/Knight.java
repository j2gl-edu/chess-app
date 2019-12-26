package edu.project.chess.model;

public class Knight extends ChessPiece {

    public Knight(char color) {
        super("Knight", color);
    }

    @Override
    public String display() {
        return "N";
    }

}
