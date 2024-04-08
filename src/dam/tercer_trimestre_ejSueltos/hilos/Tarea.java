package dam.tercer_trimestre_ejSueltos.hilos;

public class Tarea {
    private final int desde;
    private final int hasta;

    private int result;

    public Tarea (int desde, int hasta) {
        this.desde = desde;
        this.hasta = hasta;
        this.result = -1;
    }

    public int getDesde() {
        return desde;
    }

    public int getHasta() {
        return hasta;
    }

    public int getResult () {
        return this.result;
    }
    
    public void setResult(int r) {
        this.result = r;
    }
}
