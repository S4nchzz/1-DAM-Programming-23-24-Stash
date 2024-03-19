package dam.dataBase_connection.javaUsersLogin.frontend.menuRadioButton.radio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class DeleteRadio extends JRadioButton implements ActionListener {
    private boolean status = false;
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
        status = !status; // Cuando se pulse el boton su booleano pasara de ser falso a true y viceversa
        System.out.println("Delete " + status);
    }
}
