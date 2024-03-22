package dam.dataBase_connection.javaUsersLogin.frontend;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dam.dataBase_connection.javaUsersLogin.backend.gestionUsuarios.UserGestion;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Ventana principal de la gestion de la base de
 * datos situada en 127.0.0.1:"????"
 */
public class JU_Window extends JFrame implements ComponentListener, ChangeListener {
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

    private String inputUser;
    private String inputPass;

    /**
     * Constructor que añadira al frame los elementos necesarios
     * (Jlabel, JButton, JTextField, ButtonGroup, JRadioButton)
     */
    public JU_Window() {
        this.setTitle("Database Menu Admin");  

        setLayout(null); // Posicionamiento de los objetos de la
        setSize(320, 278); // Tamaño de la
        setVisible(true); // Hacerla visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se le pasa a este metodo la variable EXITONCLOSE situada en JFrame con valor 3
        setLocationRelativeTo(null); // Posicion relativa, si esta en null es el centro
        setResizable(false);

        lLogin = new JLabel();
        lLogin.setText("Login: "); // Label login

        lPass = new JLabel();
        lPass.setText("Password: "); // Label password

        tLogin = new JTextField();
        tPass = new JPasswordField();

        add(lLogin); // Se añade al frame la label "Login"
        add(lPass); // Se añade al frame la label "Password"

        add(tLogin); // Se añade al frame el textField del usuario
        add(tPass); // Se añade al frame el textField de la contraseña
        
        // Se crean los radioButtons con las opciones
        addUser = new JRadioButton();
        delete = new JRadioButton();
        changePass = new JRadioButton();
        login = new JRadioButton();

        // A los radioButtons se les da un texto
        addUser.setText("Añadir");
        delete.setText("Borrar");
        changePass.setText("Cambiar contraseña");
        login.setText("Iniciar sesion");

        // Se crea un objeto de tio ButtonGroup para meter
        // los radioButtons en ete grupo, de esta forma
        // solo se podra seleccionar uno
        rAction = new ButtonGroup();
        rAction.add(addUser);
        rAction.add(delete);
        rAction.add(changePass);
        rAction.add(login);

        // Se crean los botones mandandole al constructor como parametros el frame actual (this)
        acceptButton = new JButtonAceptar(this); 
        cancelButton = new JButtonCancelar(this);

        add(acceptButton); // Se añade el boton aceptar al frame
        add(cancelButton); // Se añade el boton cancelar al frame

        // Se importa un metodo del interface ChangeListener para el borrar,
        // se le manda como ComponentEvent this ya que el interface hereda
        // ComponentEvent
        delete.addChangeListener(this);

        // Se añaden los radioButtons
        add(addUser);
        add(delete);
        add(changePass);
        add(login);
        
        // Se le da un componentResized null al frame principal
        componentResized(null);
        addComponentListener(this); // Llamada al metodo JFrame.addComponentListener con el objeto a modificar, en este caso this
    }

    /**
     * Metodo que le da el tamaño a todos los elementos
     * del frame
     */
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

        final Dimension preferredButtonAccept = acceptButton.getPreferredSize(); // Dimension del boton Aceptar
        final Dimension preferredButtonCancel = cancelButton.getPreferredSize(); // Dimension del boton Cancelar

        int xButton = s * 2 + w0;
        int yButton = h0 * 2 + s * 2 + s;
        int wButton = preferredButtonAccept.width;
        int hButton = preferredButtonAccept.height;

        acceptButton.setBounds(xButton, yButton, wButton, hButton); // Bounds for AcceptButton
        cancelButton.setBounds(xButton + s + preferredButtonCancel.width, yButton, preferredButtonCancel.width, hButton); // Bounds for CancelButton

        Dimension addDim = addUser.getPreferredSize(); // Objeto dimension del radioButton add
        Dimension deleteDim = delete.getPreferredSize(); // Objeto dimension del radioButton delete
        Dimension changeDim = changePass.getPreferredSize(); // Objeto dimension del radioButton changePass
        Dimension loginDim = login.getPreferredSize(); // Objeto dimension del radioButton login

        // Altura maxima de los elementos * 3 + (Altura maxima / 2) * 4
        int radioY = h0 * 3 + s * 4;

        // Bounds para todos los radio buttons aumentanto en cada uno la varaible
        // radioY + h0 para separarlos unos de otros
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

    /**
     * Change listener para el boton de borrar el cual cuando se llama al metodo desactiva
     * la forma de modificar el contenido del elemento
    **/ 
    @Override
    public void stateChanged(ChangeEvent e) {
        tPass.setEnabled(!delete.isSelected());
    }

    /**
     * Esta clase analiza todos lo radio buttons y miran si estan seleccionados
     * como solo se puede seleccionar uno cuando en la rama da if-elseif que hay,
     * cuando encuentre uno isSelected() = true, empezara el metodo de añadir
     * borrar, cambiar contraseña e iniciar sesoin respectivamente por cada
     * radioButton, si ocurre un error cada rama del if se encargara de proyectar
     * un mensaje en la pantalla con el posible error
     */
    public void actionAceptar() {
        if (addUser.isSelected()) {
            inputUser = tLogin.getText();
            inputPass = tPass.getText();

            if (!inputUser.equals("") && !inputPass.equals("")) {
                boolean addSucces = UserGestion.anadir(inputUser, inputPass);

                if (!addSucces) {
                    JOptionPane.showMessageDialog(null, "Error al añadir el usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Compruebe que los campos no estan vacios");
            }
            
        } else if (delete.isSelected()) {
            inputUser = tLogin.getText();

            if (!inputUser.equals("")) {
                boolean removeSucces = UserGestion.borrar(inputUser);

                if (!removeSucces) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Compruebe que el campo del usuario no este vacio");
            }

        } else if (changePass.isSelected()) {
            inputUser = tLogin.getText();
            inputPass = tPass.getText();

            if (!inputUser.equals("") && !inputPass.equals("")) {
                boolean changeSucces = UserGestion.cambiarContrasena(inputUser, inputPass);

                if (!changeSucces) {
                    JOptionPane.showMessageDialog(null, "Error al cambiarle la contraseña al usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Compruebe que los campos no estan vacios");
            }

        } else if (login.isSelected()) {
            inputUser = tLogin.getText();
            inputPass = tPass.getText();

            if (!inputUser.equals("") && !inputPass.equals("")) {
                boolean loginSucces = UserGestion.acceder(inputUser, inputPass);

                if (loginSucces) {
                    JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente"); 
                } else {
                    JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Compruebe que los campos no estan vacios");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ninguna opcion seleccionada");
        }
    }
}