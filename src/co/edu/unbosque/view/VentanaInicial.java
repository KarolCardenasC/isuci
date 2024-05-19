package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * VentanaInicial is a class that represents the main window of the login
 * application. This window contains a login panel and a registration panel,
 * which can be dynamically switched.
 * 
 * @author Cardenas.K
 * @version 15/05/2024
 */

public class VentanaInicial extends JFrame {

	private JPanel pnlFondo;
	private Properties properties;
	private PanelLogin pnlLogin;
	private PanelRol pnlRol;

	/**
	 * Constructor of the VentanaInicial class. Initializes the window components,
	 * loads properties from a file, and displays the login panel by default.
	 */

	public VentanaInicial() {
		pnlLogin = new PanelLogin(this);
		pnlRol = new PanelRol(this);
		properties = FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties");
		initComponents();
		panelLogin();
	}

	/**
	 * Initializes the window components. Configures the title, size, position,
	 * layout, and main content of the window.
	 */

	public void initComponents() {

		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Integer.parseInt(properties.getProperty("ventanaInicial.ancho")),
				Integer.parseInt(properties.getProperty("ventanaInicial.alto")));
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		pnlFondo = new JPanel();
		pnlFondo.setLayout(null);
		pnlFondo.setSize(Integer.parseInt(properties.getProperty("ventanaInicial.ancho")),
				Integer.parseInt(properties.getProperty("ventanaInicial.alto")));
		pnlFondo.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlFondo);
	}

	/**
	 * Replaces the current panel in the window with a new one.
	 * 
	 * @param panelActual The new panel to be displayed in the window.
	 */

	public void nuevoPanel(JPanel panelActual) {
		pnlFondo.removeAll();

		if (panelActual != null)
			pnlFondo.add(panelActual);

		pnlFondo.repaint();
		pnlFondo.revalidate();
	}

	/**
	 * Displays the login panel in the window.
	 */

	public void panelLogin() {
		nuevoPanel(pnlLogin);
	}

	/**
	 * Displays the registration panel in the window.
	 */

	public void panelRegistro() {
		nuevoPanel(pnlRol);
	}

	/**
	 * Gets the main panel of the window.
	 * 
	 * @return The main panel of the window.
	 */

	public JPanel getPnlFondo() {
		return pnlFondo;
	}

	/**
	 * Sets the main panel of the window.
	 * 
	 * @param pnlFondo The new main panel of the window.
	 */

	public void setPnlFondo(JPanel pnlFondo) {
		this.pnlFondo = pnlFondo;
	}

	/**
	 * Gets the configuration properties of the window.
	 * 
	 * @return The configuration properties of the window.
	 */

	public Properties getProperties() {
		return properties;
	}

	/**
	 * Sets the configuration properties of the window.
	 * 
	 * @param properties The new configuration properties of the window.
	 */

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Gets the login panel of the window.
	 * 
	 * @return The login panel of the window.
	 */

	public PanelLogin getPnlLogin() {
		return pnlLogin;
	}

	/**
	 * Sets the login panel of the window.
	 * 
	 * @param pnlLogin The new login panel of the window.
	 */

	public void setPnlLogin(PanelLogin pnlLogin) {
		this.pnlLogin = pnlLogin;
	}

	/**
	 * Gets the registration panel of the window.
	 * 
	 * @return The registration panel of the window.
	 */

	public PanelRol getPnlRol() {
		return pnlRol;
	}

	/**
	 * Sets the registration panel of the window.
	 * 
	 * @param pnlRol The new registration panel of the window.
	 */

	public void setPnlRol(PanelRol pnlRol) {
		this.pnlRol = pnlRol;
	}

}