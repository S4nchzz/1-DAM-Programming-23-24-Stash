package dam.ventanasPrimerasPruebas.claseJFramePrimerasPruebas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonKeyListener implements KeyListener {
    @Override
    public void keyTyped (KeyEvent ke) {
        System.out.println(ke.getKeyChar());
    }

    @Override
    public void keyPressed (KeyEvent ke) {

    }

    @Override
    public void keyReleased (KeyEvent ke) {

    }
}
