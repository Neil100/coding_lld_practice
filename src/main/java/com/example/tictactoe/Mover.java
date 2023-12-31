package com.example.tictactoe;

import com.example.tictactoe.exception.InvalidMoveException;
import com.example.tictactoe.exception.PlaceAlreadyOccupiedException;

public interface Mover {
    void move(Move move) throws PlaceAlreadyOccupiedException, InvalidMoveException;
}
