package dam.tercer_trimestre_ejSueltos.hilos;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       Controller c =  new Controller(40000000, 4);
        System.out.println(c.getAcumulador());
    }
}