package dam.arrays;

import java.util.Random;
import java.util.Scanner;

public class MediaArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad del array: ");
        int cantidadArray = sc.nextInt();
        int [] obtenerSumatorio = new int[cantidadArray];

        System.out.println(sumatorioArray(obtenerSumatorio));
    }

    public static int sumatorioArray (int [] a) {
        Random rm = new Random();
        int sumatorioTotal = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = rm.nextInt(2);
            sumatorioTotal += a[i];
        }
        return sumatorioTotal / a.length;
    }
}
