package com.example.tictactoe.exception;

import com.example.tictactoe.Move;

public class PlaceAlreadyOccupiedException extends Exception {

    public PlaceAlreadyOccupiedException(String name, Move move) {
        super(name+" : Position ("+move.getXIndex()+","+move.getYIndex()+") is already filled.");
    }
}
