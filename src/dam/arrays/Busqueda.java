package dam.arrays;

import java.util.Scanner;

public class Busqueda {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.print("Cual es el tamaño del array?: ");
        int tamaño = sc.nextInt();
        int [] pajar = new int [tamaño];

        System.out.print("Que numero quieres buscar: ");
        int aguja = sc.nextInt();

        for (int k = 0; k < tamaño; k++) {
            pajar [k] = k + 1;
        }
        System.out.println (buscar(pajar, aguja));
    }

    public static int buscar (int [] pajar, int aguja) {
        for (int k = 0; k < pajar.length; k++) {
            if (aguja == pajar[k]) {
                return k;
            }
        }
        return -1;
    }
}
