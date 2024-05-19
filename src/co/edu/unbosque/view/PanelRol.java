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

/**
 * The {@code PanelRol} class represents a user interface panel for role
 * selection and user registration in a cycling team application. This class
 * extends {@link MainPanel} and implements {@link ActionListener} to handle
 * user actions and interactions with the UI components.
 * 
 * @see MainPanel
 * @see ActionListener
 * @see FileHandler
 * 
 */

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

	private String opcion = "CICLISTA";

	/**
	 * Constructs a new {@code PanelRol} with the specified initial panel.
	 *
	 * @param inicial the initial panel to interact with
	 */

	public PanelRol(VentanaInicial inicial) {
		this.setProperties(
				FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		mainPanel = inicial;
		setLayout(null);
		initComponents();
	}

	/**
	 * Initializes the components of the panel.
	 */

	public void initComponents() {

		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();
		iniciarPanelInferior();
		aplicarFuncionesValidacion();

	}

	/**
	 * Initializes the left panel.
	 */

	public void iniciarPanelIzquierdo() {
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);

		btnCiclista = this.crearBotonInvisible("Ciclista", new Rectangle(12, 155, 272, 102), "");
		pnlIzquierda.add(btnCiclista);

		btnMasajista = this.crearBotonInvisible("Masajista", new Rectangle(12, 330, 275, 102), "");
		pnlIzquierda.add(btnMasajista);

		btnDirector = this.crearBotonInvisible("Director", new Rectangle(12, 505, 275, 105), "");
		pnlIzquierda.add(btnDirector);

		btnVolver = this.crearBotonInvisible("Volver Login", new Rectangle(16, 35, 180, 60), "");
		pnlIzquierda.add(btnVolver);

		imagen = this.crearLabel("", new Rectangle(0, 0, 300, 660), "rolesRegistro.jpg");
		pnlIzquierda.add(imagen);

		add(pnlIzquierda);
	}

	/**
	 * Initializes the right panel based on the selected role.
	 */

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

		lblNombre = this.crearLabel("lblNombre.titulo", 60, 125);
		jtNombre = this.crearTextFieldInvisible("", new Rectangle(70, 165, 210, 30));
		pnlDerecha.add(lblNombre);
		pnlDerecha.add(jtNombre);

		lblCedula = this.crearLabel("lblCedula.titulo", 390, 125);
		jtCedula = this.crearTextFieldInvisible("", new Rectangle(400, 165, 235, 30));
		pnlDerecha.add(lblCedula);
		pnlDerecha.add(jtCedula);

		String[] listaGenero = { "Hombre", "Mujer" };

		lblGenero = this.crearLabel("lblGenero.titulo", 60, 215);
		jcGenero = this.crearComboBoxInvisible(listaGenero, new Rectangle(70, 255, 215, 30));
		pnlDerecha.add(lblGenero);
		pnlDerecha.add(jcGenero);

		lblCorreo = this.crearLabel("lblCorreo.titulo", 390, 215);
		jtCorreo = this.crearTextFieldInvisible("", new Rectangle(400, 255, 210, 30));
		pnlDerecha.add(lblCorreo);
		pnlDerecha.add(jtCorreo);

		lblContrasena = this.crearLabel("lblContrasena.titulo", 60, 315);
		jtContrasena = this.crearTextFieldInvisible("", new Rectangle(70, 355, 210, 30));
		pnlDerecha.add(lblContrasena);
		pnlDerecha.add(jtContrasena);

		String imgDatos = "";

		switch (opcion) {
		case "CICLISTA":

			lblIdentificador = this.crearLabel("lblIdentificador.titulo", 390, 315);
			jtIdentificador = this.crearTextFieldInvisible("", new Rectangle(400, 355, 230, 30));
			pnlDerecha.add(lblIdentificador);
			pnlDerecha.add(jtIdentificador);

			lblAniosExperiencia = this.crearLabel("lblAniosExperiencia.titulo", 60, 420);
			jtAniosExperiencia = this.crearTextFieldInvisible("", new Rectangle(70, 460, 230, 30));
			pnlDerecha.add(lblAniosExperiencia);
			pnlDerecha.add(jtAniosExperiencia);

			String[] listaEspecialidad = { "Ninguna", "Clasicomano", "Contrarrelojero", "Escalador", "Gregario",
					"Rodador", "Sprinter" };
			String[] listaContextura = { "Ninguna", "Delgado", "Medio", "Grueso" };

			lblEspecialidad = this.crearLabel("lblEspecialidad.titulo", 60, 525);
			jcEspecialidad = this.crearComboBoxInvisible(listaEspecialidad, new Rectangle(70, 563, 215, 30));
			pnlDerecha.add(lblEspecialidad);
			pnlDerecha.add(jcEspecialidad);

			lblContextura = this.crearLabel("lblContextura.titulo", 390, 420);
			jcContextura = this.crearComboBoxInvisible(listaContextura, new Rectangle(405, 460, 215, 30));
			pnlDerecha.add(lblContextura);
			pnlDerecha.add(jcContextura);

			imgDatos = "datosCiclista.jpg";

			break;

		case "MASAJISTA":

			lblAniosExperiencia = this.crearLabel("lblAniosExperiencia.titulo", 390, 315);
			jtAniosExperiencia = this.crearTextFieldInvisible("", new Rectangle(400, 355, 230, 30));
			pnlDerecha.add(lblAniosExperiencia);
			pnlDerecha.add(jtAniosExperiencia);

			imgDatos = "datosGenerales.jpg";

			break;

		case "DIRECTOR":

			lblNacionalidad = this.crearLabel("lblNacionalidad.titulo", 390, 315);
			jtNacionalidad = this.crearTextFieldInvisible("", new Rectangle(400, 355, 220, 30));
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			imgDatos = "datosGenerales.jpg";

			break;
		}

		imagen = this.crearLabel("", new Rectangle(0, 0, 680, 600), imgDatos);
		pnlDerecha.add(imagen);

		pnlDerecha.repaint();
		pnlDerecha.validate();

		add(pnlDerecha);
	}

	/**
	 * Initializes the lower panel of the user interface. Sets the bounds and layout
	 * of the panel and adds the necessary components including the "Registro"
	 * button and an image label.
	 */

	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.alto")));
		pnlInferior.setLayout(null);

		btnRegistro = this.crearBotonInvisible("Registro", new Rectangle(455, 3, 175, 53), "");
		pnlInferior.add(btnRegistro);

		/*
		 * btnVolver = this.crearBotonInvisible("Volver Login", new Rectangle(191, 5,
		 * 60, 53), ""); pnlInferior.add(btnVolver);
		 */

		imagen = this.crearLabel("", new Rectangle(0, 0, 680, 60), "botonRoles.jpg");
		pnlInferior.add(imagen);

		add(pnlInferior);
	}

	/**
	 * Applies validation functions to various input fields in the user interface.
	 * Sets constraints on the type and length of input allowed in the fields based
	 * on the selected role (CICLISTA, MASAJISTA, DIRECTOR).
	 */

	public void aplicarFuncionesValidacion() {

		numeros(jtCedula);

		letras(jtNombre);

		limitarCaracter(jtCedula, 10);
		limitarCaracter(jtCorreo, 50);
		limitarCaracter(jtContrasena, 30);
		limitarCaracter(jtNombre, 50);

		switch (opcion) {
		case "CICLISTA":
			numeros(jtAniosExperiencia);
			numeros(jtIdentificador);

			limitarCaracter(jtAniosExperiencia, 2);
			limitarCaracter(jtIdentificador, 5);
			break;

		case "MASAJISTA":
			numeros(jtAniosExperiencia);

			limitarCaracter(jtAniosExperiencia, 2);
			break;

		case "DIRECTOR":
			letras(jtNacionalidad);

			limitarCaracter(jtNacionalidad, 40);
			break;
		}

	}

	/**
	 * Handles action events triggered by user interactions with the UI components.
	 * Switches between different roles (CICLISTA, MASAJISTA, DIRECTOR) and updates
	 * the interface accordingly. Also handles the action for returning to the login
	 * panel.
	 *
	 * @param e the action event triggered by the user
	 */

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "volverlogin":
			mainPanel.panelLogin();
			break;

		case "ciclista":
		case "masajista":
		case "director":
			opcion = e.getActionCommand().toUpperCase();
			iniciarPanelDerecho();
			aplicarFuncionesValidacion();
			break;
		}

	}

	/**
	 * Gets the "Registro" button.
	 *
	 * @return the "Registro" button
	 */

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	/**
	 * Sets the "Registro" button.
	 *
	 * @param btnRegistro the new "Registro" button
	 */

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	/**
	 * Gets the password label.
	 *
	 * @return the password label
	 */

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	/**
	 * Sets the password label.
	 *
	 * @param lblContrasena the new password label
	 */

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	/**
	 * Gets the name label.
	 *
	 * @return the name label
	 */

	public JLabel getLblNombre() {
		return lblNombre;
	}

	/**
	 * Sets the name label.
	 *
	 * @param lblNombre the new name label
	 */

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/**
	 * Gets the email label.
	 *
	 * @return the email label
	 */

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	/**
	 * Sets the email label.
	 *
	 * @param lblCorreo the new email label
	 */

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	/**
	 * Gets the ID label.
	 *
	 * @return the ID label
	 */

	public JLabel getLblCedula() {
		return lblCedula;
	}

	/**
	 * Sets the ID label.
	 *
	 * @param lblCedula the new ID label
	 */

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	/**
	 * Gets the gender label.
	 *
	 * @return the gender label
	 */

	public JLabel getLblGenero() {
		return lblGenero;
	}

	/**
	 * Sets the gender label.
	 *
	 * @param lblGenero the new gender label
	 */

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	/**
	 * Gets the identifier label.
	 *
	 * @return the identifier label
	 */

	public JLabel getLblIdentificador() {
		return lblIdentificador;
	}

	/**
	 * Sets the identifier label.
	 *
	 * @param lblIdentificador the new identifier label
	 */

	public void setLblIdentificador(JLabel lblIdentificador) {
		this.lblIdentificador = lblIdentificador;
	}

	/**
	 * Gets the years of experience label.
	 *
	 * @return the years of experience label
	 */

	public JLabel getLblAniosExperiencia() {
		return lblAniosExperiencia;
	}

	/**
	 * Sets the years of experience label.
	 *
	 * @param lblAniosExperiencia the new years of experience label
	 */

	public void setLblAniosExperiencia(JLabel lblAniosExperiencia) {
		this.lblAniosExperiencia = lblAniosExperiencia;
	}

	/**
	 * Gets the specialty label.
	 *
	 * @return the specialty label
	 */

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	/**
	 * Sets the specialty label.
	 *
	 * @param lblEspecialidad the new specialty label
	 */

	public void setLblEspecialidad(JLabel lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	/**
	 * Gets the body type label.
	 *
	 * @return the body type label
	 */

	public JLabel getLblContextura() {
		return lblContextura;
	}

	/**
	 * Sets the body type label.
	 *
	 * @param lblContextura the new body type label
	 */

	public void setLblContextura(JLabel lblContextura) {
		this.lblContextura = lblContextura;
	}

	/**
	 * Gets the nationality label.
	 *
	 * @return the nationality label
	 */

	public JLabel getLblNacionalidad() {
		return lblNacionalidad;
	}

	/**
	 * Sets the nationality label.
	 *
	 * @param lblNacionalidad the new nationality label
	 */

	public void setLblNacionalidad(JLabel lblNacionalidad) {
		this.lblNacionalidad = lblNacionalidad;
	}

	/**
	 * Gets the password text field.
	 *
	 * @return the password text field
	 */

	public JTextField getJtContrasena() {
		return jtContrasena;
	}

	/**
	 * Sets the password text field.
	 *
	 * @param jtContrasena the new password text field
	 */

	public void setJtContrasena(JTextField jtContrasena) {
		this.jtContrasena = jtContrasena;
	}

	/**
	 * Gets the name text field.
	 *
	 * @return the name text field
	 */

	public JTextField getJtNombre() {
		return jtNombre;
	}

	/**
	 * Sets the name text field.
	 *
	 * @param jtNombre the new name text field
	 */

	public void setJtNombre(JTextField jtNombre) {
		this.jtNombre = jtNombre;
	}

	/**
	 * Gets the email text field.
	 *
	 * @return the email text field
	 */

	public JTextField getJtCorreo() {
		return jtCorreo;
	}

	/**
	 * Sets the email text field.
	 *
	 * @param jtCorreo the new email text field
	 */

	public void setJtCorreo(JTextField jtCorreo) {
		this.jtCorreo = jtCorreo;
	}

	/**
	 * Gets the ID text field.
	 *
	 * @return the ID text field
	 */

	public JTextField getJtCedula() {
		return jtCedula;
	}

	/**
	 * Sets the ID text field.
	 *
	 * @param jtCedula the new ID text field
	 */

	public void setJtCedula(JTextField jtCedula) {
		this.jtCedula = jtCedula;
	}

	/**
	 * Gets the identifier text field.
	 *
	 * @return the identifier text field
	 */

	public JTextField getJtIdentificador() {
		return jtIdentificador;
	}

	/**
	 * Sets the identifier text field.
	 *
	 * @param jtIdentificador the new identifier text field
	 */

	public void setJtIdentificador(JTextField jtIdentificador) {
		this.jtIdentificador = jtIdentificador;
	}

	/**
	 * Gets the years of experience text field.
	 *
	 * @return the years of experience text field
	 */

	public JTextField getJtAniosExperiencia() {
		return jtAniosExperiencia;
	}

	/**
	 * Sets the years of experience text field.
	 *
	 * @param jtAniosExperiencia the new years of experience text field
	 */

	public void setJtAniosExperiencia(JTextField jtAniosExperiencia) {
		this.jtAniosExperiencia = jtAniosExperiencia;
	}

	/**
	 * Gets the nationality text field.
	 *
	 * @return the nationality text field
	 */

	public JTextField getJtNacionalidad() {
		return jtNacionalidad;
	}

	/**
	 * Sets the nationality text field.
	 *
	 * @param jtNacionalidad the new nationality text field
	 */

	public void setJtNacionalidad(JTextField jtNacionalidad) {
		this.jtNacionalidad = jtNacionalidad;
	}

	/**
	 * Gets the main panel.
	 *
	 * @return the main panel
	 */

	public VentanaInicial getMainPanel() {
		return mainPanel;
	}

	/**
	 * Sets the main panel.
	 *
	 * @param mainPanel the new main panel
	 */

	public void setMainPanel(VentanaInicial mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * Gets the selected option.
	 *
	 * @return the selected option
	 */

	public String getOpcion() {
		return opcion;
	}

	/**
	 * Sets the selected option.
	 *
	 * @param opcion the new selected option
	 */

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	/**
	 * Gets the gender combo box.
	 *
	 * @return the gender combo box
	 */

	public JComboBox<String> getJcGenero() {
		return jcGenero;
	}

	/**
	 * Sets the gender combo box.
	 *
	 * @param jcGenero the new gender combo box
	 */

	public void setJcGenero(JComboBox<String> jcGenero) {
		this.jcGenero = jcGenero;
	}

	/**
	 * Gets the specialty combo box.
	 *
	 * @return the specialty combo box
	 */

	public JComboBox<String> getJcEspecialidad() {
		return jcEspecialidad;
	}

	/**
	 * Sets the specialty combo box.
	 *
	 * @param jcEspecialidad the new specialty combo box
	 */

	public void setJcEspecialidad(JComboBox<String> jcEspecialidad) {
		this.jcEspecialidad = jcEspecialidad;
	}

	/**
	 * Gets the body type combo box.
	 *
	 * @return the body type combo box
	 */

	public JComboBox<String> getJcContextura() {
		return jcContextura;
	}

	/**
	 * Sets the body type combo box.
	 *
	 * @param jcContextura the new body type combo box
	 */

	public void setJcContextura(JComboBox<String> jcContextura) {
		this.jcContextura = jcContextura;
	}

}