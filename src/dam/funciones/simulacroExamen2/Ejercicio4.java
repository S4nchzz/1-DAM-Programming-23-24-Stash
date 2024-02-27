package dam.funciones.simulacroExamen2;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO 4");
        System.out.print("Desde: ");
        int valor1ej4 = sc.nextInt();
        System.out.print("Hasta: ");
        int valor2ej4 = sc.nextInt();
        System.out.println(horas(valor1ej4, valor2ej4));
    }

    public static int horas (int desde, int hasta) {
        return (hasta - desde + 12) % 12;
    }

}
