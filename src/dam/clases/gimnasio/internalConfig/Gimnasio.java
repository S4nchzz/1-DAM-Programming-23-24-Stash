package dam.clases.gimnasio.internalConfig;

/**
 * Clase principal donde se genera toda la estructura del programa,
 * se inicializan los usuarios que tendra el gimnasio y los trabajadores
 */
public class Gimnasio {
    private Usuario[] users;
    private int posUser;

    private Trabajador[] worker;
    private int posWork;

    /**
     * Constructor de la clase que inicializa todo por defecto a 10
     */
    public Gimnasio() {
        this.users = new Usuario[10];
        this.worker = new Trabajador[10];
        this.posUser = 0;
        this.posWork = 0;
    }

    /**
     * Metodo que añade un nuevo usuario al array de objetos del mismo,
     * si no hay espacio hace una llamada al metodo expand para aumentar
     * el tamaño del array en un x2
     */
    public void registrarUsuario(Usuario usuario) {
        if (posUser < users.length) {
            users[posUser] = usuario;
            posUser++;
        } else {
            expandUsersVector();
            users[posUser] = usuario;
            posUser++;
        }
    }

    /**
     * Metodo para aumentar la cantida de valores que puede tener el array
     * de usuarios
     */
    private void expandUsersVector() {
        Usuario[] auxusr = new Usuario[users.length * 2];
        for (int i = 0; i < users.length; i++) {
            auxusr[i] = users[i];
        }

        this.users = auxusr;
    }

    /**
     * Metodo que añade un nuevo trabajador al array de objetos del mismo,
     * si no hay espacio hace una llamada al metodo expand para aumentar
     * el tamaño del array en un x2
     */
    public void registrarTrabajador(Trabajador work) {
        if (posWork < worker.length) {
            worker[posWork] = work;
            posWork++;
        } else {
            expandWorkerVector();
            worker[posWork] = work;
            posWork++;
        }
    }

    /**
     * Metodo que aumenta el tamaño del array
     */
    private void expandWorkerVector() {
        Trabajador[] auxwork = new Trabajador[worker.length * 2];
        for (int i = 0; i < worker.length; i++) {
            auxwork[i] = worker[i];
        }

        this.worker = auxwork;
    }

    /**
     * Metodo que retorna el nombre de los trabajadores con permisos de master
     */
    public String[] trabajadoresConPermisos() {
        String[] trabajadoresConLlave = new String[posWork - 1];
        int posArrStr = 0;

        for (int i = 0; i < worker.length; i++) {
            if (worker[i] != null && worker[i].isMaster()) {
                trabajadoresConLlave[posArrStr] = worker[i].getNombre();
                posArrStr++;
            }
        }

        return trabajadoresConLlave;
    }

    /**
     * Metodo que obtiene un array de long de todas las taquillas asociadas
     * que tiene un usuario previamente elegido con el identificador de la
     * pulsera
     */
    public long[] getNumTaqFromUser(long pulsera) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getPulsera() == pulsera) {
                return users[i].getTaquillasAsociadas();
            }
        }
        return new long[] { -1, -1, -1, -1, -1, -1, -1 };
    }

    /**
     * Metodo que cierra todas las taquillas de un unico usuario
     */
    public void cerrarTodasLasTaquillas(long pulsera) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getPulsera() == pulsera) {
                users[i].cerrarTodas();
                break;
            }
        }
    }

    /**
     * Metodo que abre todas las taquillas de un unico usuario
     */
    public void abrirTodasLasTaquillas(long pulsera) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getPulsera() == pulsera) {
                users[i].abrirTodas();
                break;
            }
        }
    }

    /**
     * Metodo que entrega a gymControl el registro de usuarios del sistema
     */
    protected Usuario[] obtenerRegistroUsuarios() {
        return this.users;
    }
}