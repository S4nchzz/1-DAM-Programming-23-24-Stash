package dam.filesCreator.htmlCreator;

import dam.filesCreator.htmlCreator.content.*;
import java.io.PrintWriter;

public class Documento extends Imprimible{
    private final Elemento raiz;

    public Documento (Elemento r) {
        this.raiz = r;
    }
    
    @Override
    public void imprimir (PrintWriter p, int sangrado) {
        raiz.imprimir(p, sangrado);
    }

    public Elemento getRaiz() {
        return this.raiz;
    }
}