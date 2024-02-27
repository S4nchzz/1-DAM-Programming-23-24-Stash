package dam.funciones;

import java.util.Scanner;

public class JirafasHipopotamos {
	public static int jirafasHipopotamos (int precioJirafa, int precioHipopotamo, int dineroTotal) {
		int numeroSoluciones = 0;
		int dinero2 = dineroTotal;
		
		for (; 0 <= dinero2; dinero2-= precioJirafa) {			
			if (dinero2 % precioHipopotamo == 0) {
				numeroSoluciones++;
			}
		}

		return numeroSoluciones;

	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("¿Cuantas jirafas? ");
		int valorJirafas = sc.nextInt();
		System.out.print("¿Cuantos hipos? ");
		int valorHipos = sc.nextInt();
		System.out.print("Dinero: ");
		int valorDinero = sc.nextInt();
		
		int resultado = (jirafasHipopotamos(valorJirafas, valorHipos, valorDinero));
		System.out.println(resultado);
	}
}
