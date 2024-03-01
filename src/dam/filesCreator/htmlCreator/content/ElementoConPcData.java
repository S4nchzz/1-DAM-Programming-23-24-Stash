package dam.filesCreator.htmlCreator.content;

import java.io.PrintWriter;

public class ElementoConPcData extends Elemento {
    private final PCdata contenido;

    public ElementoConPcData(String nombre, PCdata contenido) {
        super(nombre);
        this.contenido = contenido;
    }

    public ElementoConPcData(String nombre, String contenido) {
        this(nombre, new PCdata (contenido));
    }

    @Override
    public void imprimir(PrintWriter p, int sangrado) {
        imprimirApertura(p, sangrado);
        contenido.imprimir(p, sangrado + 1);
        imprimirCierre(p, sangrado);
    }
}