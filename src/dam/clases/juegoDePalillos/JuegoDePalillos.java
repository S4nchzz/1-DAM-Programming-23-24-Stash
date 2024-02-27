package dam.clases.juegoDePalillos;

public class JuegoDePalillos {
    private int palillos;
    private boolean contador;

    public JuegoDePalillos () {
        this.palillos = 13;
        this.contador = true;
    }

    public void coger (int n) {
        if (n > 0 && n <= 3 && n <= palillos) {
            this.palillos -= n;
            contador = !contador;
        }
    }

    public int cuantosQuedan () {
        return palillos;
    }

    public boolean turno() {
        return this.contador;
    }
}
