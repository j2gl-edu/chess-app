package edu.project.chess.model;

public abstract class ChessPiece {

    private String name;
    
    // W - White, B = balck;
    private char color;
    private int moveCounter;

    private String displayChar;

    ChessPiece(String name, char color) {
        this.moveCounter = 0;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public abstract String display();

}