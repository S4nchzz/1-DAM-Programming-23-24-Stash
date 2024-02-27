package dam.funciones.simulacroExamen;

import java.util.Scanner;


//Dados tres números, calcular el resultado de sumar el mayor más el doble del menor.
public class Ej1SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 1");

        System.out.println("Valor1 :");
        int valor1 = sc.nextInt();
        System.out.println("Valor2 :");
        int valor2 = sc.nextInt();
        System.out.println("Valor3 :");
        int valor3 = sc.nextInt();

        int numMayor;
        int numMenor;
        int calculo;

        // COMPROBACIÓN CUAL ES EL MAYOR
        if (valor1 >= valor2 && valor2 >= valor3 || valor1 >= valor3 && valor3 >= valor2) {
            numMayor = valor1;
        } else if (valor2 >= valor1 && valor1 >= valor3 || valor2 >= valor3 && valor3 >= valor1) {
            numMayor = valor2;
        } else {
            numMayor = valor3;
        }

        // COMPROBACIÓN CUAL ES EL MENOR
        if (valor1 <= valor2 && valor2 <= valor3 || valor1 <= valor3 && valor3 <= valor2) {
            numMenor = valor1;
        } else if (valor2 <= valor1 && valor1 <= valor3 || valor2 <= valor3 && valor3 <= valor1) {
            numMenor = valor2;
        } else {
            numMenor = valor3;
        }

        calculo = numMayor + (numMenor * 2);
        System.out.println(calculo);
    }
}
