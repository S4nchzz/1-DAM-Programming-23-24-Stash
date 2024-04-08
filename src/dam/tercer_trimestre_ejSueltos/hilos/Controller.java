package dam.tercer_trimestre_ejSueltos.hilos;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private int acumulador;

    private List<Tarea> tareas;
    private ContadorPrimos [] thread;

    private int desde = 0;
    private int hasta = 2000;

    private int count;

    public Controller (int numberToReach, int nHilos) throws InterruptedException {
        tareas = new ArrayList<Tarea>();
        thread = new ContadorPrimos[nHilos];
        count = 0;

        for (int i = 0; i < numberToReach / 2000; i++) {
            tareas.add(new Tarea (desde, hasta));

            desde = hasta + 1;
            hasta += 2000;
        }

        for (int i = 0; i < nHilos; i++) {
            thread[i] = new ContadorPrimos(this);
            thread[i].start();
        }

        for (int i = 0; i < nHilos; i++) {
            thread[i].join();
        }
    }

    public Tarea getTarea() {
        if (count >= tareas.size()) {
            return null;
        }

        Tarea t = tareas.get(count);
        count++;

        return t;
    }

    public int getAcumulador() {
        return acumulador;
    }

    public void setAcumulador(int a) {
        this.acumulador += a;
    }
}