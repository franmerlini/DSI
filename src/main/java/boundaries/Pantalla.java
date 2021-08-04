package boundaries;

import javax.swing.*;
import java.awt.*;

public abstract class Pantalla extends JFrame {
    private static JFrame jFrame;

    public Pantalla(String titulo, int ancho, int alto) {
        jFrame = new JFrame();
        jFrame.setTitle(titulo);
        jFrame.setSize(new Dimension(ancho, alto));
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
    }

    public void mostrarPantalla(JPanel mainPanel) {
        jFrame.setContentPane(mainPanel);
        jFrame.setVisible(true);
    }
}
