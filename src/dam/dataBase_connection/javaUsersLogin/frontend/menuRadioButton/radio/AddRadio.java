package dam.dataBase_connection.javaUsersLogin.frontend.menuRadioButton.radio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class AddRadio extends JRadioButton implements ActionListener {
    private boolean status = false;
    public AddRadio() {
        super("Add User");

        Dimension d = getPreferredSize();

        System.out.println("aceptar");
        setVisible(true);
        setSize(d);
        setLocation(100, 100);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        status = !status; // Cuando se pulse el boton su booleano pasara de ser falso a true y viceversa
        System.out.println("Add " + status);
    }
}
