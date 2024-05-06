package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

public class VentanaInicial extends JFrame {

	private JPanel pnlFondo;
	private Properties properties;
	
	public VentanaInicial() {
	    properties = FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties");
		initComponents();
		panelLogin();
	}
	
	public void initComponents() {

		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Integer.parseInt(properties.getProperty("ventana.ancho")), Integer.parseInt(properties.getProperty("ventana.alto")));
		setLocationRelativeTo(null);
        setResizable(false);
		setLayout(new BorderLayout());
		
		pnlFondo = new JPanel();
		pnlFondo.setLayout(null);
		pnlFondo.setSize(Integer.parseInt(properties.getProperty("ventana.ancho")), Integer.parseInt(properties.getProperty("ventana.alto")));
		pnlFondo.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlFondo);
	}

	public void nuevoPanel(JPanel panelActual)
	{
		pnlFondo.removeAll();
		
		if (panelActual != null)
			pnlFondo.add(panelActual);
		
		pnlFondo.repaint();
		pnlFondo.revalidate();
	}
	
	public void panelLogin()
	{
		nuevoPanel(new VentanaLogin(this));
	}
	
	public void panelRegistro()
	{
		nuevoPanel(new VentanaRol(this));
	}	
}
