package dam.filesCreator.htmlCreator.content;

import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import dam.filesCreator.htmlCreator.*;

public abstract class Elemento extends Contenido{
    private final String nombre;
    private Map <String, Atributo> atributos;
    
    public Elemento (String n) {
        this.nombre = n;
        atributos = new TreeMap<String, Atributo>();
    }

    public void imprimirApertura (PrintWriter p, int sangrado) {
        p.print(Imprimible.sangrar("<", sangrado));
        p.print(nombre);

        for (Atributo a : atributos.values()) {
            a.imprimir(p, sangrado);
        }

        p.println(">");
    }

    public void imprimirCierre (PrintWriter p, int sangrado) {
        p.println(Imprimible.sangrar("</" + nombre + ">", sangrado));
    }

    public void anadirAtributo(String nombre, String value) throws Exception {
        if (atributos.containsKey(nombre)) {
            throw new Exception("Duplicate value " + nombre);
        }

        final Atributo a = new Atributo(nombre, value);
        this.atributos.put(nombre, a);
    }
}