package com.example.tictactoe;

public class Move {
    private final int xIndex,yIndex;

    public Move(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int getXIndex() {
        return xIndex;
    }

    public int getYIndex() {
        return yIndex;
    }
}
