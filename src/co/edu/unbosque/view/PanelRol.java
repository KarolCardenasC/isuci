package co.edu.unbosque.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelRol extends MainPanel implements ActionListener {

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	private JPanel pnlInferior;

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
	private JButton btnRegistro;
	private JButton btnVolver;

	private JTextField jtContrasena;
	private JTextField jtNombre;
	private JTextField jtCorreo;
	private JTextField jtCedula;
	private JTextField jtIdentificador;
	private JTextField jtAniosExperiencia;
	private JTextField jtTiempoAcumuladoMin;
	private JTextField jtNacionalidad;

	private JComboBox<String> jcGenero;
	private JComboBox<String> jcEspecialidad;
	private JComboBox<String> jcContextura;

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
		iniciarPanelInferior();
	}

	public void iniciarPanelIzquierdo() {
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);

		btnCiclista = this.crearBotonInvisible("Ciclista", new Rectangle(84, 40, 150, 150), "cicla.png");
		pnlIzquierda.add(btnCiclista);

		btnMasajista = this.crearBotonInvisible("Masajista", new Rectangle(84, 250, 150, 150), "masajista.png");
		pnlIzquierda.add(btnMasajista);

		btnDirector = this.crearBotonInvisible("Director", new Rectangle(84, 460, 150, 150), "director.png");
		pnlIzquierda.add(btnDirector);

		add(pnlIzquierda);
	}

	public void iniciarPanelDerecho() {
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

		String[] listaGenero = { "Hombre", "Mujer" };

		lblGenero = this.crearLabel("lblGenero.titulo", 50, 138);
		jcGenero = this.crearComboBox(listaGenero, 130, 150);
		pnlDerecha.add(lblGenero);
		pnlDerecha.add(jcGenero);

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

			String[] listaEspecialidad = { "", "Clasicomano", "Contrarrelojero", "Escalador", "Gregario", "Rodador",
					"Sprinter" };
			String[] listaContextura = { "", "Delgado", "Medio", "Grueso" };

			lblEspecialidad = this.crearLabel("lblEspecialidad.titulo", 40, 498);
			jcEspecialidad = this.crearComboBox(listaEspecialidad, 170, 510);
			pnlDerecha.add(lblEspecialidad);
			pnlDerecha.add(jcEspecialidad);

			lblContextura = this.crearLabel("lblContextura.titulo", 315, 548);
			jcContextura = this.crearComboBox(listaContextura, 435, 560);
			pnlDerecha.add(lblContextura);
			pnlDerecha.add(jcContextura);

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

		add(pnlDerecha);
	}
	
	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.alto")));
		pnlInferior.setLayout(null);
		
		btnRegistro = this.crearBoton("Registro", 320, 10, "");
		pnlInferior.add(btnRegistro);
		
		btnVolver = this.crearBoton("Volver Login", 80, 10, "");
		pnlInferior.add(btnVolver);
		
		add(pnlInferior);
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "volverlogin":
			mainPanel.panelLogin();
			break;
			
		case "ciclista":
		case "masajista":
		case "director":
			opcion = e.getActionCommand();
			pnlDerecha.removeAll();
			break;
		}
		
		iniciarPanelDerecho();
		pnlDerecha.repaint();

	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JPanel getPnlDerecha() {
		return pnlDerecha;
	}

	public void setPnlDerecha(JPanel pnlDerecha) {
		this.pnlDerecha = pnlDerecha;
	}

	public JPanel getPnlIzquierda() {
		return pnlIzquierda;
	}

	public void setPnlIzquierda(JPanel pnlIzquierda) {
		this.pnlIzquierda = pnlIzquierda;
	}

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblIdentificador() {
		return lblIdentificador;
	}

	public void setLblIdentificador(JLabel lblIdentificador) {
		this.lblIdentificador = lblIdentificador;
	}

	public JLabel getLblAniosExperiencia() {
		return lblAniosExperiencia;
	}

	public void setLblAniosExperiencia(JLabel lblAniosExperiencia) {
		this.lblAniosExperiencia = lblAniosExperiencia;
	}

	public JLabel getLblTiempoAcumuladoMin() {
		return lblTiempoAcumuladoMin;
	}

	public void setLblTiempoAcumuladoMin(JLabel lblTiempoAcumuladoMin) {
		this.lblTiempoAcumuladoMin = lblTiempoAcumuladoMin;
	}

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public void setLblEspecialidad(JLabel lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	public JLabel getLblContextura() {
		return lblContextura;
	}

	public void setLblContextura(JLabel lblContextura) {
		this.lblContextura = lblContextura;
	}

	public JLabel getLblNacionalidad() {
		return lblNacionalidad;
	}

	public void setLblNacionalidad(JLabel lblNacionalidad) {
		this.lblNacionalidad = lblNacionalidad;
	}

	public JButton getBtnCiclista() {
		return btnCiclista;
	}

	public void setBtnCiclista(JButton btnCiclista) {
		this.btnCiclista = btnCiclista;
	}

	public JButton getBtnMasajista() {
		return btnMasajista;
	}

	public void setBtnMasajista(JButton btnMasajista) {
		this.btnMasajista = btnMasajista;
	}

	public JButton getBtnDirector() {
		return btnDirector;
	}

	public void setBtnDirector(JButton btnDirector) {
		this.btnDirector = btnDirector;
	}

	public JTextField getJtContrasena() {
		return jtContrasena;
	}

	public void setJtContrasena(JTextField jtContrasena) {
		this.jtContrasena = jtContrasena;
	}

	public JTextField getJtNombre() {
		return jtNombre;
	}

	public void setJtNombre(JTextField jtNombre) {
		this.jtNombre = jtNombre;
	}

	public JTextField getJtCorreo() {
		return jtCorreo;
	}

	public void setJtCorreo(JTextField jtCorreo) {
		this.jtCorreo = jtCorreo;
	}

	public JTextField getJtCedula() {
		return jtCedula;
	}

	public void setJtCedula(JTextField jtCedula) {
		this.jtCedula = jtCedula;
	}

	public JTextField getJtIdentificador() {
		return jtIdentificador;
	}

	public void setJtIdentificador(JTextField jtIdentificador) {
		this.jtIdentificador = jtIdentificador;
	}

	public JTextField getJtAniosExperiencia() {
		return jtAniosExperiencia;
	}

	public void setJtAniosExperiencia(JTextField jtAniosExperiencia) {
		this.jtAniosExperiencia = jtAniosExperiencia;
	}

	public JTextField getJtTiempoAcumuladoMin() {
		return jtTiempoAcumuladoMin;
	}

	public void setJtTiempoAcumuladoMin(JTextField jtTiempoAcumuladoMin) {
		this.jtTiempoAcumuladoMin = jtTiempoAcumuladoMin;
	}

	public JTextField getJtNacionalidad() {
		return jtNacionalidad;
	}

	public void setJtNacionalidad(JTextField jtNacionalidad) {
		this.jtNacionalidad = jtNacionalidad;
	}

	public VentanaInicial getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(VentanaInicial mainPanel) {
		this.mainPanel = mainPanel;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public JComboBox<String> getJcGenero() {
		return jcGenero;
	}

	public void setJcGenero(JComboBox<String> jcGenero) {
		this.jcGenero = jcGenero;
	}

	public JComboBox<String> getJcEspecialidad() {
		return jcEspecialidad;
	}

	public void setJcEspecialidad(JComboBox<String> jcEspecialidad) {
		this.jcEspecialidad = jcEspecialidad;
	}

	public JComboBox<String> getJcContextura() {
		return jcContextura;
	}

	public void setJcContextura(JComboBox<String> jcContextura) {
		this.jcContextura = jcContextura;
	}

}
