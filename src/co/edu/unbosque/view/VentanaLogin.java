package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame {

	private JPanel pnlFondo;
	private JLabel lblUsuario;
	private JButton btnIniciarSesion;
	private JButton btnRegistarse;

	private JTextField jtUsuario;
	private JTextField jtContraseña;

	public VentanaLogin() {
		initComponents();

	}

	public void initComponents() {

		setSize(1000, 700);
		setLocationRelativeTo(null);
		setTitle("Login");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnlFondo = new JPanel();
		pnlFondo.setBounds(0, 0, 1000, 700);
		pnlFondo.setLayout(null);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(300, 200, 150, 40);
		lblUsuario.setFont(new Font("Segoe UI", 1, 15));
		lblUsuario.setForeground(Color.black);
		pnlFondo.add(lblUsuario);

		jtUsuario = new JTextField();
		jtUsuario.setBounds(380, 210, 200, 20);
		jtUsuario.setFont(jtUsuario.getFont().deriveFont(jtUsuario.getFont().getSize() + 2f));
		jtUsuario.setForeground(new Color(0, 0, 0));
		jtUsuario.setBorder(null);
		pnlFondo.add(jtUsuario);

		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(400, 350, 200, 20);
		pnlFondo.add(btnIniciarSesion);

		jtContraseña = new JTextField();
		jtContraseña.setBounds(200, 400, 400, 20);
		jtContraseña.setFont(jtContraseña.getFont().deriveFont(jtContraseña.getFont().getSize() + 4f));
		jtContraseña.setForeground(new Color(0, 0, 0));
		jtContraseña.setBorder(null);
		pnlFondo.add(jtContraseña);

		add(pnlFondo);
		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaLogin();
	}
}
