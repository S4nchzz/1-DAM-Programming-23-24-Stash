package dam.clases.piedraPapelTijera;

public class Marcador {
    private int ganadas;
    private int perdidas;
    private int empatadas;
    private int totalPartidas;

    public Marcador (int w, int l, int d) {
        this.ganadas = w;
        this.perdidas = l;
        this.empatadas = d;
        this.totalPartidas = w + l + d;
    }

    public int getGanadas() {
        return ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getEmpatadas() {
        return empatadas;
    }
    
    public int getTotalPartidas() {
        return totalPartidas;
    }
}
