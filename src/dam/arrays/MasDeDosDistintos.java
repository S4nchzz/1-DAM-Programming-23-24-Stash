package dam.arrays;

public class MasDeDosDistintos {
    public static void main(String[] args) {
        int [] arr = new int []{2,2,2,2,2,3,3,3,3,3,3,13};

        System.out.println(masDeDosDistintos(arr));
    }

    public static boolean masDeDosDistintos(int[] a) {
        if (a.length == 0) {
            return false;
        } else {
            int k = 1;
            while (a[k] == a[0] && k < a.length) {
                k++;
            }

            if (k >= a.length) {
                return false;
            }
                int firstValue = a[0];
                int secondValue = a[k];
                k++;

            for (int i = k; i < a.length; i++) {
                if (a[i] != firstValue && a[i] != secondValue) {
                    return true;
                }
            }
        }
        return false;
    }
}
