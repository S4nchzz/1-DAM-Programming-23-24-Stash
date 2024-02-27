package dam.practicas.practicas1;
import java.util.Scanner;


public class Main {
	public static void main1 (String []args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = x;
		
		while (x >= y) {
			if (x % 2 == 0) {
				System.out.println("PAR");
			} else {
				System.out.println("IMPAR");
			}
		
			y = x;
			x = sc.nextInt();
			 
		}
	}

	public static void main2 (String []args) {
		Scanner sc = new Scanner(System.in);
		int valorUser = sc.nextInt(); 
		int calculoVueltas = 0;
		
		while (valorUser != 1) {
			if (valorUser % 2 == 0) {
				valorUser = valorUser/2;
			} else if (valorUser % 2 > 0) {
				valorUser = (valorUser * 3) + 1;
			}
			
			System.out.println(valorUser);
			calculoVueltas++;
		}
		
		System.out.println("Ha dado " + calculoVueltas + " vueltas");
	
	}

	public static void main3 (String []args) {
		Scanner sc = new Scanner(System.in);
		
		float num1 = sc.nextFloat();
		float num2 = sc.nextFloat();
		float num3 = sc.nextFloat();
		float media;	
		
		if ((num1 > num2 && num1 < num3) || (num1 < num2 && num1 > num3)) {
			media = num1;
		} else if ((num2 < num3 && num2 > num1) || (num2 > num3 && num2 < num1)) {
			media = num2;
		} else {
			media = num3;
		}
	
		System.out.println("El numero medio es " + media);
	}

	public static void main23 (String[] args) { //Calculo de media 0 para parar
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe numeros y cuando quieras parar pon 0");

		boolean loop = true; // Activar o desactivar el while
		int count = 0; // Saber cuantas veces se ingresa un valor
		int sumatorio = 0; // Suma total de los numeros introducidos
		double media = 0;
		int numeroUsuario;

		while (loop) {
			System.out.println("INGRESE VALOR: ");
			numeroUsuario = sc.nextInt();

			if (numeroUsuario != 0) {
				System.out.print(numeroUsuario + " + " + sumatorio + " = ");
				sumatorio = sumatorio + numeroUsuario; // Variable  que se actualiza por cada vuelta y se suma segun los numeros que se escriban
				System.out.println(sumatorio);
				count++; // Recuento de vueltas que da el programa si el valor introducido (3 valores, 3 vueltas, si es 0 no se cuenta la vuelta)
			} else {
				media = (double) sumatorio / count; //Convertir el resultado en double segun la variable media
				System.out.println("El numero medio es " + media);
				loop = false; // Salida del bucle
			}
		}
	}

	public static void sumatorioPareseImpares (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		int valoresUsuario;
		int sumatorioPares = 0;
		int sumatorioImpares = 0;
		
		while (loop) {
			
			System.out.print("Escribe Valor");
			valoresUsuario = sc.nextInt();
			
			if (valoresUsuario != 0) {
				if (valoresUsuario % 2 == 0) { // ASK IF IT PAR
					sumatorioPares += valoresUsuario;
				} else {
					sumatorioImpares += valoresUsuario;
				}
			} else {
				System.out.println("Ha salido del programa");
				loop = false;
			}
		}
		System.out.println("La suma de los numeros PARES es : " + sumatorioPares + " y la suma de los impares: " + sumatorioImpares);
	}

	public static void main321321 (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		System.out.print("Valores: ");
		int numeroUsuario = sc.nextInt();
		int numMayor = numeroUsuario;
		int numMenor = numeroUsuario;
		int checkOrden = numeroUsuario;
		boolean ordenado = false;
		boolean desordenado = false;
		
		while(loop) {
			System.out.print("Valores: ");
			numeroUsuario = sc.nextInt();
			
			if (numeroUsuario != 0) {
				if (numeroUsuario > numMayor) {
					numMayor = numeroUsuario;
				} else if (numeroUsuario < numMenor) {
					numMenor = numeroUsuario;
				}
				
				/*
				if (numMayor > numMenor) {
					ordenado = true;
				} else if (numMenor > numMayor) {
					desordenado = true;
				}
				
				*/
				
			} else {
				/* if (desordenado) {
					System.out.println("Ordenado");
				} else if (ordenado) {
					System.out.println("Desordenado");
				} */
				
				System.out.println("Programa finalizado");
				loop = false;
				System.out.println("Mayor " + numMayor);
				System.out.println("Menor " + numMenor);
			}
		}

	}

