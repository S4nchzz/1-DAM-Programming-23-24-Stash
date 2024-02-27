package dam.arrays;

public class rellenar1_0 {
    public static void main(String[] args) {
        boolean [] arr = new boolean[10];

        rellenarTrueFalse(arr);
    }

    public static void rellenarTrueFalse (boolean [] a) {
        int tira = 0;
        int posicion = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = tira == posicion;

            if (tira == posicion) {
                tira++;
                posicion = 0;
            } else {
                posicion++;
            }
        }
    }
}
