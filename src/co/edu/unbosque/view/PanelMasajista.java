package co.edu.unbosque.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.utils.MainPanel;

public class PanelMasajista extends MainPanel implements ActionListener {
	
	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;
	
	private JLabel lblImagenPerfil;
	private JLabel lblNombrePerfil;
	private JLabel lblRol;
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblAniosExp;
	private JLabel lblCorreo;
	private JLabel lblUsuario;
	private JLabel lblId;
	private JLabel lblContrasena;
	private JLabel lblGenero;
	
	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtAniosExp;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtGenero;
	
	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	
	private String imagen = "masajista.png";
	private String opcion = "perfilmasajista";
	
	
	private VentanaUsuario usuarioPanel;

	
	public PanelMasajista(VentanaUsuario inicial) {
		
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
		
		lblImagenPerfil = this.crearLabel("", new Rectangle(55, 50, 150, 150), imagen);
		pnlIzquierda.add(lblImagenPerfil);
		
		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 25, 210);
		pnlIzquierda.add(lblNombrePerfil);
		
		lblRol = this.crearLabel("lblRol.masajista", 25, 240);
		pnlIzquierda.add(lblRol);
		
		btnPerfil = this.crearBoton("Perfil Masajista", 20, 350, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Perfil Masajista", 20, 400, "");
		pnlIzquierda.add(btnActualizar);
		
		btnEliminar = this.crearBoton("Eliminar Perfil Masajista", 20, 450, "");
		pnlIzquierda.add(btnEliminar);
		
		btnCerrar = this.crearBoton("Cerrar Sesión Masajista", 20, 600, "");
		pnlIzquierda.add(btnCerrar);
		
		add(pnlIzquierda);
	}
	private void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")), Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);
		
		
		switch (opcion) {
		
		case "perfilmasajista":
			
			lblImagen = this.crearLabel("", new Rectangle(425, 50, 150, 150), imagen);
			pnlDerecha.add(lblImagen);
			
			lblNombre = this.crearLabel("lblNombre.perfil", 425, 230);
			pnlDerecha.add(lblNombre);
			
			lblCedula = this.crearLabel("lblCedula.perfil", 200, 300);
			pnlDerecha.add(lblCedula);
			
			lblAniosExp = this.crearLabel("lblAniosExperiencia.perfil", 200, 350);
			pnlDerecha.add(lblAniosExp);
			
			lblCorreo = this.crearLabel("lblCorreo.perfil", 200, 400);
			pnlDerecha.add(lblCorreo);
			
			lblUsuario = this.crearLabel("lblUsuario.perfil", 200, 450);
			pnlDerecha.add(lblUsuario);
			
			lblId = this.crearLabel("lblId.perfil", 200, 500);
			pnlDerecha.add(lblId);
			
			lblContrasena = this.crearLabel("lblContrasena.perfil", 200, 550);
			pnlDerecha.add(lblContrasena);
			
			lblGenero = this.crearLabel("lblGenero.perfil", 200, 600);
			pnlDerecha.add(lblGenero);
			
			break;
			
		case "actualizarperfilmasajista":
			
			lblImagen = this.crearLabel("", new Rectangle(425, 20, 150, 150), "actualizarImagen.png");
			btnImagen = this.crearBoton("Imagen Masajista", 400, 180, "");
			pnlDerecha.add(lblImagen);
			pnlDerecha.add(btnImagen);
			
			lblNombre = this.crearLabel("lblNombre.titulo", 150, 250);
			jtNombre = this.crearTextField("", 290, 250);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);
			
			lblCedula = this.crearLabel("lblCedula.titulo", 150, 300);
			jtCedula = this.crearTextField("", 290, 300);
			pnlDerecha.add(lblCedula);
			pnlDerecha.add(jtCedula);
			
			lblAniosExp = this.crearLabel("lblAniosExperiencia.titulo", 150, 350);
			jtAniosExp = this.crearTextField("", 290, 350);
			pnlDerecha.add(lblAniosExp);
			pnlDerecha.add(jtAniosExp);
			
			lblCorreo = this.crearLabel("lblCorreo.titulo", 150, 400);
			jtCorreo = this.crearTextField("", 290, 400);
			pnlDerecha.add(lblCorreo);
			pnlDerecha.add(jtCorreo);
			
			lblUsuario = this.crearLabel("lblUsuario.titulo", 150, 450);
			jtUsuario = this.crearTextField("", 290, 450);
			pnlDerecha.add(lblUsuario);
			pnlDerecha.add(jtUsuario);
			
			lblId = this.crearLabel("lblId.titulo", 150, 500);
			jtId = this.crearTextField("", 290, 500);
			pnlDerecha.add(lblId);
			pnlDerecha.add(jtId);
			
			lblContrasena = this.crearLabel("lblContrasena.titulo", 150, 550);
			jtContrasena = this.crearTextField("", 290, 550);
			pnlDerecha.add(lblContrasena);
			pnlDerecha.add(jtContrasena);
			
			lblGenero = this.crearLabel("lblGenero.titulo", 150, 600);
			jtGenero = this.crearTextField("", 290, 600);
			pnlDerecha.add(lblGenero);
			pnlDerecha.add(jtGenero);
			
			btnGuardar = this.crearBoton("Guardar", 750, 600, "");
			pnlDerecha.add(btnGuardar);
			
			break;
		}
		
		add(pnlDerecha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case "imagenmasajista": 
			JFileChooser eleccion = new JFileChooser();
			
			eleccion.setCurrentDirectory(new File("imgs"));
			eleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			eleccion.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY, new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					File folderSelec = eleccion.getCurrentDirectory();
					if (!folderSelec.getAbsolutePath().equals("imgs")) {
						
						eleccion.setCurrentDirectory(new File("imgs"));
					}
				}
			});
			
			int resultado = eleccion.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				String nombreArchivo = eleccion.getSelectedFile().getName();
				imagen = nombreArchivo;
			}
			
			iniciarPanelIzquierdo();
			pnlIzquierda.repaint();
			break;
		
		case "perfilmasajista":
			
		case "actualizarperfilmasajista":
			
		case "eliminarperfilmasajista":
			opcion = e.getActionCommand();
			pnlDerecha.removeAll();
			iniciarPanelDerecho();
			pnlDerecha.repaint();
			break;

		}
		
	}
}

