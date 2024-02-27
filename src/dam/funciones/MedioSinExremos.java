package dam.funciones;

public class MedioSinExremos {
	public static double mediaSinExtremos (double a, double b, double c, double d) {
		double sumatorioNotas = a+b+c+d;
		double sumaMenoryMayor;
		double media;
		double valorMayor;
		double valorMenor;

		
		//Comprobacion de cual es mayor de todos
		if (a >= b && a >= c && a >= d) {
			valorMayor = a;
		} else if (b >= a && b >= c && b >= d) {
			valorMayor = b;
		} else if (c >= a && c >= b && c >= d) {
			valorMayor = c;
		} else {
			valorMayor = d;
		}
		
		//Comprobacion de cual es menor de todos
		if (a <= b && a <= c && a <= d) {
			valorMenor = a;
		} else if (b <= a && b <= c && b <= d) {
			valorMenor = b;
		} else if (c <= a && c <= b && c <= d) {
			valorMenor = c;
		} else {
			valorMenor = d;
		}

		sumaMenoryMayor = valorMenor + valorMayor;
		sumatorioNotas -= sumaMenoryMayor;
		
		media = sumatorioNotas / 2;
		
		return media;
	}
	
	
	
	public static void main (String[] args) {
		System.out.println(mediaSinExtremos(1, 2, 3, 4.4444));
		System.out.println(mediaSinExtremos(1, 2, 1, 1));
		System.out.println(mediaSinExtremos(1, 1, 1, 1));
		System.out.println(mediaSinExtremos(1, 5, 3, 6));
	}
}
