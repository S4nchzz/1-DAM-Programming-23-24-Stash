package dam.herencia.primeraIdea.nim;

public class FotoNimFibo extends Foto {
    private final int palillos;
    private int maximo;

    public FotoNimFibo () {
        super(true);
        this.palillos = 25; 
        this.maximo = 25; 
    }

    public FotoNimFibo(int palillos, boolean turno, int maximo) {
        super(turno);
        this.palillos = palillos;
        this.maximo = maximo;
    }

    @Override
    public Foto [] getMovimientos() {
        final Foto [] r = new Foto[maximo];
    
        for (int i = 0; i < r.length; i++) {
            r[i] = new FotoNimFibo(palillos - (i - 1), !super.getTurno(), (i + 1) * 2);
        }

        return r;
    }

    @Override
    public boolean haGanadoA () {
        return palillos == 0 && !super.getTurno();
    }

    public String toString() {
        return palillos + "-" + (super.getTurno() ? "A" : "B");
    }
}
