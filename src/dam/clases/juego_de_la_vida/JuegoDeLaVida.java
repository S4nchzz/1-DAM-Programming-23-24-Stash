package dam.clases.juego_de_la_vida;

public class JuegoDeLaVida {
    private boolean [] casillas;
    private boolean [] nextGeneration;
/**
 * Constructor de la clase JuegoDeLaVida, el cual inicializa
 * el array booleano principal, estableciendo en true el
 * la posicion central del array dependiendo de las cassillas
 * que quiera el usuario, tambien se inicializa el array
 * de nueva generacion con el mismo tamaño que las casillas
 * que quiera el usuario. 
 * @param casillas
 */
    public JuegoDeLaVida(int casillas) {
        this.casillas = new boolean[casillas];
        this.casillas[casillas / 2] = true;
        this.nextGeneration = new boolean[casillas];
    }

    /**
     * Metodo avanzar el cual cuando es llamado recorre el array
     * el cual estaria inicializado con un unico TRUE en la posicion
     * central del array y analizaria en cada vuelta si la posicion
     * anterior y la siguiente son iguales, es decir 
     * if (a[x - 1] && a[x + 1] || !a[x - 1] && !a[x + 1]) = false;
     * else = true, se pondria la posicion del array en la posicion de i
     * en falso, si no en true, ya que estas 2 posiciones son distintas 
     * una de la otra; Tambien se analiza la primera posicion suponiendo
     * que la posicion a[-1] y a[a.length + 1] es falso, es decir, si la 
     * siguiente posicion de 0 es falso se interpreta que falso && falso = falso
     * else true, que a su vez es lo mismo que copiar en el array de nueva 
     * generacion la primera posicion del array de booleanos que se recorre, 
     * asi mismo ocurre con la ultima posicion de la nueva generacion, analizando
     * la longitud del array - 2, ya que array.length - 1 es exactamente la ultima
     * posicion, en cambio array.length - 2 es la anterior a la ultima.
     */
    public void avanzar() {
        nextGeneration[0] = casillas[1];

        for (int i = 1; i < casillas.length - 1; i++) {
            if ((!casillas[i - 1] && !casillas[i + 1]) || (casillas[i - 1] && casillas[i + 1])) {
                nextGeneration[i] = false;
            } else {
                nextGeneration[i] = true;
            }
        }

        nextGeneration[nextGeneration.length - 1] = casillas[casillas.length - 2];

        copyNewGen(nextGeneration);
    }

    /**
     * Metodo para copiar el array de nueva generacion en el actual para asi
     * cuando se llame a avanzar que analice la nueva generacion
     * @param nextGeneration
     */

    private void copyNewGen(boolean [] nextGeneration) {
        for (int i = 0; i < this.casillas.length; i ++) {
            this.casillas[i] = nextGeneration[i];
        }
    }

    /**
     * Objeto StringBuilder que recorre el array de casillas y dependiendo
     * de si es verdadero o falso llama al metodo sb.append() para poner "."
     * o "0"
     * @return
     */

    public String ver() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.casillas.length; i++) {
            if (!casillas[i]) {
                sb.append(".");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}