package com.example.tictactoe.exception;

public class PlayersLimitReachedException extends RuntimeException {

    public PlayersLimitReachedException(int limit) {
        super("Player limit can not be more than " + limit);
    }
}
