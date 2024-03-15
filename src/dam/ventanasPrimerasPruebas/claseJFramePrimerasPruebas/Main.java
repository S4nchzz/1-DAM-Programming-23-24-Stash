package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Main {
    private static JFrame ventana;
    public static void main(String[] args) throws InterruptedException {
        ventana = new JFrame("TITLE");

        ventana.setLayout(null); // Posicionamiento de los objetos de la ventana

        ventana.setSize(500, 500); // Tamaño de la ventana

        ventana.setVisible(true); // Hacerla visible
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se le pasa a este metodo la variable EXITONCLOSE situada en JFrame con valor 3

        JButton b = new JButton("Boton");
        b.addActionListener(new ButtonActionListener()); // Se añade al boton el objeto con el action performed
        b.setBounds(100, 100, 100, 100); // X, Y, W, H 

        ventana.add(b); // Se añade el boton a la ventana
        ventana.addComponentListener(new JFrameComponentAdapter(ventana));
        ventana.addKeyListener(new ButtonKeyListener());

    }

    public static JFrame getWindow () {
        return ventana;
    }
}
