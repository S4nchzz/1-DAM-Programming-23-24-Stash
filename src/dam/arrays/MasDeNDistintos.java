package dam.arrays;

import java.util.Scanner;

public class MasDeNDistintos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int []{1,1,2,3,3,4,4,5,5,6,9,7,8,8,};

        int cantidad = sc.nextInt();
        System.out.println(masDeNDistintos(arr, cantidad));
    }

    public static boolean masDeNDistintos(int[] a, int n) {
        if (a.length == 0 || n > a.length) {
            return false;
        } else {
            int[] distintos = new int[n]; //Array con numeros distintos

            /*
            //Bubble Sort
            for (int t = 0; t < a.length; t++) {
                for (int q = 0; q < a.length - 1; q++) {
                    int temp;
                    if (a[q] > a[q + 1]) {
                        temp = a[q + 1];
                        a[q + 1] = a[q];
                        a[q] = temp;
                    }
                }
            }

            */
            // Quitar repetidos
            int countDistintos = 0; //Contara cuando los valores sean distintos, para cambiar el valor del array por el correspondiente
            int posicion = 0;
            for (int i = 0; i < a.length && countDistintos != distintos.length; i++) {
                if (a[i] != a[i + 1]) {
                    distintos[countDistintos] = a[i];
                    countDistintos++;
                    posicion = i;
                }
            }

            int countRepetidos = 0;
            for (int s = 0; s < distintos.length; s++) {
                for (int w = 0; w < distintos.length; w++) {
                    if (distintos[w] == distintos[s]) {
                        countRepetidos++;
                    }
                    if (countRepetidos > 1) {
                        distintos[w] = 0;
                        countRepetidos = 0;
                    }
                }
            }

            //Cuando el FOR(J) se inicie, este analizara todos los valores de el array "distintos" sobre el array a[k]
            // el cual se actualizaen la siguiente vuelta despues de analizar todos los valores
            int count = 0;
            for (int k = posicion + 1; k < a.length; k++) {
                for (int j = 0; j < distintos.length && count == 0; j++) {
                    if (distintos[j] == a[k]) {  //En caso de que algun valor del array de distintos coincida con algun valor del array principal suma uno
                        count++;
                    }
                }
                if (count == 0) { //Si en la primera vuelta no encontro ninguno igual (count = 0) se entiende que ningun valor del array distintos coincide en la primera vuelta
                    return true;
                }
                count = 0; // Reseteo de variable para nuevo conteo
            }
        }
        return false;
    }
}