package dam.clases.gimnasio.internalConfig;

/**
 * Clase trabajador que almacena el nombre y si tiene llave maestra para
 * abrir las taquillas
 * @author Iyan Sanchez
 */
public class Trabajador {
    private final String nombre;
    private boolean llaveMaestra;
    private GymControl gym;

    /**
     * Constructor de la clase que permite poner un nombre
     * y establecer en true o false el booleano de llave maestra
     * para poder operar
     * @param nombre String nombre del trabajador
     * @param llaveMaestra Boolean con el estado de la llave maestra
     */
    public Trabajador(String nombre, boolean llaveMaestra, Gimnasio gymToGymControl) {
        this.nombre = nombre;
        this.llaveMaestra = llaveMaestra;
        this.gym = new GymControl(gymToGymControl);
    }

    /**
     * Cuando se hace llamada a este metodo comprueba que este usuario
     * no fuera ya una persona com la llave maestra (esta llave permite)
     * abrir cualquier taquilla o operar desde un panel de administrador
     */
    public void establecerAcceso() {
        if (!llaveMaestra) {
            this.llaveMaestra = true;
        } else {
            throw new Error("El usuario no tiene acceso maestro");
        }
    }

    /**
     * Este metodo permite quitar la llave maestra al trabajador
     * bien porque no cumpla o por otros motivos
     */
    public void revocarAcceso() {
        if (llaveMaestra) {
            this.llaveMaestra = false;
        } else {
            throw new Error("El usuario no tiene acceso maestro");
        }
    }

    /**
     * Este metodo hara una llamada a cierreGlobal si es administrador
     * si esto se cumple cierreGlobal cerrara todas las taquillas del
     * gimnasio
     */
    public void cierreGlobal () {
        if (llaveMaestra) {
            this.gym.cierreGlobal();
        }
    }

    /**
     * Este metodo hara una llamada a aperturaGlobal si es administrador
     * si esto se cumple aperturaGlobal abrira todas las taquillas del
     * gimnasio
     */
    public void aperturaGlobal() {
        if (llaveMaestra) {
            this.gym.aperturaGlobal();
        }
    }

    /**
     * Este metodo hara una llamada a eliminarTaquillaGlobal
     * si es administrador si esto se cumple eliminarTaquillaGlobal
     * eliminara todas las taquillas del gimnasio
     */
    public void eliminarTaquillaGlobal() {
        if (llaveMaestra) {
            this.gym.eliminarTodasLasTaquillas();
        }
    }

    public void eliminarOneTaquilla (long pulsera, long taqId) {
        if (llaveMaestra) {
            gym.removeOneTaquilla(taqId, pulsera);
        }
    }

    public void eliminarUsuario (long pulsera) {
        if (llaveMaestra) {
            gym.eliminarUsuario(pulsera); 
        }
    }

    public void eliminarTodosLosUsuarios () {
        if (llaveMaestra) {
            gym.removeAllUsers();
        }
    }

    /**
     * Este metodo retorna si el trabajador es master
     * @return laveMaestra
     */
    public boolean isMaster() {
        return this.llaveMaestra;
    }

    /**
     * Este metodo retorna el nombre del trabajador
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }
}