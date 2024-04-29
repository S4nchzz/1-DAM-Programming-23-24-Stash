package dam.tercer_trimestre_ejSueltos.examenes.fecha;

public class Fecha {
    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        set(dia, mes, ano);
    }

    private void setFechaWithConditions(int dia, int mes, int ano) {
        if ((dia > 0 && dia < 32) && (mes >= 1 && mes <= 12) && (ano >= 1901 && ano <= 2099) && dia <= maxDia(mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1901;
        }
    }

    private int maxDia(int mes, int ano) {
        switch (mes) {
            case 1:
                return 31;

            case 2:
                if (ano % 4 == 0) {
                    return 29;
                }

                return 28;
            
            case 3:
                return 31;

            case 4:
                return 30;

            case 5:
                return 31;

            case 6:
                return 30;

            case 7:
                return 31;

            case 8:
                return 31;
            
            case 9:
                return 30;

            case 10:
                return 31;

            case 11:
                return 30;

            case 12:
                return 31;
            
            default:
                return -33;
        }
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void set(int dia, int mes, int ano) {
        setFechaWithConditions(dia, mes, ano);
    }

    public void avanzarDia() {
        if (this.dia < 32 || mes < 12 || ano < 2100) {
            // dia superior al maximo
            if ((this.dia + 1) > (maxDia(this.mes, this.ano))) {
                this.dia = 1;
                avanzarMes();

            } else {
                this.dia++;
            }
        }
    }

    public void retrocederDia() {
        if (this.dia - 1 == 0) {
            retrocederMes();
            this.dia = maxDia(mes, ano);
        } else {
            dia--;
        }
    }

    public void avanzarMes() {
        if (mes <= 12 && ano < 2099) {
            if (this.mes + 1 == 13) { // mes enero
                this.mes = 1;
                avanzarAno();
            } else {
                this.mes++;
                if (this.dia > maxDia(mes, ano)) {
                    this.dia = 1;
                    mes++;
                }
            }
        }
    }

    private void avanzarAno () {
        if (this.ano + 1 >= 2100) {
            this.dia = 31;
            this.mes = 12;
            this.ano = 2099;
        } else {
            this.ano++;
        }
    }

    private void retrocederAno() {
        if (this.ano - 1 <= 1900) {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1900;
        } else {
            this.ano--;
        }
    }

    public void retrocederMes() {
        if (this.mes - 1 == 0) { // mes diciembre
            this.mes = 12;
            retrocederAno();
        } else {
            this.mes--;
            if (this.dia > maxDia(mes, ano)) {
                this.dia = 1;
                mes--;
            }
        }
    }

    public int comparar(Fecha fecha) {
        if ((fecha.getAno() < this.ano) || (fecha.getAno() == this.ano && fecha.getMes() < this.mes) || (fecha.getAno() < this.ano && fecha.getMes() < this.mes && fecha.getDia() < this.dia)) {
            return -1;
        }

        return 0;
    }

    public static void ordenar (Fecha [] fechas) {
        Fecha tempFecha = null;
        for (int i = 0; i < fechas.length - 1; i++) {
            if (fechas[i].getAno() > fechas[i + 1].getAno()) {
                tempFecha = fechas[i + 1];
                fechas[i + 1] = fechas[i];
                fechas[i] = tempFecha;
            } else if (fechas[i].getMes() > fechas[i + 1].getMes()){
                tempFecha = fechas[i + 1];
                fechas[i + 1] = fechas[i];
                fechas[i] = tempFecha;
            } else if (fechas[i].getDia() > fechas[i].getDia()) {
                tempFecha = fechas[i + 1];
                fechas[i + 1] = fechas[i];
                fechas[i] = tempFecha;
            }
        }
    }
}
