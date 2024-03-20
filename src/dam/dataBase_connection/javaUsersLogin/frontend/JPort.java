package dam.dataBase_connection.javaUsersLogin.frontend;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JPort extends JFrame implements ActionListener, ComponentListener {
    private JTextField fieldPort;
    private int entry;
    private boolean entryRecived = false;
    

    public JPort () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300, 150);
        
        fieldPort = new JTextField();

        fieldPort.addActionListener(this);
        componentResized(null);
        add(fieldPort);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            entry = Integer.parseInt(fieldPort.getText());
            this.entryRecived = true;
            this.dispose();
        } catch (Exception exx) {
            System.out.println(exx.getMessage());
        }
    }

    public int getEntry() {
        return this.entry;
    }

    public boolean entryRecived() {
        return this.entryRecived;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Insets d = this.getInsets();
        fieldPort.setBounds(0, 0, 300, 150 - d.top); // Centrar TextField en el Pane
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}