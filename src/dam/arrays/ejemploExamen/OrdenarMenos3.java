package dam.arrays.ejemploExamen;

public class OrdenarMenos3 {
    public static void main(String[] args) {
        int [] arr = new int [] {9, 3, 4, 2, 4, 6, 7, 6, 30, 10};

        ordenarMenor3(arr);
    }

    public static void ordenarMenor3 (int [] a) {
        int temp;
        for (int k = 0; k < a.length; k++) {
            for (int i = 3; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;d
                }
            }
        }
    }
}
