package dam.funciones;

import java.util.Scanner;

public class ElQueFalta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor1: ");
        int valor1 = sc.nextInt();
        System.out.print("Valor2: ");
        int valor2 = sc.nextInt();
        System.out.print("Valor3: ");
        int valor3 = sc.nextInt();

        int valor_mayor = calculoMayor(valor1, valor2, valor3);
        int valor_medio = calculoMedio(valor1, valor2, valor3);
        int valor_menor = calculoMenor(valor1, valor2, valor3);

        System.out.println(elquefalta(valor_mayor, valor_medio, valor_menor));
    }

    public static int elquefalta (int mayor, int medio, int menor) {
        if (menor + 1 != medio) {
            return menor + 1;
        } else if (medio + 1 != mayor) {
            return medio + 1;
        }
        return 0;
    }

    public static int calculoMayor (int amayor, int bmayor, int cmayor) {
        int mayor;
        if (amayor > bmayor && bmayor > cmayor || amayor > cmayor && cmayor > bmayor) {
            mayor = amayor;
        } else if (bmayor > amayor && amayor > cmayor || bmayor > cmayor && cmayor > amayor) {
            mayor = bmayor;
        } else {
            mayor = cmayor;
        }
        return mayor;
    }

    public static int calculoMedio (int amedio, int bmedio, int cmedio) {
        int medio;
        if (amedio <= cmedio && amedio >= bmedio || amedio >= cmedio && amedio <= bmedio) {
            medio = amedio;
        } else if (bmedio <= cmedio && bmedio >= amedio || bmedio >= cmedio && bmedio <= cmedio) {
            medio = bmedio;
        } else {
            medio = cmedio;
        }
        return medio;
    }

    public static int calculoMenor (int amenor, int bmenor, int cmenor) {
        int menor;
        if (amenor < bmenor && bmenor < cmenor || amenor < cmenor && cmenor < bmenor) {
            menor = amenor;
        } else if (bmenor < amenor && amenor < cmenor || bmenor < cmenor && cmenor < amenor) {
            menor = bmenor;
        } else {
            menor = cmenor;
        }
        return menor;
    }
}
