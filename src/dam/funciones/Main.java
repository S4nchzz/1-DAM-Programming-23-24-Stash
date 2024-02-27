package dam.funciones;

import java.util.Scanner;


public class Main {
	
	public static int menor2 (int uno, int dos) {
		if (uno < dos) {
			return uno;
		} else {
			return dos;
		}
	}
	
	public static int menor3 (int x, int y, int z) {
		if (x <= y && x <= z) {
			return x;
		} else if (y <= x && y <= z) {
			return y;
		} else {
			return z;
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int y = menor3(a, b, c );
		System.out.println(y);
	}
}
