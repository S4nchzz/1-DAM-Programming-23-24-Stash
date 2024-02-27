package dam.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrimeroQueNoEsta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Tamaño del array: ");
        //int tamanoSA = sc.nextInt();

        int [] arrayA1 = new int [5];

        for (int i = 0; i < arrayA1.length; i++){
            arrayA1[i] = rm.nextInt(9);
        }

        arrayA1[0] = 20;
        arrayA1[1] = 20;
        arrayA1[2] = 20;
        arrayA1[3] = 20;
        arrayA1[4] = 20;
        System.out.println(Arrays.toString(arrayA1));
        System.out.println(primeroQueNoEsta(arrayA1));
    }

    public static int primeroQueNoEsta (int [] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == count) {
                count++;
            }
        }
        return count;
    }
}
