package dam.clases.whastsapp;

public class Persona {
    private final String nombre;
    private final String telfID;

    public Persona(String nombre, String telf) {
        this.nombre = nombre;
        this.telfID = telf;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelfID() {
        return telfID;
    }
}
