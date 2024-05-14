package co.edu.unbosque.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelRol extends MainPanel implements ActionListener {

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	private JPanel pnlInferior;

	private JLabel lblContrasena;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblCedula;
	private JLabel lblGenero;
	private JLabel lblIdentificador;
	private JLabel lblAniosExperiencia;
	private JLabel lblEspecialidad;
	private JLabel lblContextura;
	private JLabel lblNacionalidad;
	private JLabel imagen;

	private JButton btnCiclista;
	private JButton btnMasajista;
	private JButton btnDirector;
	private JButton btnRegistro;
	private JButton btnVolver;

	private JTextField jtContrasena;
	private JTextField jtNombre;
	private JTextField jtCorreo;
	private JTextField jtCedula;
	private JTextField jtIdentificador;
	private JTextField jtAniosExperiencia;
	private JTextField jtNacionalidad;

	private JComboBox<String> jcGenero;
	private JComboBox<String> jcEspecialidad;
	private JComboBox<String> jcContextura;

	private VentanaInicial mainPanel;

	private String opcion = "ciclista";

	public PanelRol(VentanaInicial inicial) {
		this.setProperties(
				FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		mainPanel = inicial;
		setLayout(null);
		initComponents();
	}

	public void initComponents() {

		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();
		iniciarPanelInferior();
		aplicarFuncionesValidacion();

	}

	public void iniciarPanelIzquierdo() {
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);

		btnCiclista = this.crearBotonInvisible("Ciclista", new Rectangle(92, 53, 135, 172), "");
		pnlIzquierda.add(btnCiclista);

		btnMasajista = this.crearBotonInvisible("Masajista", new Rectangle(88, 260, 140, 179), "");
		pnlIzquierda.add(btnMasajista);

		btnDirector = this.crearBotonInvisible("Director", new Rectangle(89, 474, 140, 179), "");
		pnlIzquierda.add(btnDirector);

		imagen = this.crearLabel("", new Rectangle(0, 0, 300, 700), "roles.jpg");
		pnlIzquierda.add(imagen);

		add(pnlIzquierda);
	}

	public void iniciarPanelDerecho() {
		if (pnlDerecha == null) {
			pnlDerecha = new JPanel();
		} else {
			pnlDerecha.removeAll();
		}
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.alto")));
		pnlDerecha.setLayout(null);

		lblNombre = this.crearLabel("lblNombre.titulo", 90, 105);
		jtNombre = this.crearTextFieldInvisible("", new Rectangle(95, 138, 180, 30));
		pnlDerecha.add(lblNombre);
		pnlDerecha.add(jtNombre);

		lblCedula = this.crearLabel("lblCedula.titulo", 415, 105);
		jtCedula = this.crearTextFieldInvisible("", new Rectangle(420, 138, 180, 30));
		pnlDerecha.add(lblCedula);
		pnlDerecha.add(jtCedula);

		String[] listaGenero = { "Hombre", "Mujer" };

		lblGenero = this.crearLabel("lblGenero.titulo", 90, 205);
		jcGenero = this.crearComboBoxInvisible(listaGenero, new Rectangle(95, 238, 180, 30));
		pnlDerecha.add(lblGenero);
		pnlDerecha.add(jcGenero);

		lblCorreo = this.crearLabel("lblCorreo.titulo", 415, 205);
		jtCorreo = this.crearTextFieldInvisible("", new Rectangle(420, 238, 180, 30));
		pnlDerecha.add(lblCorreo);
		pnlDerecha.add(jtCorreo);

		lblContrasena = this.crearLabel("lblContrasena.titulo", 90, 305);
		jtContrasena = this.crearTextFieldInvisible("", new Rectangle(95, 339, 180, 30));
		pnlDerecha.add(lblContrasena);
		pnlDerecha.add(jtContrasena);

		String imgDatos = "";

		switch (opcion) {
		case "ciclista":

			lblIdentificador = this.crearLabel("lblIdentificador.titulo", 415, 304);
			jtIdentificador = this.crearTextFieldInvisible("", new Rectangle(420, 336, 180, 30));
			pnlDerecha.add(lblIdentificador);
			pnlDerecha.add(jtIdentificador);

			lblAniosExperiencia = this.crearLabel("lblAniosExperiencia.titulo", 90, 408);
			jtAniosExperiencia = this.crearTextFieldInvisible("", new Rectangle(95, 443, 180, 30));
			pnlDerecha.add(lblAniosExperiencia);
			pnlDerecha.add(jtAniosExperiencia);

			String[] listaEspecialidad = { "Ninguna", "Clasicomano", "Contrarrelojero", "Escalador", "Gregario",
					"Rodador", "Sprinter" };
			String[] listaContextura = { "Ninguna", "Delgado", "Medio", "Grueso" };

			lblEspecialidad = this.crearLabel("lblEspecialidad.titulo", 90, 510);
			jcEspecialidad = this.crearComboBoxInvisible(listaEspecialidad, new Rectangle(95, 548, 180, 30));
			pnlDerecha.add(lblEspecialidad);
			pnlDerecha.add(jcEspecialidad);

			lblContextura = this.crearLabel("lblContextura.titulo", 415, 407);
			jcContextura = this.crearComboBoxInvisible(listaContextura, new Rectangle(420, 443, 180, 30));
			pnlDerecha.add(lblContextura);
			pnlDerecha.add(jcContextura);

			imgDatos = "datosCic.jpg";

			break;

		case "masajista":

			lblAniosExperiencia = this.crearLabel("lblAniosExperiencia.titulo", 415, 303);
			jtAniosExperiencia = this.crearTextFieldInvisible("", new Rectangle(420, 336, 180, 30));
			pnlDerecha.add(lblAniosExperiencia);
			pnlDerecha.add(jtAniosExperiencia);

			imgDatos = "datosGeneral.jpg";

			break;

		case "director":

			lblNacionalidad = this.crearLabel("lblNacionalidad.titulo", 415, 303);
			jtNacionalidad = this.crearTextFieldInvisible("", new Rectangle(420, 335, 180, 30));
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			imgDatos = "datosGeneral.jpg";

			break;
		}

		imagen = this.crearLabel("", new Rectangle(0, 0, 700, 600), imgDatos);
		pnlDerecha.add(imagen);

		pnlDerecha.repaint();
		pnlDerecha.validate();

		add(pnlDerecha);
	}

	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.alto")));
		pnlInferior.setLayout(null);

		btnRegistro = this.crearBotonInvisible("Registro", new Rectangle(481, 5, 60, 53), "");
		pnlInferior.add(btnRegistro);

		btnVolver = this.crearBotonInvisible("Volver Login", new Rectangle(191, 5, 60, 53), "");
		pnlInferior.add(btnVolver);

		imagen = this.crearLabel("", new Rectangle(0, 0, 700, 65), "botonesRol.jpg");
		pnlInferior.add(imagen);

		add(pnlInferior);
	}

	public void aplicarFuncionesValidacion() {
		
		numeros(jtCedula);
		
		letras(jtNombre);
		
		limitarCaracter(jtCedula, 10);
		limitarCaracter(jtCorreo, 40);
		limitarCaracter(jtContrasena, 20);
		limitarCaracter(jtNombre, 40);

		switch (opcion) {
		case "ciclista":
			numeros(jtAniosExperiencia);
			numeros(jtIdentificador);

			limitarCaracter(jtAniosExperiencia, 2);
			limitarCaracter(jtIdentificador, 5);
			break;

		case "masajista":
			numeros(jtAniosExperiencia);

			limitarCaracter(jtAniosExperiencia, 2);
			limitarCaracter(jtIdentificador, 2);
			break;

		case "director":
			letras(jtNacionalidad);
			limitarCaracter(jtNacionalidad, 30);
			break;
		}

	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "volverlogin":
			mainPanel.panelLogin();
			break;

		case "ciclista":
		case "masajista":
		case "director":
			opcion = e.getActionCommand();
			break;
		}

		iniciarPanelDerecho();
		aplicarFuncionesValidacion();

	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
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

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblIdentificador() {
		return lblIdentificador;
	}

	public void setLblIdentificador(JLabel lblIdentificador) {
		this.lblIdentificador = lblIdentificador;
	}

	public JLabel getLblAniosExperiencia() {
		return lblAniosExperiencia;
	}

	public void setLblAniosExperiencia(JLabel lblAniosExperiencia) {
		this.lblAniosExperiencia = lblAniosExperiencia;
	}

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public void setLblEspecialidad(JLabel lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	public JLabel getLblContextura() {
		return lblContextura;
	}

	public void setLblContextura(JLabel lblContextura) {
		this.lblContextura = lblContextura;
	}

	public JLabel getLblNacionalidad() {
		return lblNacionalidad;
	}

	public void setLblNacionalidad(JLabel lblNacionalidad) {
		this.lblNacionalidad = lblNacionalidad;
	}

	public JButton getBtnCiclista() {
		return btnCiclista;
	}

	public void setBtnCiclista(JButton btnCiclista) {
		this.btnCiclista = btnCiclista;
	}

	public JButton getBtnMasajista() {
		return btnMasajista;
	}

	public void setBtnMasajista(JButton btnMasajista) {
		this.btnMasajista = btnMasajista;
	}

	public JButton getBtnDirector() {
		return btnDirector;
	}

	public void setBtnDirector(JButton btnDirector) {
		this.btnDirector = btnDirector;
	}

	public JTextField getJtContrasena() {
		return jtContrasena;
	}

	public void setJtContrasena(JTextField jtContrasena) {
		this.jtContrasena = jtContrasena;
	}

	public JTextField getJtNombre() {
		return jtNombre;
	}

	public void setJtNombre(JTextField jtNombre) {
		this.jtNombre = jtNombre;
	}

	public JTextField getJtCorreo() {
		return jtCorreo;
	}

	public void setJtCorreo(JTextField jtCorreo) {
		this.jtCorreo = jtCorreo;
	}

	public JTextField getJtCedula() {
		return jtCedula;
	}

	public void setJtCedula(JTextField jtCedula) {
		this.jtCedula = jtCedula;
	}

	public JTextField getJtIdentificador() {
		return jtIdentificador;
	}

	public void setJtIdentificador(JTextField jtIdentificador) {
		this.jtIdentificador = jtIdentificador;
	}

	public JTextField getJtAniosExperiencia() {
		return jtAniosExperiencia;
	}

	public void setJtAniosExperiencia(JTextField jtAniosExperiencia) {
		this.jtAniosExperiencia = jtAniosExperiencia;
	}

	public JTextField getJtNacionalidad() {
		return jtNacionalidad;
	}

	public void setJtNacionalidad(JTextField jtNacionalidad) {
		this.jtNacionalidad = jtNacionalidad;
	}

	public VentanaInicial getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(VentanaInicial mainPanel) {
		this.mainPanel = mainPanel;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public JComboBox<String> getJcGenero() {
		return jcGenero;
	}

	public void setJcGenero(JComboBox<String> jcGenero) {
		this.jcGenero = jcGenero;
	}

	public JComboBox<String> getJcEspecialidad() {
		return jcEspecialidad;
	}

	public void setJcEspecialidad(JComboBox<String> jcEspecialidad) {
		this.jcEspecialidad = jcEspecialidad;
	}

	public JComboBox<String> getJcContextura() {
		return jcContextura;
	}

	public void setJcContextura(JComboBox<String> jcContextura) {
		this.jcContextura = jcContextura;
	}

}
