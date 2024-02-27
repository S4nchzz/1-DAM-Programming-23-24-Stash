package dam.arrays;


import java.util.Scanner;

public class MayorDeTodos {
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

        if (a[0] > a[1] && a[0] > a[2] && a[0] > a[3]) {
            mayor = a[0];
        } else if (a[1] > a[0] && a[1] > a[2] && a[1] > a[3]) {
            mayor = a[1];
        } else if (a[2] > a[1] && a[2] > a[0] && a[2] > a[3]) {
            mayor = a[2];
        } else {
            mayor = a[3];
        }

        return mayor;
    }
}
