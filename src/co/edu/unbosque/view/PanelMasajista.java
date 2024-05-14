package co.edu.unbosque.view;

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
	private JLabel lblCedulaTit;
	private JLabel lblAniosTit;
	private JLabel lblCorreoTit;
	private JLabel lblUsuarioTit;
	private JLabel lblIdTit;
	private JLabel lblContrasenaTit;
	private JLabel lblGeneroTit;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtAniosExp;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;

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

		lblRol = this.crearLabel("lblRol.masajista", 90, 210);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBoton("Perfil Masajista", 20, 350, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Perfil Masajista", 20, 400, "");
		pnlIzquierda.add(btnActualizar);

		btnEliminar = this.crearBoton("Eliminar Perfil Masajista", 20, 450, "");
		pnlIzquierda.add(btnEliminar);

		btnCerrar = this.crearBoton("Cerrar Sesión Masajista", 20, 600, "");
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
			lblImagen = this.crearLabel("", new Rectangle(200, 20, 600, 600), "masajistaIni.png");
			pnlDerecha.add(lblImagen);
			break;

		case "perfilmasajista":

			lblImagen = this.crearLabel("", new Rectangle(425, 50, 150, 150),
					this.getProperties().getProperty("lblImagen.perfil"));
			pnlDerecha.add(lblImagen);

			lblNombre = this.crearLabel("lblNombre.perfil", 425, 230);
			pnlDerecha.add(lblNombre);

			lblCedulaTit = this.crearLabel("lblCedula.titulo", 200, 300);
			pnlDerecha.add(lblCedulaTit);

			lblAniosTit = this.crearLabel("lblAniosExperiencia.titulo", 200, 370);
			pnlDerecha.add(lblAniosTit);

			lblCorreoTit = this.crearLabel("lblCorreo.titulo", 200, 440);
			pnlDerecha.add(lblCorreoTit);

			lblUsuarioTit = this.crearLabel("lblUsuario.titulo", 200, 510);
			pnlDerecha.add(lblUsuarioTit);

			lblIdTit = this.crearLabel("lblId.titulo", 600, 300);
			pnlDerecha.add(lblIdTit);

			lblContrasenaTit = this.crearLabel("lblContrasena.titulo", 600, 370);
			pnlDerecha.add(lblContrasenaTit);

			lblGeneroTit = this.crearLabel("lblGenero.titulo", 600, 440);
			pnlDerecha.add(lblGeneroTit);

			lblCedula = this.crearLabel("lblCedula.perfil", 200, 320);
			pnlDerecha.add(lblCedula);

			lblAniosExp = this.crearLabel("lblAniosExperiencia.perfil", 200, 390);
			pnlDerecha.add(lblAniosExp);

			lblCorreo = this.crearLabel("lblCorreo.perfil", 200, 460);
			pnlDerecha.add(lblCorreo);

			lblUsuario = this.crearLabel("lblUsuario.perfil", 200, 530);
			pnlDerecha.add(lblUsuario);

			lblId = this.crearLabel("lblId.perfil", 600, 320);
			pnlDerecha.add(lblId);

			lblContrasena = this.crearLabel("lblContrasena.perfil", 600, 390);
			pnlDerecha.add(lblContrasena);

			lblGenero = this.crearLabel("lblGenero.perfil", 600, 460);
			pnlDerecha.add(lblGenero);

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
			pnlDerecha.add(lblUsuario);
			pnlDerecha.add(jtUsuario);

			lblId = this.crearLabel("lblId.titulo", 600, 350);
			jtId = this.crearTextField("lblId.perfil", 600, 380);
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

			imgCambio = false;

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

		btnGuardar = this.crearBoton("Guardar Masajista", 750, 10, "");
		pnlInferior.add(btnGuardar);

		add(pnlInferior);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagenmasajista":
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

		case "perfilmasajista":

		case "actualizarperfilmasajista":
			
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
}
