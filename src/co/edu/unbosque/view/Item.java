package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.model.CiclistaDTO;

public class Item extends JPanel {

	private static CiclistaDTO ciclista;
	private static JButton btnInfo;
	private static JButton btnAdd;

	public Item(CiclistaDTO ciclista) {
		this.ciclista = ciclista;
		this.btnInfo = new JButton();
	}

	public static JPanel getItem(int x, int y) {
		JPanel pnlItem = new JPanel();
		pnlItem.setLayout(null);
		pnlItem.setBounds(x, y, 200, 300);
		pnlItem.setToolTipText("Ciclista " + Integer.toString(ciclista.getIdentificador()));
		pnlItem.setBackground(Color.cyan);

		String labelNombre = "<html>" + ciclista.getNombre();
		String labelIdentificador = "<html>ID: " + Integer.toString(ciclista.getIdentificador());

		JLabel lblNom = new JLabel(labelNombre);
		lblNom.setBounds(15, -5, 150, 80);
		lblNom.setFont(new Font("", 1, 15));
		lblNom.setForeground(Color.BLACK);
		pnlItem.add(lblNom);

		JLabel lblIdent = new JLabel(labelIdentificador);
		lblIdent.setBounds(70, 248, 125, 40);
		lblIdent.setFont(new Font("", 1, 20));
		lblIdent.setForeground(Color.BLACK);
		pnlItem.add(lblIdent);

		// Imagen

		ImageIcon imagenInfo = new ImageIcon("imgs/infoCiclista.png");
		ImageIcon imageIconInfo = new ImageIcon(imagenInfo.getImage().getScaledInstance(42, 42, Image.SCALE_DEFAULT));

		/*
		 * ImageIcon imagenCarta = new ImageIcon("imgs/carta.jpg"); ImageIcon
		 * imageIconCarta = new ImageIcon( imagenCarta.getImage().getScaledInstance(200,
		 * 300, Image.SCALE_DEFAULT));
		 */
		JLabel imgCiclista = new JLabel();
		imgCiclista.setBounds(50, 100, 120, 120);
		ImageIcon img = new ImageIcon("imgs/" + ciclista.getImagen());
		ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));

		imgCiclista.setIcon(imageIcon);
		pnlItem.add(imgCiclista);

		// Boton cargar info
		btnInfo.setBounds(149, 15, 42, 42);
		btnInfo.setName("btnInfo_" + ciclista.getIdentificador());
		btnInfo.setIcon(imageIconInfo);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);
		pnlItem.add(btnInfo);

		/*
		 * JLabel imgn = new JLabel(imageIconCarta); imgn.setBounds(0, 0, 200, 300);
		 * pnlItem.add(imgn);
		 */

		return pnlItem;

	}

	public JButton getBtnInfo() {
		return btnInfo;
	}

	static void setBtnInfo(JButton btnInfo) {
		Item.btnInfo = btnInfo;
	}

}