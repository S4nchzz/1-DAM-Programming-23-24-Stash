package dam.examen;

public class penultimaCifra {
    public static void main(String[] args) {
        System.out.println(penultimaCifra(1221));
    }

    public static int penultimaCifra (int n) {
        for (int i = 1; i < 2; i++) {
            n /= 10;
        }
        return n;
    }
}
