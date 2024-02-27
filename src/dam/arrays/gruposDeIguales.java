package dam.arrays;

public class gruposDeIguales {
    public static void main(String[] args) {
        int [] arr = new int [] {7,7,2,2,2,2,2,1,2,2,1,2};

        System.out.println(gruposDeIguales(arr));

    }

    public static int gruposDeIguales(int [] a) {
        int contadorGrupos = 0;

        if (a.length < 2 || a.length == 0) {
            return 33;
        } else if (a[0] == a[1]) {
                contadorGrupos++;
            }
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i - 1] != a[i] && a[i] == a[i + 1]) {
                    contadorGrupos++;
                }
            }
        return contadorGrupos;
    }
}
