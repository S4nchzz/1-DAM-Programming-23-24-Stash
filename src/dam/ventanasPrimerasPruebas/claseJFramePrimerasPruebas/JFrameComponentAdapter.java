package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;


public class JFrameComponentAdapter extends ComponentAdapter {
    private final JFrame f;

    public JFrameComponentAdapter (JFrame f) {
        this.f = f;
    }

    @Override
    public void componentResized (ComponentEvent e) {
        final int width = f.getWidth();
        final int heigth = f.getHeight();

        final int xButton;
        final int yButton;
        final int wButton;
        final int hButton;

        if (width < 500) {
            xButton = 0;
            wButton = width;
        } else {
            xButton = width - 500;
            wButton = 500;
        }

        if (heigth < 100) {
            yButton = 0;
            hButton = heigth;
        } else {
            yButton = heigth - 100;
            hButton = 100;
        }

        f.getComponent(0).setBounds(xButton, yButton, wButton, hButton);
    }
}