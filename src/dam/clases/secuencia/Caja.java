package dam.clases.secuencia;

public class Caja {
    private int [] arr = new int []{7, 22, 11, 34, 17, 52, 26, 13, 40, 20};
    private int posicion = 0;
    public int mirar () {
        return arr[posicion];
    }

    public void anterior () {
        posicion--;

        if (posicion < 0) {
            posicion = arr.length - 1;
        }
    }

    public void siguiente () {
        posicion++;

        if (posicion >= arr.length) {
            posicion = 0;
        }
    }
}
