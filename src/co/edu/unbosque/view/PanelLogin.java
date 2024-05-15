package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelLogin extends MainPanel implements ActionListener {

	private JLabel lblRegistro;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel imagen;
	private JButton btnIniciarSesion;
	private JTextField jtUsuario;
	private JTextField jtContrasena;
	private VentanaInicial mainPanel;

	public PanelLogin(VentanaInicial inicial) {
		mainPanel = inicial;
		this.setProperties(
				FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		setLayout(null);
		initComponents();
	}

	public void aplicarFuncionesValidacion() {

		limitarCaracter(jtUsuario, 50);
		limitarCaracter(jtContrasena, 30);

	}

	public void initComponents() {

		removeAll();

		lblUsuario = this.crearLabel("lblUsuario.titulo", 610, 235);
		add(lblUsuario);

		jtUsuario = this.crearTextFieldInvisible("", new Rectangle(620, 275, 250, 30));
		add(jtUsuario);

		lblContrasena = this.crearLabel("lblContrasena.titulo", 610, 342);
		add(lblContrasena);

		jtContrasena = this.crearPasswordFieldInvisible(new Rectangle(620, 382, 230, 30));
		add(jtContrasena);

		btnIniciarSesion = this.crearBotonInvisible("login", new Rectangle(606, 457, 278, 42), "");
		add(btnIniciarSesion);

		lblRegistro = this.crearLabel("lblRegistro.titulo", 685, 515);
		add(lblRegistro);

		imagen = this.crearLabel("", new Rectangle(0, 0, 1000, 700), "Ingresar.jpg");
		add(imagen);

		lblRegistro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.panelRegistro();
			}
		});

		aplicarFuncionesValidacion();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JLabel getLblRegistro() {
		return lblRegistro;
	}

	public void setLblRegistro(JLabel lblRegistro) {
		this.lblRegistro = lblRegistro;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	public JTextField getJtUsuario() {
		return jtUsuario;
	}

	public void setJtUsuario(JTextField jtUsuario) {
		this.jtUsuario = jtUsuario;
	}

	public JTextField getJtContrasena() {
		return jtContrasena;
	}

	public void setJtContrasena(JTextField jtContrasena) {
		this.jtContrasena = jtContrasena;
	}

	public VentanaInicial getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(VentanaInicial mainPanel) {
		this.mainPanel = mainPanel;
	}

	/*
	 * public String getRolUser() { return rolUser; }
	 * 
	 * public void setRolUser(String rolUser) { this.rolUser = rolUser; }
	 */

}
