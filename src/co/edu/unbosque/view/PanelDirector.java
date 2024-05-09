package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.utils.MainPanel;

public class PanelDirector extends MainPanel implements ActionListener {

	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnEquipo;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;

	private JLabel lblImagenPerfil;
	private JLabel lblNombrePerfil;
	private JLabel lblRol;
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblNacionalidad;
	private JLabel lblCorreo;
	private JLabel lblUsuario;
	private JLabel lblId;
	private JLabel lblContrasena;
	private JLabel lblGenero;
	private JLabel lblTiempo;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtNacionalidad;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtGenero;
	private JTextField jtTiempo;

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;

	private String imagen = "director.png";
	private String opcion = "perfildirector";

	JLabel lblTitulo;
	private JPanel generalPanel;
	JScrollPane scrollPane;
	private Item newItem;
	private ArrayList<CiclistaDTO> lstCiclistas;

	private VentanaUsuario usuarioPanel;

	public PanelDirector(VentanaUsuario inicial) {

		this.setProperties(FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties"));
		lstCiclistas = new ArrayList<>();
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daaniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(
				new CiclistaDTO("masajista.png", "Maria vValentina Osorio Romero", 1001425987, "maOsoa62@gmail.com",
						"maOsoa62@gmail.com", "0321", "vale214", "Mujer", 0214, 13, 1.20, "Escalador", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daaniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(
				new CiclistaDTO("masajista.png", "Maria vValentina Osorio Romero", 1001425987, "maOsoa62@gmail.com",
						"maOsoa62@gmail.com", "0321", "vale214", "Mujer", 0214, 13, 1.20, "Escalador", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daaniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
		lstCiclistas.add(
				new CiclistaDTO("masajista.png", "Maria vValentina Osorio Romero", 1001425987, "maOsoa62@gmail.com",
						"maOsoa62@gmail.com", "0321", "vale214", "Mujer", 0214, 13, 1.20, "Escalador", "Delgada"));
		lstCiclistas.add(new CiclistaDTO("ciclista.png", "Daniel Fernando Arias Mondragon", 1031554865,
				"dferMon45@gmail.com", "dferMon45@gmail.com", "125430", "danifer451", "Hombre", 1021, 10, 0.50,
				"Gregario", "Delgada"));
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
		pnlIzquierda.setBounds(
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);

		lblImagenPerfil = this.crearLabel("", new Rectangle(55, 50, 150, 150), imagen);
		pnlIzquierda.add(lblImagenPerfil);

		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 25, 210);
		pnlIzquierda.add(lblNombrePerfil);

		lblRol = this.crearLabel("lblRol.director", 25, 240);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBoton("Perfil Director", 20, 300, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Perfil Director", 20, 350, "");
		pnlIzquierda.add(btnActualizar);

		btnEliminar = this.crearBoton("Eliminar Perfil Director", 20, 400, "");
		pnlIzquierda.add(btnEliminar);

		btnEquipo = this.crearBoton("Equipo", 20, 450, "");
		pnlIzquierda.add(btnEquipo);

		btnCerrar = this.crearBoton("Cerrar Sesión Director", 20, 600, "");
		pnlIzquierda.add(btnCerrar);

		add(pnlIzquierda);
	}

	private void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);

		switch (opcion) {

		case "perfildirector":

			lblImagen = this.crearLabel("", new Rectangle(425, 50, 150, 150), imagen);
			pnlDerecha.add(lblImagen);

			lblNombre = this.crearLabel("lblNombre.perfil", 425, 230);
			pnlDerecha.add(lblNombre);

			lblCedula = this.crearLabel("lblCedula.perfil", 200, 300);
			pnlDerecha.add(lblCedula);

			lblNacionalidad = this.crearLabel("lblNacionalidad.perfil", 200, 350);
			pnlDerecha.add(lblNacionalidad);

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

		case "actualizarperfildirector":

			lblImagen = this.crearLabel("", new Rectangle(425, 20, 150, 150), "actualizarImagen.png");
			btnImagen = this.crearBoton("Imagen Director", 400, 180, "");
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

			lblNacionalidad = this.crearLabel("lblNacionalidad.titulo", 150, 350);
			jtNacionalidad = this.crearTextField("", 290, 350);
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

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

		case "equipo":

			lblNombre = this.crearLabel("lblNombreEquipo.titulo", 50, 50);
			jtNombre = this.crearTextField("", 200, 50);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblTiempo = this.crearLabel("lblTiempoEquipo.titulo", 50, 100);
			jtTiempo = this.crearTextField("", 200, 100);
			pnlDerecha.add(lblTiempo);
			pnlDerecha.add(jtTiempo);

			lblNacionalidad = this.crearLabel("lblPaisEquipo.titulo", 450, 50);
			jtNacionalidad = this.crearTextField("", 600, 50);
			pnlDerecha.add(lblNacionalidad);
			pnlDerecha.add(jtNacionalidad);

			lblUsuario = this.crearLabel("lblCiclistasEquipo.titulo", 50, 170);
			pnlDerecha.add(lblUsuario);

			/*
			 * INTENTAR PONER LAS CARTAS DE LOS CICLISTAS
			 */

			mostrarCartas();

			revalidate();

			break;
		}

		add(pnlDerecha);
	}

	private void mostrarCartas() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 200, 940, 440);

		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(null);
		generalPanel.setBackground(Color.WHITE);

		int x = 80;
		int y = 60;
		int heightFinal = lstCiclistas.size();

		for (CiclistaDTO ciclista : lstCiclistas) {
			newItem = new Item(ciclista);
			generalPanel.add(newItem.getItem(x, y));

			if (x + 205 > 800) {
				x = 80;
				y += 305;
			} else {
				x += 205;
			}
		}

		double res = Math.ceil(heightFinal / 4.0);
		if (((res * 300) + 120) + (res * 5) > 700) {
			
			heightFinal = (int) ((res * 300) + 120 + (res * 5));
		} else {
			heightFinal = 700;			
		}

		generalPanel.setBounds(0, 0, 940, heightFinal);
		generalPanel.setPreferredSize(new Dimension(940, heightFinal));
		scrollPane.setViewportView(generalPanel);

		pnlDerecha.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagenDirector":
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

		case "perfildirector":

		case "actualizarperfildirector":

		case "eliminarperfildirector":

		case "equipo":
			opcion = e.getActionCommand();
			pnlDerecha.removeAll();
			iniciarPanelDerecho();
			pnlDerecha.repaint();
			break;

		}

	}

}
