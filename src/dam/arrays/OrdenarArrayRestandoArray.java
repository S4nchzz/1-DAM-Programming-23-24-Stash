package dam.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OrdenarArrayRestandoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Tamaño del array: ");
        int tamanoSA = sc.nextInt();

        int [] sortArray = new int [tamanoSA];

        for (int i = 0; i < sortArray.length; i++){
            sortArray[i] = rm.nextInt(99);
        }


        System.out.println(Arrays.toString(sortArray));
        System.out.println(Arrays.toString(ordenar(sortArray)));
    }

    public static int [] ordenar (int [] a) {
        int aLength = a.length;
        int ultimoNArray;
        int queVuelta = 0;

        for (; aLength > 1; aLength--) {
            int mayorArray = 0;

            for (int i = 0; i < a.length; i++) {
                if (a[i] > mayorArray) {
                    mayorArray = a[i];
                    queVuelta = i;
                }
            }

            ultimoNArray = a[a.length - 1];
            a[a.length - 1] = mayorArray;
            a[queVuelta] = ultimoNArray;
        }
        return a;
    }
}