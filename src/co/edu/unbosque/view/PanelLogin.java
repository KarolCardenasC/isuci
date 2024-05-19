package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * PanelLogin class represents the login panel in the application. It extends
 * MainPanel and implements ActionListener to handle action events. This panel
 * allows users to input their username and password to log in.
 *
 * @see MainPanel
 * @see ActionListener
 * @see FileHandler
 * @see VentanaInicial
 * @author Cardenas.K
 * 
 * @version 15/05/2024
 */

public class PanelLogin extends MainPanel implements ActionListener {

	private JLabel lblRegistro;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel imagen;
	private JButton btnIniciarSesion;
	private JTextField jtUsuario;
	private JTextField jtContrasena;
	private VentanaInicial mainPanel;

	/**
	 * Constructs a new PanelLogin.
	 * 
	 * @param inicial the main window that contains this panel.
	 */

	public PanelLogin(VentanaInicial inicial) {
		mainPanel = inicial;
		this.setProperties(
				FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		setLayout(null);
		initComponents();
	}

	/**
	 * Applies character limits to the input fields for validation.
	 */

	public void aplicarFuncionesValidacion() {

		limitarCaracter(jtUsuario, 50);
		limitarCaracter(jtContrasena, 30);

	}

	/**
	 * Initializes the components of the login panel.
	 */

	public void initComponents() {

		removeAll();

		lblUsuario = this.crearLabel("lblUsuario.titulo", 610, 235);
		lblUsuario.setForeground(Color.black);
		add(lblUsuario);

		jtUsuario = this.crearTextFieldInvisible("", new Rectangle(620, 275, 250, 30));
		add(jtUsuario);

		lblContrasena = this.crearLabel("lblContrasena.titulo", 610, 342);
		lblContrasena.setForeground(Color.black);
		add(lblContrasena);

		jtContrasena = this.crearPasswordFieldInvisible(new Rectangle(620, 382, 230, 30));
		add(jtContrasena);

		btnIniciarSesion = this.crearBotonInvisible("login", new Rectangle(606, 457, 278, 42), "");
		add(btnIniciarSesion);

		lblRegistro = this.crearLabel("lblRegistro.titulo", 685, 515);
		lblRegistro.setForeground(Color.black);
		add(lblRegistro);

		imagen = this.crearLabel("", new Rectangle(0, 0, 1000, 700), "Ingresar.jpg");
		add(imagen);

		lblRegistro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.panelRegistro();
			}
		});

		aplicarFuncionesValidacion();

	}

	/**
	 * Handles action events.
	 * 
	 * @param e the action event
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/**
	 * Returns the login button.
	 * 
	 * @return the login button
	 */

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	/**
	 * Sets the login button.
	 * 
	 * @param btnIniciarSesion the new login button
	 */

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	/**
	 * Returns the registration label.
	 * 
	 * @return the registration label
	 */

	public JLabel getLblRegistro() {
		return lblRegistro;
	}

	/**
	 * Sets the registration label.
	 * 
	 * @param lblRegistro the new registration label
	 */

	public void setLblRegistro(JLabel lblRegistro) {
		this.lblRegistro = lblRegistro;
	}

	/**
	 * Returns the username label.
	 * 
	 * @return the username label
	 */

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	/**
	 * Sets the username label.
	 * 
	 * @param lblUsuario the new username label
	 */

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	/**
	 * Returns the password label.
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
	 * Returns the username text field.
	 * 
	 * @return the username text field
	 */

	public JTextField getJtUsuario() {
		return jtUsuario;
	}

	/**
	 * Sets the username text field.
	 * 
	 * @param jtUsuario the new username text field
	 */

	public void setJtUsuario(JTextField jtUsuario) {
		this.jtUsuario = jtUsuario;
	}

	/**
	 * Returns the password text field.
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
	 * Returns the main panel (VentanaInicial).
	 * 
	 * @return the main panel
	 */

	public VentanaInicial getMainPanel() {
		return mainPanel;
	}

	/**
	 * Sets the main panel (VentanaInicial).
	 * 
	 * @param mainPanel the new main panel
	 */

	public void setMainPanel(VentanaInicial mainPanel) {
		this.mainPanel = mainPanel;
	}

}