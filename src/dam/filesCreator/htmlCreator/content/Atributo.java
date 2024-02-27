package dam.filesCreator.htmlCreator.content;

import dam.filesCreator.htmlCreator.*;
import java.io.PrintWriter;

public class Atributo extends Imprimible {
    private final String nombre;
    private final String value;

    public Atributo(String n, String v) {
        this.nombre = n;
        this.value = v;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getValor() {
        return this.value;
    }

    @Override
    public void imprimir(PrintWriter p, int sangrado) {
        p.print(" ");
        p.print(this.nombre);
        p.print("=\"");
        p.print(this.value);
        p.print("\"");
    }
}
