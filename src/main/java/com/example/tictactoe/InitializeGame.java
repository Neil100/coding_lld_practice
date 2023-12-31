package com.example.tictactoe;

import com.example.tictactoe.exception.PlayersLimitReachedException;

public class InitializeGame {

    public static void main(String[] msg) {
        Player player2 = new Player("Krati", new Nut());
        Player player1 = new Player("Kshitij", new Cross());


        Piece p = new Piece();

        System.out.println(p.getSymbol());
        System.out.println(".");
        Board board = new Board();
        board.printBoard();
        TicTacToeGame game = new TicTacToeGame(board);

        try {
            game.addPlayers(player1);
            game.addPlayers(player2);
        } catch (PlayersLimitReachedException ex) {
            System.out.println("Exception Occured: " + ex.getMessage());
        }

        game.beginGame();
    }
}
