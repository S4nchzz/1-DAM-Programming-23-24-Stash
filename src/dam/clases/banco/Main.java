package dam.clases.banco;

public class Main {
    public static void main(String[] args) {
        Bank santanderBank = new Bank("Juan", "1000");

        santanderBank.setNuevoUsuario("Pelayo Garcia", "4300");
        santanderBank.setNuevoUsuario("Daniel Martinez", "2300");
        santanderBank.setNuevoUsuario("Iyan Sanchez", "5700");

        System.out.println(santanderBank.getSaldo("Iyan Sanchez", 3));
        santanderBank.setRetirarDinero("Iyan Sanchez", 3, 1300);
        System.out.println(santanderBank.getSaldo("Iyan Sanchez", 3));
    }
}