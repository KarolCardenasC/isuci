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

	private String opcion = "ciclista";

	public PanelRol(VentanaInicial inicial) {
		this.setProperties(
				FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		mainPanel = inicial;
		setLayout(null);
		initComponents();
	}

	public void initComponents() {

		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();
	}

	private void iniciarPanelIzquierdo() {
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);

		btnCiclista = this.crearBoton("Ciclista", 84, 80, "");
		pnlIzquierda.add(btnCiclista);

		btnMasajista = this.crearBoton("Masajista", 84, 280, "");
		pnlIzquierda.add(btnMasajista);

		btnDirector = this.crearBoton("Director", 84, 480, "");
		pnlIzquierda.add(btnDirector);

		add(pnlIzquierda);
	}

	private void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.alto")));
		pnlDerecha.setLayout(null);

		lblNombre = this.crearLabel("lblNombre.titulo", 40, 18);
		jtNombre = this.crearTextField("", 130, 30);
		pnlDerecha.add(lblNombre);
		pnlDerecha.add(jtNombre);

		lblCedula = this.crearLabel("lblCedula.titulo", 360, 78);
		jtCedula = this.crearTextField("", 435, 90);
		pnlDerecha.add(lblCedula);
		pnlDerecha.add(jtCedula);

		lblGenero = this.crearLabel("lblGenero.titulo", 50, 138);
		jtGenero = this.crearTextField("", 130, 150);
		pnlDerecha.add(lblGenero);
		pnlDerecha.add(jtGenero);

		lblCorreo = this.crearLabel("lblCorreo.titulo", 360, 198);
		jtCorreo = this.crearTextField("", 435, 210);
		pnlDerecha.add(lblCorreo);
		pnlDerecha.add(jtCorreo);

		lblContrasena = this.crearLabel("lblContrasena.titulo", 40, 258);
		jtContrasena = this.crearTextField("", 160, 270);
		pnlDerecha.add(lblContrasena);
		pnlDerecha.add(jtContrasena);

		switch (opcion) {
		case "ciclista":

			lblIdentificador = this.crearLabel("lblIdentificador.titulo", 300, 318);
			jtIdentificador = this.crearTextField("", 435, 330);
			pnlDerecha.add(lblIdentificador);
			pnlDerecha.add(jtIdentificador);

			lblAniosExperiencia = this.crearLabel("lblAniosExperiencia.titulo", 40, 378);
			jtAniosExperiencia = this.crearTextField("", 215, 390);
			pnlDerecha.add(lblAniosExperiencia);
			pnlDerecha.add(jtAniosExperiencia);

			lblTiempoAcumuladoMin = this.crearLabel("lblTiempoAcumuladoMin.titulo", 240, 438);
			jtTiempoAcumuladoMin = this.crearTextField("", 435, 450);
			pnlDerecha.add(lblTiempoAcumuladoMin);
			pnlDerecha.add(jtTiempoAcumuladoMin);

			lblEspecialidad = this.crearLabel("lblEspecialidad.titulo", 40, 498);
			jtEspecialidad = this.crearTextField("", 170, 510);
			pnlDerecha.add(lblEspecialidad);
			pnlDerecha.add(jtEspecialidad);

			lblContextura = this.crearLabel("lblContextura.titulo", 315, 548);
			jtContextura = this.crearTextField("", 435, 560);
			pnlDerecha.add(lblContextura);
			pnlDerecha.add(jtContextura);

			break;

		case "masajista":

			lblAniosExperiencia = this.crearLabel("lblAniosExperiencia.titulo", 260, 348);
			jtAniosExperiencia = this.crearTextField("", 435, 360);
			pnlDerecha.add(lblAniosExperiencia);
			pnlDerecha.add(jtAniosExperiencia);

			break;

		case "director":

			lblNacionalidad = this.crearLabel("lblNacionalidad.titulo", 260, 348);
			jtNacionalidad = this.crearTextField("", 435, 360);
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			break;
		}

		btnIniciarSesion = this.crearBoton("Login", 300, 610, "");
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
		}
		iniciarPanelDerecho();
		pnlDerecha.repaint();
	}
}
