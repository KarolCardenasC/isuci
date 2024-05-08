package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

public class VentanaUsuario extends JFrame {

	private JPanel pnlFondo;
	private Properties properties;

	public VentanaUsuario() {
		properties = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties");
		initComponents();
//		panelDirectorDeportivo();
		panelMasajista();
//		panelCiclista();
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
		nuevoPanel(new PanelDirector(this));
	}
	
	public void panelMasajista() {
		nuevoPanel(new PanelMasajista(this));
	}
	
//	public void panelAdministrador()
//	{
//		nuevoPanel(new PanelAdministrador(this));
//	}

	public void panelCiclista()
	{
		nuevoPanel(new PanelCiclista(this));
	}	

}
