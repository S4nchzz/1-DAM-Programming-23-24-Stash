package dam.arrays;

import java.util.Scanner;
import java.util.Arrays;


public class MonedasYBilletes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.toString(repartirDinero(sc.nextInt())));

    }

    public static int [] repartirDinero (int euros) {
        int [] arr = new int [9];

        int i = 0;
        int newBadget = euros;

            if (newBadget >= 500) {
                arr[i] = newBadget / 500;
                newBadget -= 500 * arr[i];
            }
            i++;

            if (newBadget >= 200) {
                arr[i] = newBadget / 200;
                newBadget -= 200 * arr[i];
            }
            i++;

            if (newBadget >= 100) {
                arr[i] = newBadget / 100;
                newBadget -= 100 * arr[i];
            }
            i++;

            if (newBadget >= 50) {
                arr[i] = newBadget / 50;
                newBadget -= 50 * arr[i];
            }
            i++;

            if (newBadget >= 20) {
                arr[i] = newBadget / 20;
                newBadget -= 20 * arr[i];
            }
            i++;

            if (newBadget >= 10) {
                arr[i] = newBadget / 10;
                newBadget -= 10 * arr[i];
            }
            i++;

            if (newBadget >= 5) {
                arr[i] = newBadget / 5;
                newBadget -= 5 * arr[i];
            }
            i++;

            if (newBadget >= 2) {
                arr[i] = newBadget / 2;
                newBadget -= 2 * arr[i];
            }
            i++;

            if (newBadget >= 1) {
                arr[i] = newBadget;
            }
            return arr;
    }
}
