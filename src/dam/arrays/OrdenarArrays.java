package dam.arrays;

import java.util.Random;
import java.util.Scanner;

public class OrdenarArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Tamaño del array: ");
        int tamanoSA = sc.nextInt();

        int [] sortArray = new int [tamanoSA];

        for (int i = 0; i < sortArray.length; i++){
            sortArray[i] = rm.nextInt(99);
        }


        ordenar(sortArray);
    }

    public static void ordenar (int [] a) {
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
}