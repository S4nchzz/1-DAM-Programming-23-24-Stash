package dam.clases.artistaDiscoCancion;

public class Disco {
    private Cancion [] cancion;
    private String titulo;

    public Disco(Cancion [] c, String titleDisk) {
        this.cancion = c;
        copyArray(c);
        this.titulo = titleDisk;

    }

    public void copyArray (Cancion [] c) {
        for (int i = 0; i < c.length; i++) {
            this.cancion[i] = c[i];
        }
    }

    public String getTitulo () {
        return this.titulo;
    }

    public String duracionTotalHMS() {
        int sumatorioSeg = 0;
        for (int i = 0; i < this.cancion.length; i++) {
            sumatorioSeg += this.cancion[i].getDuracion();
        }

        int horas = sumatorioSeg / 60;
        int minutos = sumatorioSeg / 60;
        int segundos = sumatorioSeg % 60;

        StringBuilder sb = new StringBuilder();

        if (horas < 10) {
            sb.append("0");
        }
        sb.append(horas);
        sb.append(":");

        if (minutos < 10) {
            sb.append("0");
        }
        sb.append(minutos);
        sb.append(":");

        if (segundos < 10) {
            sb.append("0");
        }
        sb.append(segundos);

        return sb.toString();
    }

    public int getSegundosTotal() {
        int sumatorioTotalSeg = 0;
        for (int i = 0; i < cancion.length; i++) {
            sumatorioTotalSeg += cancion[i].getDuracion();
        }
        return sumatorioTotalSeg;
    }

    public Cancion [] cancionesDeMasDe (int seg) {
        int countMayorQueSum = 0;
        for (int i = 0; i < this.cancion.length; i++) {
            if (cancion[i].getDuracion() > seg) {
                countMayorQueSum++;
            }
        }

        Cancion [] cancionesMasLargasQueSeg = new Cancion[countMayorQueSum];
        int posCancionLarga = 0;
        for (int i = 0; i < this.cancion.length; i++) {
            if (cancion[i].getDuracion() > seg) {
                cancionesMasLargasQueSeg[posCancionLarga] = cancion[i];
                posCancionLarga++;
            }
        }
        return cancionesMasLargasQueSeg;
    }

    public Cancion [] getCancion (){
        return this.cancion;
    }
}