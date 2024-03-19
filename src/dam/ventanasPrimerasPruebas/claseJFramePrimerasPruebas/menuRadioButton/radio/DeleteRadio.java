package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas.menuRadioButton.radio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class DeleteRadio extends JRadioButton implements ActionListener {
    private boolean selected = false;
    public DeleteRadio() {
        super("Delete User");

        Dimension d = getPreferredSize();
        
        System.out.println("aceptar");
        setVisible(true);
        setSize(d);
        setLocation(100, 140);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selected = !selected; // Cuando se pulse el boton su booleano pasara de ser falso a true y viceversa
        System.out.println("Delete " + selected);
    }
}
