package dam.examen;

public class todosDistintos {
    public static void main(String[] args) {
        System.out.println(todosDistintos(7, 7, 7));
    }

    public static boolean todosDistintos (int a, int b, int c) {
        if (a == b || a == c || b == a || b == c || c == a || c == b) {
            return false;
        } else {
            return true;
        }
    }
}
