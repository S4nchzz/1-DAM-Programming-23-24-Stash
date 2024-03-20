package dam.dataBase_connection.javaUsersLogin.frontend;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonCancelar extends JButton implements ActionListener{
    private JFrame frame;

    public JButtonCancelar (JFrame frame) {
        setText("Cancelar");
        this.frame = frame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        System.exit(0);
    }    
}
