package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.FileHandler;

public class PanelDirector extends MainPanel implements ActionListener {

	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnEquipo;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;

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
	private JLabel lblCedulaTit;
	private JLabel lblNacionalidadTit;
	private JLabel lblCorreoTit;
	private JLabel lblUsuarioTit;
	private JLabel lblIdTit;
	private JLabel lblContrasenaTit;
	private JLabel lblGeneroTit;
	private JLabel lblTiempo;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtNacionalidad;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtTiempo;

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
	private Item newItem;
	private ArrayList<CiclistaDTO> lstCiclistas;

	private VentanaUsuario usuarioPanel;

	public PanelDirector(VentanaUsuario inicial) {

		this.setProperties(FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties"));
		lstCiclistas = new ArrayList<>();
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daaniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(
				new CiclistaDTO("masajista.png", "Maria vValentina Osorio Romero", 1001425987, "maOsoa62@gmail.com",
						"maOsoa62@gmail.com", "0321", "vale214", "Mujer", 0214, 13, 1.20, "Escalador", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daaniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(
				new CiclistaDTO("masajista.png", "Maria vValentina Osorio Romero", 1001425987, "maOsoa62@gmail.com",
						"maOsoa62@gmail.com", "0321", "vale214", "Mujer", 0214, 13, 1.20, "Escalador", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daaniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(
				new CiclistaDTO("masajista.png", "Maria vValentina Osorio Romero", 1001425987, "maOsoa62@gmail.com",
						"maOsoa62@gmail.com", "0321", "vale214", "Mujer", 0214, 13, 1.20, "Escalador", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		usuarioPanel = inicial;
		setLayout(null);
		initComponents();

	}

	public void initComponents() {
		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();
		iniciarPanelInferior();

	}

	public void iniciarPanelIzquierdo() {

		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);

		lblImagenPerfil = this.crearLabel("", new Rectangle(55, 50, 150, 150),
				this.getProperties().getProperty("lblImagen.perfil"));
		pnlIzquierda.add(lblImagenPerfil);

		lblRol = this.crearLabel("lblRol.director", 55, 210);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBoton("Perfil Director", 20, 300, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Perfil Director", 20, 350, "");
		pnlIzquierda.add(btnActualizar);

		btnEliminar = this.crearBoton("Eliminar Perfil Director", 20, 400, "");
		pnlIzquierda.add(btnEliminar);

		btnEquipo = this.crearBoton("Equipo", 20, 450, "");
		pnlIzquierda.add(btnEquipo);

		btnCerrar = this.crearBoton("Cerrar Sesión Director", 20, 600, "");
		pnlIzquierda.add(btnCerrar);

		add(pnlIzquierda);
	}

	public void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);

		switch (opcion) {

		case "perfilinicial":
			lblImagen = this.crearLabel("", new Rectangle(200, 20, 600, 600), "directorIni.png");
			pnlDerecha.add(lblImagen);
			break;

		case "perfildirector":

			lblImagen = this.crearLabel("", new Rectangle(425, 50, 150, 150),
					this.getProperties().getProperty("lblImagen.perfil"));
			pnlDerecha.add(lblImagen);

			lblNombre = this.crearLabel("lblNombre.perfil", 425, 230);
			pnlDerecha.add(lblNombre);

			lblCedulaTit = this.crearLabel("lblCedula.titulo", 150, 300);
			pnlDerecha.add(lblCedulaTit);

			lblNacionalidadTit = this.crearLabel("lblNacionalidad.titulo", 150, 350);
			pnlDerecha.add(lblNacionalidadTit);

			lblCorreoTit = this.crearLabel("lblCorreo.titulo", 150, 400);
			pnlDerecha.add(lblCorreoTit);

			lblUsuarioTit = this.crearLabel("lblUsuario.titulo", 150, 450);
			pnlDerecha.add(lblUsuarioTit);

			lblIdTit = this.crearLabel("lblId.titulo", 150, 500);
			pnlDerecha.add(lblIdTit);

			lblContrasenaTit = this.crearLabel("lblContrasena.titulo", 150, 550);
			pnlDerecha.add(lblContrasenaTit);

			lblGeneroTit = this.crearLabel("lblGenero.titulo", 150, 600);
			pnlDerecha.add(lblGeneroTit);

			lblCedula = this.crearLabel("lblCedula.perfil", 400, 300);
			pnlDerecha.add(lblCedula);

			lblNacionalidad = this.crearLabel("lblNacionalidad.perfil", 400, 350);
			pnlDerecha.add(lblNacionalidad);

			lblCorreo = this.crearLabel("lblCorreo.perfil", 400, 400);
			pnlDerecha.add(lblCorreo);

			lblUsuario = this.crearLabel("lblUsuario.perfil", 400, 450);
			pnlDerecha.add(lblUsuario);

			lblId = this.crearLabel("lblId.perfil", 400, 500);
			pnlDerecha.add(lblId);

			lblContrasena = this.crearLabel("lblContrasena.perfil", 400, 550);
			pnlDerecha.add(lblContrasena);

			lblGenero = this.crearLabel("lblGenero.perfil", 400, 600);
			pnlDerecha.add(lblGenero);

			break;

		case "actualizarperfildirector":

			lblImagen = this.crearLabel("", new Rectangle(425, 20, 150, 150), "actualizarImagen.png");
			btnImagen = this.crearBoton("Imagen Director", 400, 180, "");
			pnlDerecha.add(lblImagen);
			pnlDerecha.add(btnImagen);

			lblNombre = this.crearLabel("lblNombre.titulo", 200, 300);
			jtNombre = this.crearTextField("lblNombre.perfil", 200, 330);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblCedula = this.crearLabel("lblCedula.titulo", 200, 380);
			jtCedula = this.crearTextField("lblCedula.perfil", 200, 410);
			pnlDerecha.add(lblCedula);
			pnlDerecha.add(jtCedula);

			lblNacionalidad = this.crearLabel("lblNacionalidad.titulo", 200, 460);
			jtNacionalidad = this.crearTextField("lblNacionalidad.perfil", 200, 490);
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			lblCorreo = this.crearLabel("lblCorreo.titulo", 200, 540);
			jtCorreo = this.crearTextField("lblCorreo.perfil", 200, 570);
			pnlDerecha.add(lblCorreo);
			pnlDerecha.add(jtCorreo);

			lblUsuario = this.crearLabel("lblUsuario.titulo", 500, 300);
			jtUsuario = this.crearTextField("lblUsuario.perfil", 500, 330);
			pnlDerecha.add(lblUsuario);
			pnlDerecha.add(jtUsuario);

			lblId = this.crearLabel("lblId.titulo", 500, 380);
			jtId = this.crearTextField("lblId.perfil", 500, 410);
			pnlDerecha.add(lblId);
			pnlDerecha.add(jtId);

			lblContrasena = this.crearLabel("lblContrasena.titulo", 500, 460);
			jtContrasena = this.crearTextField("lblContrasena.perfil", 500, 490);
			pnlDerecha.add(lblContrasena);
			pnlDerecha.add(jtContrasena);

			String[] listaGenero = { "Hombre", "Mujer" };

			lblGenero = this.crearLabel("lblGenero.titulo", 500, 540);
			jcGenero = this.crearComboBox(listaGenero, 500, 570);
			if (this.getProperties().getProperty("lblGenero.perfil").contains("Hombre")) {
				jcGenero.setSelectedIndex(0);
			} else {
				jcGenero.setSelectedIndex(1);
			}
			pnlDerecha.add(lblGenero);
			pnlDerecha.add(jcGenero);

			imgCambio = false;

			break;

		case "equipo":

			lblNombre = this.crearLabel("lblNombreEquipo.titulo", 50, 50);
			jtNombre = this.crearTextField("", 200, 50);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblTiempo = this.crearLabel("lblTiempoEquipo.titulo", 50, 100);
			jtTiempo = this.crearTextField("", 200, 100);
			pnlDerecha.add(lblTiempo);
			pnlDerecha.add(jtTiempo);

			lblNacionalidad = this.crearLabel("lblPaisEquipo.titulo", 450, 50);
			jtNacionalidad = this.crearTextField("", 600, 50);
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			lblUsuario = this.crearLabel("lblCiclistasEquipo.titulo", 50, 170);
			pnlDerecha.add(lblUsuario);

			/*
			 * INTENTAR PONER LAS CARTAS DE LOS CICLISTAS
			 */

			mostrarCartas();

			revalidate();

			break;
		}

		add(pnlDerecha);
	}

	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.alto")));
		pnlInferior.setLayout(null);

		btnGuardar = this.crearBoton("Guardar Director", 750, 10, "");
		pnlInferior.add(btnGuardar);

		add(pnlInferior);
	}

	public void mostrarCartas() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 200, 940, 440);

		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(null);
		generalPanel.setBackground(Color.WHITE);

		int x = 80;
		int y = 60;
		int heightFinal = lstCiclistas.size();

		for (CiclistaDTO ciclista : lstCiclistas) {
			newItem = new Item(ciclista);
			generalPanel.add(newItem.getItem(x, y));

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

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagendirector":
			JFileChooser eleccion = new JFileChooser();

			eleccion.setCurrentDirectory(new File("imgs"));
			eleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);

			eleccion.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY, new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					File folderSelec = eleccion.getCurrentDirectory();
					if (!folderSelec.getAbsolutePath().equals("imgs")) {

						eleccion.setCurrentDirectory(new File("imgs"));
					}
				}
			});

			int resultado = eleccion.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				String nombreArchivo = eleccion.getSelectedFile().getName();
				imagen = nombreArchivo;
				imgCambio = true;

			}

			break;

		case "perfildirector":

		case "actualizarperfildirector":

		case "equipo":
			opcion = e.getActionCommand();
			pnlDerecha.removeAll();
			iniciarPanelDerecho();
			pnlDerecha.repaint();
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

}
