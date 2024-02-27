package dam.clases.juego_de_la_vida;

public class Main {
    public static void main(String[] args) {
        JuegoDeLaVida jogo = new JuegoDeLaVida(100);

        for (int i = 0; i < 100; i++) {
            jogo.avanzar();
            System.out.println(jogo.ver());
        }
    }
}