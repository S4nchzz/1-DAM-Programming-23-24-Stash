package dam.examen;

public class MasProximoA7 {
    public static void main(String[] args) {
        System.out.println(masProximoA7(3, 6, 5));
    }

    public static int masProximoA7 (int a, int b, int c) {
        int calculoA = a;
        int calculoB = b;
        int calculoC = c;

        int vueltasA = 0;
        int vueltasB = 0;
        int vueltasC = 0;

        for (; calculoA != 7; vueltasA++) {
            calculoA = a % 10;
        }

        for (; calculoB != 7; vueltasB++) {
            calculoB = b % 10;
        }

        for (; calculoC != 7; vueltasC++) {
            calculoC = c % 10;
        }

        if (vueltasA < vueltasB && vueltasB < vueltasC || vueltasA < vueltasC && vueltasC < vueltasB) {
            return a;
        } else if (vueltasB < vueltasA && vueltasA < vueltasC || vueltasB < vueltasC && vueltasC < vueltasA) {
            return b;
        } else {
            return c;
        }
    }
}
