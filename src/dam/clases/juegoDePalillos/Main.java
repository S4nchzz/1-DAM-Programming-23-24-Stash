package dam.clases.juegoDePalillos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JuegoDePalillos jp = new JuegoDePalillos();

        Scanner sc = new Scanner(System.in);
        while (jp.cuantosQuedan() > 0) {
            if (jp.turno()) {
                System.out.print("Jugador A: ");
            } else {
                System.out.print("Jugador B: ");
            }

            System.out.println("Quedan " + jp.cuantosQuedan());
            jp.coger(sc.nextInt());
        }
        System.out.println(jp.turno() ? "Gano A" : "Gano B");
    }
}
