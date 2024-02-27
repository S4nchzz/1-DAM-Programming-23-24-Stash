package dam.arrays.examen;

import java.util.Arrays;

public class RellenarSerie {
    public static void main(String[] args) {
        int [] arr = new int [5];

        System.out.println(Arrays.toString(rellenarSerie(arr)));
    }

    public static int [] rellenarSerie (int [] a) {
        int valorRelleno = 1;
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < valorRelleno; k++) {
                a[i] = valorRelleno;
            }
            valorRelleno++;
        }
        return a;
    }
}
