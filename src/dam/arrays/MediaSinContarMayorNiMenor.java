package dam.arrays;

import java.util.Random;
import java.util.Scanner;

public class MediaSinContarMayorNiMenor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad del array: ");
        int cantidadArray = sc.nextInt();
        double [] obtenerMedia = new double[cantidadArray];

        System.out.println(sumatorio(obtenerMedia));
    }

    public static double mayor (double [] a) {
        double mayor = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > mayor) {
                mayor = a[i];
            }
        }
        return mayor;
    }

    public static double menor (double [] a) {
        double menor = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < menor) {
                menor = a[i];
            }
        }
        return menor;
    }

    public static double sumatorio (double [] a) {
        Random rm = new Random();
        double sumatorioTotal = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = rm.nextInt(10);
            sumatorioTotal += a[i];
        }
        return (sumatorioTotal - (mayor(a) + menor(a))) / (a.length - 2);
    }
}
