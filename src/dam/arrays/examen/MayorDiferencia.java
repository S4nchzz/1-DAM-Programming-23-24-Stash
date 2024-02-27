package dam.arrays.examen;

public class MayorDiferencia {
    public static void main(String[] args) {
        int [] arr = new int []{1,4,8,9,10};
        System.out.println(mayorDiferencia(arr));
    }
    public static int mayorDiferencia (int [] a ){
        if (a.length == 0) {
            return -1;
        } else {
            int resta = a[0] - a[1] < 0 ? a[1] - a[0] : a[0] - a[1];
            int mayorResta = resta;

            for (int i = 1; i < a.length - 1; i++) {
                resta = a[i] - a[i + 1] < 0 ? a[i + 1] - a[i] : a[i] - a[i + 1];

                if (resta > mayorResta) {
                    mayorResta = resta;
                }
            }
            return mayorResta;
        }
    }
}
