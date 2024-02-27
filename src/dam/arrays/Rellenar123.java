package dam.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Rellenar123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int [] arr = new int [sc.nextInt()];

        rellenar123(arr);
    }

    public static void rellenar123 (int [] a){
        int count = 1;
        
        for (int i = 0; i < a.length; i++) {
            a[i] = count;
            count++;

            if (count == 3) {
                count = 1;
            }
        }
    }
}
