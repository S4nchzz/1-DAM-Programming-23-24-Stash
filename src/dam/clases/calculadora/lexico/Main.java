package dam.clases.calculadora.lexico;

import dam.clases.calculadora.sintactico.Sintactico;

public class Main {
    public static void main(String[] args) {
        String texto = "33 + 8 / 3";

        SDC sdc = new SDC(texto);
        Lexico lex = new Lexico(sdc);

        Sintactico syn = new Sintactico(lex);

        System.out.println(syn.getResultado());
    }
}
