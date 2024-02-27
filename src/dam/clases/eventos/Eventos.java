package dam.clases.eventos;

public class Eventos {
    private Evento [] arr;
    private int hora;
    private int minuto;
    private String eventoNombre;

    public Eventos () {
        arr = new Evento[0];
    }

    private int buscarEvento (int hora, int minuto) {
        int r = 0;

        while (r < arr.length) {
            if (arr[r].getHora() == hora && arr[r].getMinutos() == minuto) {
                return r;
            }

            r++;
        }

        return -1;
    }
    public void añadirEvento (int hora, int minuto, String evento) {
        int pos = buscarEvento(hora, minuto);

        if (pos >= 0) {
            arr[pos].setEventoNombre(evento);
            return;
        }

        Evento [] nuevoArr = new Evento[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            nuevoArr[i] = arr[i];
        }

        nuevoArr[arr.length] = new Evento(hora, minuto, evento);
        arr = nuevoArr;
    }

    public void borrarEvento (int hora, int minuto) {
        int pos = buscarEvento(hora, minuto);
    }

    public String getEvento (int hora, int minuto) {
        int pos = buscarEvento(hora, minuto);

        if (pos >= 0) {
            return arr[pos].getEventoNombre();
        }

        return "No se han encontrado eventos en esa hora";
    }

    public int cuantosEventos () {
        return arr.length;
    }

    public String todosOrdenados () {
        return "null";
    }
}
