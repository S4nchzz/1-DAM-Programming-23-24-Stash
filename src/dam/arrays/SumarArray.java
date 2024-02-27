package dam.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumarArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] arrayN1 = new int [4];
        arrayN1[0] = sc.nextInt();
        arrayN1[1] = sc.nextInt();
        arrayN1[2] = sc.nextInt();
        arrayN1[3] = sc.nextInt();

        System.out.println("------------");

        int [] arrayY1 = new int [4];
        arrayY1[0] = sc.nextInt();
        arrayY1[1] = sc.nextInt();
        arrayY1[2] = sc.nextInt();
        arrayY1[3] = sc.nextInt();

        System.out.println(Arrays.toString(sumatorioCalculo(arrayN1, arrayY1)));
    }

    public static int [] sumatorioCalculo (int [] a1, int [] a2) {
        int cuantasMeLlevo = 0;
        int sumatorio;

        int [] resultado = new int [5];

        for (int k = a1.length - 1; k >= 0; k--) {
            sumatorio = a1[k] + a2[k] + cuantasMeLlevo;
            if (sumatorio > 9) {
                cuantasMeLlevo = 1;
                sumatorio %= 10;
            } else {
                cuantasMeLlevo = 0;
            }

            resultado[k + 1] = sumatorio;
        }

        resultado[0] = cuantasMeLlevo;
        return resultado;
    }


}