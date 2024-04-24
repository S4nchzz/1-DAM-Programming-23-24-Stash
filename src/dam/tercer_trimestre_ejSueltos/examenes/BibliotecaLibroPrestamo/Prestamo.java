package dam.tercer_trimestre_ejSueltos.examenes.BibliotecaLibroPrestamo;

public class Prestamo {
    private final String nombre;
    private final Fecha fechaInicio;
    private Fecha fechaFin;

    public String getNombre() {
        return nombre;
    }

    public Prestamo (String nombre) {
        this.nombre = nombre;
        this.fechaInicio = null;
        this.fechaFin = null;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }
}
