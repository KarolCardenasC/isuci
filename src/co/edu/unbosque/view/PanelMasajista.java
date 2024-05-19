package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelMasajista extends MainPanel implements ActionListener {

	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;

	private JLabel lblImagenPerfil;
	private JLabel lblRol;
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblAniosExp;
	private JLabel lblCorreo;
	private JLabel lblUsuario;
	private JLabel lblId;
	private JLabel lblContrasena;
	private JLabel lblGenero;
	private JLabel lblEquipo;
	private JLabel lblCedulaTit;
	private JLabel lblAniosTit;
	private JLabel lblCorreoTit;
	private JLabel lblUsuarioTit;
	private JLabel lblIdTit;
	private JLabel lblContrasenaTit;
	private JLabel lblGeneroTit;
	private JLabel lblEquipoTit;
	private JLabel lblNombrePerfil;
	private JLabel imagenPanel;
	private JLabel imagenPanelIzq;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtAniosExp;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtEquipo;

	private JComboBox<String> jcGenero;

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	private JPanel pnlInferior;

	private String imagen = this.getProperties().getProperty("lblImagen.perfil");
	private String opcion = "perfilinicial";
	private boolean imgCambio = false;

	private VentanaUsuario usuarioPanel;

	public PanelMasajista(VentanaUsuario inicial) {

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

		pnlIzquierda.setBounds(
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);

		lblImagenPerfil = this.crearLabel("", new Rectangle(49, 31, 155, 165),
				this.getProperties().getProperty("lblImagen.perfil"));
		pnlIzquierda.add(lblImagenPerfil);

		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 5, 235);
		lblNombrePerfil.setSize(240, 60);
		lblNombrePerfil.setForeground(new Color(245, 227, 187));
		lblNombrePerfil.setHorizontalAlignment(SwingConstants.CENTER);
		pnlIzquierda.add(lblNombrePerfil);

		lblRol = this.crearLabel("lblRol.masajista", 5, 300);
		lblRol.setFont(new Font("Tahoma", Font.BOLD | Font.PLAIN, 20));
		lblRol.setForeground(Color.white);
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBotonInvisible("Perfil Masajista", new Rectangle(0, 360, 250, 65), "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBotonInvisible("Actualizar Perfil Masajista", new Rectangle(0, 426, 250, 65), "");
		pnlIzquierda.add(btnActualizar);

		btnEliminar = this.crearBotonInvisible("Eliminar Perfil Masajista", new Rectangle(0, 492, 250, 65), "");
		pnlIzquierda.add(btnEliminar);

		btnCerrar = this.crearBotonInvisible("Cerrar Sesión Masajista", new Rectangle(0, 592, 250, 68), "");
		pnlIzquierda.add(btnCerrar);

		imagenPanelIzq = this.crearLabel("", new Rectangle(0, 0, 250, 660), "izquierdaMasajista.jpg");
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
			imgDatos = "perfilInicialMasajista.jpg";
			break;

		case "perfilmasajista":

			lblImagen = this.crearLabel("", new Rectangle(425, 15, 180, 180),
					this.getProperties().getProperty("lblImagen.perfil"));
			pnlDerecha.add(lblImagen);

			lblNombre = this.crearLabel("lblNombre.perfil", 405, 180);
			lblNombre.setSize(240, 60);
			lblNombre.setForeground(new Color(71, 30, 1));
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			pnlDerecha.add(lblNombre);

			lblCedulaTit = this.crearLabel("lblCedula.titulo", 120, 240);
			pnlDerecha.add(lblCedulaTit);

			lblAniosTit = this.crearLabel("lblAniosExperiencia.titulo", 120, 335);
			pnlDerecha.add(lblAniosTit);

			lblCorreoTit = this.crearLabel("lblCorreo.titulo", 120, 427);
			pnlDerecha.add(lblCorreoTit);

			lblUsuarioTit = this.crearLabel("lblUsuario.titulo", 120, 525);
			pnlDerecha.add(lblUsuarioTit);

			lblIdTit = this.crearLabel("lblId.titulo", 610, 285);
			pnlDerecha.add(lblIdTit);

			lblContrasenaTit = this.crearLabel("lblContrasena.titulo", 610, 385);
			pnlDerecha.add(lblContrasenaTit);

			lblGeneroTit = this.crearLabel("lblGenero.titulo", 610, 480);
			pnlDerecha.add(lblGeneroTit);
			
			lblEquipoTit = this.crearLabel("lblEquipo.titulo", 610, 20);
			pnlDerecha.add(lblEquipoTit);

			lblCedula = this.crearLabel("lblCedula.perfil", 135, 274);
			pnlDerecha.add(lblCedula);

			lblAniosExp = this.crearLabel("lblAniosExperiencia.perfil", 135, 369);
			pnlDerecha.add(lblAniosExp);

			lblCorreo = this.crearLabel("lblCorreo.perfil", 135, 461);
			lblCorreo.setSize(320, 35);
			pnlDerecha.add(lblCorreo);

			lblUsuario = this.crearLabel("lblUsuario.perfil", 135, 559);
			lblUsuario.setSize(320, 35);
			pnlDerecha.add(lblUsuario);

			lblId = this.crearLabel("lblId.perfil", 625, 317);
			lblId.setSize(320, 35);
			pnlDerecha.add(lblId);

			lblContrasena = this.crearLabel("lblContrasena.perfil", 625, 417);
			pnlDerecha.add(lblContrasena);

			lblGenero = this.crearLabel("lblGenero.perfil", 625, 512);
			pnlDerecha.add(lblGenero);
			
			lblEquipo = this.crearLabel("lblEquipo.perfil", 625, 52);
			pnlDerecha.add(lblEquipo);
			
			imgDatos = "perfilDatosMasajista.jpg";

			btnGuardar.setVisible(false);

			break;

		case "actualizarperfilmasajista":

			lblImagen = this.crearLabel("", new Rectangle(425, 20, 150, 150), "actualizarImagen.png");
			btnImagen = this.crearBoton("Imagen Masajista", 400, 180, "");
			pnlDerecha.add(lblImagen);
			pnlDerecha.add(btnImagen);

			lblNombre = this.crearLabel("lblNombre.titulo", 200, 270);
			jtNombre = this.crearTextField("lblNombre.perfil", 200, 300);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblCedula = this.crearLabel("lblCedula.titulo", 200, 350);
			jtCedula = this.crearTextField("lblCedula.perfil", 200, 380);
			jtCedula.setEnabled(false);
			pnlDerecha.add(lblCedula);
			pnlDerecha.add(jtCedula);

			lblAniosExp = this.crearLabel("lblAniosExperiencia.titulo", 200, 430);
			jtAniosExp = this.crearTextField("lblAniosExperiencia.perfil", 200, 460);
			pnlDerecha.add(lblAniosExp);
			pnlDerecha.add(jtAniosExp);

			lblCorreo = this.crearLabel("lblCorreo.titulo", 200, 510);
			jtCorreo = this.crearTextField("lblCorreo.perfil", 200, 540);
			pnlDerecha.add(lblCorreo);
			pnlDerecha.add(jtCorreo);

			lblUsuario = this.crearLabel("lblUsuario.titulo", 600, 270);
			jtUsuario = this.crearTextField("lblUsuario.perfil", 600, 300);
			jtUsuario.setEnabled(false);
			pnlDerecha.add(lblUsuario);
			pnlDerecha.add(jtUsuario);

			lblId = this.crearLabel("lblId.titulo", 600, 350);
			jtId = this.crearTextField("lblId.perfil", 600, 380);
			jtId.setEnabled(false);
			pnlDerecha.add(lblId);
			pnlDerecha.add(jtId);

			lblContrasena = this.crearLabel("lblContrasena.titulo", 600, 430);
			jtContrasena = this.crearTextField("lblContrasena.perfil", 600, 460);
			pnlDerecha.add(lblContrasena);
			pnlDerecha.add(jtContrasena);

			String[] listaGenero = { "Hombre", "Mujer" };

			lblGenero = this.crearLabel("lblGenero.titulo", 600, 510);
			jcGenero = this.crearComboBox(listaGenero, 600, 540);
			if (this.getProperties().getProperty("lblGenero.perfil").contains("Hombre")) {
				jcGenero.setSelectedIndex(0);
			} else {
				jcGenero.setSelectedIndex(1);
			}
			pnlDerecha.add(lblGenero);
			pnlDerecha.add(jcGenero);
			
			lblEquipo = this.crearLabel("lblEquipo.titulo", 600, 20);
			jtEquipo = this.crearTextField("lblEquipo.perfil", 600, 52);
			pnlDerecha.add(lblEquipo);
			pnlDerecha.add(jtEquipo);
			
			imgDatos = "perfilActMasajista.jpg";

			btnGuardar.setVisible(true);

			imgCambio = false;

			aplicarFuncionesValidacion();

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

		btnGuardar = this.crearBoton("Guardar Masajista", 750, 10, "");
		pnlInferior.add(btnGuardar);

		imagenPanel = this.crearLabel("", new Rectangle(0, 0, 1050, 600), "panelInferior.jpg");
		pnlInferior.add(imagenPanel);

		add(pnlInferior);
	}

	public void aplicarFuncionesValidacion() {

		numeros(jtCedula);
		numeros(jtAniosExp);

		letras(jtNombre);

		limitarCaracter(jtCedula, 10);
		limitarCaracter(jtCorreo, 50);
		limitarCaracter(jtContrasena, 30);
		limitarCaracter(jtNombre, 50);
		limitarCaracter(jtAniosExp, 2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagenmasajista":
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

		case "perfilmasajista":

		case "actualizarperfilmasajista":

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

	public JLabel getLblAniosExp() {
		return lblAniosExp;
	}

	public void setLblAniosExp(JLabel lblAniosExp) {
		this.lblAniosExp = lblAniosExp;
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

	public JTextField getJtAniosExp() {
		return jtAniosExp;
	}

	public void setJtAniosExp(JTextField jtAniosExp) {
		this.jtAniosExp = jtAniosExp;
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

	public JLabel getLblCedulaTit() {
		return lblCedulaTit;
	}

	public void setLblCedulaTit(JLabel lblCedulaTit) {
		this.lblCedulaTit = lblCedulaTit;
	}

	public JLabel getLblAniosTit() {
		return lblAniosTit;
	}

	public void setLblAniosTit(JLabel lblAniosTit) {
		this.lblAniosTit = lblAniosTit;
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

	public JLabel getLblNombrePerfil() {
		return lblNombrePerfil;
	}

	public void setLblNombrePerfil(JLabel lblNombrePerfil) {
		this.lblNombrePerfil = lblNombrePerfil;
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
}
