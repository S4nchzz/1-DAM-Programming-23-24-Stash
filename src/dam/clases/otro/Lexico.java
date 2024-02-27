package dam.clases.otro;

public class Lexico {
    private int token;
    private SecuenciaCaracteres sc;

    public Lexico (SecuenciaCaracteres sc) {
        this.sc = sc;
        this.avanzar();
    }

    public int mirar () {
        return token;
    }

    public void avanzar () {
        while (sc.mirar() == ' ') {
            sc.avanzar();
        }
            if (sc.mirar() < '0' || sc.mirar() > '9') {
                this.token = traducir();
                sc.avanzar();
            } else {
                int acumulador = 0;
                while (sc.mirar() >= '0' && sc.mirar() <= '9') {
                    acumulador = acumulador * 10 + sc.mirar() - '0';
                    sc.avanzar();
                    this.token = acumulador;
                }
            }
        }

    private int traducir () {
        if (sc.mirar() == '+') {
            return -3;
        } else if (sc.mirar() == '-') {
            return -4;
        } else if (sc.mirar() == '*') {
            return -5;
        } else if (sc.mirar() == '/') {
            return -6;
        } else if (sc.mirar() == '(') {
            return -7;
        } else if (sc.mirar() == ')') {
            return -8;
        } else if (sc.mirar() == -1) {
            return -1;
        } else {
            return -2;
        }
    }
}
