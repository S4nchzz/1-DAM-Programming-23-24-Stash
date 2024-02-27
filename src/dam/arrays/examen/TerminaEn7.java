package dam.arrays.examen;

public class TerminaEn7 {
    public static void main(String[] args) {
        int [] arr = new int []{};
        System.out.println(terminanEn7(arr));
    }

    public static int terminanEn7 (int [] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 10 == 7) {
                count++;
            }
        }
        return count;
    }
}
