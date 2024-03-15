package dam.dataBase_connection.javaUsersLogin.frontend.window;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public abstract class Window extends JFrame {
    public Window () {
        setSize(500, 500);
        setLocation(500, 150);
        setVisible(true);

        JPanel panel = new JPanel(new FlowLayout());
        panel.setVisible(true);
        add(panel);

        JButton buttonAdd = new JButton("Añadir usuario");
        JButton buttonRemove = new JButton("Borrar Usuario");
        JButton buttonChange = new JButton("Cambiar contraseña");
        JButton buttonLogin = new JButton("Iniciar sesion");
        panel.add(buttonAdd);
        panel.add(buttonRemove);
        panel.add(buttonChange);
        panel.add(buttonLogin);
    }
}
