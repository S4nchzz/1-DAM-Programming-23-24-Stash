package dam.clases.bidimensional;

public class LifeGame {
    private boolean [][] game;

    public LifeGame() {
        this.game = new boolean[10][10];
        this.game[game.length / 2][game.length / 2] = true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < game.length; i++) {
            for (int k = 0; k < game[i].length; k++) {
                if (game[i][k]) {
                    sb.append("X");
                    sb.append(" ");
                } else {
                    sb.append(".");
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }
        return sb.toString();
    }
}
