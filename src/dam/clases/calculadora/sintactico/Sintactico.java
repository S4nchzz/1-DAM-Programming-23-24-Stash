package dam.clases.calculadora.sintactico;

import dam.clases.calculadora.lexico.Lexico;

public class Sintactico {
    private Lexico lex;
    private double resultado;

    public Sintactico(Lexico lex) {
        this.lex = lex;
        this.resultado = sumando();
    }

    public double getResultado() {
        return resultado;
    }

    private double factor() {
        int factor = lex.mirar();
        double r;

        if (factor >= 0) {
            r = (double) factor;
        } else if (factor != -7) {
            throw new Error();
        } else {
            lex.avanzar();
            r = expresion();

            if (lex.mirar() != -8) {
                throw new Error();
            }
        }

        lex.avanzar();
        return factor;
    }

    private double sumando() {
        double nFactor = factor();

        while (lex.mirar() == -5 || lex.mirar() == -6) {
            if (lex.mirar() == -6) {
                lex.avanzar();
                nFactor /= factor();
            } else {
                lex.avanzar();
                nFactor *= factor();
            }
        }
        return nFactor;
    }

    private double expresion() {
        double r = sumando();

        int signo = lex.mirar();

        while (signo == -3 || signo == -4) {
            lex.avanzar();
            double otro = sumando();

            if (signo == -3) {
                r += otro;
            } else {
                r -= otro;
            }
        }
        return r;
    }
}