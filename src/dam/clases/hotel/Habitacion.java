package dam.clases.hotel;

public class Habitacion {
    private final int numero;
    private final double metros;
    private final boolean baño;
    private boolean reservada;

    public Habitacion(int numero, int metros, boolean baño) {
        this.numero = numero;
        this.metros = metros;
        this.baño = baño;
    }

    public int getNumero() {
        return numero;
    }

    public double getMetros() {
         return metros;
    }

    public boolean getBaño() {
        return baño;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    public boolean getReservada() {
        return this.reservada;
    }
}