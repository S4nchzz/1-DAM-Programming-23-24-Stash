package dam.tercer_trimestre_ejSueltos.examenes.BibliotecaLibroPrestamo;

public class Prestamo {
    private final String nombre;
    private final Fecha fechaInicio;
    private Fecha fechaFin;
    
    public Prestamo (String nombre, Fecha fechaInicio) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
    }

    public String getNombre() {
        return nombre;
    }
    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin (Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }
}
