package dam.herencia.tic_tac_toe.game;

public interface GameBase {
    public String toString(int value);
    public String getBoard();
    public void makeMove(int move);
    public boolean getTurn();
    public boolean isWinner();
    public String endGame();
}