package control;

import DAO.EntradaDAO;
import DAO.ReservaVisitaDAO;
import DAO.UsuarioDAO;
import boundaries.Impresor;
import boundaries.PantVentaEntrada;
import entities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestorVentas implements ActionListener {
    //Atributos de la clase GestorVentas
    private List<Usuario> usuarios;
    private List<Entrada> entradas;
    private List<ReservaVisita> reservasVisita;

    private Usuario usuarioLogueado;
    private Sesion sesionActiva;
    private Sede sedeActual;
    private LocalDate fechaActual;
    private LocalDateTime fechaHoraActual;

    private List<Tarifa> tarifasVigentesSedeActual;
    private List<ReservaVisita> reservasVisitaSedeFechaActual;
    private List<Entrada> entradasSedeActual;

    private final PantVentaEntrada pantVentaEntrada = new PantVentaEntrada();
    private int idTarifaSeleccionada;
    private Tarifa tarifaSeleccionada;
    private boolean seleccionaTarifa = false;
    private boolean servicioGuiaSeleccionado = false;
    private int cant;
    private int cantidadEntradasSeleccionada;
    private double montoEntrada;

    private final Impresor impresor = new Impresor();
    //private final PantSala pantSala = new PantSala();
    //private final PantMuseo pantMuseo = new PantMuseo();

    //Metodo constructor
    public GestorVentas() {
        //Obtener los datos de la base de datos
        obtenerDatos();
        //Iniciar eventos para las pantallas
        iniciarEventos();
    }


    public static void main(String[] args) {
        //Instanciar la clase GestorVentas
        GestorVentas gv = new GestorVentas();

        //Tomar la fecha actual del sistema y guardarla en una variable global
        gv.fechaActual = gv.obtenerFechaActual();
        //Tomar la fecha y hora actual del sistema y guardarla en una variable global
        gv.fechaHoraActual = gv.obtenerFechaHoraActual();

        //Logueo ficticio
        gv.usuarioLogueado = gv.loguear("pedrosanchez");
        gv.sesionActiva = new Sesion(gv.usuarioLogueado, gv.fechaHoraActual, null);

        //1. opcionRegistrarVentaEntrada
        gv.opcionRegistrarVentaEntrada();

        //3. nuevaVentaEntrada
        gv.nuevaVentaEntrada();
    }

    //Traer todos los datos necesarios desde la base de datos y guardarlos en listas
    public void obtenerDatos() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarios = usuarioDAO.listar();

        EntradaDAO entradaDAO = new EntradaDAO();
        entradas = entradaDAO.listar();

        ReservaVisitaDAO reservaVisitaDAO = new ReservaVisitaDAO();
        reservasVisita = reservaVisitaDAO.listar();
    }

    //Obtener la fecha actual del sistema
    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    //Obtener la fecha y hora actual del sistema
    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    //Obtener la hora actual del sistema
    public LocalTime obtenerHoraActual() {
        return LocalTime.now();
    }

    //Realizar un logueo ficticio al sistema pasando como parametro un nombre de usuario
    public Usuario loguear(String nombre) {
        Usuario aux = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                aux = usuario;
            }
        }
        return aux;
    }

    //Realizar un clickeo ficticio al boton "Registrar Venta de Entrada"
    public void opcionRegistrarVentaEntrada() {
        //2. habilitarPantalla
        pantVentaEntrada.habilitarPantalla();
    }

    public void nuevaVentaEntrada() {
        //4. buscarEmpleadoLogueado
        Empleado empleadoLogueado = buscarEmpleadoLogueado();
        //5. buscarSedeEmpleado
        sedeActual = buscarSedeEmpleado(empleadoLogueado);
        //6. obtenerFechaActual
        LocalDate fechaActual = obtenerFechaActual();
        //7. buscarTarifasSedeActual
        tarifasVigentesSedeActual = buscarTarifasSedeActual(sedeActual, fechaActual);
        //8. mostrarTarifasVigentes
        pantVentaEntrada.mostrarTarifasVigentes(tarifasVigentesSedeActual);
    }

    public void tomarSeleccionTarifa() {
        tarifaSeleccionada = buscarTarifaPorId(idTarifaSeleccionada);
    }

    public void tomarSeleccionServicioGuia() {
        //14. calcularDuracionEstimadaVisitaCompleta
        calcularDuracionEstimadaVisitaCompleta();
    }

    public boolean tomarSeleccionCantidadEntradas() {
        cantidadEntradasSeleccionada = cant;
        //18. validarCantidadEntradasDisponibles
        boolean hayDisponibilidad = validarCantidadEntradasDisponibles(cantidadEntradasSeleccionada);
        //22. mostrarDetalleVenta
        mostrarDetalleVenta();

        return hayDisponibilidad;
    }

    public void tomarConfirmacionVenta() {
        //26. buscarUltimoNumeroEntrada
        int ultimoNumeroEntrada = buscarUltimoNumeroEntrada();
        //27. crearEntrada
        crearEntrada(ultimoNumeroEntrada);
        //28. actualizarCantidadVisitantes
        actualizarCantidadVisitantes();
    }

    //------------------------------------------Metodos que dan solucion al CU------------------------------------------
    //Buscar empleado logueado
    public Empleado buscarEmpleadoLogueado() {
        return sesionActiva.obtenerEmpleadoLogueado();
    }

    //Buscar sede donde trabaja el empleado logueado
    public Sede buscarSedeEmpleado(Empleado empleado) {
        return empleado.obtenerSedeDondeTrabaja();
    }

    //Buscar tarifas de la sede actual
    public List<Tarifa> buscarTarifasSedeActual(Sede sede, LocalDate fechaActual) {
        return sede.buscarTarifasVigentes(fechaActual);
    }

    //Calcular la duracion estimada para una visita completa al museo
    public void calcularDuracionEstimadaVisitaCompleta() {
        LocalDate fechaActual = obtenerFechaActual();
        int aux = sedeActual.calcularDuracionEstimadaVisitaCompleta(fechaActual);
        System.out.println("Tiempo estimado para una visita completa al museo: " + aux + " minutos");
    }

    public boolean validarCantidadEntradasDisponibles(int cantidadEntradasSeleccionada) {
        boolean aux = false;

        //19. buscarLimiteVisitantes
        int limiteVisitantes = sedeActual.buscarLimiteVisitantes();
        //20. buscarReservasVisitaSedeFechaActual
        reservasVisitaSedeFechaActual = buscarReservasVisitaSedeFechaActual(sedeActual, fechaActual);
        //21. buscarEntradasSedeFechaActual
        entradasSedeActual = buscarEntradasSedeFechaActual(sedeActual, fechaActual);

        if (limiteVisitantes - (cantidadEntradasSeleccionada + reservasVisitaSedeFechaActual.size() +
                entradasSedeActual.size()) > 0) {
            aux = true;
        }

        return aux;
    }

    private List<ReservaVisita> buscarReservasVisitaSedeFechaActual(Sede sedeActual, LocalDate fechaActual) {
        List<ReservaVisita> aux = new ArrayList<>();

        for (ReservaVisita reservaVisita : reservasVisita) {
            if (reservaVisita.esSedeActual(sedeActual) && reservaVisita.esFechaActual(fechaActual)) {
                aux.add(reservaVisita);
            }
        }
        return aux;
    }

    public List<Entrada> buscarEntradasSedeFechaActual(Sede sedeActual, LocalDate fechaActual) {
        List<Entrada> aux = new ArrayList<>();

        for (Entrada entrada : entradas) {
            if (entrada.esSedeActual(sedeActual) && entrada.esFechaActual(fechaActual)) {
                aux.add(entrada);
            }
        }
        return aux;
    }

    public void mostrarDetalleVenta() {
        int cant = cantidadEntradasSeleccionada;
        double monto = tarifaSeleccionada.getMonto();
        double montoAdicional = tarifaSeleccionada.getMontoAdicionalGuia();
        double total;

        if (servicioGuiaSeleccionado) {
            montoEntrada = monto + montoAdicional;
        } else {
            montoEntrada = monto;
        }

        total = cant * montoEntrada;
        pantVentaEntrada.mostrarDetalleVenta(Integer.toString(cant), Double.toString(montoEntrada),
                Double.toString(total));
    }

    public int buscarUltimoNumeroEntrada() {
        int aux = 0;

        for (Entrada entrada : entradas) {
            if (aux < entrada.getNumero()) {
                aux = entrada.getNumero();
            }
        }
        return aux;
    }

    public void crearEntrada(int ultimoNumeroEntrada) {
        LocalTime horaActual = obtenerHoraActual();

        for (int i = 0; i < cantidadEntradasSeleccionada; i++) {
            ultimoNumeroEntrada++;
            Entrada entradaNueva = new Entrada(ultimoNumeroEntrada, sedeActual, tarifaSeleccionada,
                    fechaActual, horaActual, montoEntrada);
            //Persistir el objeto entradaNueva en la base de datos
            EntradaDAO entradaDAONueva = new EntradaDAO();
            entradaDAONueva.insertar(entradaNueva);
            //Imprimir la entrada (por consola)
            imprimirEntrada(entradaNueva);
        }
    }

    public void imprimirEntrada(Entrada entrada) {
        impresor.imprimirEntrada(entrada);
    }

    public void actualizarCantidadVisitantes() {
        int limiteVisitantes = sedeActual.getCantMaxVisitantes();
        int cantidadVisitantes = limiteVisitantes - (reservasVisitaSedeFechaActual.size() +
                entradasSedeActual.size() + cantidadEntradasSeleccionada);

        //pantSala.mostrarCantidadVisitantes(Integer.toString(limiteVisitantes), Integer.toString(cantidadVisitantes));
        //pantMuseo.mostrarCantidadVisitantes(Integer.toString(limiteVisitantes), Integer.toString(cantidadVisitantes));
    }

    //----------------------------------------Metodos para la pantalla--------------------------------------------------
    public void iniciarEventos() {
        pantVentaEntrada.siguienteButton1.addActionListener(this);
        pantVentaEntrada.siguienteButton2.addActionListener(this);
        pantVentaEntrada.anteriorButton1.addActionListener(this);
        pantVentaEntrada.anteriorButton2.addActionListener(this);
        pantVentaEntrada.cancelarButton1.addActionListener(this);
        pantVentaEntrada.cancelarButton2.addActionListener(this);
        pantVentaEntrada.cancelarButton3.addActionListener(this);
        pantVentaEntrada.confirmarButton.addActionListener(this);

        pantVentaEntrada.incluirServicioGuiaRadioButton.addActionListener(this);
        pantVentaEntrada.noIncluirServicioGuiaRadioButton.addActionListener(this);

        //9. solicitarSeleccionTarifa
        pantVentaEntrada.tarifasTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel dtm = (DefaultTableModel) pantVentaEntrada.tarifasTable.getModel();
                int indiceFilaSeleccionada = pantVentaEntrada.tarifasTable.getSelectedRow();
                //10. seleccionarTarifa
                idTarifaSeleccionada = Integer.parseInt(dtm.getValueAt(indiceFilaSeleccionada, 0).toString());
                seleccionaTarifa = true;
            }
        });

        //10. solicitarSeleccionServicioGuia
        pantVentaEntrada.incluirServicioGuiaRadioButton.addChangeListener(e -> {
            if (pantVentaEntrada.incluirServicioGuiaRadioButton.isSelected()) {
                //11. seleccionarServicioGuia
                servicioGuiaSeleccionado = true;
            }
            if (seleccionaTarifa) {
                pantVentaEntrada.siguienteButton1.setEnabled(true);
            }
        });

        //10. solicitarSeleccionServicioGuia
        pantVentaEntrada.noIncluirServicioGuiaRadioButton.addChangeListener(e -> {
            if (pantVentaEntrada.noIncluirServicioGuiaRadioButton.isSelected()) {
                //11. seleccionarServicioGuia
                servicioGuiaSeleccionado = false;
            }
            if (seleccionaTarifa) {
                pantVentaEntrada.siguienteButton1.setEnabled(true);
            }
        });

        //15. solicitarSeleccionCantidadEntradas
        pantVentaEntrada.cantidadSpinner.addChangeListener(e -> {
            //16. seleccionarCantidadEntradas
            cant = Integer.parseInt(pantVentaEntrada.cantidadSpinner.getValue().toString());
            if (cant != 0) {
                pantVentaEntrada.siguienteButton2.setEnabled(true);
            }
            if (cant == 0) {
                pantVentaEntrada.siguienteButton2.setEnabled(false);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();

        if (evt.equals(pantVentaEntrada.anteriorButton1)) {
            pantVentaEntrada.tabbedPane.setSelectedIndex(0);
        }
        //
        else if (evt.equals(pantVentaEntrada.anteriorButton2)) {
            pantVentaEntrada.tabbedPane.setSelectedIndex(1);
        }
        //
        else if (evt.equals(pantVentaEntrada.siguienteButton1)) {
            //12. tomarSeleccionTarifa
            tomarSeleccionTarifa();
            //13. tomarSeleccionServicioGuia
            tomarSeleccionServicioGuia();
            //Mostrar la cantidad de entradas disponibles
            pantVentaEntrada.mostrarEntradasDisponibles(Integer.toString(cantidadEntradasDisponibles()));
            pantVentaEntrada.tabbedPane.setSelectedIndex(1);
        }
        //
        else if (evt.equals(pantVentaEntrada.siguienteButton2)) {
            //17. tomarSeleccionCantidadEntradas
            boolean hayDisponibilidad = tomarSeleccionCantidadEntradas();
            if (hayDisponibilidad) {
                pantVentaEntrada.tabbedPane.setSelectedIndex(2);
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficientes entradas " +
                        "disponibles. Ingrese otro valor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //
        else if (evt.equals(pantVentaEntrada.cancelarButton1) ||
                evt.equals(pantVentaEntrada.cancelarButton2) ||
                evt.equals(pantVentaEntrada.cancelarButton3)) {
            System.exit(0);
        }
        //23. solicitarConfirmacionVenta
        //24. confirmarVenta
        else if (evt.equals(pantVentaEntrada.confirmarButton)) {
            //25. tomarConfirmacionVenta
            tomarConfirmacionVenta();
            JOptionPane.showMessageDialog(null, "La operacion ha sido realizada exitosamente",
                    "Exito", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    //Buscar una tarifa pasando como parametro un id
    public Tarifa buscarTarifaPorId(int idTarifaSeleccionada) {
        Tarifa aux = null;
        for (Tarifa tarifa : tarifasVigentesSedeActual) {
            if (tarifa.getId() == idTarifaSeleccionada) {
                aux = tarifa;
            }
        }
        return aux;
    }

    public int cantidadEntradasDisponibles() {
        int limiteVisitantes = sedeActual.buscarLimiteVisitantes();
        reservasVisitaSedeFechaActual = buscarReservasVisitaSedeFechaActual(sedeActual, fechaActual);
        entradasSedeActual = buscarEntradasSedeFechaActual(sedeActual, fechaActual);

        return limiteVisitantes - (reservasVisitaSedeFechaActual.size() + entradasSedeActual.size());
    }
}
