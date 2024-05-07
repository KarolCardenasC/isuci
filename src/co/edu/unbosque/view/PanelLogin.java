package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.utils.MainPanel;

public class PanelLogin extends MainPanel implements ActionListener {
	
	private JLabel lblRegistro;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnIniciarSesion;
	private JTextField jtUsuario;
	private JTextField jtContrasena;
	private VentanaInicial mainPanel;
	
	public PanelLogin(VentanaInicial inicial) {
		mainPanel = inicial;
		this.setProperties(FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		setLayout(null);
		initComponents();
	}
	
	public void initComponents() {

		removeAll();
		
		lblUsuario = new JLabel();
		lblUsuario.setText(this.getProperties().getProperty("lblUsuario.titulo"));
		lblUsuario.setBounds(300, 240, 150, 40);
		lblUsuario.setFont(new Font("Segoe UI", 1, 15));
		lblUsuario.setForeground(Color.black);
		add(lblUsuario);

		jtUsuario = new JTextField();
		jtUsuario.setBounds(370, 253, 200, 20);
		jtUsuario.setFont(jtUsuario.getFont().deriveFont(jtUsuario.getFont().getSize() + 2f));
		jtUsuario.setForeground(new Color(0, 0, 0));
		jtUsuario.setBorder(null);
		add(jtUsuario);
	
		lblContrasena = new JLabel();
		lblContrasena.setText(this.getProperties().getProperty("lblContrasena.titulo"));		
		lblContrasena.setBounds(275, 280, 150, 40);
		lblContrasena.setFont(new Font("Segoe UI", 1, 15));
		lblContrasena.setForeground(Color.black);
		add(lblContrasena);
		
		jtContrasena = new JTextField();
		jtContrasena.setBounds(370, 293, 200, 20);
		jtContrasena.setFont(jtContrasena.getFont().deriveFont(jtContrasena.getFont().getSize() + 4f));
		jtContrasena.setForeground(new Color(0, 0, 0));
		jtContrasena.setBorder(null);
		add(jtContrasena);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(370, 350, 200, 20);
		add(btnIniciarSesion);

		lblRegistro = new JLabel("Registar Usuario");
		lblRegistro.setBounds(10, 10, 150, 40);
		lblRegistro.setFont(new Font("Segoe UI", 1, 15));
		lblRegistro.setForeground(Color.black);
		add(lblRegistro);
		
		lblRegistro.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
				mainPanel.panelRegistro();
		    }  
		});		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
