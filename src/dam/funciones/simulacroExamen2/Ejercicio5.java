package dam.funciones.simulacroExamen2;

public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println(abecedariosEntrelazados());
    }

    public static String abecedariosEntrelazados () {
        String cadena = "";

        for (int i = 0; i < 26; i++) {
            cadena += (char)('A' + i);
            cadena += (char)('a' + i);
            cadena += (i + 1);
        }
        return cadena;
    }
}
