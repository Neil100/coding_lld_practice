package com.example.tictactoe;

public enum PieceSymbol {
    CROSS("X"),
    NUTS("O"),
    DOT(".");

    String value;
    PieceSymbol(String value) {
        this.value = value;
    }

}
