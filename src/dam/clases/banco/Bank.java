package dam.clases.banco;

public class Bank {
    private int arrPointer;
    private String[] clientes;
    private String[] salario;
    private int[] nCuenta;

    public Bank() {
        this.arrPointer = 0;
        this.clientes = new String[10];
        this.salario = new String[10];
        this.nCuenta = new int[10];
    }

    public Bank(String cliente, String salario) {
        this();
        this.clientes[arrPointer] = cliente;
        this.salario[arrPointer] = salario;
        this.nCuenta[arrPointer] = 0;
        this.arrPointer = 1;
    }

    public int getSaldo(String cliente, int nCuenta) {
        for (int i = 0; i < this.clientes.length; i++) {
            if (cliente.equals(this.clientes[i]) && this.nCuenta[i] == nCuenta) {
                Integer salarioInt = Integer.parseInt(salario[i]);
                return salarioInt;
            }
        }
        return -1;
    }

    public void setRetirarDinero(String cliente, int nCuenta, int importeRetirada) {
        for (int i = 0; i < this.clientes.length; i++) {
            if (cliente.equals(this.clientes[i]) && this.nCuenta[i] == nCuenta) {
                Integer salarioInt = Integer.parseInt(this.salario[i]);
                int calculoRestaDinero = salarioInt - importeRetirada > 0 ? salarioInt - importeRetirada : importeRetirada - salarioInt;
                String conversionRestaDinero = String.valueOf(calculoRestaDinero);
                salario[i] = conversionRestaDinero;
                break;
            }
        }
    }

    public int getId(String cliente) {
        for (int i = 0; i < this.clientes.length; i++) {
            if (cliente.equals(this.clientes[i])) {
                return nCuenta[i];
            }
        }
        return -1;
    }

    public void setNuevoUsuario(String cliente, String salario) {
        this.clientes[arrPointer] = cliente;
        this.salario[arrPointer] = salario;
        this.nCuenta[arrPointer] = arrPointer;
        this.arrPointer++;
    }
}
