package dam.clases.arrayDeInt;

public class Main {
    public static void main(String[] args) {
        ArrayDeInt arrInt = new ArrayDeInt();

        arrInt.setLength(3);
        arrInt.setValue(2, 33);
        System.out.println(arrInt.getArrIndice(2));
        System.out.println(arrInt.getLength());
    }
}
