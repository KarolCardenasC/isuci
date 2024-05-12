package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

public class VentanaUsuario extends JFrame {

	private JPanel pnlFondo;
	private Properties properties;
	private PanelCiclista pnlCiclista;
	private PanelMasajista pnlMasajista;
	private PanelDirector pnlDirector;
	private String rol = "director";

	public VentanaUsuario() {
		pnlCiclista = new PanelCiclista(this);
		pnlMasajista = new PanelMasajista(this);
		pnlDirector = new PanelDirector(this);
		properties = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties");
		initComponents();
		escogerRol();
	}

	public void escogerRol() {
		switch (rol) {
		case "ciclista":
			panelCiclista();
			break;
		case "masajista":
			panelMasajista();
			break;
		case "director":
			panelDirectorDeportivo();
			break;

		default:
			break;
		}
	}

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

	public void nuevoPanel(JPanel panelActual) {
		pnlFondo.removeAll();

		if (panelActual != null)
			pnlFondo.add(panelActual);

		pnlFondo.repaint();
		pnlFondo.revalidate();
	}

	public void panelDirectorDeportivo() {
		nuevoPanel(pnlDirector);
	}

	public void panelMasajista() {
		nuevoPanel(pnlMasajista);
	}

//	public void panelAdministrador()
//	{
//		nuevoPanel(new PanelAdministrador(this));
//	}

	public void panelCiclista() {
		nuevoPanel(pnlCiclista);
	}

	public JPanel getPnlFondo() {
		return pnlFondo;
	}

	public void setPnlFondo(JPanel pnlFondo) {
		this.pnlFondo = pnlFondo;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public PanelCiclista getPnlCiclista() {
		return pnlCiclista;
	}

	public void setPnlCiclista(PanelCiclista pnlCiclista) {
		this.pnlCiclista = pnlCiclista;
	}

	public PanelMasajista getPnlMasajista() {
		return pnlMasajista;
	}

	public void setPnlMasajista(PanelMasajista pnlMasajista) {
		this.pnlMasajista = pnlMasajista;
	}

	public PanelDirector getPnlDirector() {
		return pnlDirector;
	}

	public void setPnlDirector(PanelDirector pnlDirector) {
		this.pnlDirector = pnlDirector;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