	public static void main22 (String[] args) {
	    Scanner sc = new Scanner(System.in);

	    boolean loop = true;
	    boolean mayorToMenor = false;
	    boolean menorToMayor = false;
	    System.out.print("Valores: ");
	    int numeroUsuario = sc.nextInt();
	    int numMayor = numeroUsuario;
	    int numMenor = numeroUsuario;
	    if (numeroUsuario < 0) {
	        loop = false;
	        System.out.println("Finalizando el programa, valor introducido menor que 0");
	    } else {
	        while (loop) {
	            if (numMayor < numeroUsuario) {
	                menorToMayor = true;
	            } else if (numMayor <= numeroUsuario) {
	                mayorToMenor = true;
	            }

	            System.out.print("Valores: ");
	            numeroUsuario = sc.nextInt();
	            // Actualizacion de variables |numMayor| y |numMenor| dependiendo del numero del usuario.
	            if (numeroUsuario != 0) {
	                if (numeroUsuario > numMayor) {
	                    numMayor = numeroUsuario;
	                } else if (numeroUsuario < numMenor) {
	                    numMenor = numeroUsuario;
	                }
	            } else { // Se ejecutara si el numero elegido es 0.
	                // Comprobacion si se empieza por menor o mayor dependiendo de las booleans definidas.
	                if (menorToMayor) {
	                    System.out.println("Menor --> Mayor");
	                } else if (mayorToMenor) {
	                    System.out.println("Mayor --> Menor");
	                }
	                System.out.println("Programa finalizado");
	                loop = false;
	                System.out.println("Mayor " + numMayor);
	                System.out.println("Menor " + numMenor);
	            }
	        }
	        sc.close();
	    }
	}

	public static void main33 (String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean mayorAMenor = true;
		
		boolean menorAMayor = true;
		int x = sc.nextInt();
		int xAnterior = x;
		
		while (x != 0) {
			if (x < xAnterior) {
				menorAMayor = false;
			} else if (x > xAnterior) {
				mayorAMenor = false;
			}
			
			xAnterior = x;
			x = sc.nextInt();
		}
		System.out.println(menorAMayor);
		System.out.println(mayorAMenor);
	}

	public static void main2323 (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hora = sc.nextInt();
		int minuto= sc.nextInt();
		int segundo = sc.nextInt();
		int delta = sc.nextInt();
		
		for (int k = 0; k < delta; k++) {
		
		segundo++;
		
		if (segundo >= 60) {
			segundo -= 60;
			minuto++;

				if (minuto >= 60) {
					minuto -= 60;
					
					if (hora >= 24) {
						hora = 0;
					}
				}
			}
		}
		System.out.println(hora + ":" + minuto + ":" + segundo);
	}

	public static void main12321332 (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int horas = sc.nextInt();
		int minuto= sc.nextInt();
		int segundo = sc.nextInt();
		int delta = sc.nextInt();
		
		segundo = segundo + delta;
		
		minuto += segundo /60;
		segundo %= 60;
		horas += minuto / 60;
		minuto %= 60;
		horas %= 24;
		
		
		
		System.out.println(horas + ":" + minuto + ":" + segundo);
	}

	public static void main22222 (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int w = 1; w <= 3; w++) {
			for (int k = 1; k <= 4; k++) {
				System.out.println(w + " " + k);
			}
		}
	}

	public static void main (String[] args) {

		int sumatorio = 0;
		int sumatorioJirafas = 0;
		int sumatorioHipos = 0;
		int dinero = 1;
		
		
		
		for (int jirafas = 0; jirafas <= 200; jirafas++) {			
			for (int hipos = 0; hipos <= 800; hipos++) {
				
				int euros = 17 * jirafas + 23 * hipos;
				if (euros == 1000) {
					System.out.println(jirafas + " Jirafas" + " + " + hipos + " hipos" + " euros " + euros);		
				}
			}
		}
	}
}
