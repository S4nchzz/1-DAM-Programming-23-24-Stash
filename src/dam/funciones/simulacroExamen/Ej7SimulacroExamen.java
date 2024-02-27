package dam.funciones.simulacroExamen;

import java.util.Scanner;

//Dado un número, calcular la suma de todos los números desde el 1 hasta el número dado,
//exceptuando los que terminen en 7 o en 8.

public class Ej7SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 7");

        System.out.print("Valor1:");
        int valor = sc.nextInt();
        System.out.println(restoCalculo(valor));
    }

    public static int restoCalculo (int n) {
        int calculo = 0;
        for (int i = 0; i <= n; i++) {
            if (calculo % 10 != 7 || calculo % 10 != 8) {
                calculo += i;
            }
        }
        return calculo;
    }
}
