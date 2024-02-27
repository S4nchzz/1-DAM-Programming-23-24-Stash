package dam.herencia.tic_tac_toe.game;

public class TicTacToe implements GameBase {
    private int [][] board;
    private boolean turno;

    public TicTacToe () {
        board = new int [3][3];
        turno = true;
    }

    @Override
    public boolean isWinner() {
        return true;
    }

    @Override
    public String getBoard() {
        StringBuilder sb = new StringBuilder();

        /**
         * StringBuilder que concatena el tablero dependiendo del this.board,
         * 0 representa vacio, -1 representa X y 1 representa O.
         */

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (board[i][k] == 0) {
                    sb.append(". ");
                } else if(board[i][k] == -1) {
                    sb.append("X ");
                } else {
                    sb.append("O ");
                }
            }
            sb.append("\n");
         }

        return sb.toString();
    }

    /**
     * Los movimientos en este juego se representan con un número del 1 al 9, donde el jugador,
     * siendo 9 la ultima posicion y 1 la primera.
     * @param move movimiento del usuario
     */
    @Override
    public void makeMove(int move) {
        int posicion = 1;
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (posicion == move && board[i][k] == 0 && getTurn()) {
                    this.board[i][k] = 1;
                    this.turno = !this.turno;
                    return;
                } else if (posicion == move && board[i][k] == 0) {
                    this.board[i][k] = -1;
                    this.turno = !this.turno;
                    return;
                }
                posicion++;
            }
        }
    }

    @Override
    public boolean getTurn () {
        return this.turno;
    }

    @Override
    public String endGame() {
        int lineCountWhite = 0;
        int lineCountBlack = 0;

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (board[i][k] == 1) {
                    lineCountWhite++;
                } else {
                    lineCountBlack++;
                }
            }

            if (lineCountWhite == 3) {
                return "Gano 0";
            }

            if (lineCountBlack == 3) {
                return "Gano X";
            }
        }

        return "Error";
    }
    @Override
    public String toString(int a) {
        return "";
    }
}
