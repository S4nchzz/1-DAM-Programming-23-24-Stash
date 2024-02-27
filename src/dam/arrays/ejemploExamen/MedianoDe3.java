package dam.arrays.ejemploExamen;

public class MedianoDe3 {
    public static void main(String[] args) {
        int [] arr = new int [] {9, 3, 4, 2, 4, 6, 7, 6, 30, 10};

        mediano3(arr);
    }

    public static void mediano3 (int [] a) {
        int media;
        for (int i = 0; i < a.length - 1; i++) {
            media = a[i] + a[i + 1] / 2;
            a[i] = media;
            a[i + 1] = media;
            i++;
        }
    }
}
