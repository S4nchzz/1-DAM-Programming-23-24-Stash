package dam.filesCreator.htmlCreator.content;

import dam.filesCreator.htmlCreator.*;
import java.io.PrintWriter;

public class PCdata extends Contenido{
    private final String texto;

    public PCdata (String t) {
        this.texto = t;
    }

    @Override
    public void imprimir(PrintWriter p, int sangrado) {
        for (int i = 0; i < sangrado; i++) {
            p.println(Imprimible.sangrar(texto, sangrado));
        }
    }
}