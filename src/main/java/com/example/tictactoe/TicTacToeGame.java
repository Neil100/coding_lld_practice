package com.example.tictactoe;

import com.example.tictactoe.exception.InvalidMoveException;
import com.example.tictactoe.exception.PlaceAlreadyOccupiedException;
import com.example.tictactoe.exception.PlayersLimitReachedException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicTacToeGame {
    GameStatus gameStatus;
    Board board;
    List<GameObserver> players = new ArrayList<>();

    void addPlayers(Player player) {
        if(players.size()<2) {
            players.add(player);
            player.setGame(this);
        } else {
            throw new PlayersLimitReachedException(2);
        }
    }
    TicTacToeGame(Board board) {
        this.board = board;
        gameStatus = GameStatus.NOT_STARTED;
    }
    public void beginGame() {
        Queue<GameObserver> queue = new LinkedList<>(players);
        GameObserver playerWithTurn = null;
        gameStatus = GameStatus.IN_PROGRESS;
        while(true) {
            playerWithTurn = queue.peek();
            Move move = null;
            try {
                move = playerWithTurn.yourTurn();
            } catch (InvalidMoveException ex) {
                System.out.println("Exception Thrown: " + ex.getMessage());
//                playerWithTurn.wrongMove(ex.getMessage());
                continue;
            } catch (PlaceAlreadyOccupiedException ex) {
                System.out.println("Exception Thrown: " + ex.getMessage());
//                playerWithTurn.wrongMove(ex.getMessage());
                continue;
            } catch (Exception ex) {
                System.out.println("Exception Thrown: " + ex.getMessage());
                throw ex;
            }
            evaludateGameStatus(move);
            if(performActionBasedOnGameStatus(queue)) {
                queue.remove();
                queue.add(playerWithTurn);
            } else {
                break;
            }
        }
    }

    private void informPlayersTheyHaveLost(Queue<GameObserver> queue) {
        while(!queue.isEmpty()) {
            queue.peek().youLost();
            queue.remove();
        }
    }

    private boolean performActionBasedOnGameStatus(Queue<GameObserver> queue) {
        if(gameStatus.compareTo(GameStatus.OVER)==0) {
            queue.peek().youWon();
            queue.remove();
            informPlayersTheyHaveLost(queue);
            return false;
        } else if (gameStatus.compareTo(GameStatus.DRAW)==0) {
            informPlayersTheyHaveDrawn(queue);
            return false;
        }
        return true;
    }

    private void informPlayersTheyHaveDrawn(Queue<GameObserver> queue) {
        while(!queue.isEmpty()) {
            queue.peek().youHaveDrawn();
            queue.remove();
        }
    }

    private void evaludateGameStatus(Move move) {
        // null check
        int x = move.getXIndex(), y=0;
        if(board.getPiece(x, y).getSymbol().equals(board.getPiece(x, y+1).getSymbol())  &&  board.getPiece(x, y).getSymbol().equals(board.getPiece(x, y+2).getSymbol())) {
            gameStatus = GameStatus.OVER;
            return ;
        }
        x = 0; y = move.getYIndex();
        if(board.getPiece(x, y).getSymbol().equals(board.getPiece(x+1, y).getSymbol())  &&  board.getPiece(x, y).getSymbol().equals(board.getPiece(x+2, y).getSymbol())) {
            gameStatus = GameStatus.OVER;
            return ;
        }
        if(move.getYIndex()==move.getXIndex()) {
            if(board.getPiece(0, 0).getSymbol().equals(board.getPiece(1, 1).getSymbol())  &&  board.getPiece(0, 0).getSymbol().equals(board.getPiece(2, 2).getSymbol())) {
                gameStatus = GameStatus.OVER;
                return ;
            }
        }
        if((move.getXIndex()+move.getYIndex())==2) {
            if(board.getPiece(1, 1).getSymbol().equals(board.getPiece(2, 0).getSymbol())  &&  board.getPiece(0, 0).getSymbol().equals(board.getPiece(0, 2).getSymbol())) {
                gameStatus = GameStatus.OVER;
                return ;
            }
        }
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board.getPiece(i, j).getSymbol().equals(PieceSymbol.DOT)) {
                    return ;
                }
            }
        }
        gameStatus = GameStatus.DRAW;
    }

    public void implementMove(Player player, Move move) throws PlaceAlreadyOccupiedException, InvalidMoveException {
        System.out.println("Implementing move for "+player.getName()+" "+move.getXIndex()+" "+move.getYIndex());
        board.addPiece(player.getPiece(), move, player.getName());
        board.printBoard();
    }
}
