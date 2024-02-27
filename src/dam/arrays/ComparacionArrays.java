package dam.arrays;

import java.util.Scanner;
import java.util.Random;

public class ComparacionArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese cantidad de valores del array1: ");
        int ay1 = sc.nextInt();

        System.out.println("Ingrese cantidad de valores del array2: ");
        int ay2 = sc.nextInt();

        int [] array1 = new int[ay1];
        int [] array2 = new int[ay2];

        System.out.println(comparar(array1, array2));
    }

    public static boolean comparar (int [] a, int [] b) {
        Random rm = new Random();
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                a[i] = rm.nextInt(6);
                b[i] = rm.nextInt(6);

                if (a[i] == b[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
