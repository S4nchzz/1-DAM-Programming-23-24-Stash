package dam.clases.artistaDiscoCancion;

public class Artista {
    private Disco [] disco;
    int posDisc;

    public Artista() {
        disco = new Disco[10];
        posDisc = 0;
    }

    public void addDisco(Disco disco) {
        this.disco[posDisc] = disco;
        posDisc++;
    }

    public Disco[] discosConMasDeNCanciones(int nCanciones) {
        int countDiscos = 0;
        int countMasCancionesQueN = 0;

        for (int i = 0; i < disco.length; i++) {
                countDiscos = disco[i].getCancion().length;
                if (countDiscos > nCanciones) {
                    countMasCancionesQueN++;
                }
        }

        Disco[] discoNcanciones = new Disco[countMasCancionesQueN];
        int posDiscNCan = 0;

        for (int i = 0; i < disco.length; i++) {
                countDiscos = disco[i].getCancion().length;
                if (countDiscos > nCanciones) {
                    discoNcanciones[posDiscNCan] = disco[i];
                    posDiscNCan++;
                }
        }
        return discoNcanciones;
    }

    public Disco[] discosConMasDeNSegundos(int segundos) {
        int sumatorioTotalVueltaDeI = 0;
        int arrDuracionSize = 0;
        for (int i = 0; i < disco.length; i++) {
            sumatorioTotalVueltaDeI = disco[i].getSegundosTotal();

            if (sumatorioTotalVueltaDeI > segundos) {
                arrDuracionSize++;
            }
        }

        Disco[] discosConMasSeg = new Disco[arrDuracionSize];
        int discMasSeg = 0;

        for (int i = 0; i < disco.length; i++) {
            sumatorioTotalVueltaDeI = disco[i].getSegundosTotal();

            if (sumatorioTotalVueltaDeI > segundos) {
                discosConMasSeg[discMasSeg] = disco[i];
                discMasSeg++;
            }
        }

        return discosConMasSeg;
    }
}
