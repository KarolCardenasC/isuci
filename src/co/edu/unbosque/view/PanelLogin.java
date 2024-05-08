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
		
		lblUsuario = this.crearLabel("lblUsuario.titulo", 300, 240);
		add(lblUsuario);

		jtUsuario = this.crearTextField("", 370, 253);
		add(jtUsuario);
	
		lblContrasena = this.crearLabel("lblContrasena.titulo", 275, 280);
		add(lblContrasena);
		
		jtContrasena = this.crearPasswordField("", 370, 293);
		add(jtContrasena);
		
		btnIniciarSesion = this.crearBoton("Iniciar Sesión", 370, 350, "");
		add(btnIniciarSesion);

		lblRegistro = this.crearLabel("lblRegistro.titulo", 10, 10);
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
