package dam.examen;

public class terminaen7 {
    public static void main(String[] args) {
        System.out.println(terminaEn7(30, 88));
    }

    public static int terminaEn7 (int a, int b) {
        int count = a;
        int countDevoluciones = 0;

        for (; count <= b; count++) {
            if (count % 10 == 7) {
                countDevoluciones++;
            }
        }
        return countDevoluciones;
    }
}
