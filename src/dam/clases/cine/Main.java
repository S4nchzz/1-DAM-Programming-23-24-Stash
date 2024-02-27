package dam.clases.cine;

public class Main {
    public static void main(String[] args) {
        Cine c = new Cine();

        System.out.println(c.reservar(3));
        System.out.println(c.reservar(2));
        System.out.println(c.butacasLibres());
        System.out.println(c.juntos(3));

        if (c.buscarButaca(11) != -1) {
            System.out.println("Existe");
        } else {
            System.out.println("No existe");
        } 
    }
}