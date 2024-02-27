package dam.arrays;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño array: ");
        int tamaño = sc.nextInt();
        int [] paja = new int[tamaño]; // ARRAY CON TAMAÑO PERS.

        System.out.print("Numero a buscar: ");
        int aguja = sc.nextInt();


        System.out.println(busqueda(paja, aguja));
        System.out.println(arrayToString(paja));
    }

    public static int busqueda (int paja [], int aguja) {
        for (int k = 1; k < paja.length; k++) {
            //RANDOMIZE
            if (paja [k]== aguja) {
                return k;
            }
        }
        return -1;
    }
    public static String arrayToString (int [] x) {
        if (x.length <= 0) {
            return "{}";
        }

        String r = "{" + x[0];
        for (int k = 1; k < x.length; k++) {
            r = r + "," + x[k];
        }

        return r + "}";
    }
}
