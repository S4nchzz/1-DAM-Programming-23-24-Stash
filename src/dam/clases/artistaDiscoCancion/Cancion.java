package dam.clases.artistaDiscoCancion;

public class Cancion {
    private String titulo;
    private int duracion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion (int duracion) {
        this.duracion = duracion;
    }

    public String duracionMS() {
        int minutos = this.duracion / 60;
        int segundos = this.duracion % 60;

        StringBuilder sb = new StringBuilder();

        if (minutos < 10) {
            sb.append("0");
        }

        sb.append(minutos);
        sb.append(":");

        if (segundos < 10) {
            sb.append("0");
        }

        sb.append(segundos);

        return sb.toString();
    }
}