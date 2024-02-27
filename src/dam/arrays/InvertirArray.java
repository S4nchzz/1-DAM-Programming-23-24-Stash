package dam.arrays;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class InvertirArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Tamaño del array");
        int tamaño = sc.nextInt();

        int [] arrayA1 = new int[tamaño];

        for (int i = 0; i < arrayA1.length; i++){
            arrayA1[i] = rm.nextInt(99);
        }

        invertir(arrayA1);
    }

    public static void invertir (int [] a){
        int temp;
        for (int i = 0; i < a.length - 1 - i; i++) {
            temp = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
            a[i] = temp;
        }
    }
}
