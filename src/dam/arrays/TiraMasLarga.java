package dam.arrays;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class TiraMasLarga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Tamaño del array");
        int tamaño = sc.nextInt();

        int [] arrayA1 = new int[tamaño];

        for (int i = 0; i < arrayA1.length; i++){
            arrayA1[i] = rm.nextInt(2);
        }

        System.out.println(Arrays.toString(arrayA1));
        System.out.println(tiraMasLarga(arrayA1));
    }

    public static int tiraMasLarga(int [] a){
        int tira = 1;
        int count = 1;
        for (int i = 1; i < a.length; i++){
            if (a[i] == a[i - 1]){
                count++;
            } else {
                count = 1;
            }
            tira = count;

            if (count > tira){
               count = tira;
            }
        }

        return tira;
    }
}
