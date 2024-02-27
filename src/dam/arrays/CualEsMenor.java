package dam.arrays;

import java.util.Scanner;
import java.util.Random;

public class CualEsMenor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        int tamaño1 = sc.nextInt();
        int [] array1 = new int [tamaño1];
        int tamaño2 = sc.nextInt();
        int [] array2 = new int [tamaño2];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = rm.nextInt(9);
        }

        for (int k = 0; k < array2.length; k++) {
            array2[k] = rm.nextInt(9);
        }
    }

    public static boolean esMenor (int [] a, int [] b) {
        int i = 0;

        while (i < a.length && i < b.length) {
            if (a[i] < b[i]) {
                return true;
            } else if (a[i] > b[i]) {
                return false;
            }
        }
        return a.length < b.length;
    }
}
