package dam.arrays.examen;

public class MenorRepetido {
    public static void main(String[] args) {
        int [] arr = new int []{5,9,3,5,9,9};

        System.out.println(menorRepetido(arr));
    }

    public static int menorRepetido (int [] a) {
        boolean hayRepetidos = false;
        int count = 1;

        for (int i = 0; i < a.length; i++) {
            for (int k = i + 1; k < a.length; k++) {
                if (a[k] == a[i]) {
                    if (hayRepetidos) {
                    } else {
                        count = a[i];
                        hayRepetidos = true;
                    }
                }
            }
        }
        return count;
    }
}
