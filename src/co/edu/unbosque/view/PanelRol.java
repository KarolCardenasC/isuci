 package co.edu.unbosque.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.utils.MainPanel;

public class PanelRol extends MainPanel implements ActionListener {	

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	
	private JLabel lblContrasena;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblCedula;
	private JLabel lblGenero;
	private JLabel lblIdentificador;
	private JLabel lblAniosExperiencia;
	private JLabel lblTiempoAcumuladoMin;
	private JLabel lblEspecialidad;
	private JLabel lblContextura;
	private JLabel lblNacionalidad;
	
	private JButton btnCiclista;
	private JButton btnMasajista;
	private JButton btnDirector;
	
	private JTextField jtContrasena;
	private JTextField jtNombre;
	private JTextField jtCorreo;
	private JTextField jtCedula;
	private JTextField jtGenero;
	private JTextField jtIdentificador;
	private JTextField jtAniosExperiencia;
	private JTextField jtTiempoAcumuladoMin;
	private JTextField jtEspecialidad;
	private JTextField jtContextura;
	private JTextField jtNacionalidad;
	
	private JButton btnIniciarSesion;
	private VentanaInicial mainPanel;

	private String opcion = "Ciclista";
	
	public PanelRol(VentanaInicial inicial) {
		this.setProperties(FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		mainPanel = inicial;
		setLayout(null);
		initComponents();
	}
	
	public void initComponents() {

		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();
	}

	private void iniciarPanelIzquierdo()
	{
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.vertical")),Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.ancho")), Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);
		
		btnCiclista = this.createButton("Ciclista",new Rectangle(84, 80, 100, 100));
		btnCiclista.addActionListener(this);
		btnCiclista.setActionCommand("Ciclista");
		pnlIzquierda.add(btnCiclista);
		
		btnMasajista = this.createButton("Masajista",new Rectangle(84, 280, 100, 100));
		btnMasajista.addActionListener(this);
		btnMasajista.setActionCommand("Masajista");
		pnlIzquierda.add(btnMasajista);
		
		btnDirector = this.createButton("Director",new Rectangle(84, 480, 100, 100));
		btnDirector.addActionListener(this);
		btnDirector.setActionCommand("Director");
		pnlIzquierda.add(btnDirector);
		
		add(pnlIzquierda);
	}
	
	private void iniciarPanelDerecho()
	{
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.vertical")),Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.ancho")), Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.alto")));
		pnlDerecha.setLayout(null);
		
		
		lblNombre = this.createLabel("lblNombre.titulo",new Rectangle(40, 18, 150, 40));
		jtNombre = this.createTextField(new Rectangle(130, 30, 220, 20));
		pnlDerecha.add(lblNombre);
		pnlDerecha.add(jtNombre);
		
		lblCedula = this.createLabel("lblCedula.titulo",new Rectangle(360, 78, 150, 40));
		jtCedula = this.createTextField(new Rectangle(435, 90, 220, 20));
		pnlDerecha.add(lblCedula);
		pnlDerecha.add(jtCedula);
		
		lblGenero = this.createLabel("lblGenero.titulo",new Rectangle(50, 138, 150, 40));
		jtGenero = this.createTextField(new Rectangle(130, 150, 220, 20));
		pnlDerecha.add(lblGenero);
		pnlDerecha.add(jtGenero);
		
		lblCorreo = this.createLabel("lblCorreo.titulo",new Rectangle(360, 198, 150, 40));
		jtCorreo = this.createTextField(new Rectangle(435, 210, 220, 20));
		pnlDerecha.add(lblCorreo);
		pnlDerecha.add(jtCorreo);
		
		lblContrasena = this.createLabel("lblContrasena.titulo",new Rectangle(40, 258, 150, 40));
		jtContrasena = this.createTextField(new Rectangle(160, 270, 220, 20));
		pnlDerecha.add(lblContrasena);
		pnlDerecha.add(jtContrasena);
		
		
		switch (opcion) {
			case "Ciclista":
				
				lblIdentificador = this.createLabel("lblIdentificador.titulo",new Rectangle(300, 318, 150, 40));
				jtIdentificador = this.createTextField(new Rectangle(435, 330, 220, 20));
				pnlDerecha.add(lblIdentificador);
				pnlDerecha.add(jtIdentificador);
				
				lblAniosExperiencia = this.createLabel("lblAniosExperiencia.titulo",new Rectangle(40, 378, 200, 40));
				jtAniosExperiencia = this.createTextField(new Rectangle(215, 390, 220, 20));
				pnlDerecha.add(lblAniosExperiencia);
				pnlDerecha.add(jtAniosExperiencia);
				
				lblTiempoAcumuladoMin = this.createLabel("lblTiempoAcumuladoMin.titulo",new Rectangle(240, 438, 200, 40));
				jtTiempoAcumuladoMin = this.createTextField(new Rectangle(435, 450, 220, 20));
				pnlDerecha.add(lblTiempoAcumuladoMin);
				pnlDerecha.add(jtTiempoAcumuladoMin);
				
				lblEspecialidad = this.createLabel("lblEspecialidad.titulo",new Rectangle(40, 498, 200, 40));
				jtEspecialidad = this.createTextField(new Rectangle(170, 510, 220, 20));
				pnlDerecha.add(lblEspecialidad);
				pnlDerecha.add(jtEspecialidad);
				
				lblContextura = this.createLabel("lblContextura.titulo",new Rectangle(315, 548, 200, 40));
				jtContextura = this.createTextField(new Rectangle(435, 560, 220, 20));
				pnlDerecha.add(lblContextura);
				pnlDerecha.add(jtContextura);
				
				break;
				
			case "Masajista":
				
				lblAniosExperiencia = this.createLabel("lblAniosExperiencia.titulo",new Rectangle(260, 348, 200, 40));
				jtAniosExperiencia = this.createTextField(new Rectangle(435, 360, 220, 20));
				pnlDerecha.add(lblAniosExperiencia);
				pnlDerecha.add(jtAniosExperiencia);
							
				break;
				
			case "Director":
				
				lblNacionalidad = this.createLabel("lblNacionalidad.titulo",new Rectangle(260, 348, 200, 40));
				jtNacionalidad = this.createTextField(new Rectangle(435, 360, 220, 20));
				pnlDerecha.add(lblNacionalidad);
				pnlDerecha.add(jtNacionalidad);
							
				break;				
		}
	
		btnIniciarSesion = this.createButton("Login",new Rectangle(300, 610, 200, 20));
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setActionCommand("login");
		pnlDerecha.add(btnIniciarSesion);
		
		add(pnlDerecha);
	}	
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "login":
			mainPanel.panelLogin();
			break;
		default:
			opcion = e.getActionCommand();
			break;
//		case "Ciclista":
//		case "Masajista":
//		case "Director":
//			opcion = e.getActionCommand();
//			break;

		}
		iniciarPanelDerecho();
		pnlDerecha.repaint();
	}
}
