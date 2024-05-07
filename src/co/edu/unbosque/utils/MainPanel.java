package co.edu.unbosque.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

public class MainPanel extends JPanel {

	private Properties properties;

	public MainPanel() {
		properties = FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties");

	}

	public JLabel createLabel(String text, Rectangle bounds) {
		JLabel label = new JLabel();
		label.setText(properties.getProperty(text));
		label.setBounds(bounds);
		label.setFont(new Font("Segoe UI", 1, 20));
		label.setForeground(Color.black);

		return label;
	}
	public JTextField createTextField( Rectangle bounds) {
		JTextField textBox = new JTextField();
		textBox.setBounds(bounds);
		textBox.setFont(textBox.getFont().deriveFont(textBox.getFont().getSize() + 2f));
		textBox.setForeground(new Color(0, 0, 0));
		textBox.setBorder(null);
		return textBox;
	}
	public JButton createButton(String text, Rectangle bounds) {
		JButton button = new JButton();
		button.setText(text);
		button.setBounds(bounds);
		return button;
	}
}
