package dam.clases.cronometro;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cronometro crono = new Cronometro(1);
        System.out.println(crono.start(0));
        Thread.sleep(2000);
        System.out.println(crono.peek(0));
        Thread.sleep(2000);
        System.out.println(crono.stop(0));
        Thread.sleep(2000);
        System.out.println(crono.start(0));
    }
}
