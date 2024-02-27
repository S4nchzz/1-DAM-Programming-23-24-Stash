package dam.herencia.primeraIdea.nim;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        Foto a = new FotoNimFibo();

        Foto [] m = a.getMovimientos();

        while (m.length > 0) {
            System.out.println("------");
            System.out.println("Posicion actual: ");
            System.out.println(a.toString());

            for (int i = 0 ; i < m.length; i++) {
                System.out.println("Movimiento " + i);
                System.out.println(m[i].toString());
            }

            System.out.println("Le toca a " + (a.getTurno() ? "A" : "B"));
            System.out.println("Elige movimientos: ");
            final int eleccion = sc.nextInt();

            if (eleccion >= 0 && eleccion < m.length) {
                a = m[eleccion];
                m = a.getMovimientos();
            }
        }
        sc.close();
        System.out.println("Ha ganado " + (a.haGanadoA() ? "A" : "B"));
    }
}
