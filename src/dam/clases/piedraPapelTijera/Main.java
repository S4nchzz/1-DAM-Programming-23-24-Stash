package dam.clases.piedraPapelTijera;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PiedraPapelTijera ppt = new PiedraPapelTijera();
       
        System.out.println("! ! ! * * * Piedra (0), Papel, Tijera * * * ! !"); 
        System.out.println("-------------------------------------------");
        System.out.println();

        int h = sc.nextInt();
        
        while (h >= 0) {
            int o = ppt.sacar(h);
            System.out.println("H: " + h + " O: " + o);

            Marcador m = ppt.getMarcador();
            System.out.println("G: " + m.getGanadas()
                            + " // P:" + m.getPerdidas()
                            + " // E:" + m.getEmpatadas());
            
            h = sc.nextInt();
        }
    }
}