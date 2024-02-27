package dam.clases.gimnasio.internalConfig;

/**
 * Esta clase almacena toda la informacion de un usuario del sistema
 * asi como su nombre, un identificador(pulsera), si este usuario se
 * encuentra dado de baja o no y sus taquillas personales
 */
public class Usuario {
    private final String nombre;
    private final long pulsera;
    private boolean usuarioActivo;
    private Taquilla[] llavesTaq;

    /**
     * Constructor de la clase que inicializa el nombre y el identificador cuando se
     * añade un nuevo usuario
     * 
     * @param nombre  Nombre del usuaro
     * @param pulsera Identificador del usuario
     */
    public Usuario(String nombre, long pulsera) {
        this.nombre = nombre;
        this.pulsera = pulsera;
        this.llavesTaq = new Taquilla[3];
        this.usuarioActivo = true;
    }

    /**
     * Metodo que añade una taquilla al usuario (MAX 3) con la condicion
     * de que no haya 2 taquillas con el mismo identificador
     * 
     * @param taquilla Informacion de la taquilla a ser añadida
     */
    public void asignarLlave(Taquilla taquilla) {
        boolean existe = false;
        if (usuarioActivo) {
            for (int i = 0; i < llavesTaq.length; i++) {
                if (llavesTaq[i] != null && taquilla.getIdTaquilla() == llavesTaq[i].getIdTaquilla()) {
                    existe = true;
                }
            }

            if (!existe) {
                for (int i = 0; i < llavesTaq.length; i++) {
                    if (llavesTaq[i] == null) {
                        this.llavesTaq[i] = taquilla; // Se asigna la nueva llave de una taquilla con su informacion
                        break;
                    }
                }
            }
        } else {
            throw new Error("El usuario se encuentra de baja");
        }
    }

    /**
     * Metodo que da de baja al usuario elegido y borra todas las taquillas que
     * tiene asignadas
     * para darselas a otro usuario
     */
    public void darDeBaja() {
        if (usuarioActivo) {
            this.usuarioActivo = false;
            for (int i = 0; i < llavesTaq.length; i++) {
                this.llavesTaq[i] = null;
            }
        } else {
            throw new Error("El usuario ya se encuentra dado de baja");
        }
    }

    /**
     * Metodo que retorna todas las taquillas asociadas al usuario con su
     * identificador
     * 
     * @return Taquillas asociadas
     */
    public long[] getTaquillasAsociadas() {
        long[] taqAsociated = new long[llavesTaq.length + 1];
        int taqAsociatedPos = 0;

        for (int i = 0; i < llavesTaq.length; i++) {
            if (llavesTaq[i] != null) {
                taqAsociated[taqAsociatedPos] = llavesTaq[i].getIdTaquilla();
                taqAsociatedPos++;
            }
        }

        return taqAsociated;
    }

    /**
     * Metodo que dado un objeto de tipo taquilla retorna la posicion
     * donde se encuentra en el array de objetos local si es que existe,
     * si no retorna -1
     * 
     * @param taq Object class
     * @return Posicion del elemento o -1
     */
    private int buscarTaquilla(Taquilla taq) {
        for (int i = 0; i < llavesTaq.length; i++) {
            if (llavesTaq[i] != null && taq.getIdTaquilla() == llavesTaq[i].getIdTaquilla()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metodo que cierra una taquilla con un identificador concreto
     * llamando al metodod buscar para que busque la taquilla
     */
    protected void cerrarTaquilla(Taquilla taq) {
        int posTaq = buscarTaquilla(taq);
        if (posTaq == -1) {
            return;
        }

        this.llavesTaq[posTaq].cerrarTaquilla();
    }

    /**
     * Metodo que abre una taquilla con un identificador concreto
     * llamando al metodod buscar para que busque la taquilla
     */
    public void abrirTaquilla(Taquilla taq) {
        int posTaq = buscarTaquilla(taq);
        if (posTaq == -1) {
            return;
        }

        this.llavesTaq[posTaq].abrirTaquilla();
    }

    /**
     * Metodo que abre todas las taquillas del usuario
     */
    public void abrirTodas() {
        for (int i = 0; i < llavesTaq.length; i++) {
            if (this.llavesTaq[i] != null) {
                this.llavesTaq[i].abrirTaquilla();
            }
        }
    }

    /**
     * Metodo que cierra todas las taquillas del usuario
     */
    public void cerrarTodas() {
        for (int i = 0; i < llavesTaq.length; i++) {
            if (this.llavesTaq[i] != null) {
                this.llavesTaq[i].cerrarTaquilla();
            }
        }
    }

    /**
     * Metodo que retorna las taquillas del usuario
     */
    public Taquilla[] getTaquillas() {
        return this.llavesTaq;
    }

    /**
     * Metodo que elimina una taquilla del array de objetos de taquilla
     * por un id
     */
    protected void removeOneTaquilla(long id) {
        for (int i = 0; i < llavesTaq.length; i++) {
            if (llavesTaq[i] != null && llavesTaq[i].getIdTaquilla() == id) {
                this.llavesTaq[i] = null;
            }
        }
    }

    /**
     * Metodo que elimina TODAS las taquillas del usuario poniendolas a null
     */
    protected void removeAllTaquillas() {
        for (int i = 0; i < llavesTaq.length; i++) {
            llavesTaq[i] = null;
        }
    }

    /**
     * Metodo que devuele el nombre del usuario
     * 
     * @return Nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que devuelve el identificador de la pulsera
     * 
     * @return ID
     */
    public long getPulsera() {
        return this.pulsera;
    }

    /**
     * Metodo que retorna si el usuario esta de baja o no
     * 
     * @return Boolean Baja
     */
    public boolean getUsuarioActivo() {
        return this.usuarioActivo;
    }
}