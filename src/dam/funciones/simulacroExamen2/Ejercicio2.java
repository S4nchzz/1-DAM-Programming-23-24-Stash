package dam.funciones.simulacroExamen2;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO 2");
        System.out.print("Valor1: ");
        int v1ej2 = sc.nextInt();
        System.out.print("Valor2: ");
        int v2ej2 = sc.nextInt();
        System.out.print("Valor3: ");
        int v3ej2 = sc.nextInt();

        System.out.println(triple(v1ej2, v2ej2, v3ej2));
    }

    public static boolean triple (int a, int b, int c) {
        return (a * 3 == b || a * 3 == c || b * 3 == a || b * 3 == c || c * 3 == a);
    }
}
