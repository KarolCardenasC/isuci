package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * The Item class represents a graphical component in the form of a JPanel 
 * that displays information about a CiclistaDTO object.
 * 
 * @author Moreno.JP
 * @version 28/04/2024
 * 
 */

public class Item extends JPanel {

	private static CiclistaDTO ciclista;
	private static UsuarioDTO usuario;	
	private static JButton btnInfo;
	private static JButton btnAdd;
	
	private static JCheckBox chkSelect;

	/**
     * Constructs an Item object with the given CiclistaDTO.
     *
     * @param ciclista the CiclistaDTO object containing the cyclist's information
     */
	
	public Item(CiclistaDTO ciclista) {
		this.ciclista = ciclista;
		btnInfo = new JButton();
		chkSelect = new JCheckBox();
		setName("Ciclista " + ciclista.getId());
	}
	
	public Item(UsuarioDTO usuario) {
		this.usuario = usuario;
		this.btnInfo = new JButton();
	}

	/**
     * Creates a JPanel that displays the cyclist's information.
     *
     * @param x the x-coordinate of the panel
     * @param y the y-coordinate of the panel
     * @return a JPanel displaying the cyclist's information
     */
	
	public static JPanel getItem(int x, int y) {
		JPanel pnlItem = new JPanel();
		pnlItem.setName("Ciclista " + ciclista.getId());
		pnlItem.setLayout(null);
		pnlItem.setBounds(x, y, 200, 300);
		pnlItem.setToolTipText("Ciclista " + Integer.toString(ciclista.getIdentificador()));
		pnlItem.setBackground(Color.cyan);

		String labelNombre = "<html>" + ciclista.getNombre();
		String labelIdentificador = "<html>ID: " + Integer.toString(ciclista.getIdentificador());
		String labelEspecialidad = "<html>" + ciclista.getEspecialidad();
		String labelRol = "<html>" + ciclista.getRol();

		JLabel lblNom = new JLabel(labelNombre);
		lblNom.setBounds(15, -5, 150, 80);
		lblNom.setFont(new Font("", 1, 15));
		lblNom.setForeground(Color.BLACK);
		pnlItem.add(lblNom);

		JLabel lblIdent = new JLabel(labelIdentificador);
		lblIdent.setBounds(70, 200, 125, 40);
		lblIdent.setFont(new Font("", 1, 20));
		lblIdent.setForeground(Color.BLACK);
		pnlItem.add(lblIdent);

		JLabel lblRol = new JLabel(labelRol);
		lblRol.setBounds(70, 245, 125, 20);
		lblRol.setFont(new Font("", 1, 15));
		lblRol.setForeground(Color.BLACK);
		pnlItem.add(lblRol);
		
		JLabel lblEsp = new JLabel(labelEspecialidad);
		lblEsp.setBounds(70, 270, 125, 20);
		lblEsp.setFont(new Font("", 1, 15));
		lblEsp.setForeground(Color.BLACK);
		pnlItem.add(lblEsp);
		

		ImageIcon imagenInfo = new ImageIcon("imgs/infoCiclista.png");
		ImageIcon imageIconInfo = new ImageIcon(imagenInfo.getImage().getScaledInstance(42, 42, Image.SCALE_DEFAULT));
		
		JLabel imgCiclista = new JLabel();
		imgCiclista.setBounds(60, 90, 100, 100);
		ImageIcon img = new ImageIcon("imgs/" + ciclista.getImagen());
		ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

		imgCiclista.setIcon(imageIcon);
		pnlItem.add(imgCiclista);

//		btnInfo.setBounds(149, 15, 42, 42);
//		btnInfo.setName("btnInfo_" + ciclista.getIdentificador());
//		btnInfo.setIcon(imageIconInfo);
//		btnInfo.setContentAreaFilled(false);
//		btnInfo.setBorderPainted(false);
//		pnlItem.add(btnInfo);
		
		chkSelect.setBounds(149, 15, 42, 42);
		chkSelect.setName("chkInfo_" + ciclista.getIdentificador());
//		btnInfo.setContentAreaFilled(false);
//		btnInfo.setBorderPainted(false);
		pnlItem.add(chkSelect);		

		return pnlItem;

	}
	public static JPanel getItemUsuarios(int x, int y) {
		JPanel pnlItem = new JPanel();
		pnlItem.setLayout(null);
		pnlItem.setBounds(x, y, 200, 300);
		pnlItem.setToolTipText("Usuario " + Long.toString(usuario.getCedula()));
		pnlItem.setBackground(Color.cyan);
		
		String labelNombre = "<html>" + usuario.getNombre();
		String labelCedula = "<html>CC: " + Long.toString(usuario.getCedula());
		String labelRol = "<html>" + usuario.getRol();
		
		JLabel lblNom = new JLabel(labelNombre);
		lblNom.setBounds(15, -5, 150, 80);
		lblNom.setFont(new Font("", 1, 15));
		lblNom.setForeground(Color.BLACK);
		pnlItem.add(lblNom);
		
		JLabel lblCc = new JLabel(labelCedula);
		lblCc.setBounds(20, 200, 165, 40);
		lblCc.setFont(new Font("", 1, 20));
		lblCc.setForeground(Color.BLACK);
		pnlItem.add(lblCc);
		
		JLabel lblRol = new JLabel(labelRol);
		lblRol.setBounds(50, 245, 145, 20);
		lblRol.setFont(new Font("", 1, 15));
		lblRol.setForeground(Color.BLACK);
		pnlItem.add(lblRol);
		
		ImageIcon imagenInfo = new ImageIcon("imgs/infoUsuario.png");
		ImageIcon imageIconInfo = new ImageIcon(imagenInfo.getImage().getScaledInstance(42, 42, Image.SCALE_DEFAULT));
		
		JLabel imgUsuario = new JLabel();
		imgUsuario.setBounds(60, 90, 100, 100);
		ImageIcon img = new ImageIcon("imgs/" + usuario.getImagen());
		ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		imgUsuario.setIcon(imageIcon);
		pnlItem.add(imgUsuario);
		
		btnInfo.setBounds(149, 15, 42, 42);
		btnInfo.setName("btnInfo_" + usuario.getCedula());
		btnInfo.setIcon(imageIconInfo);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);
		pnlItem.add(btnInfo);
		
		return pnlItem;
		
	}

	/**
     * Gets the button used to display cyclist information.
     *
     * @return the info button
     */
	
	public JButton getBtnInfo() {
		return btnInfo;
	}

	/**
     * Sets the button used to display cyclist information.
     *
     * @param btnInfo the info button to set
     */
	
	static void setBtnInfo(JButton btnInfo) {
		Item.btnInfo = btnInfo;
	}
	
	public boolean getIsSelect()
	{
		return chkSelect.isSelected();
	}

	public CiclistaDTO getCiclista()
	{
		return this.ciclista;
	}
}