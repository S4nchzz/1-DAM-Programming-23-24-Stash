package dam.herencia.primeraIdea.nim;

public class FotoNim extends Foto {
    private final int palillos;
    private final boolean turno;
    private Foto [] fs;

    public FotoNim () {
        super(true);
        this.palillos = 13;
        this.turno = true;
        this.fs = null;
    }

    public FotoNim (int palillos, boolean turno) {
        super(turno);
        this.palillos = palillos;
        this.turno = turno;
    }

    @Override
    public Foto [] getMovimientos() {
        if (fs == null) {
            final Foto[] r = new Foto[Math.min(palillos, 3)];

            for (int i = 0; i < r.length; i++) {
                r[i] = new FotoNim(palillos - 1 - i, !turno);
            }

            return r;
        } else {
            return getFotos();
        }
    }

    @Override
    public boolean getTurno() {
        return this.turno;
    }

    @Override
    public boolean haGanadoA () {
        return palillos == 0 && this.turno;
    }

    public String toString() {
        return palillos + "-" + (turno ? "A" : "B");
    }

    public Foto [] getFotos () {
        return this.fs;
    } 
}