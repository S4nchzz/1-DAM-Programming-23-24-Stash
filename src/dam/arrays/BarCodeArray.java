package dam.arrays;

import java.util.Scanner;

public class BarCodeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño del array: ");
        int tamaño = sc.nextInt();

        int [] eanDigits = new int [tamaño];
        eanDigits[0] = 4;
        eanDigits[1] = 0;
        eanDigits[2] = 0;
        eanDigits[3] = 4;
        eanDigits[4] = 7;
        eanDigits[5] = 6;
        eanDigits[6] = 4;
        eanDigits[7] = 0;
        eanDigits[8] = 3;
        eanDigits[9] = 3;
        eanDigits[10] = 2;
        eanDigits[11] = 1;
        eanDigits[12] = 8;

       System.out.println(ean13(eanDigits));
    }

    public static boolean ean13 (int [] barras) {
        int multiplicacionPares;
        int sumatorioPares = 0;
        int sumatorioImpares = 0;

        int sumatorioGlobal;

        for (int k = 0; k < 13; k++) {
            if (barras[k] % 2 != 0) {
                multiplicacionPares = barras[k] * 3;
                sumatorioPares += multiplicacionPares;
            } else {
                sumatorioImpares += barras[k];
            }
        }

        sumatorioGlobal = sumatorioPares + sumatorioImpares;
        return sumatorioGlobal % 10 == 0;
    }
}