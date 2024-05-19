package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * This class represents the main panel for the application's user interface. It
 * provides methods to create various UI components with specific styles and
 * behaviors.
 *
 * @author Moreno.JP
 * @version 28/04/2024
 *
 */

public class MainPanel extends JPanel implements ActionListener {

	private Properties properties;
	private static Color colorPrincipal = new Color(0, 0, 64);
	private static Font fuenteLabelPrincipal = new Font("Tahoma", Font.PLAIN, 15);
	private static Font fuenteTextFieldPrincipal = new Font("Tahoma", Font.PLAIN, 15);
	private static Font fuenteLabelBoldPrincipal = new Font("Tahoma", Font.BOLD | Font.PLAIN, 16);
	private static Color colorFuenteBoton = Color.white;
	private static Color colorFuenteLabel = new Color(148, 105, 59);
	private static Color colorTextField = new Color(215, 219, 221);

	/**
	 * Constructs a MainPanel and loads the properties file.
	 */

	public MainPanel() {
		properties = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties");

	}

	/**
	 * Creates a JButton with specified title, position, and icon.
	 *
	 * @param titulo the title of the button
	 * @param posX   the x position of the button
	 * @param posY   the y position of the button
	 * @param icono  the icon for the button
	 * @return the created JButton
	 */

	public JButton crearBoton(String titulo, int posX, int posY, String icono) {
		JButton boton = new JButton(titulo);
		boton.setBounds(new Rectangle(posX, posY, 200, 50));

		if (!"".equals(icono)) {
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

	/**
	 * Creates an invisible JButton with specified action command, bounds, and icon.
	 *
	 * @param actCom the action command of the button
	 * @param bounds the bounds of the button
	 * @param icono  the icon for the button
	 * @return the created JButton
	 */

	public JButton crearBotonInvisible(String actCom, Rectangle bounds, String icono) {
		JButton boton = new JButton();
		boton.setBounds(bounds);

		if (!"".equals(icono)) {
			Image imagen = new ImageIcon("imgs/" + icono).getImage();
			ImageIcon img = new ImageIcon(
					imagen.getScaledInstance((int) bounds.getWidth(), (int) bounds.getHeight(), Image.SCALE_SMOOTH));
			boton.setIcon(img);
		}

		boton.setActionCommand(actCom.replace(" ", "").toLowerCase());
		boton.addActionListener(this);
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);

		return boton;
	}
	
	 /**
     * Creates a JLabel with specified title and position.
     *
     * @param titulo the title of the label
     * @param posX   the x position of the label
     * @param posY   the y position of the label
     * @return the created JLabel
     */

	public JLabel crearLabel(String titulo, int posX, int posY) {
		JLabel label = new JLabel("<html>" + properties.getProperty(titulo));

		label.setBounds(new Rectangle(posX, posY, 240, 35));
		label.setForeground(colorFuenteLabel);
		label.setFont(fuenteLabelBoldPrincipal);

		return label;
	}

	 /**
     * Creates a JLabel with specified title, bounds, and icon.
     *
     * @param titulo the title of the label
     * @param bounds the bounds of the label
     * @param icono  the icon for the label
     * @return the created JLabel
     */
	
	public JLabel crearLabel(String titulo, Rectangle bounds, String icono) {
		JLabel label = new JLabel("<html>" + properties.getProperty(titulo));
		if (!"".equals(icono)) {
			Image imagen = new ImageIcon("imgs/" + icono).getImage();
			ImageIcon fondo = new ImageIcon(
					imagen.getScaledInstance((int) bounds.getWidth(), (int) bounds.getHeight(), Image.SCALE_SMOOTH));
			label.setIcon(fondo);
			label.setAlignmentX(CENTER_ALIGNMENT);
		}
		label.setBounds(bounds);

		return label;
	}
	
	public JLabel crearLabelWithName(String nombre, String titulo, Rectangle bounds, String icono) {
		JLabel label = new JLabel("<html>" + titulo);
		if (!"".equals(icono)) {
			Image imagen = new ImageIcon("imgs/" + icono).getImage();
			ImageIcon fondo = new ImageIcon(imagen.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
			label.setIcon(fondo);
			label.setAlignmentX(LEFT_ALIGNMENT);
		}
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setName(titulo);
		label.setBounds(bounds);

		return label;
	}	
	
	public JLabel crearLabel(String nombre, String titulo, int posX, int posY) {
		JLabel label = new JLabel("<html>" + titulo);

		label.setName(nombre);
		label.setBounds(new Rectangle(posX, posY, 250, 35));
		label.setForeground(colorFuenteLabel);
		label.setFont(fuenteLabelBoldPrincipal);

		return label;
	}
	
	public JProgressBar crearProgressBar(Rectangle bounds)
	{
		JProgressBar jProgress = new JProgressBar();
		
		jProgress.setBounds(bounds);
		jProgress.setForeground(colorFuenteLabel);
		jProgress.setFont(fuenteLabelBoldPrincipal);
		jProgress.setBorder(null);
		jProgress.setStringPainted(true);
		
		return jProgress;
	}

	/**
     * Creates a JPasswordField with specified title, position, and font size.
     *
     * @param titulo the title of the password field
     * @param posX   the x position of the password field
     * @param posY   the y position of the password field
     * @return the created JPasswordField
     */
	
	public JPasswordField crearPasswordField(String titulo, int posX, int posY) {
		JPasswordField password = new JPasswordField(titulo);

		password.setBounds(new Rectangle(posX, posY, 200, 30));
		password.setBackground(colorTextField);
		password.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 1f));

		return password;
	}

