package dam.filesCreator.htmlCreator.content;

public class ElementoMetaCharset extends ElementoSinContenido {
    private final String charset;
    public ElementoMetaCharset(String charset) {
        super("meta", true);
        this.charset = charset;

        try {
            anadirAtributo("charset", this.charset);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public ElementoMetaCharset() {
        this("UTF-8");
    }
}
