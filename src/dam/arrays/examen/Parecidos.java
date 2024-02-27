package dam.arrays.examen;

public class Parecidos {
    public static void main(String[] args) {
        int [] a = new int []{2,2,3};
        int [] b = new int []{2,1,0,2,3,0};

        System.out.println(parecidos(a, b));
    }

    public static boolean parecidos (int [] a, int [] b) {
        int aumentoPosicionA = 0;
        int aumentoPosicionB = 0;

        for (int i = 0; i < 100; i++) {
            while (aumentoPosicionA < a.length && a[aumentoPosicionA] == 0) {
                aumentoPosicionA++;
            }

            while (aumentoPosicionB < b.length && b[aumentoPosicionB] == 0) {
                aumentoPosicionB++;
            }

            if (a[aumentoPosicionA] != 0 && b[aumentoPosicionB] != 0) {
                if (a[aumentoPosicionA] != b[aumentoPosicionB]) {
                    return false;
                } else {
                    aumentoPosicionA++;
                    aumentoPosicionB++;
                }
            }
        }
        return true;
    }
}
