package dam.examen;

public class consecutivos {
    public static void main(String[] args) {
        System.out.println(consecutivos(4, 6, -5));
    }

    public static boolean consecutivos (int a, int b, int c) {
        if (a == b || b == c || c == a) {
            return false;
        } else if (a + 1 == b && b + 1 == c || a + 1 == c && c + 1 == b
                || b + 1 == a && a + 1 == c || b + 1 == c && c + 1 == a
                || c + 1 == a && a + 1 == b || c + 1 == b || b + 1 == a) {
            return true;
        }
        return false;
    }
}
