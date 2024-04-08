package dam.tercer_trimestre_ejSueltos.hilos;

public class ContadorPrimos extends Thread {
    private Controller c;
    private Tarea t;

    private int countPrimos;
    
    public ContadorPrimos (Controller c) {
        countPrimos = 0;
        if (c != null) {
            this.c = c;
        } else {
            System.exit(0);
        }
    }

    @Override
    public void run () {
        t = c.getTarea();

        while (t != null) {
            contarPrimos();
            t = c.getTarea ();
        }
        c.setAcumulador(countPrimos);
    }

    private boolean esPrimo(int x) {
        if (x <= 3) {
            return x >= 2;
        }

        if (x % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int contarPrimos () {
        for (int i = t.getDesde(); i <= t.getHasta(); i++) {
            if (esPrimo(i)) {
                countPrimos++;
            }
        }

        return countPrimos;
    }
    
    public int getResultado() {
        return countPrimos;
    }
}