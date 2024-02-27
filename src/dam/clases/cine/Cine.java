package dam.clases.cine;

public class Cine {
    private int [] butaca;
    private final boolean [] reservado;
    private boolean existeButaca;

    public Cine() {
        this.butaca = new int[]{23,22,11,55,5,6,7,8,9,10};
        this.reservado = new boolean[]{true,false,false,true,true,true,false,false,false,true};
        this.existeButaca = false;
    }

    public boolean reservar(int butaca) {
        if (buscarButaca(butaca) != -1) {
            existeButaca = true;
        } else {
            existeButaca = false;
        }

        if (existeButaca && !reservado[buscarButaca(butaca)]) {
            reservado[buscarButaca(butaca)] = true;
            return true;
        }
        return false;
    }

    public boolean anular(int butaca) {
        if (buscarButaca(butaca) != -1) {
            existeButaca = true;
        }
        if (existeButaca && reservado[buscarButaca(butaca)]) {
            reservado[buscarButaca(butaca)] = false;
            return true;
        }

        return false;
    }

    public int buscarButaca (int butaca) {
        for (int i = 0; i < this.butaca.length; i++) {
            if (this.butaca[i] == butaca) {
                return i;
            }
        }
        return -1;
    }

    public int butacasLibres() {
        int countLibres = 0;
        for (int i = 0; i < reservado.length; i++) {
            if (!reservado[i]) {
                countLibres++;
            }
        }

        return countLibres;
    }

    public int juntos(int personas) {
        int countLibres = 0;
        int savePosLibre = 0;
        for (int i = 0; i < reservado.length; i++) {
            if (!reservado[i]) {
                if (countLibres == 0) {
                    savePosLibre = i;
                }
                countLibres++;
            } else {
                countLibres = 0;
            }

            if (countLibres == personas) {
                return savePosLibre;
            }
        }
        return -1;
    }
}