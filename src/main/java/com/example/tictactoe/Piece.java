package com.example.tictactoe;

public class Piece {
    PieceSymbol symbol = PieceSymbol.DOT;
    public void draw() {
        System.out.print(symbol.value);
    }
    public PieceSymbol getSymbol() {
        return symbol;
    }
}
