package dam.arrays.examen;

public class MasProximoA7 {
    public static void main(String[] args) {
        int [] arr = new int [] {};
        System.out.println(masProximoA7(arr));
    }

    public static int masProximoA7 (int [] a) {
        if (a.length == 0) {
            return -1;
        }

        int calculo = a[0] - 7 < 0 ? 7 - a[0] : a[0] - 7;
        int valorMenor = calculo;
        int numero = a[0];
        for (int i = 0; i < a.length; i++) {
            calculo = a[i] - 7 < 0 ? 7 - a[i] : a[i] - 7;

            if (calculo < valorMenor) {
                valorMenor = calculo;
                numero = a[i];
            }
        }
        return numero;
    }
}
