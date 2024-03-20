package dam.dataBase_connection.javaUsersLogin.frontend;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class JButtonAceptar extends JButton implements ActionListener {
    private JFrame frame;

    public JButtonAceptar(JFrame frame) {
        setText("Aceptar");
        this.frame = frame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().setBackground(new Color(0xFFFF00));
    }
}
