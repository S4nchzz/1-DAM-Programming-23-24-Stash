package dam.dataBase_connection.javaUsersLogin.frontend;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JButtonAceptar extends JButton implements ActionListener {
    private JU_Window frame;

    public JButtonAceptar(JU_Window frame) {
        setText("Aceptar");
        this.frame = frame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cuando se pulse el boton se hara una llamada a un metodo del frame el cual 
        // maneja las funciones de los radioButtons
        frame.actionAceptar();
    }
}
