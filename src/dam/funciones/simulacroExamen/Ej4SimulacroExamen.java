package dam.funciones.simulacroExamen;

import java.util.Scanner;

//Dado un número de segundos, convertirlo en horas, minutos y segundos
public class Ej4SimulacroExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 4");
        System.out.println("Valor delta: ");

        int delta = sc.nextInt();

        System.out.println(calculoTiempo(delta));
    }

    public static String calculoTiempo (int delta) {
        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        for (int i = 0; i < delta; i++) {
            segundos++; // VARIABLE EN AUMENTO PARA CALCULO DE SEGUNDOS

            if (horas == 24) {
                segundos = 0;
                horas = 0;
            }

            if (minutos == 60) {
                horas++;
                minutos = 0;
            }

            if (segundos == 60) {
                minutos++;
                segundos = 0;
            }
        }
        return (horas + ":" + minutos + ":" + segundos);
    }
}
