package dam.tercer_trimestre_ejSueltos.examenes.bibliotecaLibroPrestamo;

public class Fecha {
    private final int y;
    private final int m;
    private final int d;

    public Fecha (int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public int getYear () {
        return this.y;
    }

    public int getMonth() {
        return this.m;
    }

    public int getDay () {
        return this.d;
    }
}
