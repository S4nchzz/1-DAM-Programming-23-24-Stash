package dam.arrays;

import java.util.Scanner;

public class MayorDeTodosFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] obtenerMax = new int[4];

        System.out.println("Valor1: ");
        obtenerMax [0] = sc.nextInt();

        System.out.println("Valor2: ");
        obtenerMax [1] = sc.nextInt();

        System.out.println("Valor3: ");
        obtenerMax [2] = sc.nextInt();

        System.out.println("Valor4: ");
        obtenerMax [3] = sc.nextInt();

        System.out.println(maximo(obtenerMax));
    }

    public static int maximo (int [] a) {
        int mayor = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > mayor) {
                mayor = a[i];
            }
        }
        return mayor;
    }
}
