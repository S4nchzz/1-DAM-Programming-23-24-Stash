package dam.clases.sintacticoCasa;

public class Main {
    public static void main(String[] args) {
        Sintactico cl = new Sintactico("1+1");

        System.out.println(cl.getString());
        System.out.println(cl.getLexico());
    }
}