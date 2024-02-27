package dam.herencia.primeraIdea.nim;

public abstract class Foto {
    public abstract Foto [] getMovimientos ();
    public abstract boolean haGanadoA ();

    private final boolean turno;

    public Foto (boolean param) {
        this.turno = param;
    }

    public boolean getTurno () {
        return this.turno;
    }
}