package dam.examen;

public class nElevadoAN {
    public static void main(String[] args) {
        System.out.println(nElevadoAN(5));
    }

    public static int nElevadoAN (int n) {

        for (int i = 1; i <= n; i++) {
            n = n * n;
        }
        return n;

    }
}
