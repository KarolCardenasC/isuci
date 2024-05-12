package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

public class VentanaInicial extends JFrame {

	private JPanel pnlFondo;
	private Properties properties;
	private PanelLogin pnlLogin;
	private PanelRol pnlRol;

	public VentanaInicial() {
		pnlLogin = new PanelLogin(this);
		pnlRol = new PanelRol(this);
		properties = FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties");
		initComponents();
		panelLogin();
	}

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

	public void nuevoPanel(JPanel panelActual) {
		pnlFondo.removeAll();

		if (panelActual != null)
			pnlFondo.add(panelActual);

		pnlFondo.repaint();
		pnlFondo.revalidate();
	}

	public void panelLogin() {
		nuevoPanel(pnlLogin);
	}

	public void panelRegistro() {
		nuevoPanel(pnlRol);
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

	public PanelLogin getPnlLogin() {
		return pnlLogin;
	}

	public void setPnlLogin(PanelLogin pnlLogin) {
		this.pnlLogin = pnlLogin;
	}

	public PanelRol getPnlRol() {
		return pnlRol;
	}

	public void setPnlRol(PanelRol pnlRol) {
		this.pnlRol = pnlRol;
	}

}
