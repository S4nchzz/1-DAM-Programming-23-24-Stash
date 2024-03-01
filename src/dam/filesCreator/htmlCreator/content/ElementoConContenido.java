package dam.filesCreator.htmlCreator.content;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ElementoConContenido extends Elemento {
    private List<Contenido> contenido;

    public ElementoConContenido(String nombre) {
        super(nombre);
        contenido = new LinkedList<Contenido>();
        
    }

    @Override
    public void imprimir (PrintWriter p, int sangrado) {
        super.imprimirApertura(p, sangrado);
        
        for (Contenido c : contenido) {
            c.imprimir(p, sangrado + 1);
        }

        super.imprimirCierre(p, sangrado);
    }

    public void anadirContenido(Contenido c) {
        contenido.add(c);
    }
}