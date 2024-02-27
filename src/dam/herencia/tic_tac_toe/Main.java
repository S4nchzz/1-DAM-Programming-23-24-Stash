package dam.herencia.tic_tac_toe;

import dam.herencia.tic_tac_toe.game.*;

public class Main {
    public static void main(String[] args) {
        GameBase game = new TicTacToe();
        
        game.makeMove(1);
        System.out.println(game.endGame());
        game.makeMove(4);
        System.out.println(game.endGame());
        game.makeMove(2);
        System.out.println(game.endGame());
        game.makeMove(6);
        System.out.println(game.endGame());
        game.makeMove(3);
        System.out.println(game.endGame());
        System.out.println(game.getBoard());
    }
}