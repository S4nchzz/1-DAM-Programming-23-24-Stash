package dam.clases.otro;

public class SecuenciaCaracteres {
    private int posicion = 0;
    private int longitudTexto;
    private String palabra;
    private int caracter;

    public SecuenciaCaracteres (String s) {
        this.palabra = s;
        longitudTexto = s.length();
        caracter = palabra.charAt(posicion);
    }

    public int mirar () {
        return caracter;
    }

    public void avanzar () {
        posicion++;
        if (posicion >= longitudTexto) {
            caracter = -1;
        } else {
            caracter = palabra.charAt(posicion);
        }
    }
}

