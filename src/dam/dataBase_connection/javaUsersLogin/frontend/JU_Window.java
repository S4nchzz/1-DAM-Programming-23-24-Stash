package dam.dataBase_connection.javaUsersLogin.frontend;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class JU_Window extends JFrame implements ComponentListener {
    private JButton acceptButton;
    private JButton cancelButton;

    private final JLabel lLogin;
    private final JLabel lPass;
    private final JTextField tLogin;
    private final JTextField tPass;

    private final ButtonGroup rAction;
    private final JRadioButton addUser; 
    private final JRadioButton delete; 
    private final JRadioButton changePass; 
    private final JRadioButton login;

    public JU_Window() {
        this.setTitle("Database Menu Admin");  

        setLayout(null); // Posicionamiento de los objetos de la
        setSize(500, 500); // Tamaño de la
        setVisible(true); // Hacerla visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se le pasa a este metodo la variable EXITONCLOSE situada en JFrame con valor 3
        setLocationRelativeTo(null); // Posicion relativa, si esta en null es el centro
        setAlwaysOnTop(true); //Posicion en la posicion y = 0;

        acceptButton = new JButtonAceptar(this);
        cancelButton = new JButtonCancelar();
        add(acceptButton); // Se añade el boton aceptar al frame
        add(cancelButton); // Se añade el boton cancelar al frame

        lLogin = new JLabel();
        lLogin.setText("Login: ");

        lPass = new JLabel();
        lPass.setText("Password: ");

        tLogin = new JTextField();
        tPass = new JTextField();

        add(lLogin);
        add(lPass);

        add(tLogin);
        add(tPass);
        
        addUser = new JRadioButton();
        delete = new JRadioButton();
        changePass = new JRadioButton();
        login = new JRadioButton();

        addUser.setText("Añadir");
        delete.setText("Borrar");
        changePass.setText("Cambiar contraseña");
        login.setText("Iniciar sesion");

        rAction = new ButtonGroup();
        rAction.add(addUser);
        rAction.add(delete);
        rAction.add(changePass);
        rAction.add(login);

        add(addUser);
        add(delete);
        add(changePass);
        add(login);
        
        componentResized(null);
        addComponentListener(this); // Llamada al metodo JFrame.addComponentListener con el objeto a modificar, en este caso this
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension preferredLabelLogin = lLogin.getPreferredSize(); // Size preferido de la label de login
        Dimension preferredLabelPass = lPass.getPreferredSize(); // Size preferido de la label de password
        Dimension preferredTextF = tLogin.getPreferredSize(); // Size preferido de cualquier textField

        int h0 = (int) Math.max(preferredLabelLogin.getHeight(), preferredTextF.getHeight()); // Altura maxima entre el label y el textField
        int w0 = (int) Math.max(preferredLabelLogin.getWidth(), preferredLabelPass.getWidth()); // Anchura maxima de los label
        int s = h0 / 2; // Altura total entre 2

        final Insets insets = getInsets();
        final int width = getWidth() - insets.left - insets.right; // Ancho de la ventana sin los marcos

        int w1 = width - w0 - 3 * s;

        lLogin.setBounds(s, s, w0, h0); // Bounds for LabelLogin
        tLogin.setBounds(s * 2 + w0, s, w1, h0); // Bounds for TextFieldLogin

        lPass.setBounds(s, s * 2 + h0, w0, h0); // Bounds for LabelPass
        tPass.setBounds(s * 2 + w0, s * 2 + h0, w1, h0); // Bounds for TextFieldPassword

        final Dimension preferredButton = acceptButton.getPreferredSize();

        int xButton = s * 2 + w0;
        int yButton = h0 * 2 + s * 2 + s;
        int wButton = preferredButton.width;
        int hButton = preferredButton.height;

        acceptButton.setBounds(xButton, yButton, wButton, hButton);

        Dimension addDim = addUser.getPreferredSize(); // Objeto dimension del radioButton add
        Dimension deleteDim = delete.getPreferredSize(); // Objeto dimension del radioButton delete
        Dimension changeDim = changePass.getPreferredSize(); // Objeto dimension del radioButton changePass
        Dimension loginDim = login.getPreferredSize(); // Objeto dimension del radioButton login

        int radioY = h0 * 2 + s * 2 + s;

        addUser.setBounds(s, radioY, addDim.width, addDim.height);
        radioY += h0;
        delete.setBounds(s, radioY, deleteDim.width, addDim.height);
        radioY += h0;
        changePass.setBounds(s, radioY, changeDim.width, addDim.height);
        radioY += h0;
        login.setBounds(s, radioY, loginDim.width, addDim.height);

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