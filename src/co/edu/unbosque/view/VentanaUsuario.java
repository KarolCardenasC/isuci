package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * The VentanaUsuario class represents the main window of the application for users.
 * It allows the display of different panels depending on the user's role.
 * User roles include: Administrator, Cyclist, Masseur, and Sports Director.
 * 
 * @author Cardenas.K
 * @version 15/05/2024
 */

public class VentanaUsuario extends JFrame {

	private JPanel pnlFondo;
	private Properties properties;
	private PanelCiclista pnlCiclista;
	private PanelMasajista pnlMasajista;
	private PanelDirector pnlDirector;
	private PanelAdministrador pnlAdministrador;
	
	private String rol = "ADMINISTRADOR";

	/**
     * Constructor for the VentanaUsuario class.
     * Initializes panels for each user role.
     * Loads window properties from an external file.
     * Calls the initComponents() method to initialize window components.
     * Calls the escogerRol() method to determine which panel to show based on the current role.
     */
	
	public VentanaUsuario() {
		pnlCiclista = new PanelCiclista(this);
		pnlMasajista = new PanelMasajista(this);
		pnlDirector = new PanelDirector(this);
		pnlAdministrador = new PanelAdministrador(this);
		properties = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties");
		initComponents();
		escogerRol();
	}

	/**
     * Method to determine which panel to show based on the current user's role.
     */
	
	public void escogerRol() {
		switch (rol) {
		case "ADMINISTRADOR":
			panelAdministrador();
			break;
		case "CICLISTA":
			panelCiclista();
			break;
		case "MASAJISTA":
			panelMasajista();
			break;
		case "DIRECTOR":
			panelDirectorDeportivo();
			break;

		default:
			break;
		}
	}

	/**
     * Initializes the window components.
     */
	
	public void initComponents() {

		setTitle("Usuario");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Integer.parseInt(properties.getProperty("ventanaUsuario.ancho")),
				Integer.parseInt(properties.getProperty("ventanaUsuario.alto")));
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		pnlFondo = new JPanel();
		pnlFondo.setLayout(null);
		pnlFondo.setSize(Integer.parseInt(properties.getProperty("ventanaUsuario.ancho")),
				Integer.parseInt(properties.getProperty("ventanaUsuario.alto")));
		pnlFondo.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlFondo);
	}

	/**
     * Removes the current panel and adds a new panel.
     * 
     * @param panelActual The new panel to display
     */
	
	public void nuevoPanel(JPanel panelActual) {
		pnlFondo.removeAll();

		if (panelActual != null)
			pnlFondo.add(panelActual);

		pnlFondo.repaint();
		pnlFondo.revalidate();
	}

	/**
     * Removes the current panel and adds the Sports Director panel.
     */
	
	public void panelDirectorDeportivo() {
		nuevoPanel(pnlDirector);
	}

	/**
     * Removes the current panel and adds the Masseur panel.
     */
	
	public void panelMasajista() {
		nuevoPanel(pnlMasajista);
	}

	/**
     * Removes the current panel and adds the Administrator panel.
     */
	
	public void panelAdministrador()
	{
		nuevoPanel(pnlAdministrador);
	}

	/**
     * Removes the current panel and adds the Cyclist panel.
     */
	
	public void panelCiclista() {
		nuevoPanel(pnlCiclista);
	}

	/**
     * Gets the background panel.
     * 
     * @return The background panel
     */
	
	public JPanel getPnlFondo() {
		return pnlFondo;
	}
	
	/**
     * Sets the background panel.
     * 
     * @param pnlFondo The background panel to set
     */

	public void setPnlFondo(JPanel pnlFondo) {
		this.pnlFondo = pnlFondo;
	}

	/**
     * Gets the properties.
     * 
     * @return The properties
     */
	
	public Properties getProperties() {
		return properties;
	}

	/**
     * Sets the properties.
     * 
     * @param properties The properties to set
     */
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
     * Gets the Cyclist panel.
     * 
     * @return The Cyclist panel
     */
	
	public PanelCiclista getPnlCiclista() {
		return pnlCiclista;
	}

	/**
     * Sets the Cyclist panel.
     * 
     * @param pnlCiclista The Cyclist panel to set
     */
	
	public void setPnlCiclista(PanelCiclista pnlCiclista) {
		this.pnlCiclista = pnlCiclista;
	}

	 /**
     * Gets the Masseur panel.
     * 
     * @return The Masseur panel
     */
	
	public PanelMasajista getPnlMasajista() {
		return pnlMasajista;
	}

	 /**
     * Sets the Masseur panel.
     * 
     * @param pnlMasajista The Masseur panel to set
     */	
	
	public void setPnlMasajista(PanelMasajista pnlMasajista) {
		this.pnlMasajista = pnlMasajista;
	}

	/**
     * Gets the Sports Director panel.
     * 
     * @return The Sports Director panel
     */
	
	public PanelDirector getPnlDirector() {
		return pnlDirector;
	}

	 /**
     * Sets the Sports Director panel.
     * 
     * @param pnlDirector The Sports Director panel to set
     */
	
	public void setPnlDirector(PanelDirector pnlDirector) {
		this.pnlDirector = pnlDirector;
	}

	/**
     * Gets the current role.
     * 
     * @return The current role
     */
	
	
	public String getRol() {
		return rol;
	}

	/**
     * Sets the current role.
     * 
     * @param rol The role to set
     */
	
	
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
     * Gets the Administrator panel.
     * 
     * @return The Administrator panel
     */
	
	public PanelAdministrador getPnlAdministrador() {
		return pnlAdministrador;
	}

	 /**
     * Sets the Administrator panel.
     * 
     * @param pnlAdministrador The Administrator panel to set
     */
	
	public void setPnlAdministrador(PanelAdministrador pnlAdministrador) {
		this.pnlAdministrador = pnlAdministrador;
	}

}