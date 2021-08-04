package boundaries;

import entities.Usuario;

import javax.swing.*;

public class PantMenuPrincipal extends Pantalla {
    private JPanel mainPanel;
    public JButton registrarVentaButton;
    private JButton registrarPrecioButton;
    private JButton anularVentaButton;
    private JButton modificarPrecioButton;
    private JButton registrarTipoButton;
    private JButton eliminarTipoButton;
    private JButton ventasButton;
    private JButton tiposButton;
    private JButton preciosButton;
    private JButton vendidasButton;
    private JLabel usuarioLabel;

    public PantMenuPrincipal() {
        super("Menu principal venta de entradas", 500, 350);

        //Deshabilitar botones
        registrarPrecioButton.setEnabled(false);
        anularVentaButton.setEnabled(false);
        modificarPrecioButton.setEnabled(false);
        registrarTipoButton.setEnabled(false);
        eliminarTipoButton.setEnabled(false);
        ventasButton.setEnabled(false);
        tiposButton.setEnabled(false);
        preciosButton.setEnabled(false);
        vendidasButton.setEnabled(false);

    }

    //Mostrar usuario logueado
    public void setUsuarioLabel(Usuario usuario) {
        usuarioLabel.setText("Usuario en sesion: " + usuario.getNombre());
    }

    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }
}
