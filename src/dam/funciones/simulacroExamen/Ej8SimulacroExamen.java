package dam.funciones.simulacroExamen;

import java.util.Scanner;

//Dado un número, Escribir tantos términos de la secuencia 1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,... como indique el número.
public class Ej8SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 8");

        System.out.print("Valor:");
        int n = sc.nextInt();
        int contador123 = 1;

        for (int i = 1; i <= n; i++) {
            n = n + contador123;
            contador123++;

            if (contador123 > 3) {
                contador123 = 1;
            }
        }
    }
}
