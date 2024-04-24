package dam.tercer_trimestre_ejSueltos.examenes.BibliotecaLibroPrestamo;

public class Libro {
    private final String title;
    private Prestamo [] prestamos;

    public Libro (String title) {
        this.title = title;
        this.prestamos = new Prestamo[1];
    }

    public String getTitulo () {
        return this.title;
    }

    public Prestamo iniciarPrestamo (String cliente, Fecha fechaInicio) {
        if (!estaReservado()) {
            expandArray();

        }
    }

    private boolean estaReservado () {
        if (prestamos[prestamos.length - 1].getFechaFin() == null) {
            return true;
        }
        return false;
    }

    private void expandArray () {
        Prestamo [] p = new Prestamo[this.prestamos.length + 1];

        for (int i = 0; i < this.prestamos.length; i++) {
            p[i] = prestamos[i];
        }

        this.prestamos = p;
    }
}
