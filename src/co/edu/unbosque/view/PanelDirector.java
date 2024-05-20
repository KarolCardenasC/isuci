package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.FileHandler;

public class PanelDirector extends MainPanel implements ActionListener {

	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnEquipo;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;
	private JButton btnGuardarEquipo;

	private JLabel lblImagenPerfil;
	private JLabel lblRol;
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblNacionalidad;
	private JLabel lblCorreo;
	private JLabel lblUsuario;
	private JLabel lblId;
	private JLabel lblContrasena;
	private JLabel lblGenero;
	private JLabel lblEquipo;
	private JLabel lblCedulaTit;
	private JLabel lblNacionalidadTit;
	private JLabel lblCorreoTit;
	private JLabel lblUsuarioTit;
	private JLabel lblIdTit;
	private JLabel lblContrasenaTit;
	private JLabel lblGeneroTit;
	private JLabel lblEquipoTit;
	private JLabel lblTiempo;
	private JLabel lblNombrePerfil;
	private JLabel imagenPanel;
	private JLabel imagenPanelIzq;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtNacionalidad;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtTiempo;
	private JTextField jtEquipo;

	private JComboBox<String> jcGenero;

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	private JPanel pnlInferior;

	private String imagen = this.getProperties().getProperty("lblImagen.perfil");
	private String opcion = "perfilinicial";
	private boolean imgCambio = false;

	JLabel lblTitulo;
	private JPanel generalPanel;
	JScrollPane scrollPane;
	private ArrayList<Item> lstItemCiclistas;
	private Item newItem;
	private ArrayList<CiclistaDTO> lstCiclistas;

	private VentanaUsuario usuarioPanel;

	private JTable tabla;
	private String columnas[] = { "ID", "Nombre", "Cedula", "Tipo", "Especialidad", "Acción" };
	private boolean ColumnasEditables[] = { false, false, false, false, false, true };
	private Class tipo[] = new Class[] { java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
			java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class };

