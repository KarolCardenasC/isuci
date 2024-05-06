 package co.edu.unbosque.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

public class VentanaRol extends JPanel implements ActionListener {	

	private Properties properties;
	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	
	private JLabel lblRol;
	private JLabel lblUsuario;
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
	
	private JTextField jtUsuario;
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
	
	public VentanaRol(VentanaInicial inicial) {
		properties = FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties");
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
		pnlIzquierda.setBounds(Integer.parseInt(properties.getProperty("ventanaRol.pnlizquierda.horizontal")),
		Integer.parseInt(properties.getProperty("ventanaRol.pnlizquierda.vertical")),Integer.parseInt(properties.getProperty("ventanaRol.pnlizquierda.ancho")), Integer.parseInt(properties.getProperty("ventanaRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);
		
		btnCiclista = new JButton("Ciclista");
		btnCiclista.setBounds(84, 80, 100, 100);
		btnCiclista.addActionListener(this);
		btnCiclista.setActionCommand("Ciclista");
		pnlIzquierda.add(btnCiclista);
		
		btnMasajista = new JButton("Masajista");
		btnMasajista.setBounds(84, 280, 100, 100);
		btnMasajista.addActionListener(this);
		btnMasajista.setActionCommand("Masajista");
		pnlIzquierda.add(btnMasajista);
		
		btnDirector = new JButton("Director");
		btnDirector.setBounds(84, 480, 100, 100);
		btnDirector.addActionListener(this);
		btnDirector.setActionCommand("Director");
		pnlIzquierda.add(btnDirector);
		
		add(pnlIzquierda);
	}
	
	private void iniciarPanelDerecho()
	{
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(properties.getProperty("ventanaRol.pnlderecha.horizontal")),
		Integer.parseInt(properties.getProperty("ventanaRol.pnlderecha.vertical")),Integer.parseInt(properties.getProperty("ventanaRol.pnlderecha.ancho")), Integer.parseInt(properties.getProperty("ventanaRol.pnlderecha.alto")));
		pnlDerecha.setLayout(null);
		
		lblNombre = new JLabel();
		lblNombre.setText(properties.getProperty("lblNombre.titulo"));
		lblNombre.setBounds(40, 18, 150, 40);
		lblNombre.setFont(new Font("Segoe UI", 1, 20));
		lblNombre.setForeground(Color.black);
		pnlDerecha.add(lblNombre);

		jtNombre = new JTextField();
		jtNombre.setBounds(130, 30, 220, 20);
		jtNombre.setFont(jtNombre.getFont().deriveFont(jtNombre.getFont().getSize() + 2f));
		jtNombre.setForeground(new Color(0, 0, 0));
		jtNombre.setBorder(null);
		pnlDerecha.add(jtNombre);
		
		lblCedula = new JLabel();
		lblCedula.setText(properties.getProperty("lblCedula.titulo"));
		lblCedula.setBounds(360, 78, 150, 40);
		lblCedula.setFont(new Font("Segoe UI", 1, 20));
		lblCedula.setForeground(Color.black);
		pnlDerecha.add(lblCedula);

		jtCedula = new JTextField();
		jtCedula.setBounds(435, 90, 220, 20);
		jtCedula.setFont(jtCedula.getFont().deriveFont(jtCedula.getFont().getSize() + 2f));
		jtCedula.setForeground(new Color(0, 0, 0));
		jtCedula.setBorder(null);
		pnlDerecha.add(jtCedula);
		
		lblGenero = new JLabel();
		lblGenero.setText(properties.getProperty("lblGenero.titulo"));
		lblGenero.setBounds(50, 138, 150, 40);
		lblGenero.setFont(new Font("Segoe UI", 1, 20));
		lblGenero.setForeground(Color.black);
		pnlDerecha.add(lblGenero);

		jtGenero = new JTextField();
		jtGenero.setBounds(130, 150, 220, 20);
		jtGenero.setFont(jtGenero.getFont().deriveFont(jtGenero.getFont().getSize() + 2f));
		jtGenero.setForeground(new Color(0, 0, 0));
		jtGenero.setBorder(null);
		pnlDerecha.add(jtGenero);
		
		lblCorreo = new JLabel();
		lblCorreo.setText(properties.getProperty("lblCorreo.titulo"));
		lblCorreo.setBounds(360, 198, 150, 40);
		lblCorreo.setFont(new Font("Segoe UI", 1, 20));
		lblCorreo.setForeground(Color.black);
		pnlDerecha.add(lblCorreo);

		jtCorreo = new JTextField();
		jtCorreo.setBounds(435, 210, 220, 20);
		jtCorreo.setFont(jtCorreo.getFont().deriveFont(jtCorreo.getFont().getSize() + 2f));
		jtCorreo.setForeground(new Color(0, 0, 0));
		jtCorreo.setBorder(null);
		pnlDerecha.add(jtCorreo);
		
		lblContrasena = new JLabel();
		lblContrasena.setText(properties.getProperty("lblContrasena.titulo"));
		lblContrasena.setBounds(40, 258, 150, 40);
		lblContrasena.setFont(new Font("Segoe UI", 1, 20));
		lblContrasena.setForeground(Color.black);
		pnlDerecha.add(lblContrasena);

		jtContrasena = new JTextField();
		jtContrasena.setBounds(160, 270, 220, 20);
		jtContrasena.setFont(jtContrasena.getFont().deriveFont(jtContrasena.getFont().getSize() + 2f));
		jtContrasena.setForeground(new Color(0, 0, 0));
		jtContrasena.setBorder(null);
		pnlDerecha.add(jtContrasena);
		
		
		
		switch (opcion) {
			case "Ciclista":
				lblIdentificador = new JLabel();
				lblIdentificador.setText(properties.getProperty("lblIdentificador.titulo"));
				lblIdentificador.setBounds(300, 318, 150, 40);
				lblIdentificador.setFont(new Font("Segoe UI", 1, 20));
				lblIdentificador.setForeground(Color.black);
				pnlDerecha.add(lblIdentificador);

				jtIdentificador = new JTextField();
				jtIdentificador.setBounds(435, 330, 220, 20);
				jtIdentificador.setFont(jtIdentificador.getFont().deriveFont(jtIdentificador.getFont().getSize() + 2f));
				jtIdentificador.setForeground(new Color(0, 0, 0));
				jtIdentificador.setBorder(null);
				pnlDerecha.add(jtIdentificador);
				
				lblAniosExperiencia = new JLabel();
				lblAniosExperiencia.setText(properties.getProperty("lblAniosExperiencia.titulo"));
				lblAniosExperiencia.setBounds(40, 378, 200, 40);
				lblAniosExperiencia.setFont(new Font("Segoe UI", 1, 20));
				lblAniosExperiencia.setForeground(Color.black);
				pnlDerecha.add(lblAniosExperiencia);

				jtAniosExperiencia = new JTextField();
				jtAniosExperiencia.setBounds(215, 390, 220, 20);
				jtAniosExperiencia.setFont(jtAniosExperiencia.getFont().deriveFont(jtAniosExperiencia.getFont().getSize() + 2f));
				jtAniosExperiencia.setForeground(new Color(0, 0, 0));
				jtAniosExperiencia.setBorder(null);
				pnlDerecha.add(jtAniosExperiencia);
				
				lblTiempoAcumuladoMin = new JLabel();
				lblTiempoAcumuladoMin.setText(properties.getProperty("lblTiempoAcumuladoMin.titulo"));
				lblTiempoAcumuladoMin.setBounds(240, 438, 200, 40);
				lblTiempoAcumuladoMin.setFont(new Font("Segoe UI", 1, 20));
				lblTiempoAcumuladoMin.setForeground(Color.black);
				pnlDerecha.add(lblTiempoAcumuladoMin);

				jtTiempoAcumuladoMin = new JTextField();
				jtTiempoAcumuladoMin.setBounds(435, 450, 220, 20);
				jtTiempoAcumuladoMin.setFont(jtTiempoAcumuladoMin.getFont().deriveFont(jtTiempoAcumuladoMin.getFont().getSize() + 2f));
				jtTiempoAcumuladoMin.setForeground(new Color(0, 0, 0));
				jtTiempoAcumuladoMin.setBorder(null);
				pnlDerecha.add(jtTiempoAcumuladoMin);
				
				lblEspecialidad = new JLabel();
				lblEspecialidad.setText(properties.getProperty("lblEspecialidad.titulo"));
				lblEspecialidad.setBounds(40, 498, 200, 40);
				lblEspecialidad.setFont(new Font("Segoe UI", 1, 20));
				lblEspecialidad.setForeground(Color.black);
				pnlDerecha.add(lblEspecialidad);

				jtEspecialidad = new JTextField();
				jtEspecialidad.setBounds(170, 510, 220, 20);
				jtEspecialidad.setFont(jtEspecialidad.getFont().deriveFont(jtEspecialidad.getFont().getSize() + 2f));
				jtEspecialidad.setForeground(new Color(0, 0, 0));
				jtEspecialidad.setBorder(null);
				pnlDerecha.add(jtEspecialidad);
				
				lblContextura = new JLabel();
				lblContextura.setText(properties.getProperty("lblContextura.titulo"));
				lblContextura.setBounds(315, 548, 200, 40);
				lblContextura.setFont(new Font("Segoe UI", 1, 20));
				lblContextura.setForeground(Color.black);
				pnlDerecha.add(lblContextura);

				jtContextura = new JTextField();
				jtContextura.setBounds(435, 560, 220, 20);
				jtContextura.setFont(jtContextura.getFont().deriveFont(jtContextura.getFont().getSize() + 2f));
				jtContextura.setForeground(new Color(0, 0, 0));
				jtContextura.setBorder(null);
				pnlDerecha.add(jtContextura);
				
				break;
			case "Masajista":
				lblAniosExperiencia = new JLabel();
				lblAniosExperiencia.setText(properties.getProperty("lblAniosExperiencia.titulo"));
				lblAniosExperiencia.setBounds(260, 348, 200, 40);
				lblAniosExperiencia.setFont(new Font("Segoe UI", 1, 20));
				lblAniosExperiencia.setForeground(Color.black);
				pnlDerecha.add(lblAniosExperiencia);

				jtAniosExperiencia = new JTextField();
				jtAniosExperiencia.setBounds(435, 360, 220, 20);
				jtAniosExperiencia.setFont(jtAniosExperiencia.getFont().deriveFont(jtAniosExperiencia.getFont().getSize() + 2f));
				jtAniosExperiencia.setForeground(new Color(0, 0, 0));
				jtAniosExperiencia.setBorder(null);
				pnlDerecha.add(jtAniosExperiencia);				
				break;
			case "Director":
				lblNacionalidad = new JLabel();
				lblNacionalidad.setText(properties.getProperty("lblNacionalidad.titulo"));
				lblNacionalidad.setBounds(260, 348, 200, 40);
				lblNacionalidad.setFont(new Font("Segoe UI", 1, 20));
				lblNacionalidad.setForeground(Color.black);
				pnlDerecha.add(lblNacionalidad);

				jtNacionalidad = new JTextField();
				jtNacionalidad.setBounds(435, 360, 220, 20);
				jtNacionalidad.setFont(jtNacionalidad.getFont().deriveFont(jtNacionalidad.getFont().getSize() + 2f));
				jtNacionalidad.setForeground(new Color(0, 0, 0));
				jtNacionalidad.setBorder(null);
				pnlDerecha.add(jtNacionalidad);				
				break;				
		}
	
		
		btnIniciarSesion = new JButton("Login");
		btnIniciarSesion.setBounds(300, 610, 200, 20);
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
			case "Ciclista":
				opcion = "Ciclista";
//				iniciarPanelDerecho();
				new VentanaRol(mainPanel);
				break;
			case "Masajista":
				opcion = "Masajista";
//				iniciarPanelDerecho();
				new VentanaRol(mainPanel);

				break;
			case "Director":
				opcion = "Director";
//				iniciarPanelDerecho();
				new VentanaRol(mainPanel);

				break;				
		}
	}
}