	/**
     * Creates an invisible JPasswordField with specified bounds.
     *
     * @param bounds the bounds of the password field
     * @return the created JPasswordField
     */
	
	public JPasswordField crearPasswordFieldInvisible(Rectangle bounds) {
		JPasswordField password = new JPasswordField();

		password.setBounds(bounds);
		password.setBorder(null);
		password.setOpaque(false);
		password.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 3f));

		return password;
	}

	public JTextField crearTextFieldInvisible(String texto, Rectangle bounds) {
		JTextField textField = new JTextField(properties.getProperty(texto));

		textField.setBounds(bounds);
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 4f));

		return textField;
	}

	public JTextField crearTextField(String nombre, String texto, int posX, int posY) {
		JTextField textField = new JTextField(texto);

		textField.setName(nombre);
		textField.setBounds(new Rectangle(posX, posY, 250, 40));
		textField.setBorder(null);
		textField.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 4f));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		return textField;
	}	
	
	/**
     * Creates an invisible JTextField with specified text and bounds.
     *
     * @param texto  the text of the text field
     * @param bounds the bounds of the text field
     * @return the created JTextField
     */
	
	public JTextField crearTextField(String texto, int posX, int posY) {
		JTextField textField = new JTextField(properties.getProperty(texto));

		textField.setBounds(new Rectangle(posX, posY, 200, 30));
		textField.setBackground(colorTextField);
		textField.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 2f));

		return textField;
	}
	
	/**
     * Creates a JTextField with specified text, position, and font size.
     *
     * @param texto the text of the text field
     * @param posX  the x position of the text field
     * @param posY  the y position of the text field
     * @return the created JTextField
     */

	public JComboBox<String> crearComboBox(String[] lista, int posX, int posY) {
		JComboBox<String> jComboBox = new JComboBox<>(lista);
		jComboBox.setBounds(new Rectangle(posX, posY, 200, 30));
		jComboBox.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 2f));
		jComboBox.setSelectedIndex(-1);

		return jComboBox;
	}

	/**
     * Creates a JComboBox with specified list, position, and font size.
     *
     * @param lista the list of items in the combo box
     * @param posX  the x position of the combo box
     * @param posY  the y position of the combo box
     * @return the created JComboBox
     */
	
	public JComboBox<String> crearComboBoxInvisible(String[] lista, Rectangle bounds) {
		JComboBox<String> jComboBox = new JComboBox<>(lista);
		jComboBox.setBounds(bounds);
		jComboBox.setBackground(new Color(245, 227, 187));
		jComboBox.setBorder(new LineBorder(new Color(245, 227, 187), -2));
		jComboBox.setFont(fuenteTextFieldPrincipal.deriveFont(fuenteTextFieldPrincipal.getSize() + 2f));
		jComboBox.setSelectedIndex(-1);

		return jComboBox;
	}
	
	/**
	 * Creates a JTable.
	 *
	 * @return the created JTable
	 */

	public JTable crearTable() {
		JTable tabla = new JTable();

		return tabla;
	}

	/**
	 * Adds a key listener to a JTextField to allow only numeric input.
	 *
	 * @param a the JTextField to which the listener is added
	 */
	
	public static void numeros(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}
	
	/**
	 * Adds a key listener to a JTextField to allow only numeric input with decimal point.
	 *
	 * @param a the JTextField to which the listener is added
	 */

	public static void numerosDecimal(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					e.consume();
				}
				if (c == '.' && a.getText().contains(".")) {
					e.consume();
				}
			}
		});
	}

	/**
	 * Adds a key listener to a JTextField to allow only alphabetic input.
	 *
	 * @param a the JTextField to which the listener is added
	 */
	
	public static void letras(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && c != ' ') {
					e.consume();
				}
				if (c == '.' && a.getText().contains(".")) {
					e.consume();
				}
			}
		});
	}

	/**
	 * Limits the number of characters in a JTextField.
	 *
	 * @param textField the JTextField to limit
	 * @param limit     the maximum number of characters allowed
	 */
	
	public static void limitarCaracter(JTextField textField, int limit) {
		AbstractDocument doc = (AbstractDocument) textField.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				if (fb.getDocument().getLength() + text.length() - length > limit) {
					Toolkit.getDefaultToolkit().beep();
					return;
				}
				super.replace(fb, offset, length, text, attrs);
			}
		});
	}

	/**
	 * Gets the properties object.
	 *
	 * @return the properties object
	 */
	
	public Properties getProperties() {
		return properties;
	}

	/**
	 * Sets the properties object.
	 *
	 * @param properties the properties object to set
	 */
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 // Implementation of action event handling goes here
	}

}
