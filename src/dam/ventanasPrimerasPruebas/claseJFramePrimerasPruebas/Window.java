package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

import dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas.menuRadioButton.radio.AddRadio;
import dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas.menuRadioButton.radio.ChangePassRadio;
import dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas.menuRadioButton.radio.DeleteRadio;
import dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas.menuRadioButton.radio.LoginRadio;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window extends JFrame implements ComponentListener {
    private JButton acceptButton;

    public Window() {
        this.setTitle("Login");      

        setLayout(null); // Posicionamiento de los objetos de la 
        setSize(500, 500); // Tamaño de la 
        setVisible(true); // Hacerla visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se le pasa a este metodo la variable EXITONCLOSE situada en JFrame con valor 3

        acceptButton = new JButtonAceptar();
        add(acceptButton); // Se añade el boton aceptar al frame
       
        add(new AddRadio()); // Se añade el AddRadioButton al frame
        add(new DeleteRadio()); // Se añade el DeleteRadioButton al frame
        add(new ChangePassRadio()); // Se añade el ChangePassRadioButton al frame
        add(new LoginRadio()); // Se añade el LoginRadioButton al frame
        
        componentResized(null);
        addComponentListener(this); // Llamada al metodo JFrame.addComponentListener con el objeto a modificar, en este caso this
    }

    @Override
    public void componentResized(ComponentEvent e) {
        final Insets insets = getInsets();
        final int width = getWidth() - insets.left - insets.right;
        final int heigth = getHeight() - insets.top - insets.bottom;
        final Dimension preferred = acceptButton.getPreferredSize();

        final int xButton;
        final int yButton;
        final int wButton;
        final int hButton;

        if (width < preferred.width) {
            xButton = 0;
            wButton = width;
        } else {
            xButton = width - preferred.width;
            wButton = preferred.width;
        }

        if (heigth < preferred.height) {
            yButton = insets.top;
            hButton = heigth;
        } else {
            yButton = heigth - preferred.height;
            hButton = preferred.height;
        }

        acceptButton.setBounds(xButton, yButton, wButton, hButton);
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
