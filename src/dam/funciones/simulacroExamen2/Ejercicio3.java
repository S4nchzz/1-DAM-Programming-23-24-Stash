package dam.funciones.simulacroExamen2;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO 3");
        System.out.print("Valor: ");
        int v1ej3 = sc.nextInt();

        System.out.println(siguiente7(v1ej3));
    }

    public static int siguiente7 (int n) {
        while (n % 10 != 7) {
            n++;
        }
        return n;
    }
}