	public PanelDirector(VentanaUsuario inicial) {

		this.setProperties(FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties"));
		usuarioPanel = inicial;
		setLayout(null);
		lstItemCiclistas = new ArrayList<>();
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

		lblRol = this.crearLabel("lblRol.director", 5, 300);
		lblRol.setFont(new Font("Tahoma", Font.BOLD | Font.PLAIN, 20));
		lblRol.setForeground(Color.white);
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBotonInvisible("Perfil Director", new Rectangle(0, 363, 250, 48), "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBotonInvisible("Actualizar Perfil Director", new Rectangle(0, 411, 250, 48), "");
		pnlIzquierda.add(btnActualizar);

		btnEliminar = this.crearBotonInvisible("Eliminar Perfil Director", new Rectangle(0, 459, 250, 48), "");
		pnlIzquierda.add(btnEliminar);

		btnEquipo = this.crearBotonInvisible("Equipo", new Rectangle(0, 507, 250, 48), "");
		pnlIzquierda.add(btnEquipo);

		btnCerrar = this.crearBotonInvisible("Cerrar Sesión Director", new Rectangle(0, 592, 250, 68), "");
		pnlIzquierda.add(btnCerrar);

		imagenPanelIzq = this.crearLabel("", new Rectangle(0, 0, 250, 660), "izquierdaDirector.jpg");
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
			btnGuardarEquipo.setVisible(false);
			imgDatos = "perfilInicialDirector.jpg";
			pnlInferior.setBackground(new Color(255, 255, 255));
			break;

		case "perfildirector":

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

			lblNacionalidadTit = this.crearLabel("lblNacionalidad.titulo", 120, 335);
			pnlDerecha.add(lblNacionalidadTit);

			lblCorreoTit = this.crearLabel("lblCorreo.titulo", 120, 427);
			pnlDerecha.add(lblCorreoTit);

			lblUsuarioTit = this.crearLabel("lblUsuario.titulo", 120, 525);
			pnlDerecha.add(lblUsuarioTit);

			lblIdTit = this.crearLabel("lblId.titulo", 610, 240);
			pnlDerecha.add(lblIdTit);

			lblContrasenaTit = this.crearLabel("lblContrasena.titulo", 610, 335);
			pnlDerecha.add(lblContrasenaTit);

			lblGeneroTit = this.crearLabel("lblGenero.titulo", 610, 427);
			pnlDerecha.add(lblGeneroTit);

			lblEquipoTit = this.crearLabel("lblEquipo.titulo", 610, 525);
			pnlDerecha.add(lblEquipoTit);

			lblCedula = this.crearLabel("lblCedula.perfil", 135, 274);
			pnlDerecha.add(lblCedula);

			lblNacionalidad = this.crearLabel("lblNacionalidad.perfil", 135, 369);
			pnlDerecha.add(lblNacionalidad);

			lblCorreo = this.crearLabel("lblCorreo.perfil", 135, 461);
			lblCorreo.setSize(320, 35);
			pnlDerecha.add(lblCorreo);

			lblUsuario = this.crearLabel("lblUsuario.perfil", 135, 559);
			lblUsuario.setSize(320, 35);
			pnlDerecha.add(lblUsuario);

			lblId = this.crearLabel("lblId.perfil", 625, 274);
			lblId.setSize(320, 35);
			pnlDerecha.add(lblId);

			lblContrasena = this.crearLabel("lblContrasena.perfil", 625, 369);
			pnlDerecha.add(lblContrasena);

			lblGenero = this.crearLabel("lblGenero.perfil", 625, 461);
			pnlDerecha.add(lblGenero);

			lblEquipo = this.crearLabel("lblEquipo.perfil", 625, 559);
			pnlDerecha.add(lblEquipo);

			imgDatos = "perfilDatos.jpg";

			pnlInferior.setBackground(new Color(255, 255, 255));

			btnGuardar.setVisible(false);
			btnGuardarEquipo.setVisible(false);
			break;

		case "actualizarperfildirector":

			btnImagen = this.crearBotonInvisible("Imagen Director", new Rectangle(280, 12, 165, 160), "");
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

			lblNacionalidad = this.crearLabel("lblNacionalidad.titulo", 100, 355);
			jtNacionalidad = this.crearTextFieldInvisible("lblNacionalidad.perfil", new Rectangle(120, 393, 335, 30));
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			lblCorreo = this.crearLabel("lblCorreo.titulo", 100, 435);
			jtCorreo = this.crearTextFieldInvisible("lblCorreo.perfil", new Rectangle(120, 475, 335, 30));
			pnlDerecha.add(lblCorreo);
			pnlDerecha.add(jtCorreo);

			lblUsuario = this.crearLabel("lblUsuario.titulo", 100, 515);
			jtUsuario = this.crearTextFieldInvisible("lblUsuario.perfil", new Rectangle(120, 554, 335, 30));
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

			lblEquipo = this.crearLabel("lblEquipo.titulo", 555, 435);
			jtEquipo = this.crearTextFieldInvisible("lblEquipo.perfil", new Rectangle(575, 475, 335, 30));
			jtEquipo.setEnabled(false);
			pnlDerecha.add(lblEquipo);
			pnlDerecha.add(jtEquipo);

			pnlInferior.setBackground(new Color(255, 243, 217));

			imgDatos = "perfilActDirector.jpg";

			btnGuardar.setVisible(true);
			btnGuardarEquipo.setVisible(false);

			imgCambio = false;

			aplicarFuncionesValidacion();

			break;

		case "equipo":

			lblNombre = this.crearLabel("lblNombreEquipo.titulo", 50, 50);
			jtNombre = this.crearTextField("", 50, 80);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblTiempo = this.crearLabel("lblTiempoEquipo.titulo", 300, 50);
			jtTiempo = this.crearTextField("", 300, 80);
			pnlDerecha.add(lblTiempo);
			pnlDerecha.add(jtTiempo);

			lblNacionalidad = this.crearLabel("lblPaisEquipo.titulo", 550, 50);
			jtNacionalidad = this.crearTextField("", 550, 80);
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			lblUsuario = this.crearLabel("lblCiclistasEquipo.titulo", 50, 140);
			pnlDerecha.add(lblUsuario);

			/*
			 * INTENTAR PONER LAS CARTAS DE LOS CICLISTAS
			 */

			mostrarCartas();

			btnGuardar.setVisible(false);
			btnGuardarEquipo.setVisible(true);
			imgDatos = "simulacion.jpg";

			revalidate();

			break;
		}

		imagenPanel = this.crearLabel("", new Rectangle(0, 0, 1050, 600), imgDatos);
		pnlDerecha.add(imagenPanel);

		pnlDerecha.repaint();
		pnlDerecha.revalidate();

		add(pnlDerecha);
	}

	public void iniciarPanelInferior() {
		if (pnlInferior == null) {
			pnlInferior = new JPanel();
		}
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.alto")));
		pnlInferior.setLayout(null);

		btnGuardar = this.crearBotonInvisible("Guardar Administrador", new Rectangle(720, 0, 200, 50),
				"btnGuardar.jpg");
		btnGuardarEquipo = this.crearBotonInvisible("guardarequipo", new Rectangle(220, 0, 200, 50), "btnGuardar.jpg");
		pnlInferior.add(btnGuardarEquipo);

		add(pnlInferior);
	}

	public void mostrarCartas() {
		if (lstCiclistas == null) {
			return;
		}

		DefaultTableModel tableModel = new DefaultTableModel(columnas, 0) {
			public boolean isCellEditable(int row, int col) {
				return ColumnasEditables[col];
			}

			public Class getColumnClass(int index) {
				return tipo[index];
			}
		};

		for (CiclistaDTO c : lstCiclistas) {
			Object[] data = { c.getIdentificador(), c.getNombre(), c.getCedula(), c.getRol(), c.getEspecialidad() };
			tableModel.addRow(data);
		}

		tabla = crearTable(columnas, ColumnasEditables, tableModel);
		JScrollPane jsPanel = new JScrollPane(tabla);
		jsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsPanel.setBounds(20, 200, 1000, 300);
		pnlDerecha.add(jsPanel);

	}

	public void aplicarFuncionesValidacion() {

		numeros(jtCedula);

		letras(jtNombre);
		letras(jtNacionalidad);

		limitarCaracter(jtCedula, 10);
		limitarCaracter(jtCorreo, 50);
		limitarCaracter(jtContrasena, 30);
		limitarCaracter(jtNombre, 50);
		limitarCaracter(jtNacionalidad, 40);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagendirector":
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

		case "perfildirector":

		case "actualizarperfildirector":

		case "equipo":
			opcion = e.getActionCommand();
			iniciarPanelDerecho();
			break;
		}

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

	public JLabel getLblNacionalidad() {
		return lblNacionalidad;
	}

	public void setLblNacionalidad(JLabel lblNacionalidad) {
		this.lblNacionalidad = lblNacionalidad;
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

	public JLabel getLblNacionalidadTit() {
		return lblNacionalidadTit;
	}

	public void setLblNacionalidadTit(JLabel lblNacionalidadTit) {
		this.lblNacionalidadTit = lblNacionalidadTit;
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

	public JTextField getJtNacionalidad() {
		return jtNacionalidad;
	}

	public void setJtNacionalidad(JTextField jtNacionalidad) {
		this.jtNacionalidad = jtNacionalidad;
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

	public ArrayList<CiclistaDTO> getLstCiclistas() {
		return lstCiclistas;
	}

	public void setLstCiclistas(ArrayList<CiclistaDTO> lstCiclistas) {
		this.lstCiclistas = lstCiclistas;
	}

	public VentanaUsuario getUsuarioPanel() {
		return usuarioPanel;
	}

	public void setUsuarioPanel(VentanaUsuario usuarioPanel) {
		this.usuarioPanel = usuarioPanel;
	}

	public JComboBox<String> getJcGenero() {
		return jcGenero;
	}

	public void setJcGenero(JComboBox<String> jcGenero) {
		this.jcGenero = jcGenero;
	}

	public JPanel getPnlInferior() {
		return pnlInferior;
	}

	public void setPnlInferior(JPanel pnlInferior) {
		this.pnlInferior = pnlInferior;
	}

	public boolean isImgCambio() {
		return imgCambio;
	}

	public void setImgCambio(boolean imgCambio) {
		this.imgCambio = imgCambio;
	}

	public JLabel getLblNombrePerfil() {
		return lblNombrePerfil;
	}

	public void setLblNombrePerfil(JLabel lblNombrePerfil) {
		this.lblNombrePerfil = lblNombrePerfil;
	}

	public JLabel getLblEquipo() {
		return lblEquipo;
	}

	public void setLblEquipo(JLabel lblEquipo) {
		this.lblEquipo = lblEquipo;
	}

	public JLabel getLblEquipoTit() {
		return lblEquipoTit;
	}

	public void setLblEquipoTit(JLabel lblEquipoTit) {
		this.lblEquipoTit = lblEquipoTit;
	}

	public JTextField getJtEquipo() {
		return jtEquipo;
	}

	public void setJtEquipo(JTextField jtEquipo) {
		this.jtEquipo = jtEquipo;
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

	public ArrayList<Item> getLstItemCiclistas() {
		return lstItemCiclistas;
	}

	public void setLstItemCiclistas(ArrayList<Item> lstItemCiclistas) {
		this.lstItemCiclistas = lstItemCiclistas;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public String[] getColumnas() {
		return columnas;
	}

	public void setColumnas(String[] columnas) {
		this.columnas = columnas;
	}

	public boolean[] getColumnasEditables() {
		return ColumnasEditables;
	}

	public void setColumnasEditables(boolean[] columnasEditables) {
		ColumnasEditables = columnasEditables;
	}

	public Class[] getTipo() {
		return tipo;
	}

	public void setTipo(Class[] tipo) {
		this.tipo = tipo;
	}

	public JButton getBtnGuardarEquipo() {
		return btnGuardarEquipo;
	}

	public void setBtnGuardarEquipo(JButton btnGuardarEquipo) {
		this.btnGuardarEquipo = btnGuardarEquipo;
	}

}
