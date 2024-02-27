package dam.clases.termostato;

public class Termostato {
    private int modo;
    private boolean estado;
    private double temperaturaReal;
    private double temperaturaDeseada;

        public Termostato(int temperatura) {
            this.temperaturaReal = temperatura;
            this.modo = 2;

            if (temperatura >= 5 && temperatura <= 26) {
                this.temperaturaDeseada = temperaturaReal;
            } else if (temperatura < 5) {
                this.temperaturaDeseada = 5;
            } else {
                this.temperaturaDeseada = 26;
            }

            if (temperaturaReal < temperaturaDeseada && temperatura < 5) {
                this.estado = true;
            } else {
                this.estado = false;
            }
        }

        public boolean getEstadoCaldera() {
            return estado;
        }

        private void actualizacionEstado () {
            if (this.modo == 0) {
                this.estado = false;
            } else if (this.modo == 1) {
                this.estado = true;
            } else if (this.temperaturaDeseada > this.temperaturaReal) {
                this.estado = true;
            } else if (this.temperaturaDeseada < this.temperaturaReal) {
                this.estado = false;
            }
        }

        public void setModo (int modo) {
            this.modo = modo;
            actualizacionEstado();
        }

        public void setTemperaturaReal(int temperatura) {
            this.temperaturaReal = temperatura;
            actualizacionEstado();
        }

        public void setTemperaturaDeseada(int temperatura) {
            if (temperatura > 26) {
                this.temperaturaDeseada = 26;
            } else if (temperatura < 5) {
                this.temperaturaDeseada = 5;
            } else {
                temperatura = (int)this.temperaturaDeseada;
            }
            actualizacionEstado();
        }
}