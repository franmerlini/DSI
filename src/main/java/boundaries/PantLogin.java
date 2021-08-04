package boundaries;

import javax.swing.*;

public class PantLogin extends Pantalla {
    private JPanel mainPanel;
    public JButton iniciarSesionButton;
    public JCheckBox mostrarContraCheckBox;
    public JTextField usuTextField;
    public JPasswordField contraPasswordField;

    public PantLogin() {
        super("Inicio sesion", 350, 350);
    }

    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }
}
