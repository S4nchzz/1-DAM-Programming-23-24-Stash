package dam.clases.whatsapp_casa;

public class EsAdmin {
    private Persona pers;
    private boolean administrador;

    public EsAdmin(Persona p, boolean b) {
        pers = new Persona();
        this.pers = p;
        this.administrador = b;
    }

    public Persona getPersona() {
        return pers;
    }

    public boolean getEstado() {
        return this.administrador;
    }

    public void setEstadoEsAdmin(boolean newState) {
        this.administrador = newState;
    }
}
