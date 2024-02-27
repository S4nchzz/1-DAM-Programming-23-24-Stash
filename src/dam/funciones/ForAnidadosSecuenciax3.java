package dam.funciones;

public class ForAnidadosSecuenciax3 {
    public static void main(String[] args) {
        
    }

    public static int maximoPasos (int a) {
        int r = 1;
        int collatzR = collatzR (r);

        for (int k = 2; k < a; k++) {
            int collatzK = collatzR (k);

            if (collatzK > collatzR) {
                r = k;
                collatzR = collatzK;
            }
        }
        return r;
    }
    public static int collatzR (int k) {
        for (k = 1; k < 10; k++) {
            System.out.println(k + "" + collatzR(k));
        }
        return 2;
    }
}
