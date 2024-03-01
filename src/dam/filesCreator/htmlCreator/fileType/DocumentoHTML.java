package dam.filesCreator.htmlCreator.fileType;

import dam.filesCreator.htmlCreator.Documento;
import dam.filesCreator.htmlCreator.content.*;

public class DocumentoHTML extends Documento {
    private final ElementoConContenido body;

    public DocumentoHTML (String title) {
        super(new ElementoConContenido("html"));
        body = new ElementoConContenido("body");

        final ElementoConContenido raiz = (ElementoConContenido) getRaiz();

        final ElementoConContenido head = new ElementoConContenido("head");
        final ElementoConContenido body = new ElementoConContenido("body");
        final ElementoConContenido titl = new ElementoConContenido("title");
        final ElementoSinContenido meta1 = new ElementoMetaCharset();

        raiz.anadirContenido(head);
        raiz.anadirContenido(body);
        head.anadirContenido(titl);

        head.anadirContenido(meta1);

        try {
            meta1.anadirAtributo("charset", "UTF-8");
        } catch (Exception e) {
            System.out.println("Error");
        }

        titl.anadirContenido(new PCdata(title));
    }

    public void anadirContenido(Contenido c) {
        body.anadirContenido(c);
    }
}