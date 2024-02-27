package dam.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscarBinarioArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Tamaño del array: ");
        int tamanoSA = sc.nextInt();

        int[] sortArray = new int[tamanoSA];

        for (int i = 0; i < sortArray.length; i++) {
            sortArray[i] = rm.nextInt(99);
        }

        ordenar(sortArray);
        System.out.println(Arrays.toString(sortArray));

        System.out.println("Valor a buscar en el array: ");
        int valorBusqueda = sc.nextInt();

        buscar(sortArray, valorBusqueda);
    }

    public static void ordenar(int[] a) {
        int cambioEnIteracion = a[0];

        for (int j = 1; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    cambioEnIteracion = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = cambioEnIteracion;
                }
            }
        }
    }

    public static int buscar(int[] a, int x) {
        if (a.length <= 0) {
            return -1;
        } else {
            for (int i = 0; a[3] < x; i++) {
                if (a[i] == x) {
                    return a[i];
                }
            }
            for (int i = a.length; a[3] > x; i--) {
                if (a[i] == x) {
                    return a[i];
                }
            }
            return -1;
        }
    }
}
