package dam.arrays;

import java.util.Scanner;
import java.util.Random;

public class RotacionArrayDE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.print("Tamaño Array: ");
        int tamaño = sc.nextInt();

        int [] array1 = new int [tamaño];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = rm.nextInt(100);
        }

        rotarDerecha(array1);
    }

    public static void rotarDerecha (int [] a) {
        int ultimo = a[a.length - 1];

        for (int i = a.length - 2; i >= 0; i--) {
            a[i + 1] = a[i];
        }
        a[0] = ultimo;
    }
}
