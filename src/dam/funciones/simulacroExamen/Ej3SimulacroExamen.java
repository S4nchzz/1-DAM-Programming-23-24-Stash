package dam.funciones.simulacroExamen;

import java.util.Scanner;


//Dado un número, calcular cuántas condiciones cumple entre las siguientes:
//a) Es un número impar entre 10 y 20.
//b) Es un número i
public class Ej3SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 3");

        System.out.println("Valor1 :");
        int valor1 = sc.nextInt();

        int resultado = calculoCondicionesSeCumplen(valor1);
        System.out.println("Se cumplen " + resultado + " condiciones");
    }

    public static int calculoCondicionesSeCumplen (int a) {
        int count = 0;
        if (a % 2 != 0 && a > 10 && a < 20) {
            count++;
        }

        if (a % 2 != 0 && a >= 5 && a <= 15) {
            count++;
        }

        if (a % 10 == 8) {
            count++;
        }
        return count;
    }

}
