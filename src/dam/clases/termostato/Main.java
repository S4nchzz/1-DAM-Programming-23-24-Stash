package dam.clases.termostato;

public class Main {
    public static void main(String[] args) {
        Termostato termo = new Termostato(15);
        System.out.println(termo.getEstadoCaldera());
        termo.setTemperaturaReal(2);
        System.out.println(termo.getEstadoCaldera());
        termo.setTemperaturaReal(20);
        System.out.println(termo.getEstadoCaldera());
    }
}
