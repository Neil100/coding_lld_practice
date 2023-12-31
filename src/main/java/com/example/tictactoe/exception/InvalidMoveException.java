package com.example.tictactoe.exception;

import com.example.tictactoe.Move;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String playerName, Move move) {
        super("Player: " + playerName + " has played an invalid move. The position should be from 0 to 2 (both inclusive)");
    }
}
