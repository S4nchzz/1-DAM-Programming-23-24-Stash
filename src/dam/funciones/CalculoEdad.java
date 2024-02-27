package dam.funciones;

import java.util.Scanner;

public class CalculoEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       System.out.println(edad(21, 8, 1985, 23, 10, 2023));
    }

    public static int edad (int dn, int mn, int an, int dh, int mh, int ah) {
        int r = ah - an;

        if (mh < mn || mh == mn && dh < dn) {
            r--;
        }
        return r;
    }
}
