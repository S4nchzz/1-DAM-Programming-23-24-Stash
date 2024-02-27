package dam.practicas.practicas2;
import java.util.Scanner;

public class Main {

	public static void main1 (String [] args) {
		System.out.println ("Hola1");
	}
	
	
	public static void main2 (String [] args) {
		
	System.out.println (15 + 30);
	System.out.println ("Hola " + "mundo!");
	
	}
		
	
	public static void main3 (String [] args) {
		int a;
		String b;
		
		a = 33;
		b = "Trenta";
		
		
		System.out.println (a + 3 - 3);
		System.out.println (b + " y tres");
		
		a = 12;
		
		System.out.println (a + 20);
		System.out.println (b + " y tres");
	
	}
	
	
	public static void main4 (String [] args) {
	
	int a = 32;
		System.out.println (a);
		
	a = a + 1;
		System.out.println (a);
		
	a = a + 1;
		System.out.println (a);
		
	float f;
	double d;
	char s;
	int m;
	
	f = 10219873F;
	d = 10231823D;
	s = 'A';
	m = s;
	
	System.out.println (f);
	System.out.println (d);
	System.out.println (s);
	System.out.println (m);
	}
			

	public static void main5 (String [] args) {
		
		int a = 5;
		int c = 1;
		
		switch (a - c) {
		case 1:
			System.out.println("Uno");
			break;
		case 2:
			System.out.println("Dos");
			break;
		case 3:
			System.out.println("Tres");
			break;
		case 4:
			System.out.println("Cuatro");
			break;
		case 5:
			System.out.println("Cinco");
			break;
		case 6:
			System.out.println("Seis");
			break;
		default:
			System.out.println("Rarete no?");
			break;
		
		}
		
		
		int b;
		
		if (a < 10) {
			b = 12;
		} else {
			if (a < 13) {
				b = 55;
			} else {
				b = 45;
			}
	}
	
		System.out.println (b);
		
	}

	
	public static void main6 (String [] args) {
		
		int a = 5;
		int b = 3;
		
		if (a < 4) {
			System.out.println("El numero es menor que 4");
		} else { if (a < 6) { 
			
			switch (a - b) {
			case 1:
				System.out.println("Uno");
				break;
			case 2:
				System.out.println("Dos");
				break;
			case 3:
				System.out.println("Tres");
				break;
			case 4:
				System.out.println("Cuatro");
				break;
			default:
				System.out.println("none");
			}
		} else {
			System.out.println("Error2");
			}
	}
	}

	
	public static void main7 (String [] args) {
		int a = 3;
		
		if (a == 1) {
			System.out.println("Uno");
		} else if (a == 2) {
			System.out.println(a);
		} else if (a == 3) {
			System.out.println(a);
		} else if (a == 4) {
			System.out.println(a);
		} else if (a == 5) {
			System.out.println(a);
		} else if (a == 6) {
			System.out.println(a);
		} else {
			System.out.println("Un poqiullo raro no?");
		}
		
	}
	
	
	public static void main8 (String [] args) {
		int edad = 15;
	
		if (edad < 0) {
			System.out.println("No nacido");
		} else if (edad < 10) {
			System.out.println("Es joven");
		} else if (edad < 20) {
			System.out.println("Es adolescente");
		} else if (edad < 60) {
			System.out.println("Es adulto");
		} else {
			System.out.println("Es anciano");
		}
	}


	public static void main9 (String [] args) {
		
		int a = 3000;
		
		if (a < 0) {
			System.out.println("No nacio");
		} else if (a < 100) {
			System.out.println("Es demasiado viejo");
		} else {
			System.out.println("WTF");
		}
	}


	public static void main10 (String [] args) {
		int a = 2;
		
		
		if (a == 5) {
			System.out.println("hola");
		} else if (a < 5) {
			System.out.println("MENU 1");
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("EXIT");
			System.out.println("--------");
			
			switch (a) {
			case 1:
				System.out.println("IP");
				break;
			case 2:
				System.out.println("HOSTANAME");
				break;
			case 3:
				System.out.println("IP A");
				break;
			case 4:
				System.out.println("HOSTNAME -I");
				break;
			}
		}
	}

	
	public static void main11 (String[] args) {
		int c = 0;
		int a1 = 22;
		int a2 = 12;
		int a3 = 2;
		
		if (c != 0 ) {
			System.out.println("El numero es igual a ");
		} else if (a1 > 10) {
				c = c + 1;
					if (a2 > 10)  {
						c = c + 1;
						if (a3 > 10) {
								c = c + 1;
							}
					}
				}
		System.out.println(c);
	}

	
	public static void main12 (String[] args) {
		int c = 0;
		int a1 = 33;
		int a2 = 2;
		int a3 = 33;
		
		if (a1 <= a2 && a1 <= a3){
			System.out.println (a1);
		} else if (a2 <= a3) {
			System.out.println(a2);
		} else {
			System.out.println(a3);
		}
		
		 System.out.println(c);
	}


	public static void main13 (String[] args) {
		int i = 1;
		
		while (i < 10) {
			System.out.println(i);
			i = i + 1;
		}
			
	}


	public static void main14(String[] args) {
		int a;

		for (a = 3; a < 334; a = a + 1) {
			System.out.println(a);
		}
	}


	public static void main15(String[] args) {
		int method = newMethod();
		
		System.out.println(method);
		
	}
	

	public static int newMethod() {
		int newInt = 33;
		return newInt;
	}


	public static void main16(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		
		if ((a <= c && a >= b) || (a >= c && a <= b)) {
			System.out.println (a);
		} else if ((c >= a && c <= b) || (c <= a && c >= b)) {
			System.out.println(c);
		} else {
			System.out.println(b);
		}
	}


	public static void main100(String[] args) {
		int a;
		int a1 = 4;
		int a2 = 0;
		
		for (a = 4; a <= 40; a = a + 4) {
			a2 = a2 + 1;
			
			System.out.println(a1 + " x " + a2 + " = " + a);
		}
	}



	public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);		
			
			boolean bo = true;
				
			while (bo) {
				int a = sc.nextInt ();
					if (a == 0) {
						bo = false;
					} else if (a % 2 == 0) {
						System.out.println("PAR");
					} else {
						System.out.println("IMPAR");
				}
			}
		}
	}