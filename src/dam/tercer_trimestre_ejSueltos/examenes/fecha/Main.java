package dam.tercer_trimestre_ejSueltos.examenes.fecha;

public class Main {
    public static void main(String[] args) {
        Fecha fecha = new Fecha(31, 8, 2015);
        fecha.retrocederMes();
        fecha.retrocederDia();
        fecha.retrocederMes();
        fecha.retrocederMes();
        fecha.retrocederMes();
        fecha.retrocederMes();
        System.out.println(fecha.getDia());
        System.out.println(fecha.getMes());
        System.out.println(fecha.getAno());

    }   
}
