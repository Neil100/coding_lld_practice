package com.example.tictactoe;

import com.example.tictactoe.exception.InvalidMoveException;
import com.example.tictactoe.exception.PlaceAlreadyOccupiedException;

import java.util.Scanner;

public class Player implements GameObserver, Mover {

    private String name;
    private Piece piece;

    private TicTacToeGame game;

    Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }
    @Override
    public Move yourTurn() throws PlaceAlreadyOccupiedException, InvalidMoveException {
        System.out.println(name + " : this is your turn.");
        Scanner scanner = new Scanner(System.in);
        int xIndex = scanner.nextInt();
        int yIndex = scanner.nextInt();

        Move move = new Move(xIndex, yIndex);
        move(move);
        return move;
    }

    @Override
    public void wrongMove() {

    }

    @Override
    public void youWon() {
        System.out.println(name + " has won the game.");
    }

    @Override
    public void youLost() {
        System.out.println(name + " has lost the game.");
    }

    @Override
    public void setGame(TicTacToeGame game) {
        this.game = game;
    }

    @Override
    public void youHaveDrawn() {
        System.out.println(name + " has drawn the game.");
    }


    @Override
    public void move(Move move) throws PlaceAlreadyOccupiedException, InvalidMoveException {
        game.implementMove(this, move);
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    public TicTacToeGame getGame() {
        return game;
    }
}
