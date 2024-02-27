package dam.funciones.simulacroExamen2;

import java.util.Scanner;


public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO 1");
        System.out.print("Valor1: ");
        int v1ej1 = sc.nextInt();
        System.out.print("Valor2: ");
        int v2ej1 = sc.nextInt();
        System.out.print("Valor3: ");
        int v3ej1 = sc.nextInt();

        System.out.println(diferenciaMenor(v1ej1, v2ej1, v3ej1));
    }
    public static int diferenciaMenor (int a, int b, int c) {

        int calculoAB = a - b < 0 ? b - a : a - b ;
        int calculoBC = b - c < 0 ? c - b : b - c ;
        int calculoCA = c - a < 0 ? a - c : c - a ;

        if (calculoAB <= calculoBC && calculoAB <= calculoCA) {
            return calculoAB;
        } else if (calculoBC <= calculoAB && calculoBC <= calculoCA) {
            return calculoBC;
        } else {
            return calculoCA;
        }
    }
}