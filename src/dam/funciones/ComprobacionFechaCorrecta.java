package dam.funciones;

import java.util.Scanner;

public class ComprobacionFechaCorrecta {

	public static boolean esBisiesto(int ano) {
		return ano % 4 == 0;
	}

	public static int diasDelMes(int mes, int ano) {
		if (mes < 1 || mes > 12) {
			return 0;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return 30;
		} else if (mes != 2) {
			return 31;
		} else {
			return esBisiesto(ano) ? 29 : 28;
		}
	}

	public static boolean esFechaCorrecta(int dia, int mes, int ano) {
		boolean fechaCorrecta = dia >= 1 && dia <= diasDelMes(mes, ano);
		return fechaCorrecta;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dia = sc.nextInt();
		int mes = sc.nextInt();
		int ano = sc.nextInt();
		
		if (esFechaCorrecta(dia, mes, ano)) {
			System.out.println("La fecha introducida es correcta");
			if (esBisiesto(ano)) {
				System.out.println(ano + " es bisiesto");
			} else {
				System.out.println(ano + " no es bisiesto");
			}
		} else {
			System.out.print("La fecha introducida es incorrecta");
		}
	}
}