package dam.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MonedasYBilletesConArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.toString(repartirDinero(sc.nextInt())));

    }

    public static int [] repartirDinero (int euros) {
        int [] sumaDinero = new int [9];
        int [] valoresDinero = new int [] {500, 200, 100, 50, 20, 10, 5, 2, 1};

        int newBadget = euros;

        for (int i = 0; i < valoresDinero.length; i++) {
            sumaDinero[i] = newBadget / valoresDinero[i] ;
            newBadget -= valoresDinero[i] * sumaDinero[i];
        }
        return sumaDinero;
    }
}
