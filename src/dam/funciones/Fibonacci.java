package dam.funciones;

import java.util.Scanner;

public class Fibonacci {
	public static int fibonacci (int x) {
		if (x < 2) {
			return 1;
		}
		
		int a = 1;
		int b = 1;
		int c = a + b;
		
		for (int k = 2; k < x; k++) {
			a = b;
			b = c;
			c = a + b;
		}
		
		return c;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int valor = sc.nextInt();
		
		int resultado = fibonacci(valor);
		System.out.println(resultado);
		
	}
	
}
