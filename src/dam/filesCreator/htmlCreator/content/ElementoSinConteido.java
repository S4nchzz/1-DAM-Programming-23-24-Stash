package dam.filesCreator.htmlCreator.content;

import java.io.PrintWriter;

public class ElementoSinConteido extends Elemento {
    private final boolean cerrar;

    public ElementoSinConteido (String nombre, boolean c) {
        super(nombre);
        this.cerrar = c;
    }

    @Override
    public void imprimir (PrintWriter p, int sangrado) {
        super.imprimirApertura(p, sangrado);
        super.imprimirCierre(p, sangrado);
    }
}