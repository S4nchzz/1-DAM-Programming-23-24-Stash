package dam.clases.secuencia;

public class Main {
    public static void main(String[] args) {
        Caja c = new Caja();
        System.out.println(c.mirar());
        c.siguiente();
        System.out.println(c.mirar());
        c.anterior();
        c.anterior();
        System.out.println(c.mirar());
    }
}



