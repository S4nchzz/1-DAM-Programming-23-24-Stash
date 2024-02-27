package dam.arrays;

public class ContarAislados {
    public static void main(String[] args) {
        boolean [] arr = new boolean[]{false,true,false,false,true,true,true,false,true,true};
        System.out.println(contarAislados(arr));
    }

    public static int contarAislados (boolean [] a) {
        int count = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (i == 0) {
                if (a[i] != a[i + 1]) {
                    count++;
                }
            } else if (i == a.length - 1){
                if (a[i] != a[i - 1]) {
                    count++;
                }
            } else if (a[i] != a[i - 1] && a[i] != a[i + 1]) {
                count++;
            }

        }
        return count;
    }
}
