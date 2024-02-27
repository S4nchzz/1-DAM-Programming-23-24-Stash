package dam.clases.otro;

public class Main {
    public static void main(String[] args) {
        SecuenciaCaracteres sc = new SecuenciaCaracteres("3 +2704)");
        Lexico lx = new Lexico(sc);

        while (lx.mirar() != -1) {
            System.out.println(lx.mirar());
            lx.avanzar();
        }
    }
}
