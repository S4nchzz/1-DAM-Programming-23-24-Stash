package dam.clases.cola;

public class Cola {
    private int [] cola;
    private int posEntrada; 
    private int posSalida; 

    public Cola() {
        this.cola = new int [10];
        this.posEntrada = 0;
        this.posSalida = 0;
    }

    public void push(int valor) {
        if (this.posSalida != this.posEntrada || (this.posEntrada == 0 && this.posSalida == 0)) {
            this.cola[posEntrada] = valor;

            if (posEntrada >= cola.length) {
                posEntrada = 0;
            } else {
                posEntrada++;
            }
        }
    }

    public int pop() {
        int saveValue = -1;
        if (this.posSalida != this.posEntrada) {
            saveValue = this.cola[posSalida]; 
            this.cola[posSalida] = 0;

            if (posSalida >= cola.length) {
                posSalida = 0;
            } else {
                posSalida++;
            }
        }
        return saveValue == -1 ? -1 : saveValue;
    }

    public int cuantos() {
        int countValues = 0;
        for (int i = 0; i < cola.length; i++) {
            if (cola[i] != 0) {
                countValues++;
            }
        }
        return countValues == 0 ? 0 : countValues;
    }

    public void vaciar() {
        for (int i = 0; i < cola.length; i++) {
            this.cola[i] = 0;
            this.posEntrada = 0;
            this.posSalida = 0;
        }
    }
}
