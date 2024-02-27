package dam.arrays;

public class Consecutivos {
    public static void main(String[] args) {
        int [] arr = new int [] {3,4,3};

        System.out.println(consecutivos(arr));
    }

    public static boolean consecutivos (int [] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] <= a[i + 1]) {
                if (a[i] + 1 != a[i + 1]) {
                    return false;
                }
            } else if (a[i] >= a[i + 1]) {
                if (a[i] - 1 != a[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
