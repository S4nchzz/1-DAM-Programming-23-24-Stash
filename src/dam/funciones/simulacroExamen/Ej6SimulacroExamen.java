package dam.funciones.simulacroExamen;

import java.util.Scanner;

//Dados tres números, calcular un resultado según los siguientes criterios:
//a) Si hay dos números pares y uno impar, el resultado es la diferencia entre los dos pares.
//b) Si hay dos números impares y uno par, el resultado es la diferencia entre los dos impares.
//c) Si hay tres números pares o tres números impares, el resultado es 42.

public class Ej6SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 6");

        System.out.println("Valor1: ");
        int valorUsuario1 = sc.nextInt();
        System.out.println("Valor2: ");
        int valorUsuario2 = sc.nextInt();
        System.out.println("Valor3: ");
        int valorUsuario3 = sc.nextInt();

        System.out.println(restoCalculo(valorUsuario1, valorUsuario2, valorUsuario3));
    }

    public static int restoCalculo (int a, int b, int c) {
        int calculoResto = 0;

        // RESTO 2 VARIABLES SI UNA DE ELLAS ES IMPAR
        if (a % 2 == 0 && b % 2 == 0 && c % 2 != 0) {
            calculoResto = a - b;
        } else if (b % 2 == 0 && c % 2 == 0 && a % 2 != 0) {
            calculoResto = b - c;
        } else if (a % 2 == 0 && c % 2 == 0 && b % 2 != 0) {
            calculoResto = a - c;
        }
        // RESTO 2 VARIABLES SI UNA DE ELLAS ES PAR
        if (a % 2 != 0 && b % 2 != 0 && c % 2 == 0) {
            calculoResto = a - b;
        } else if (b % 2 != 0 && c % 2 != 0 && a % 2 == 0) {
            calculoResto = b - c;
        } else if (a % 2 != 0 && c % 2 != 0 && b % 2 == 0) {
            calculoResto = a - c;
        }

        if ((a % 2 == 0 && b % 2 == 0 && c % 2 == 0) || (a % 2 != 0 && b % 2 != 0 && c % 2 != 0)) {
            return 42;
        }

        if (calculoResto < 0) {
            calculoResto -= calculoResto;
        }

        return calculoResto;
    }

}
