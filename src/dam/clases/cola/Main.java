package dam.clases.cola;

public class Main {
    public static void main(String[] args) {
        Cola c = new Cola(); // la cola está recién creada, por lo tanto vacía
        System.out.println(c.pop()); // devuelve -1 porque la cola está vacía
        System.out.println(c.cuantos());
        c.push(42);
        c.push(28);
        System.out.println(c.cuantos());
        System.out.println(c.pop());
        System.out.println(c.cuantos());
        c.push(14);
        c.cuantos();    
        System.out.println(c.pop());
        c.vaciar();
        System.out.println(c.cuantos());
        System.out.println(c.pop());
    }
}
