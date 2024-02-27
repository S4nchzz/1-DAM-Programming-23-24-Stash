package dam.funciones;

import java.util.Scanner;


public class SumatorioDesdeHasta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Desde: ");
        int valor1 = sc.nextInt();
        System.out.print("Hasta: ");
        int valor2 = sc.nextInt();
        System.out.println(suma(valor1, valor2));
    }

    public static int suma (int desde, int hasta) {
        int sumatorioDesde;
        int calculo = 0;

        for(int i = 0; i != (desde - hasta); i++) {
            sumatorioDesde = desde++;
            calculo += sumatorioDesde;
            if (sumatorioDesde == hasta) {
                break;
            }
        }
        return calculo;
    }
}
