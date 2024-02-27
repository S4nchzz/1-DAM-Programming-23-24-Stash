package dam.clases.eventos;

public class Evento {
    private int hora;
    private int minutos;
    private String eventoNombre;

    public Evento (int hora, int minuto, String evento) {
        this.hora = hora;
        this.minutos = minuto;
        this.eventoNombre = evento;
    }


    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getEventoNombre() {
        return eventoNombre;
    }

    public void setEventoNombre(String eventoNombre) {
        this.eventoNombre = eventoNombre;
    }


}
