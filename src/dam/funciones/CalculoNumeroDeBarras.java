package dam.funciones;

import java.util.Scanner;

public class CalculoNumeroDeBarras {
	public static boolean ean13v1(int n0, int n1, int n2, int n3, int n4, int n5, int n6, 
									int n7, int n8, int n9, int n10, int n11, int n12) {
		
		int calculo1 = n0 + n2 + n4 + n6 + n8 + n10 + n12;
		int calculo2 = (n1 + n3 + n5 + n7 + n9 + n11) * 3;
		int sumatorio = calculo1 + calculo2;
		
		return (sumatorio % 10 == 0) ? true : false;
		
	}
	
	
	public static boolean ean13v2 (long numero) {
		long suma = 0;
		for (int i = 0; i <= 13; i++) {
			long cifra = numero % 10;
			numero = numero / 10;
			boolean por3 = i % 2 != 0;
			long cifraMultiplicada;
			
			if (por3) {
				cifraMultiplicada = 3 * cifra;
			} else {
				cifraMultiplicada = cifra;
			}
			suma = suma + cifraMultiplicada;
		}
		return suma % 10 == 0;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----------------Primer Metodo---------------");
		System.out.println("Escribe un numero de 13 cifras uno por uno");
		
		int n0 = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		int n5 = sc.nextInt();
		int n6 = sc.nextInt();
		int n7 = sc.nextInt();
		int n8 = sc.nextInt();
		int n9 = sc.nextInt();
		int n10 = sc.nextInt();
		int n11 = sc.nextInt();
		int n12 = sc.nextInt();
		
		boolean comprobacion = ean13v1 (n0, n1, n2, n3, n4, n5, n6, 
				n7, n8, n9, n10, n11, n12);
		
		System.out.println(comprobacion);
		System.out.println("-----------------Segundo Metodo---------------");
		System.out.println("Escribe un numero de 13 cifras");
		
		int valorCompleto = sc.nextInt();
		boolean comprobacion2 = ean13v2(valorCompleto);
		System.out.println(comprobacion2);
		
		
		
	}
}