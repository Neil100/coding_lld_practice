package com.example.tictactoe;

import com.example.tictactoe.exception.InvalidMoveException;
import com.example.tictactoe.exception.PlaceAlreadyOccupiedException;

public interface GameObserver {

    public Move yourTurn() throws PlaceAlreadyOccupiedException, InvalidMoveException;

    public void wrongMove();
    public void youWon();
    public void youLost();

    public void setGame(TicTacToeGame game);

    public void youHaveDrawn();
}
