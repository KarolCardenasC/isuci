package co.edu.unbosque.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.persistence.FileHandler;

public class MainPanel extends JPanel implements ActionListener{

	private Properties properties;
	private static Color colorPrincipal = new Color(0, 0, 64);
	private static Font fuenteLabelPrincipal = new Font("Tahoma",Font.PLAIN, 12);
	private static Font fuenteTextFieldPrincipal = new Font("Tahoma", Font.PLAIN, 12);
	private static Font fuenteLabelBoldPrincipal = new Font("Tahoma", Font.BOLD | Font.PLAIN, 12);
	private static Color colorFuenteBoton = Color.white;
	private static Color colorFuenteLabel = new Color(0, 0, 64);
	private static Color colorTextField = new Color(215, 219, 221);

	public MainPanel() {
		properties = FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties");

	}
	
	public JButton crearBoton(String titulo, int posX, int posY, String icono)
	{
		JButton boton = new JButton(titulo);
		boton.setBounds(new Rectangle(posX, posY, 200, 50));
		
		if (!"".equals(icono))
		{
			Image imagen = new ImageIcon("imgs/" + icono).getImage();
			ImageIcon img = new ImageIcon(imagen.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			boton.setIcon(img);
		}
		
		boton.setActionCommand(titulo.replace(" ", "").toLowerCase());			
		boton.addActionListener(this);
		boton.setBorderPainted(false);
		boton.setBackground(colorPrincipal);
		boton.setHorizontalTextPosition(SwingConstants.RIGHT);
		boton.setForeground(colorFuenteBoton);
		
		return boton;
	}
	
	public JLabel crearLabel(String titulo, int posX, int posY)
	{
		JLabel label = new JLabel("<html>" + properties.getProperty(titulo));
		
		label.setBounds(new Rectangle(posX, posY, 200, 18));
		label.setForeground(colorFuenteLabel);
		label.setFont(fuenteLabelBoldPrincipal);
		
		return label;
	}
	
	public JLabel crearLabel(String titulo, Rectangle bounds, String icono)
	{
		JLabel label = new JLabel("<html>" + properties.getProperty(titulo));
		if (!"".equals(icono))
		{
			Image imagen = new ImageIcon("imgs/" + icono).getImage();
			ImageIcon fondo = new ImageIcon(imagen.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
			label.setIcon(fondo);
			label.setAlignmentX(CENTER_ALIGNMENT);
		}
		label.setBounds(bounds);

		return label;
	}
	
	public JPasswordField crearPasswordField(String titulo, int posX, int posY)
	{
		JPasswordField password = new JPasswordField(titulo);
		
		password.setBounds(new Rectangle(posX, posY, 200, 30));
		password.setBackground(colorTextField);
		password.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize()+1f));
		
		return password;
	}
	
	public JTextField crearTextField(String texto, int posX, int posY)
	{
		JTextField textField = new JTextField(texto);
		
		textField.setBounds(new Rectangle(posX, posY, 200, 30));
		textField.setBackground(colorTextField);
		textField.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize()+2f));
		
		return textField;
	}
	
	public JTable crearTable()
	{
		JTable tabla = new JTable();
		
		return tabla;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
