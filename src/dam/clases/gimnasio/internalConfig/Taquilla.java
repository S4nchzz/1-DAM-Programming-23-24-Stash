package dam.clases.gimnasio.internalConfig;

/**
 * Esta clase contiene toda la informacion de una taquilla asi
 * como su identificador personal,si esta disponible o no y si el
 * usuario que tiene esta taquilla en su ficha esta dado de baja o no
 */
public class Taquilla {
    private final long numeroTaquilla;
    private boolean disponible;
    private boolean usuarioDeBaja;

    /**
     * Constructor de la clase que inicializa todos los atributos a false
     * excepto el numero de la taquilla el cual es obtenido al crear este
     * objeto
     * 
     * @param nTaquilla identificador de la taquilla
     */
    public Taquilla(int nTaquilla) {
        this.usuarioDeBaja = false;
        this.numeroTaquilla = nTaquilla;
        this.disponible = true;
    }

    /**
     * Metodo que retorna si la taquilla esta disponible o no
     * 
     * @return
     */
    public boolean taquillaDisponible() {
        return this.disponible;
    }

    /**
     * Metodo que abre esta taquilla
     */
    public void abrirTaquilla() {
        if (!usuarioDeBaja && !disponible) {
            disponible = true;
        } else {
            return;
        }
    }

    /**
     * Metodo que cierra esta taquilla
     */
    public void cerrarTaquilla() {
        if (!usuarioDeBaja && disponible) {
            disponible = false;
        } else {
            return;
        }
    }

    /**
     * Metodo que retorna el Id de la taquilla
     * 
     * @return Identificador
     */
    public long getIdTaquilla() {
        return this.numeroTaquilla;
    }

    /**
     * Metodo que da de baja el usuario al que pertenece esta taquillaa true
     */
    public void usuarioDeBaja() {
        this.usuarioDeBaja = true;
    }
}