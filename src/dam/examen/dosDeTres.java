package dam.examen;

public class dosDeTres {
    public static void main(String[] args) {
        System.out.println(dosDeTres(7, 15, 5));
    }

    public static int dosDeTres (int a, int b, int c) {
        int calculoCondicionesA = 0;
        int calculoCondicionesB = 0;
        int calculoCondicionesC = 0;

        if (a % 10 == 0) {
            calculoCondicionesA++;
        }

        if (b % 10 == 0) {
            calculoCondicionesB++;
        }

        if (c % 10 == 0) {
            calculoCondicionesC++;
        }

        if (a > 7) {
            calculoCondicionesA++;
        }

        if (b > 7) {
            calculoCondicionesB++;
        }

        if (c > 7) {
            calculoCondicionesC++;
        }

        if (a < 20) {
            calculoCondicionesA++;
        }

        if (b < 20) {
            calculoCondicionesB++;
        }

        if (c < 20) {
            calculoCondicionesC++;
        }

        if (calculoCondicionesA >= 2) {
            return calculoCondicionesA;
        }

        if (calculoCondicionesB >= 2){
            return calculoCondicionesB;
        }

        if (calculoCondicionesC >= 2) {
            return calculoCondicionesC;
        }

        return 0;
    }
}
