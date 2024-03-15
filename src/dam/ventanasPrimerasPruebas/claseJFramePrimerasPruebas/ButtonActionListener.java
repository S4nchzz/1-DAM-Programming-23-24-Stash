package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class ButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed (ActionEvent e) {
        JOptionPane.showMessageDialog(null, "PoUp en la pantalla");
        JFrame ventana = Main.getWindow(); // Objeto de tipo JFrame con la ventana principal

        JButton b = new JButton("Boton");
        b.setBounds(200, 200, 100, 100);
        ventana.add(b);
    }
}