package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.CiclistaDAO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.UsuarioDAO;

public class PanelAdministrador extends MainPanel implements ActionListener {

	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnEquipo;
	private JButton btnSimulacion;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;

	private JLabel lblImagenPerfil;
	private JLabel lblRol;
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblCorreo;
	private JLabel lblUsuario;
	private JLabel lblId;
	private JLabel lblContrasena;
	private JLabel lblGenero;
	private JLabel lblCedulaTit;
	private JLabel lblCorreoTit;
	private JLabel lblUsuarioTit;
	private JLabel lblIdTit;
	private JLabel lblContrasenaTit;
	private JLabel lblGeneroTit;
	private JLabel lblTiempo;
	private JLabel lblNombrePerfil;
	private JLabel imagenPanel;
	private JLabel imagenPanelIzq;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtTiempo;

	private JComboBox<String> jcGenero;

	private JPanel pnlFondo;
	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	private JPanel pnlInferior;

	private String imagen = this.getProperties().getProperty("lblImagen.perfil");
	private String opcion = "perfilinicial";
	private boolean imgCambio = false;
	JLabel lblTitulo;
	private JPanel generalPanel;
	JScrollPane scrollPane;
	private Item newItem;
	private ArrayList<UsuarioDTO> mostrarTodos;

	private VentanaUsuario usuarioPanel;

	// Simulacion
	private JTable tabla;
	private String columnas[] = { "Equipo", "Corredor", "Tiempo", "Acción" };
	private boolean ColumnasEditables[] = { false, false, false, true };
	private Class tipo[] = new Class[] { java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
			java.lang.Boolean.class };
	private String tipoSeleccionado;
	private JTable tablaSimulacion;
	private String columnasSimulacion[] = { "Equipo", "Corredor", "Tiempo" };
	private boolean ColumnasSimulacionEditables[] = { false, false, false };

	private JButton btnIniciarSimulacion;
	private JProgressBar jpSimulacion;
	private Timer timer;
	private final int MAX_VAL = 100;
	private ArrayList<CiclistaDTO> corredores;

	public PanelAdministrador(VentanaUsuario inicial) {

		this.setProperties(FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties"));
		usuarioPanel = inicial;
		setLayout(null);
		initComponents();

	}

	public void initComponents() {
		removeAll();
		iniciarPanelInferior();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();
	}

	public void iniciarPanelIzquierdo() {
		if (pnlIzquierda == null) {
			pnlIzquierda = new JPanel();
		}

		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);

		lblImagenPerfil = this.crearLabel("", new Rectangle(49, 31, 155, 165),
				this.getProperties().getProperty("lblImagen.perfil"));
		pnlIzquierda.add(lblImagenPerfil);

		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 10, 235);
		lblNombrePerfil.setSize(230, 60);
		lblNombrePerfil.setForeground(new Color(245, 227, 187));
		lblNombrePerfil.setHorizontalAlignment(SwingConstants.CENTER);
		pnlIzquierda.add(lblNombrePerfil);

		lblRol = this.crearLabel("lblRol.administrador", 5, 300);
		lblRol.setFont(new Font("Tahoma", Font.BOLD | Font.PLAIN, 20));
		lblRol.setForeground(Color.white);
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBotonInvisible("Perfil Administrador", new Rectangle(0, 360, 250, 65), "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBotonInvisible("Actualizar Perfil Administrador", new Rectangle(0, 426, 250, 65), "");
		pnlIzquierda.add(btnActualizar);

		btnEquipo = this.crearBotonInvisible("Usuarios", new Rectangle(0, 492, 250, 65), "");
		pnlIzquierda.add(btnEquipo);
		
		btnSimulacion = this.crearBotonInvisible("Simulacion", new Rectangle(20, 558, 250, 65), "");
		pnlIzquierda.add(btnSimulacion);

		btnCerrar = this.crearBotonInvisible("Cerrar Sesión Administrador", new Rectangle(0, 592, 250, 68), "");
		pnlIzquierda.add(btnCerrar);

		imagenPanelIzq = this.crearLabel("", new Rectangle(0, 0, 250, 660), "izquierdaAdministrador.jpg");
		pnlIzquierda.add(imagenPanelIzq);

		pnlIzquierda.repaint();
		pnlIzquierda.revalidate();

		add(pnlIzquierda);
	}

