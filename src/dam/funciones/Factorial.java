package dam.funciones;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        int valor = sc.nextInt();
        System.out.println(factorial(valor));

    }

    public static int factorial (int n) {
        int sumatorio = 1;

        for (int i = 1; i <= n; i++) {
            sumatorio = i * sumatorio;
        }
        return sumatorio;
    }
}
