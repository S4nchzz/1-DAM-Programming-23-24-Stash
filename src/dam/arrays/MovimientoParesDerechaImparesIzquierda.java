package dam.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MovimientoParesDerechaImparesIzquierda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.print("Tamaño del array: ");
        int arraySize = sc.nextInt();

        int[] arrayA1 = new int[arraySize];

        for (int i = 0; i < arrayA1.length; i++) {
            arrayA1[i] = rm.nextInt(10);
            if (arrayA1[i] == 0) {
                arrayA1[i] = 1;
            }
        }

        System.out.println(Arrays.toString(arrayA1));
        System.out.println(Arrays.toString(procesarArray(arrayA1)));
    }

    public static int[] procesarArray(int[] array) {

        int[] variablesImpares = new int[array.length];

        // SEGUN UN ARRAY CON LA MISMA LONGITUD QUE EL PRINCIPAL
        // SE PONDRAN LOS NUMEROS IMPARES EN LAS POSICIONES EN LAS QUE VIENE SUPRIMIENDO LOS PARES
        for (int x = 0; x < array.length; x++) {
            if (array[x] % 2 != 0) {
                variablesImpares[x] = array[x];
            }
        }

        for (int c = 0; c < array.length; c++) {
            // BUCLE QUE COMIENZA EN LA LONGITUD MAXIMA DEL ARRAY Y VA RESTANDO HASTA QUE LLEGUE A 0
            for (int q = variablesImpares.length - 1; q > 0; q--) {
                // SI LA POSICION ACTUAL ES 0 Y LA ANTERIOR ES DISTINTO DE 0 SE INTERCAMBIAN
                if (variablesImpares[q] == 0 && variablesImpares[q - 1] != 0) {
                    variablesImpares[q] = variablesImpares[q - 1];
                    variablesImpares[q - 1] = 0;
                }
            }
        }


        int temp;
        // BUCLE ANIDADO PARA REPETIR EL CALCULO TANTAS VECES COMO SEA LA LONGITUD DEL ARRAY
        for (int k = 0; k < array.length; k++) {
            // BUCLE PARA CALCULAR LAS POSICIONES RECORRIENDO
            // EL ARRAY 1 UNICA VEZ DEL 0 HASTA SU LONGITUD Y CAMBIANDO LOS VALORES CORRESPONDIENTES
            for (int i = 0; i < array.length - 1; i++) {
                // SI EL VALOR DE LA POSICION ACTUAL ES IMPAR Y LA SIGUIENTE ES PAR SE INTERCAMBIAN
                if (array[i] % 2 != 0 && array[i + 1] % 2 == 0) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        int temp2;
        // BUCLE PARA RECORRER EL ARRAY TANTAS VECES COMO SEA SU LONGITUD
        for (int j = 0; j < array.length; j++) {
            // BUCLE PARA RECORRER EL ARRAY MENOS LA ULTIMA POSICION
            for (int g = 0; g < array.length - 1; g++) {
                // SI LA POSICION ACTUAL ES PAR SE EJECUTA EL IF
                if (array[g] % 2 == 0) {
                    // SI LA POSICION ACTUAL ES MAYOR QUE LA SIGUIENTE Y LA POSICION SIGUIENTE ES PAR SE INTERCAMBIAN
                    if (array[g] > array[g + 1] && array[g + 1] % 2 == 0) {
                        temp2 = array[g + 1];
                        array[g + 1] = array[g];
                        array[g] = temp2;
                    }
                }
            }
        }

        // SE SOBREESCRIBE EL ARRAY PRINCIPAL CON EL ARRAY CON LOS NUMEROS IMPARES YA MOVIDOS
        for (int f = 0; f < array.length; f++) {
            if (array[f] % 2 != 0) {
                array[f] = variablesImpares[f];
            }
        }
        return array;
    }
}
    //EJERCICIO ARRAY CHATGPT
    //1. Mover todos los números pares al principio del array, manteniendo el orden original de aparición de los números pares.
    //2. Ordenar de forma ascendente los números pares ubicados al principio del array.
    //3. Mover todos los números impares al final del array, manteniendo el orden original de aparición de los números impares.
    //4. Devolver el array modificado.
