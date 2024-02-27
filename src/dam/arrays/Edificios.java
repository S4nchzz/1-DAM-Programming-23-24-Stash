package dam.arrays;

import java.util.Arrays;

public class Edificios {
    public static void main(String[] args) {
        int [] edificios = new int [33];

        System.out.println(Arrays.toString(edificios));
        System.out.println(cuantosEdificiosSeVen(edificios));
    }

    public static int cuantosEdificiosSeVen(int [] a) {
        int count = 1;
        if (a.length == 0) {
            return 0;
        } else {
            int temp = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                if (temp > a[i + 1]) {
                    count++;
                    temp = a[i + 1];
                }
            }
        }
        return count;
    }
}
