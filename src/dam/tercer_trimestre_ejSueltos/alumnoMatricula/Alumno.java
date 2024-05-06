package dam.tercer_trimestre_ejSueltos.alumnoMatricula;

import java.util.ArrayList;

public class Alumno {
    private final String nombre;
    private ArrayList<String> modulos;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.modulos = new ArrayList<>();
    }

    public boolean matricular(String modulo) {
        if (modulos.contains(modulo)) {
            return false;
        }

        this.modulos.add(modulo);
        return true;
    }

    public boolean desmatricular(String modulo) {
        if (!modulos.contains((String) modulo)) {
            return false;
        }

        this.modulos.remove(modulo);
        return true;
    }

    public boolean estaMatriculado(String modulo) {
        return modulos.contains(modulo);
    }
}