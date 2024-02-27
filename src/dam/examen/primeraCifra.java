package dam.examen;

public class primeraCifra {
    public static void main(String[] args) {
        System.out.println(primeraCifra(1221));
    }

    public static int primeraCifra (int n) {
        int calculoPenultimo = n;
        int calculoNumeros = n;
        int numeroCifras = 0;

        while (calculoNumeros != 0) {
            numeroCifras++;
            calculoNumeros /= 10;
        }


        for (int i = 1; i < numeroCifras; i++) {
            calculoPenultimo = calculoPenultimo / 10;
        }
        return calculoPenultimo;
    }
}
