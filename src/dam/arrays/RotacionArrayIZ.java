package dam.arrays;

import java.util.Scanner;
import java.util.Random;

public class RotacionArrayIZ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.print("Tamaño Array: ");
        int tamaño = sc.nextInt();

        int [] array1 = new int [tamaño];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = rm.nextInt(100);
        }

        rotarIzquierda(array1);
    }

    public static void rotarIzquierda (int [] a) {
        int primero = a[0];

        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }

        a[a.length - 1] = primero;
    }
}
