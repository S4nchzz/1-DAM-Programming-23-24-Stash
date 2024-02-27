package dam.clases.hotel;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Habitacion hab1 = new Habitacion(1, 11, true);
        Habitacion hab2 = new Habitacion(2, 12, true);
        Habitacion hab3 = new Habitacion(3, 13, false);

        hotel.añadirHabitacion(hab1);
        hotel.añadirHabitacion(hab2);
        hotel.añadirHabitacion(hab3);

        hotel.reservar(3);
        hotel.bucar1(2, true);
        hotel.anularReserva(3);

        hotel.buscarN(1, false, 1);
    }
}