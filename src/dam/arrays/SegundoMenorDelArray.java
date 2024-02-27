package dam.arrays;

import java.util.Scanner;
import java.util.Random;


public class SegundoMenorDelArray {
    public static void main(String[] args) {
        Random rm = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Tamaño del array: ");
        int tamañoArray = sc.nextInt();

        int [] array2doMenor = new int [tamañoArray];

        for (int i = 0; i < array2doMenor.length; i++) {
            array2doMenor[i] = rm.nextInt(10);
        }

        System.out.println(segundoMenor(array2doMenor));
    }

    public static int segundoMenor (int [] a) {
        int menor = a[0];
        int segundoMenor = menor;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < menor) {
                segundoMenor = menor;
                menor = a[i];

            } else if (segundoMenor > a[i]) {
                segundoMenor = a[i];
            }
        }
        return segundoMenor;
    }
}
