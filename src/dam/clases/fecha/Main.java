package dam.clases.fecha;

public class Main {
    public static void main(String[] args) {
        Fecha f = new Fecha ();
        f.dia = 21;
        f.mes = 22;
        f.ano = 23;

        Fecha f2 = new Fecha();
        f2.dia = 33;
        f2.mes = 32;
        f2.ano = 31;

        System.out.println(f.dia);
        System.out.println(f.mes);
        System.out.println(f.ano);
        System.out.println("------");
        System.out.println(f2.dia);
        System.out.println(f2.mes);
        System.out.println(f2.ano);

        f2 = f;

        System.out.println(f.dia);
        System.out.println(f.mes);
        System.out.println(f.ano);
        System.out.println("------");
        System.out.println(f2.dia);
        System.out.println(f2.mes);
        System.out.println(f2.ano);
    }
}
