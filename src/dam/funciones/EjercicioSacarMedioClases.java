package dam.funciones;

import java.util.Scanner;


public class EjercicioSacarMedioClases {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vU1 = sc.nextInt();
		int vU2 = sc.nextInt();
		int vU3 = sc.nextInt();
		
		int resultado = calculoMedio(vU1, vU2, vU3);
		System.out.println(resultado);
		
		sc.close();
	}

	public static int calculoMedio (int v1, int v2, int v3) {
	
		int medio;
		
		if ((v1 <= v2 && v1 >= v3) || (v1 >= v2 && v1 <= v3)) {
			medio = v1;
		} else if ((v2 <= v1 && v2 >= v3) || (v2 >= v1 && v2 <= v3)){
			medio = v2;
		} else {
			medio = v3;
		}

		return medio;

	}
}