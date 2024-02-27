package dam.clases.piedraPapelTijera;

import java.util.Scanner;

public class PiedraPapelTijera {
    private int eleccionMaquina;

    private int ganadas;
    private int perdidas;
    private int empatadas;

    public PiedraPapelTijera () {
        this.ganadas = 0;
        this.perdidas = 0;
        this.empatadas = 0;
    }

    public int sacar (int tiradaHumano) {
        Scanner sc = new Scanner(System.in);

        this.eleccionMaquina = (int)(Math.random() * 3);

        do {
            if (tiradaHumano > 2) {
                System.out.println("Numero invalido, elija otro (0~2): ");
                tiradaHumano = sc.nextInt();
                if (tiradaHumano == -1) {
                    break;
                }
            }
        } while (tiradaHumano > 2);

        if (eleccionMaquina == tiradaHumano) {
            this.empatadas++;
        } else if(!ganaHumano(eleccionMaquina, tiradaHumano)) {
            this.ganadas++;
        } else {
            this.perdidas++;
        }
        return this.eleccionMaquina;
    }

    private static boolean ganaHumano (int eleccionMaquina, int tiradaHumano) {
        if (eleccionMaquina == tiradaHumano) {
            return false;
        } else if(eleccionMaquina == 0 && tiradaHumano == 1
                    || eleccionMaquina == 1 && tiradaHumano == 2
                    || eleccionMaquina == 2 && tiradaHumano == 0) {
            return false;
        } else {
            return true;
        }
    }

    public Marcador getMarcador () {
        return new Marcador(this.ganadas, this.perdidas, empatadas);
    }
}
