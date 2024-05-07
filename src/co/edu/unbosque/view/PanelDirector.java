package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.utils.MainPanel;

public class PanelDirector extends MainPanel implements ActionListener {
	
	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEquipo;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnPerfil;
	
	private JLabel lblNombreAct;
	private JLabel lblImagen;
	private JLabel lblNombrePerfil;
	
	private JTextField jtNombre;
	
	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	
	private String imagen = "usuario.png";
	
	
	private VentanaUsuario usuarioPanel;

	
	public PanelDirector(VentanaUsuario inicial) {
		
		this.setProperties(FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties")) ;
		usuarioPanel = inicial;
		setLayout(null);
		initComponents();
		
	}
	
	private void initComponents() {
		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();

	}
	
	private void iniciarPanelIzquierdo() {
		
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.vertical")),Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.ancho")), Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);
		
		lblImagen = new JLabel();
		lblImagen.setBounds(84, 80, 100, 120);
		ImageIcon img = new ImageIcon("imgs/" + imagen);
		ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(100, 120, Image.SCALE_DEFAULT));
		lblImagen.setIcon(imageIcon);
		pnlIzquierda.add(lblImagen);
		
		lblNombrePerfil = this.createLabel("lblNombre.perfil",new Rectangle(50, 210, 150, 80));
		pnlIzquierda.add(lblNombrePerfil);
		
		btnPerfil = this.createButton("Perfil", new Rectangle(20, 350, 200, 50));
		btnPerfil.addActionListener(this);
		btnPerfil.setActionCommand("Perfil");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.createButton("Actualizar", new Rectangle(20, 400, 200, 50));
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("Actualizar");
		pnlIzquierda.add(btnActualizar);
		
		btnEquipo = this.createButton("Equipo", new Rectangle(20, 450, 200, 50));
		btnEquipo.addActionListener(this);
		btnEquipo.setActionCommand("Equipo");
		pnlIzquierda.add(btnEquipo);
		
		btnEliminar = this.createButton("Eliminar", new Rectangle(20, 500, 200, 50));
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		pnlIzquierda.add(btnEliminar);
		
		btnCerrar = this.createButton("Cerrar Sesión", new Rectangle(20, 680, 150, 30));
		btnCerrar.addActionListener(this);
		btnCerrar.setActionCommand("Cerrar");
		pnlIzquierda.add(btnCerrar);
		
		add(pnlIzquierda);
	}
	private void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")), Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);
		
		lblNombreAct = this.createLabel("lblNombre.titulo",new Rectangle(40, 18, 150, 40));
		jtNombre = this.createTextField(new Rectangle(130, 30, 220, 20));
		pnlDerecha.add(lblNombreAct);
		pnlDerecha.add(jtNombre);
		
		btnImagen = this.createButton("Imagen",new Rectangle(100, 610, 200, 20));
		btnImagen.addActionListener(this);
		btnImagen.setActionCommand("ImagenPerfil");
		pnlDerecha.add(btnImagen);
		
		add(pnlDerecha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case "ImagenPerfil": {
			JFileChooser chooser = new JFileChooser();
			// Establecer el directorio inicial
			chooser.setCurrentDirectory(new File("imgs"));
			// Permitir seleccionar solo archivos, no directorios
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			// Escuchar el cambio de directorio
			chooser.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY, new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					File selectedFolder = chooser.getCurrentDirectory();
					if (!selectedFolder.getAbsolutePath().equals("imgs")) {
						// Si el usuario intenta cambiar de carpeta, restablecerla
						chooser.setCurrentDirectory(new File("imgs"));
					}
				}
			});
			
			int result = chooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				String fileName = chooser.getSelectedFile().getName();
				imagen = fileName;
			}
			
			iniciarPanelIzquierdo();
			pnlIzquierda.repaint();
			break;
		}

		}
		
	}
}
