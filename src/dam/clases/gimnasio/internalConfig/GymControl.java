package dam.clases.gimnasio.internalConfig;

/**
 * Esta clase permite controlar de manera abrupta todo el acceso
 * del gimnasio, de momento esta limitado para poder abrir, cerrar
 * y eliminar las usersuillas
 */
public class GymControl {
    private Usuario[] users;
    private Gimnasio gym;

    protected GymControl(Gimnasio gimnasio) {
        this.gym = gimnasio;
        this.users = gym.obtenerRegistroUsuarios();
    }

    /**
     * Cierre total de todas las usersuillas del gimnasio
     */
    protected void cierreGlobal() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                users[i].cerrarTodas();
            }
        }
    }

    /**
     *
     * Apertura total de todas las usersuillas del gimnasio
     */
    protected void aperturaGlobal() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                users[i].abrirTodas();
            }
        }
    }

    /**
     * Eliminacion total de todas las usersuillas del gimnasio
     */
    protected void eliminarTodasLasTaquillas() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                users[i].removeAllTaquillas();
            }
        }
    }

    protected void removeOneTaquilla (long taqIdUs, long pulsera) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                for (int k = 0; k < users[i].getTaquillas().length; k++) {
                    if (users[i] != null && users[i].getTaquillas()[k].getIdTaquilla() == taqIdUs
                            && users[i].getPulsera() == pulsera) {
                        long taqId = users[i].getTaquillas()[k].getIdTaquilla();
                        users[i].removeOneTaquilla(taqId);
                        break;
                    }
                }
            }
        }
    }

    protected void eliminarUsuario (long pulsera) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getPulsera() == pulsera) {
                users[i] = null;
            }
        }
    }

    protected void removeAllUsers () {
        for (int i = 0; i < users.length; i++) {
            users[i] = null;
        }
    }
}