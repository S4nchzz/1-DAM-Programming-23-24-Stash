package dam.clases.arrayDeInt;

public class ArrayDeInt {
    private int [] arr = new int [10];

    public int getArrIndice (int indice) {
        return arr[indice];
    }

    public void setValue (int indice, int valor) {
        this.arr[indice] = valor;
    }

    public int getLength () {
        return arr.length;
    }
    public void setLength (int longitud) {
        int [] resizedArr = new int [longitud];
        int smallerLength = Math.min (arr.length, resizedArr.length);
        for (int i = 0; i < smallerLength; i++) {
            resizedArr[i] = arr[i];
        }
        arr = resizedArr;
    }
}
