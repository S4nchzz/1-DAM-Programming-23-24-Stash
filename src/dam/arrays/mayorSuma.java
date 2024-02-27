package dam.arrays;

public class mayorSuma {
    public static void main(String[] args) {
        int [] arr = new int [] {1,2,3,4,5,6,7,8,9,9,1,7,6,5,4,3,2,1};

        System.out.println(mayorSuma2(arr));
        int obj = 2;
        System.out.println(mayorSumaN(arr, obj));
    }

    public static int mayorSuma2(int[] a) {
        int suma;
        int sumaMayor = a[0] + a[1];
        for (int i = 0; i < a.length - 1; i++) {
            suma = a[i] + a[i + 1];

            if (suma > sumaMayor) {
                sumaMayor = suma;
            }
        }

        return sumaMayor;
    }

    public static int mayorSumaN(int[] a, int n) {
        int sum;
        int sumMayor = a[0];

        for (int x = 1; x < n; x++) {
            sumMayor += a[x];
        }

        for (int i = 1; i < a.length; i++) {
            sum = 0;
            for (int k = i; k <= n; k++) {
                sum += a[k];
            }

            if (sum > sumMayor) {
                sumMayor = sum;
            }
        }

        return sumMayor;
    }
}
