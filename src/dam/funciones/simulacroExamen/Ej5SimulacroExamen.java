package dam.funciones.simulacroExamen;

import java.util.Scanner;

//Dado un número, decir si es o no un cuadrado perfecto.
public class Ej5SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 5");
        System.out.println("Valor: ");

        int valorCuadradoPerfecto = sc.nextInt();
        System.out.println(calculoPerfecto(valorCuadradoPerfecto));
    }

    public static boolean calculoPerfecto (int a) {
        int calculo;
        for (int i = 0; i < a; i++) {
            calculo = i * i;
            if (a == calculo) {
                return true;
            }
        }
        return false;
    }

}
