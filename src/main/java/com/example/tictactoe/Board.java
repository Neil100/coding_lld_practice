package com.example.tictactoe;

import com.example.tictactoe.exception.InvalidMoveException;
import com.example.tictactoe.exception.PlaceAlreadyOccupiedException;

public class Board {
    private Piece[][] board;

    Board() {
        board = new Piece[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = new Piece();
            }
        }
    }
    public void addPiece(Piece piece, Move move, String playerName) throws InvalidMoveException, PlaceAlreadyOccupiedException {
        // exception if move is invalid
        // exception if place is already occupied
        if((move.getXIndex()>2 || move.getXIndex()<0) || (move.getYIndex()>2 | move.getYIndex()<0)) {
            throw new InvalidMoveException(playerName, move);
        }

        if(!board[move.getXIndex()][move.getYIndex()].getSymbol().equals(PieceSymbol.DOT)) {
            throw new PlaceAlreadyOccupiedException(playerName, move);
        }
        board[move.getXIndex()][move.getYIndex()] = piece;
    }

    public boolean isOccuPied(Move move) {
        if(board[move.getXIndex()][move.getYIndex()].getSymbol().equals(PieceSymbol.DOT)) {
            return true;
        }
        return false;
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void printBoard() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j].draw();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
