package boundaries;

import javax.swing.*;
import java.awt.*;

public abstract class PantallasMuseoSalas extends JFrame {
    private final JFrame jFrame;

    public PantallasMuseoSalas(String titulo, int ancho, int alto, int x, int y) {
        jFrame = new JFrame();
        jFrame.setTitle(titulo);
        jFrame.setSize(new Dimension(ancho, alto));
        jFrame.setLocation(x, y);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
    }

    public void mostrarPantalla(JPanel mainPanel) {
        jFrame.setContentPane(mainPanel);
        jFrame.setVisible(true);
    }

    public void cerrarPantala() {
        jFrame.dispose();
    }
}
