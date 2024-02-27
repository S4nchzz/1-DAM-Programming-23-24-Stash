package dam.arrays;

public class cuantosCambios {
    public static void main(String[] args) {
        boolean [] arr = new boolean[] {true, true, false, true, false, false, false, false, false, true, false, false};

        System.out.println(cambioArr(arr));
    }

    public static int cambioArr(boolean [] a) {
        int contador = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                contador++;
            }
        }
        return contador;
    }
}
