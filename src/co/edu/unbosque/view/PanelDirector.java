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
		
		lblImagen = this.crearLabel("", new Rectangle(55, 50, 150, 150), imagen);
		pnlIzquierda.add(lblImagen);
		
		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 60, 210);
		pnlIzquierda.add(lblNombrePerfil);
		
		btnPerfil = this.crearBoton("Perfil Director", 20, 350, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Director", 20, 400, "");
		pnlIzquierda.add(btnActualizar);
		
		btnEquipo = this.crearBoton("Equipo", 20, 450, "");
		pnlIzquierda.add(btnEquipo);
		
		btnEliminar = this.crearBoton("Eliminar Director", 20, 500, "");
		pnlIzquierda.add(btnEliminar);
		
		btnCerrar = this.crearBoton("Cerrar Sesión", 20, 600, "");
		pnlIzquierda.add(btnCerrar);
		
		add(pnlIzquierda);
	}
	private void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")), Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);
		
		lblNombreAct = this.crearLabel("lblNombre.titulo", 40, 18);
		jtNombre = this.crearTextField("", 130, 30);
		pnlDerecha.add(lblNombreAct);
		pnlDerecha.add(jtNombre);
		
		btnImagen = this.crearBoton("Imagen Perfil Director", 100, 600, "");
		pnlDerecha.add(btnImagen);
		
		add(pnlDerecha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case "imagenperfildirector": {
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
