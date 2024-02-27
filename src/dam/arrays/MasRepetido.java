package dam.arrays;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class MasRepetido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tamaño del array: ");
        int arraySize = sc.nextInt();

        int[] arr = new int[5];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 4;

        System.out.println(elMasRepetido(arr));
    }

    public static int elMasRepetido(int[] a) {
        int count = 0;
        int lastCount = count;
        int saveNumber = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                saveNumber = a[i];
                count++;
            }

            if (count > lastCount) {
                lastCount = count;
                count = 1;
                saveNumber = 0;
            }
        }

        return saveNumber;
    }
}