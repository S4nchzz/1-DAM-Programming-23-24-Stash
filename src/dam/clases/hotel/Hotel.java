package dam.clases.hotel;

public class Hotel {
    private Habitacion[] habitacion;
    int conteoHabitaciones = 0;

    public Hotel() {
        habitacion = new Habitacion[10];
        conteoHabitaciones = 0;
    }

    public int buscarHabitacion(int numero) {
        for (int i = 0; i < habitacion.length; i++) {
            if (habitacion[i] != null && habitacion[i].getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    public boolean añadirHabitacion(Habitacion h) {
        for (int i = 0; i < habitacion.length; i++) {
            if (habitacion[i] == null) {
                habitacion[i] = h;
                return true;
            } else if (habitacion[i].getNumero() == h.getNumero()) {
                return false;
            }
        }
        return false;
    }

    public boolean borrar(int numero) {
        boolean existeHabitacion = false;
        int savePosHab = 0;

        if (buscarHabitacion(numero) != -1) {
            savePosHab = buscarHabitacion(numero);
            existeHabitacion = true;
        } else {
            System.exit(0);
        }

        if (existeHabitacion) {
            habitacion[savePosHab] = null;
            return true;
        }

        return false;
    }

    public double totalMetros() {
        int sumatorioMetros = 0;
        for (int i = 0; i < habitacion.length; i++) {
            if (habitacion[i] != null) {
                sumatorioMetros += habitacion[i].getMetros();
            }
        }
        return sumatorioMetros;
    }

    public boolean reservar(int numero) {
        if (buscarHabitacion(numero) != -1) {
            if (habitacion[buscarHabitacion(numero)].getReservada()) {
                return false;
            } else {
                habitacion[buscarHabitacion(numero)].setReservada(true);
                return true;
            }
        }
        return false;
    }

    public boolean anularReserva(int numero) {
        if (buscarHabitacion(numero) != -1) {
            if (!habitacion[buscarHabitacion(numero)].getReservada()) {
                habitacion[buscarHabitacion(numero)].setReservada(true);
                return true;
            }
            return false;
        }
        return false;
    }

    public int bucar1(double metrosMinimo, boolean baño) {
        for (int i = 0; i < habitacion.length; i++) {
            if (habitacion[i].getReservada() == false && metrosMinimo > habitacion[i].getMetros()
                    && habitacion[i].getBaño() == baño) {
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public int[] buscarN(double metrosMinimo, boolean baño, int cuantas) {
        int contadorHabitacionesLibres = 0;
        for (int i = 0; i < habitacion.length; i++) {
            if (habitacion[i] != null && !habitacion[i].getReservada()) {
                contadorHabitacionesLibres++;
            }
        }

        int[] numeroHab = new int[contadorHabitacionesLibres];
        int habPointer = 0;

        for (int i = 0; i < numeroHab.length; i++) {
            if (habitacion[i] != null && !habitacion[i].getReservada()) {
                numeroHab[habPointer] = habitacion[i].getNumero();
            }
        }
        return numeroHab;
    }
}