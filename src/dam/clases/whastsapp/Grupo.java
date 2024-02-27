package dam.clases.whastsapp;

public class Grupo {
    private PersAdmin [] persAdmin;
    private int punteroPers;

    public Grupo () {
        persAdmin = new PersAdmin[10];
        punteroPers = 0;
    }

    private int buscar (String telefono) {
        for (int i = 0; i < punteroPers; i++) {
            if (persAdmin[i].getPers().getTelfID().equals (telefono)) {
                return i;
            }
        }

        return -1;
    }

    public void addPersona(Persona p) {
        persAdmin[punteroPers] = new PersAdmin (p, false);
        punteroPers++;
    }

    public void delPersona (String telf) {
        int pos = buscar (telf);

        if (pos < 0) {
            return;
        }

        punteroPers--;
        persAdmin[pos] = persAdmin[punteroPers];
        persAdmin[punteroPers] = null;
    }
}