	public void iniciarPanelDerecho() {
		if (pnlDerecha == null) {
			pnlDerecha = new JPanel();
		} else {
			pnlDerecha.removeAll();
		}

		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panel.pnlDerecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlDerecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlDerecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);

		String imgDatos = "";

		switch (opcion) {

		case "perfilinicial":
			btnGuardar.setVisible(false);
			imgDatos = "perfilInicialAdministrador.jpg";
			pnlInferior.setBackground(new Color(255, 255, 255));
			break;

		case "perfiladministrador":

			lblImagen = this.crearLabel("", new Rectangle(431, 25, 160, 155),
					this.getProperties().getProperty("lblImagen.perfil"));
			pnlDerecha.add(lblImagen);

			lblNombre = this.crearLabel("lblNombre.perfil", 345, 190);
			lblNombre.setSize(360, 60);
			lblNombre.setForeground(new Color(71, 30, 1));
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			pnlDerecha.add(lblNombre);

			lblCedulaTit = this.crearLabel("lblCedula.titulo", 120, 240);
			pnlDerecha.add(lblCedulaTit);

			lblCorreoTit = this.crearLabel("lblCorreo.titulo", 120, 335);
			pnlDerecha.add(lblCorreoTit);

			lblUsuarioTit = this.crearLabel("lblUsuario.titulo", 120, 427);
			pnlDerecha.add(lblUsuarioTit);

			lblIdTit = this.crearLabel("lblId.titulo", 610, 240);
			pnlDerecha.add(lblIdTit);

			lblContrasenaTit = this.crearLabel("lblContrasena.titulo", 610, 335);
			pnlDerecha.add(lblContrasenaTit);

			lblGeneroTit = this.crearLabel("lblGenero.titulo", 610, 427);
			pnlDerecha.add(lblGeneroTit);

			lblCedula = this.crearLabel("lblCedula.perfil", 135, 274);
			pnlDerecha.add(lblCedula);

			lblCorreo = this.crearLabel("lblCorreo.perfil", 135, 369);
			lblCorreo.setSize(320, 35);
			pnlDerecha.add(lblCorreo);

			lblUsuario = this.crearLabel("lblUsuario.perfil", 135, 461);
			lblUsuario.setSize(320, 35);
			pnlDerecha.add(lblUsuario);

			lblId = this.crearLabel("lblId.perfil", 625, 274);
			lblId.setSize(320, 35);
			pnlDerecha.add(lblId);

			lblContrasena = this.crearLabel("lblContrasena.perfil", 625, 369);
			pnlDerecha.add(lblContrasena);

			lblGenero = this.crearLabel("lblGenero.perfil", 625, 461);
			pnlDerecha.add(lblGenero);

			imgDatos = "perfilDatosAdministrador.jpg";

			pnlInferior.setBackground(new Color(255, 255, 255));

			btnGuardar.setVisible(false);

			break;

		case "actualizarperfiladministrador":

			btnImagen = this.crearBotonInvisible("Imagen Administrador", new Rectangle(280, 12, 165, 160), "");
			pnlDerecha.add(btnImagen);

			lblNombre = this.crearLabel("lblNombre.titulo", 100, 185);
			jtNombre = this.crearTextFieldInvisible("lblNombre.perfil", new Rectangle(120, 225, 335, 30));
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblCedula = this.crearLabel("lblCedula.titulo", 100, 275);
			jtCedula = this.crearTextFieldInvisible("lblCedula.perfil", new Rectangle(120, 313, 335, 30));
			jtCedula.setEnabled(false);
			pnlDerecha.add(lblCedula);
			pnlDerecha.add(jtCedula);

			lblCorreo = this.crearLabel("lblCorreo.titulo", 100, 355);
			jtCorreo = this.crearTextFieldInvisible("lblCorreo.perfil", new Rectangle(120, 393, 335, 30));
			pnlDerecha.add(lblCorreo);
			pnlDerecha.add(jtCorreo);

			lblUsuario = this.crearLabel("lblUsuario.titulo", 100, 436);
			jtUsuario = this.crearTextFieldInvisible("lblUsuario.perfil", new Rectangle(120, 475, 335, 30));
			jtUsuario.setEnabled(false);
			pnlDerecha.add(lblUsuario);
			pnlDerecha.add(jtUsuario);

			lblId = this.crearLabel("lblId.titulo", 555, 185);
			jtId = this.crearTextFieldInvisible("lblId.perfil", new Rectangle(575, 225, 335, 30));
			jtId.setEnabled(false);
			pnlDerecha.add(lblId);
			pnlDerecha.add(jtId);

			lblContrasena = this.crearLabel("lblContrasena.titulo", 555, 275);
			jtContrasena = this.crearTextFieldInvisible("lblContrasena.perfil", new Rectangle(575, 313, 335, 30));
			pnlDerecha.add(lblContrasena);
			pnlDerecha.add(jtContrasena);

			String[] listaGenero = { "Hombre", "Mujer" };

			lblGenero = this.crearLabel("lblGenero.titulo", 555, 355);
			jcGenero = this.crearComboBoxInvisible(listaGenero, new Rectangle(575, 393, 335, 30));
			if (this.getProperties().getProperty("lblGenero.perfil").contains("Hombre")) {
				jcGenero.setSelectedIndex(0);
			} else {
				jcGenero.setSelectedIndex(1);
			}
			pnlDerecha.add(lblGenero);
			pnlDerecha.add(jcGenero);

			pnlInferior.setBackground(new Color(255, 243, 217));

			imgDatos = "perfilActAdministrador.jpg";

			btnGuardar.setVisible(true);

			imgCambio = false;

			aplicarFuncionesValidacion();

			break;

		case "usuarios":

			lblUsuario = this.crearLabel("lblCiclistasEquipo.titulo", 50, 170);
			pnlDerecha.add(lblUsuario);

			/*
			 * INTENTAR PONER LAS CARTAS DE LOS CICLISTAS
			 */

			btnGuardar.setVisible(false);
			mostrarCartas();

			imgDatos = "listaUsuarios.jpg";

			revalidate();

			break;

		case "simulacion":
			seleccionarCarrera();
			break;
		case "montana":
		case "curvas":
		case "semi":
		case "undia":
		case "llano":
			iniciarSimulacion();
			break;
		case "simular":
			iniciarCarrera();
			break;
		case "resultados":
			finalizarSimulacion();
			break;		
		}

