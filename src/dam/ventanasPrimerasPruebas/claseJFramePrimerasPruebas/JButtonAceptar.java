package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonAceptar extends JButton implements ActionListener {
    public JButtonAceptar() {
        setText("Aceptar");
        addActionListener(this);
    }

    @Override
    public void actionPerformed (ActionEvent ae) {
        
    }
}
