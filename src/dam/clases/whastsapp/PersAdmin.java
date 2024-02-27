package dam.clases.whastsapp;

public class PersAdmin {
    private Persona pers;
    private boolean admin;

    public PersAdmin (Persona p, boolean admin) {
        this.pers = p;
        this.admin = admin;
    }

    public Persona getPers() {
        return pers;
    }

    public void setPers(Persona p) {
        pers = p;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