		imagenPanel = this.crearLabel("", new Rectangle(0, 0, 1050, 600), imgDatos);
		pnlDerecha.add(imagenPanel);

		pnlDerecha.repaint();
		pnlDerecha.revalidate();

		add(pnlDerecha);
	}

	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.alto")));
		pnlInferior.setLayout(null);

		btnGuardar = this.crearBotonInvisible("Guardar Administrador", new Rectangle(720, 0, 200, 50),
				"btnGuardar.jpg");
		pnlInferior.add(btnGuardar);

		add(pnlInferior);
	}

	public void mostrarCartas() {
		if (mostrarTodos == null) {
			return;
		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 200, 940, 440);

		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(null);
		generalPanel.setBackground(Color.WHITE);

		int x = 80;
		int y = 60;
		int heightFinal = mostrarTodos.size();

		for (UsuarioDTO usuario : mostrarTodos) {
			newItem = new Item(usuario);
			generalPanel.add(newItem.getItemUsuarios(x, y));

			if (x + 205 > 800) {
				x = 80;
				y += 305;
			} else {
				x += 205;
			}
		}

		double res = Math.ceil(heightFinal / 4.0);
		if (((res * 300) + 120) + (res * 5) > 700) {
			heightFinal = (int) ((res * 300) + 120 + (res * 5));
		} else {
			heightFinal = 700;
		}

		generalPanel.setBounds(0, 0, 940, heightFinal);
		generalPanel.setPreferredSize(new Dimension(940, heightFinal));
		scrollPane.setViewportView(generalPanel);

		pnlDerecha.add(scrollPane);
	}

	public void aplicarFuncionesValidacion() {

		numeros(jtCedula);

		letras(jtNombre);

		limitarCaracter(jtCedula, 10);
		limitarCaracter(jtCorreo, 50);
		limitarCaracter(jtContrasena, 30);
		limitarCaracter(jtNombre, 50);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagenadministrador":
			JFileChooser eleccion = new JFileChooser();

			eleccion.setCurrentDirectory(new File("imgs/users"));
			eleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);

			eleccion.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY, new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					File folderSelec = eleccion.getCurrentDirectory();
					if (!folderSelec.getAbsolutePath().equals("imgs/users")) {

						eleccion.setCurrentDirectory(new File("imgs/users"));
					}
				}
			});

			int resultado = eleccion.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				String nombreArchivo = eleccion.getSelectedFile().getName();
				imagen = "users/" + nombreArchivo;
				imgCambio = true;

			}

			break;

		case "perfiladministrador":

		case "actualizarperfiladministrador":

		case "simulacion":

		case "usuarios":
		case "montana":
		case "curvas":
		case "semi":
		case "undia":
		case "llano":
			opcion = e.getActionCommand();
			if ("usuarios".equals(opcion)) {
				UsuarioDAO UsuarioDAO = new UsuarioDAO();
				mostrarTodos = UsuarioDAO.mostrarTodos();
			}
			iniciarPanelDerecho();
			break;
		case "simular":
			corredores = new ArrayList<>();
			if (Seleccionados(3)) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
					boolean sel = tabla.getValueAt(i, 3) != null;
					if (sel) {
						CiclistaDTO newCorredor = new CiclistaDTO(i, 0, 0, "", "", "");
						newCorredor.setNombre((String) tabla.getValueAt(i, 0));
						corredores.add(newCorredor);
					}
				}
				opcion = e.getActionCommand();
				iniciarPanelDerecho();
			} else {
				JOptionPane.showMessageDialog(null,
						"Antes de comenzar la simulacion, se debe seleccionar al menos un ciclista", "Mensaje",
						JOptionPane.WARNING_MESSAGE);
			}
			break;
		}
	}

	public void nuevoPanel(JPanel panelActual) {
		pnlDerecha.removeAll();

		if (panelActual != null)
			pnlDerecha.add(panelActual);

	}

	public JButton getBtnImagen() {
		return btnImagen;
	}

	public void setBtnImagen(JButton btnImagen) {
		this.btnImagen = btnImagen;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnEquipo() {
		return btnEquipo;
	}

	public void setBtnEquipo(JButton btnEquipo) {
		this.btnEquipo = btnEquipo;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JLabel getLblImagenPerfil() {
		return lblImagenPerfil;
	}

	public void setLblImagenPerfil(JLabel lblImagenPerfil) {
		this.lblImagenPerfil = lblImagenPerfil;
	}

	public JLabel getLblRol() {
		return lblRol;
	}

	public void setLblRol(JLabel lblRol) {
		this.lblRol = lblRol;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblCedulaTit() {
		return lblCedulaTit;
	}

	public void setLblCedulaTit(JLabel lblCedulaTit) {
		this.lblCedulaTit = lblCedulaTit;
	}

	public JLabel getLblCorreoTit() {
		return lblCorreoTit;
	}

	public void setLblCorreoTit(JLabel lblCorreoTit) {
		this.lblCorreoTit = lblCorreoTit;
	}

	public JLabel getLblUsuarioTit() {
		return lblUsuarioTit;
	}

	public void setLblUsuarioTit(JLabel lblUsuarioTit) {
		this.lblUsuarioTit = lblUsuarioTit;
	}

	public JLabel getLblIdTit() {
		return lblIdTit;
	}

	public void setLblIdTit(JLabel lblIdTit) {
		this.lblIdTit = lblIdTit;
	}

	public JLabel getLblContrasenaTit() {
		return lblContrasenaTit;
	}

	public void setLblContrasenaTit(JLabel lblContrasenaTit) {
		this.lblContrasenaTit = lblContrasenaTit;
	}

	public JLabel getLblGeneroTit() {
		return lblGeneroTit;
	}

	public void setLblGeneroTit(JLabel lblGeneroTit) {
		this.lblGeneroTit = lblGeneroTit;
	}

	public JLabel getLblTiempo() {
		return lblTiempo;
	}

	public void setLblTiempo(JLabel lblTiempo) {
		this.lblTiempo = lblTiempo;
	}

	public JLabel getLblNombrePerfil() {
		return lblNombrePerfil;
	}

	public void setLblNombrePerfil(JLabel lblNombrePerfil) {
		this.lblNombrePerfil = lblNombrePerfil;
	}

	public JTextField getJtNombre() {
		return jtNombre;
	}

	public void setJtNombre(JTextField jtNombre) {
		this.jtNombre = jtNombre;
	}

	public JTextField getJtCedula() {
		return jtCedula;
	}

	public void setJtCedula(JTextField jtCedula) {
		this.jtCedula = jtCedula;
	}

	public JTextField getJtCorreo() {
		return jtCorreo;
	}

	public void setJtCorreo(JTextField jtCorreo) {
		this.jtCorreo = jtCorreo;
	}

	public JTextField getJtUsuario() {
		return jtUsuario;
	}

	public void setJtUsuario(JTextField jtUsuario) {
		this.jtUsuario = jtUsuario;
	}

	public JTextField getJtId() {
		return jtId;
	}

	public void setJtId(JTextField jtId) {
		this.jtId = jtId;
	}

	public JTextField getJtContrasena() {
		return jtContrasena;
	}

	public void setJtContrasena(JTextField jtContrasena) {
		this.jtContrasena = jtContrasena;
	}

	public JTextField getJtTiempo() {
		return jtTiempo;
	}

	public void setJtTiempo(JTextField jtTiempo) {
		this.jtTiempo = jtTiempo;
	}

	public JComboBox<String> getJcGenero() {
		return jcGenero;
	}

	public void setJcGenero(JComboBox<String> jcGenero) {
		this.jcGenero = jcGenero;
	}

	public JPanel getPnlDerecha() {
		return pnlDerecha;
	}

	public void setPnlDerecha(JPanel pnlDerecha) {
		this.pnlDerecha = pnlDerecha;
	}

	public JPanel getPnlIzquierda() {
		return pnlIzquierda;
	}

	public void setPnlIzquierda(JPanel pnlIzquierda) {
		this.pnlIzquierda = pnlIzquierda;
	}

	public JPanel getPnlInferior() {
		return pnlInferior;
	}

	public void setPnlInferior(JPanel pnlInferior) {
		this.pnlInferior = pnlInferior;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public boolean isImgCambio() {
		return imgCambio;
	}

	public void setImgCambio(boolean imgCambio) {
		this.imgCambio = imgCambio;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JPanel getGeneralPanel() {
		return generalPanel;
	}

	public void setGeneralPanel(JPanel generalPanel) {
		this.generalPanel = generalPanel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}

	public VentanaUsuario getUsuarioPanel() {
		return usuarioPanel;
	}

	public void setUsuarioPanel(VentanaUsuario usuarioPanel) {
		this.usuarioPanel = usuarioPanel;
	}

	public JLabel getImagenPanel() {
		return imagenPanel;
	}

	public void setImagenPanel(JLabel imagenPanel) {
		this.imagenPanel = imagenPanel;
	}

	public JLabel getImagenPanelIzq() {
		return imagenPanelIzq;
	}

	public void setImagenPanelIzq(JLabel imagenPanelIzq) {
		this.imagenPanelIzq = imagenPanelIzq;
	}

	public JPanel getPnlFondo() {
		return pnlFondo;
	}

	public void setPnlFondo(JPanel pnlFondo) {
		this.pnlFondo = pnlFondo;
	}

	public ArrayList<UsuarioDTO> getMostrarTodos() {
		return mostrarTodos;
	}

	public void setMostrarTodos(ArrayList<UsuarioDTO> mostrarTodos) {
		this.mostrarTodos = mostrarTodos;
	}

	// Funcion que valida si se ha seleccionado al menos 1 corredor
	private boolean Seleccionados(int pos) {
		int contador = 0;
		boolean bandera = true;
		for (int i = 0; i < tabla.getRowCount(); i++) {
			boolean seleccion = tabla.getValueAt(i, pos) != null;
			if (seleccion) {
				contador++;
			}
		}
		if (contador == 0) {
			bandera = false;
		}
		return bandera;
	}

	private void seleccionarCarrera() {
		JButton btnMap1 = crearBotonMapas("montana", 220, 100, "montana.jpg");
		JLabel lblMap1 = crearLabelCenter("Montana", 220, 280);
		pnlDerecha.add(btnMap1);
		pnlDerecha.add(lblMap1);

		JButton btnMap2 = crearBotonMapas("curvas", 440, 100, "curvas.jpg");
		JLabel lblMap2 = crearLabelCenter("Llano con curvas", 440, 280);
		pnlDerecha.add(btnMap2);
		pnlDerecha.add(lblMap2);

		JButton btnMap3 = crearBotonMapas("semi", 660, 100, "semi.jpg");
		JLabel lblMap3 = crearLabelCenter("Semi Llano", 660, 280);
		pnlDerecha.add(btnMap3);
		pnlDerecha.add(lblMap3);

		JButton btnMap4 = crearBotonMapas("undia", 330, 350, "undia.jpg");
		JLabel lblMap4 = crearLabelCenter("Un solo dia", 330, 530);
		pnlDerecha.add(btnMap4);
		pnlDerecha.add(lblMap4);

		JButton btnMap5 = crearBotonMapas("llano", 550, 350, "llano.jpg");
		JLabel lblMap5 = crearLabelCenter("Llano en Recta", 550, 530);
		pnlDerecha.add(btnMap5);
		pnlDerecha.add(lblMap5);
	}

	// Funcion que crea la tabla para mostrar los ciclistas a ser seleccionados en
	// la simulacion
	private void iniciarSimulacion() {
		corredores = new ArrayList<>();
		tipoSeleccionado = opcion;

		JLabel lblCarreraSeleccionada = crearLabelCarrera(tipoSeleccionado, "", 60, 200, tipoSeleccionado + ".jpg", 180);
		JLabel lblTituloCarreraSeleccionada = crearLabelCenter(this.getProperties().getProperty("lblCarrera." + tipoSeleccionado), 60, 400);
		pnlDerecha.add(lblCarreraSeleccionada);
		pnlDerecha.add(lblTituloCarreraSeleccionada);

		JLabel lblCorredores = crearLabel("lblCarrera.carrera.corredores", 300, 120);
		pnlDerecha.add(lblCorredores);
		
		CiclistaDAO CiclistasDAO = new CiclistaDAO();
		ArrayList<CiclistaDTO> lstCiclistas = CiclistasDAO.mostrarTodos();

		btnIniciarSimulacion = this.crearBoton("Simular", 425, 480, "");
		pnlDerecha.add(btnIniciarSimulacion);

		DefaultTableModel tableModel = new DefaultTableModel(columnas, 0) {
			public boolean isCellEditable(int row, int col) {
				return ColumnasEditables[col];
			}

			public Class getColumnClass(int index) {
				return tipo[index];
			}
		};

		for (CiclistaDTO c : lstCiclistas) {
			Object[] data = { c.getNombre(), c.getNombre(), c.getTiempoAcumuladoMin() };
			tableModel.addRow(data);
		}

		tabla = crearTable(columnas, ColumnasEditables, tableModel);
		JScrollPane jsPanel = new JScrollPane(tabla);
		jsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsPanel.setBounds(300, 150, 650, 300);
		pnlDerecha.add(jsPanel);
	}

	// Evento listener del timer que se ejecuta cada vez que pasa 1 segundo
	private class UpdateBarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random random = new Random();
			double tiempo = 0;

			for (int i = 0; i < tablaSimulacion.getRowCount(); i++) {
				CiclistaDTO corredor = corredores.get(i);
				tiempo = corredor.getTiempoAcumuladoMin() + random.nextDouble(50);
				corredor.setTiempoAcumuladoMin(tiempo);
				tablaSimulacion.setValueAt(" " + String.format("%.2f", tiempo), i, 2);
			}
			try {
				Thread.sleep(400);

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			int val = jpSimulacion.getValue();

			if (val >= MAX_VAL) {
				timer.stop();
				JOptionPane.showMessageDialog(getRootPane(), "Finalizo la carrera.");
				jpSimulacion.setValue(0);
				Collections.sort(corredores, new Comparator<CiclistaDTO>() {
					@Override
					public int compare(CiclistaDTO p1, CiclistaDTO p2) {
						return String.valueOf(p2.getTiempoAcumuladoMin())
								.compareTo(String.valueOf(p1.getTiempoAcumuladoMin()));
					}
				});
				opcion = "resultados";
				iniciarPanelDerecho();
				return;
			}
			jpSimulacion.setValue(++val);
		}
	}

	private void iniciarCarrera() {
		JLabel lblCarreraSeleccionada = crearLabelCarrera(tipoSeleccionado, "", 60, 200, tipoSeleccionado + ".jpg", 180);
		JLabel lblTituloCarreraSeleccionada = crearLabelCenter(this.getProperties().getProperty("lblCarrera." + tipoSeleccionado), 60, 400);
		pnlDerecha.add(lblCarreraSeleccionada);
		pnlDerecha.add(lblTituloCarreraSeleccionada);
		
		DefaultTableModel modelResult = new DefaultTableModel(columnasSimulacion, 0) {
			public boolean isCellEditable(int row, int col) {
				return ColumnasSimulacionEditables[col];
			}
		};
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);
		modelocentrar.setFont(new Font("Tahoma", Font.BOLD | Font.PLAIN, 16));

		for (CiclistaDTO c : corredores) {
			Object[] data = { c.getNombre(), c.getNombre(), c.getTiempoAcumuladoMin() };
			modelResult.addRow(data);
		}

		tablaSimulacion = crearTable(columnas, ColumnasEditables, modelResult);
		tablaSimulacion.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);

		JScrollPane jsPanel = new JScrollPane(tablaSimulacion);
		jsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsPanel.setBounds(300, 150, 530, 300);
		pnlDerecha.add(jsPanel);

		jpSimulacion = crearProgressBar(new Rectangle(350, 550, 350, 30));
		pnlDerecha.add(jpSimulacion);

		pnlDerecha.repaint();
		pnlDerecha.revalidate();

		timer = new Timer(10, new UpdateBarListener());
		timer.start();

	}
	
	private void finalizarSimulacion()
	{
		JLabel lblPrimerLugar = crearLabelCarrera("first_place", "", 425, 10, "first_place.png", 180);
		JLabel lblCorredorPrimerLugar = crearLabelCenter(corredores.get(0).getNombre(), 425, 200);
		JLabel lblTiempoPrimerLugar = crearLabelCenter(String.format("%.2f", corredores.get(0).getTiempoAcumuladoMin()), 425, 220);
		pnlDerecha.add(lblPrimerLugar);
		pnlDerecha.add(lblCorredorPrimerLugar);
		pnlDerecha.add(lblTiempoPrimerLugar);
		
		JLabel lblSegundoLugar = crearLabelCarrera("second_place", "", 300, 230, "second_place.png", 80);
		pnlDerecha.add(lblSegundoLugar);

		JLabel lblTercerLugar = crearLabelCarrera("third_place", "", 650, 230, "third_place.png", 80);
		pnlDerecha.add(lblTercerLugar);
		
		if (corredores.size() > 3)
		{
			JLabel lblCorredorSegundoLugar = crearLabelCenter(corredores.get(1).getNombre(), 250, 380);
			JLabel lblTiempoSegundoLugar = crearLabelCenter(String.format("%.2f", corredores.get(1).getTiempoAcumuladoMin()), 250, 400);
			pnlDerecha.add(lblCorredorSegundoLugar);
			pnlDerecha.add(lblTiempoSegundoLugar);
			
			JLabel lblCorredorTercerLugar = crearLabelCenter(corredores.get(2).getNombre(), 580, 380);
			JLabel lblTiempoTercerLugar = crearLabelCenter(String.format("%.2f", corredores.get(2).getTiempoAcumuladoMin()), 580, 400);
			pnlDerecha.add(lblCorredorTercerLugar);
			pnlDerecha.add(lblTiempoTercerLugar);
		}

	}
	

}