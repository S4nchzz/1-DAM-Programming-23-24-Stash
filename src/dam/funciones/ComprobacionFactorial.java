package dam.funciones;

import java.util.Scanner;

public class ComprobacionFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        int valor = sc.nextInt();

        System.out.println(esFactorial(valor));

    }

    public static boolean esFactorial (int n) {
        int r = 1;
        int k = 2;

        while (k < 10) {
            r = r * k;
            k++;
        }
        return r == n;
    }
}
