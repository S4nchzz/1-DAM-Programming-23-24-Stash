package dam.arrays.ejemploExamen;

public class TiraAscendenteMasLarga {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 2, 2, 2, 2, 1};

        System.out.println(tiraAscendenteMasLarga(arr));
    }

    public static int tiraAscendenteMasLarga(int[] a) {
        int tira1 = 1;
        int tiraLarga = tira1;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                tira1++;
                if (tira1 > tiraLarga) {
                    tiraLarga = tira1;
                }
            } else {
                tira1 = 1;
            }
        }
        return tiraLarga;
    }
}

