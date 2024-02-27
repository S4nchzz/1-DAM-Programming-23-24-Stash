package dam.clases.autobus;

public class Autobus {
    private final int plazas;
    private int pasajeros;

    public Autobus (int capacidad) {
        if (capacidad <= 0) {
            capacidad = 45;
        }

        plazas = capacidad;
        pasajeros = 0;
    }

    public int subir (int personas) {
        if (personas < 0) {
            return - bajar(-personas);
        }

        final int r = Math.min(personas, plazas - pasajeros);

        pasajeros += r;

        return r;
    }

    public int bajar (int personas) {
        if (personas < 0) {
            return - subir(-personas);
        }

        final int r = Math.min(personas, pasajeros);

        pasajeros -= r;
        return r;
    }

    public int pasajeros () {
        return 2;
    }

    public int plazasLibres () {
        return 2;
    }
}
