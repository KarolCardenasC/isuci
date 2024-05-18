package co.edu.unbosque.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelCiclista extends MainPanel implements ActionListener {

	private JButton btnImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnPerfil;
	private JButton btnGuardar;
	private JButton btnCambio;

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
	private JLabel lblIdentificador;
	private JLabel lblTiempoAcumulado;
	private JLabel lblEspecialidad;
	private JLabel lblContextura;
	private JLabel lblCaract1;
	private JLabel lblCaract2;
	private JLabel lblCaract3;
	private JLabel lblCedulaTit;
	private JLabel lblAniosExpTit;
	private JLabel lblCorreoTit;
	private JLabel lblUsuarioTit;
	private JLabel lblIdTit;
	private JLabel lblContrasenaTit;
	private JLabel lblGeneroTit;
	private JLabel lblIdentificadorTit;
	private JLabel lblTiempoAcumuladoTit;
	private JLabel lblEspecialidadTit;
	private JLabel lblContexturaTit;
	private JLabel lblCaract1Tit;
	private JLabel lblCaract2Tit;
	private JLabel lblCaract3Tit;

	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtAniosExp;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtIdentificador;
	private JTextField jtTiempoAcumulado;
	private JTextField jtCaract1;
	private JTextField jtCaract2;
	private JTextField jtCaract3;

	private JComboBox<String> jcGenero;
	private JComboBox<String> jcEspecialidad;
	private JComboBox<String> jcContextura;
	private JComboBox<String> jcFuncion;

	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	private JPanel pnlInferior;

	private String imagen = this.getProperties().getProperty("lblImagen.perfil");
	private String opcion = "perfilinicial";
	private boolean imgCambio = false;

	private VentanaUsuario usuarioPanel;

	public PanelCiclista(VentanaUsuario inicial) {

		this.setProperties(FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties"));
		usuarioPanel = inicial;
		setLayout(null);
		initComponents();

	}

	public void initComponents() {
		removeAll();
		iniciarPanelInferior();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();

	}

	public void iniciarPanelIzquierdo() {
		if (pnlIzquierda == null) {
			pnlIzquierda = new JPanel();
		}

		pnlIzquierda.setBounds(
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);

		lblImagenPerfil = this.crearLabel("", new Rectangle(55, 50, 150, 150),
				this.getProperties().getProperty("lblImagen.perfil"));
		pnlIzquierda.add(lblImagenPerfil);

		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 25, 210);
		pnlIzquierda.add(lblNombrePerfil);

		lblRol = this.crearLabel("lblRol.ciclista", 90, 240);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBoton("Perfil Ciclista", 20, 350, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Perfil Ciclista", 20, 400, "");
		pnlIzquierda.add(btnActualizar);

		btnEliminar = this.crearBoton("Eliminar Perfil Ciclista", 20, 450, "");
		pnlIzquierda.add(btnEliminar);

		btnCerrar = this.crearBoton("Cerrar Sesión Ciclista", 20, 600, "");
		pnlIzquierda.add(btnCerrar);

		pnlIzquierda.repaint();
		pnlIzquierda.revalidate();

		add(pnlIzquierda);
	}

	public void iniciarPanelDerecho() {
		if (pnlDerecha == null) {
			pnlDerecha = new JPanel();
		} else {
			pnlDerecha.removeAll();
		}

		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);

		switch (opcion) {

		case "perfilinicial":
			lblImagen = this.crearLabel("", new Rectangle(200, 20, 600, 600), "ciclistaIni.png");
			pnlDerecha.add(lblImagen);
			btnGuardar.setVisible(false);
			break;

		case "perfilciclista":

			lblImagen = this.crearLabel("", new Rectangle(425, 50, 150, 150),
					this.getProperties().getProperty("lblImagen.perfil"));
			pnlDerecha.add(lblImagen);

			lblNombre = this.crearLabel("lblNombre.perfil", 425, 230);
			pnlDerecha.add(lblNombre);

			lblCedulaTit = this.crearLabel("lblCedula.titulo", 100, 280);
			pnlDerecha.add(lblCedulaTit);

			lblAniosExpTit = this.crearLabel("lblAniosExperiencia.titulo", 100, 330);
			pnlDerecha.add(lblAniosExpTit);

			lblCorreoTit = this.crearLabel("lblCorreo.titulo", 100, 380);
			pnlDerecha.add(lblCorreoTit);

			lblUsuarioTit = this.crearLabel("lblUsuario.titulo", 100, 430);
			pnlDerecha.add(lblUsuarioTit);

			lblIdTit = this.crearLabel("lblId.titulo", 100, 480);
			pnlDerecha.add(lblIdTit);

			lblContrasenaTit = this.crearLabel("lblContrasena.titulo", 100, 530);
			pnlDerecha.add(lblContrasenaTit);

			lblGeneroTit = this.crearLabel("lblGenero.titulo", 410, 280);
			pnlDerecha.add(lblGeneroTit);

			lblIdentificadorTit = this.crearLabel("lblIdentificador.titulo", 410, 330);
			pnlDerecha.add(lblIdentificadorTit);

			lblTiempoAcumuladoTit = this.crearLabel("lblTiempoAcumuladoMin.titulo", 410, 380);
			pnlDerecha.add(lblTiempoAcumuladoTit);

			lblEspecialidadTit = this.crearLabel("lblEspecialidad.titulo", 410, 430);
			pnlDerecha.add(lblEspecialidadTit);

			lblContexturaTit = this.crearLabel("lblContextura.titulo", 410, 480);
			pnlDerecha.add(lblContexturaTit);

			lblCedula = this.crearLabel("lblCedula.perfil", 100, 300);
			pnlDerecha.add(lblCedula);

			lblAniosExp = this.crearLabel("lblAniosExperiencia.perfil", 100, 350);
			pnlDerecha.add(lblAniosExp);

			lblCorreo = this.crearLabel("lblCorreo.perfil", 100, 400);
			pnlDerecha.add(lblCorreo);

			lblUsuario = this.crearLabel("lblUsuario.perfil", 100, 450);
			pnlDerecha.add(lblUsuario);

			lblId = this.crearLabel("lblId.perfil", 100, 500);
			pnlDerecha.add(lblId);

			lblContrasena = this.crearLabel("lblContrasena.perfil", 100, 550);
			pnlDerecha.add(lblContrasena);

			lblGenero = this.crearLabel("lblGenero.perfil", 410, 300);
			pnlDerecha.add(lblGenero);

			lblIdentificador = this.crearLabel("lblIdentificador.perfil", 410, 350);
			pnlDerecha.add(lblIdentificador);

			lblTiempoAcumulado = this.crearLabel("lblTiempoAcumuladoMin.perfil", 410, 400);
			pnlDerecha.add(lblTiempoAcumulado);

			lblEspecialidad = this.crearLabel("lblEspecialidad.perfil", 410, 450);
			pnlDerecha.add(lblEspecialidad);

			lblContextura = this.crearLabel("lblContextura.perfil", 410, 500);
			pnlDerecha.add(lblContextura);

			switch (this.getProperties().getProperty("lblEspecialidad.perfil")) {
			case "Ninguna":
				break;

			case "Clasicomano":
				lblCaract1Tit = this.crearLabel("lblClasicosGanados.titulo", 410, 530);
				pnlDerecha.add(lblCaract1Tit);

				lblCaract1 = this.crearLabel("lblClasicosGanados.perfil", 410, 550);
				pnlDerecha.add(lblCaract1);
				break;

			case "Contrarrelojero":
				lblCaract1Tit = this.crearLabel("lblVelocidadMaxima.titulo", 410, 530);
				pnlDerecha.add(lblCaract1Tit);

				lblCaract1 = this.crearLabel("lblVelocidadMaxima.perfil", 410, 550);
				pnlDerecha.add(lblCaract1);
				break;

			case "Escalador":
				lblCaract1Tit = this.crearLabel("lblAceleracionSubida.titulo", 410, 530);
				pnlDerecha.add(lblCaract1Tit);
				lblCaract2Tit = this.crearLabel("lblRampaSoportada.titulo", 720, 280);
				pnlDerecha.add(lblCaract2Tit);

				lblCaract1 = this.crearLabel("lblAceleracionSubida.perfil", 410, 550);
				pnlDerecha.add(lblCaract1);
				lblCaract2 = this.crearLabel("lblRampaSoportada.perfil", 720, 300);
				pnlDerecha.add(lblCaract2);
				break;

			case "Gregario":
				lblCaract1Tit = this.crearLabel("lblFuncionPeloton.titulo", 410, 530);
				pnlDerecha.add(lblCaract1Tit);

				lblCaract1 = this.crearLabel("lblFuncionPeloton.perfil", 410, 550);
				pnlDerecha.add(lblCaract1);
				break;

			case "Rodador":
				lblCaract1Tit = this.crearLabel("lblVelocidadPedaleo.titulo", 410, 530);
				pnlDerecha.add(lblCaract1Tit);

				lblCaract1 = this.crearLabel("lblVelocidadPedaleo.perfil", 410, 550);
				pnlDerecha.add(lblCaract1);
				break;

			case "Sprinter":
				lblCaract1Tit = this.crearLabel("lblExplosion.titulo", 410, 530);
				pnlDerecha.add(lblCaract1Tit);
				lblCaract2Tit = this.crearLabel("lblPotenciaVatios.titulo", 720, 280);
				pnlDerecha.add(lblCaract2Tit);
				lblCaract3Tit = this.crearLabel("lblVelocidadSprint.titulo", 720, 330);
				pnlDerecha.add(lblCaract3Tit);

				lblCaract1 = this.crearLabel("lblExplosion.perfil", 410, 550);
				pnlDerecha.add(lblCaract1);
				lblCaract2 = this.crearLabel("lblPotenciaVatios.perfil", 720, 300);
				pnlDerecha.add(lblCaract2);
				lblCaract3 = this.crearLabel("lblVelocidadSprint.perfil", 720, 350);
				pnlDerecha.add(lblCaract3);
				break;
			}
			btnGuardar.setVisible(false);
			break;

		case "actualizarperfilciclista":

			lblImagen = this.crearLabel("", new Rectangle(445, 10, 120, 120), "actualizarImagen.png");
			btnImagen = this.crearBoton("Imagen Ciclista", 400, 140, "");
			pnlDerecha.add(lblImagen);
			pnlDerecha.add(btnImagen);

			lblNombre = this.crearLabel("lblNombre.titulo", 100, 220);
			jtNombre = this.crearTextField("lblNombre.perfil", 100, 250);
			pnlDerecha.add(lblNombre);
			pnlDerecha.add(jtNombre);

			lblCedula = this.crearLabel("lblCedula.titulo", 100, 300);
			jtCedula = this.crearTextField("lblCedula.perfil", 100, 330);
			jtCedula.setEnabled(false);
			pnlDerecha.add(lblCedula);
			pnlDerecha.add(jtCedula);

			lblAniosExp = this.crearLabel("lblAniosExperiencia.titulo", 100, 380);
			jtAniosExp = this.crearTextField("lblAniosExperiencia.perfil", 100, 410);
			pnlDerecha.add(lblAniosExp);
			pnlDerecha.add(jtAniosExp);

			lblCorreo = this.crearLabel("lblCorreo.titulo", 100, 460);
			jtCorreo = this.crearTextField("lblCorreo.perfil", 100, 490);
			pnlDerecha.add(lblCorreo);
			pnlDerecha.add(jtCorreo);

			lblUsuario = this.crearLabel("lblUsuario.titulo", 100, 540);
			jtUsuario = this.crearTextField("lblUsuario.perfil", 100, 570);
			jtUsuario.setEnabled(false);
			pnlDerecha.add(lblUsuario);
			pnlDerecha.add(jtUsuario);

			lblId = this.crearLabel("lblId.titulo", 410, 220);
			jtId = this.crearTextField("lblId.perfil", 410, 250);
			jtId.setEnabled(false);
			pnlDerecha.add(lblId);
			pnlDerecha.add(jtId);

			lblContrasena = this.crearLabel("lblContrasena.titulo", 410, 300);
			jtContrasena = this.crearTextField("lblContrasena.perfil", 410, 330);
			pnlDerecha.add(lblContrasena);
			pnlDerecha.add(jtContrasena);

			String[] listaGenero = { "Hombre", "Mujer" };

			lblGenero = this.crearLabel("lblGenero.titulo", 410, 380);
			jcGenero = this.crearComboBox(listaGenero, 410, 410);
			if (this.getProperties().getProperty("lblGenero.perfil").contains("Hombre")) {
				jcGenero.setSelectedIndex(0);
			} else {
				jcGenero.setSelectedIndex(1);
			}
			pnlDerecha.add(lblGenero);
			pnlDerecha.add(jcGenero);

			lblIdentificador = this.crearLabel("lblIdentificador.titulo", 410, 460);
			jtIdentificador = this.crearTextField("lblIdentificador.perfil", 410, 490);
			jtIdentificador.setEnabled(false);
			pnlDerecha.add(lblIdentificador);
			pnlDerecha.add(jtIdentificador);

			lblTiempoAcumulado = this.crearLabel("lblTiempoAcumuladoMin.titulo", 410, 540);
			jtTiempoAcumulado = this.crearTextField("lblTiempoAcumuladoMin.perfil", 410, 570);
			jtTiempoAcumulado.setEnabled(false);
			pnlDerecha.add(lblTiempoAcumulado);
			pnlDerecha.add(jtTiempoAcumulado);

			String[] listaEspecialidad = { "Ninguna", "Clasicomano", "Contrarrelojero", "Escalador", "Gregario",
					"Rodador", "Sprinter" };
			String[] listaContextura = { "Ninguna", "Delgado", "Medio", "Grueso" };

			lblEspecialidad = this.crearLabel("lblEspecialidad.titulo", 720, 220);
			jcEspecialidad = this.crearComboBox(listaEspecialidad, 720, 250);
			pnlDerecha.add(lblEspecialidad);
			pnlDerecha.add(jcEspecialidad);
			
			btnCambio = this.crearBoton("Lista Habilidad", 920, 250, "");
			pnlDerecha.add(btnCambio);

			lblContextura = this.crearLabel("lblContextura.titulo", 720, 300);
			jcContextura = this.crearComboBox(listaContextura, 720, 330);

			switch (this.getProperties().getProperty("lblContextura.perfil")) {
			case "Ninguna":
				jcContextura.setSelectedIndex(0);
				break;
			case "Delgado":
				jcContextura.setSelectedIndex(1);
				break;
			case "Medio":
				jcContextura.setSelectedIndex(2);
				break;
			case "Grueso":
				jcContextura.setSelectedIndex(3);
				break;
			}

			pnlDerecha.add(lblContextura);
			pnlDerecha.add(jcContextura);

			lblCaract1 = this.crearLabel("", 720, 380);
			jtCaract1 = this.crearTextField("", 720, 410);
			pnlDerecha.add(lblCaract1);
			pnlDerecha.add(jtCaract1);

			lblCaract2 = this.crearLabel("", 720, 460);
			jtCaract2 = this.crearTextField("", 720, 490);
			pnlDerecha.add(lblCaract2);
			pnlDerecha.add(jtCaract2);

			lblCaract3 = this.crearLabel("", 720, 540);
			jtCaract3 = this.crearTextField("", 720, 570);
			pnlDerecha.add(lblCaract3);
			pnlDerecha.add(jtCaract3);

			String[] listaFuncion = { "Ninguna", "Abastecedor", "Mantener ritmo", "Captura fugas", "Posicionar líder",
					"Proteger líder" };

			jcFuncion = this.crearComboBox(listaFuncion, 720, 410);
			jcFuncion.addActionListener(this);
			jcFuncion.setActionCommand("listafuncion");

			especificos(this.getProperties().getProperty("lblEspecialidad.perfil"));

			pnlDerecha.add(jcFuncion);

			imgCambio = false;

			aplicarFuncionesValidacion();

			btnGuardar.setVisible(true);
			break;
		}

		pnlDerecha.repaint();
		pnlDerecha.revalidate();

		add(pnlDerecha);
	}

	public void especificos(String especialidad) {

		jtCaract1.setVisible(false);
		jtCaract2.setVisible(false);
		jtCaract3.setVisible(false);
		lblCaract1.setVisible(false);
		lblCaract2.setVisible(false);
		lblCaract3.setVisible(false);
		jcFuncion.setVisible(false);

		switch (especialidad) {
		case "Ninguna":
			jcEspecialidad.setSelectedIndex(0);
			break;

		case "Clasicomano":
			jcEspecialidad.setSelectedIndex(1);

			lblCaract1.setText(this.getProperties().getProperty("lblClasicosGanados.titulo"));
			jtCaract1.setText(this.getProperties().getProperty("lblClasicosGanados.perfil"));
			jtCaract1.setVisible(true);
			lblCaract1.setVisible(true);
			break;

		case "Contrarrelojero":
			jcEspecialidad.setSelectedIndex(2);

			lblCaract1.setText(this.getProperties().getProperty("lblVelocidadMaxima.titulo"));
			jtCaract1.setText(this.getProperties().getProperty("lblVelocidadMaxima.perfil"));
			jtCaract1.setVisible(true);
			lblCaract1.setVisible(true);
			break;

		case "Escalador":
			jcEspecialidad.setSelectedIndex(3);

			lblCaract1.setText(this.getProperties().getProperty("lblAceleracionSubida.titulo"));
			jtCaract1.setText(this.getProperties().getProperty("lblAceleracionSubida.perfil"));
			jtCaract1.setVisible(true);
			lblCaract1.setVisible(true);

			lblCaract2.setText(this.getProperties().getProperty("lblRampaSoportada.titulo"));
			jtCaract2.setText(this.getProperties().getProperty("lblRampaSoportada.perfil"));
			jtCaract2.setVisible(true);
			lblCaract2.setVisible(true);
			break;

		case "Gregario":
			jcEspecialidad.setSelectedIndex(4);

			lblCaract1.setText(this.getProperties().getProperty("lblFuncionPeloton.titulo"));

			switch (this.getProperties().getProperty("lblFuncionPeloton.perfil")) {
			case "Ninguna":
				jcFuncion.setSelectedIndex(0);
				break;
			case "Abastecedor":
				jcFuncion.setSelectedIndex(1);
				break;
			case "Mantener ritmo":
				jcFuncion.setSelectedIndex(2);
				break;
			case "Captura fugas":
				jcFuncion.setSelectedIndex(3);
				break;
			case "Posicionar líder":
				jcFuncion.setSelectedIndex(4);
				break;
			case "Proteger líder":
				jcFuncion.setSelectedIndex(5);
				break;
			}
			jcFuncion.setVisible(true);
			lblCaract1.setVisible(true);
			break;

		case "Rodador":
			jcEspecialidad.setSelectedIndex(5);

			lblCaract1.setText(this.getProperties().getProperty("lblVelocidadPedaleo.titulo"));
			jtCaract1.setText(this.getProperties().getProperty("lblVelocidadPedaleo.perfil"));
			jtCaract1.setVisible(true);
			lblCaract1.setVisible(true);
			break;

		case "Sprinter":
			jcEspecialidad.setSelectedIndex(6);

			lblCaract1.setText(this.getProperties().getProperty("lblExplosion.titulo"));
			jtCaract1.setText(this.getProperties().getProperty("lblExplosion.perfil"));
			jtCaract1.setVisible(true);
			lblCaract1.setVisible(true);

			lblCaract2.setText(this.getProperties().getProperty("lblPotenciaVatios.titulo"));
			jtCaract2.setText(this.getProperties().getProperty("lblPotenciaVatios.perfil"));
			jtCaract2.setVisible(true);
			lblCaract2.setVisible(true);

			lblCaract3.setText(this.getProperties().getProperty("lblVelocidadSprint.titulo"));
			jtCaract3.setText(this.getProperties().getProperty("lblVelocidadSprint.perfil"));
			jtCaract3.setVisible(true);
			lblCaract3.setVisible(true);
			break;
		}
		
		aplicarFuncionesValidacion();
	}

	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panel.pnlinferior.alto")));
		pnlInferior.setLayout(null);

		btnGuardar = this.crearBoton("Guardar Ciclista", 750, 10, "");
		pnlInferior.add(btnGuardar);

		add(pnlInferior);
	}

	public void aplicarFuncionesValidacion() {

		numeros(jtCedula);
		numeros(jtAniosExp);
		numeros(jtIdentificador);

		letras(jtNombre);

		limitarCaracter(jtAniosExp, 2);
		limitarCaracter(jtIdentificador, 5);
		limitarCaracter(jtCedula, 10);
		limitarCaracter(jtCorreo, 50);
		limitarCaracter(jtContrasena, 30);
		limitarCaracter(jtNombre, 50);

		switch (this.getProperties().getProperty("lblEspecialidad.perfil")) {
		case "Clasicomano":
			numeros(jtCaract1);

			limitarCaracter(jtCaract1, 7);
			break;

		case "Contrarrelojero":
			numerosDecimal(jtCaract1);

			limitarCaracter(jtCaract1, 7);
			break;

		case "Escalador":
			numerosDecimal(jtCaract1);
			numerosDecimal(jtCaract2);

			limitarCaracter(jtCaract1, 7);
			limitarCaracter(jtCaract2, 7);
			break;

		case "Rodador":
			numerosDecimal(jtCaract1);

			limitarCaracter(jtCaract1, 7);
			break;

		case "Sprinter":
			numerosDecimal(jtCaract1);
			numerosDecimal(jtCaract1);
			numerosDecimal(jtCaract1);

			limitarCaracter(jtCaract1, 7);
			limitarCaracter(jtCaract1, 7);
			limitarCaracter(jtCaract1, 7);
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "imagenciclista":
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
				imgCambio = true;
			}

			iniciarPanelIzquierdo();
			pnlIzquierda.repaint();
			break;

		case "perfilciclista":

		case "actualizarperfilciclista":
			opcion = e.getActionCommand();
			iniciarPanelDerecho();
			break;
		case "listahabilidad":
			especificos(jcEspecialidad.getSelectedItem().toString());
			break;
		}

	}

	public JButton getBtnImagen() {
		return btnImagen;
	}

	public void setBtnImagen(JButton btnImagen) {
		this.btnImagen = btnImagen;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JLabel getLblImagenPerfil() {
		return lblImagenPerfil;
	}

	public void setLblImagenPerfil(JLabel lblImagenPerfil) {
		this.lblImagenPerfil = lblImagenPerfil;
	}

	public JLabel getLblNombrePerfil() {
		return lblNombrePerfil;
	}

	public void setLblNombrePerfil(JLabel lblNombrePerfil) {
		this.lblNombrePerfil = lblNombrePerfil;
	}

	public JLabel getLblRol() {
		return lblRol;
	}

	public void setLblRol(JLabel lblRol) {
		this.lblRol = lblRol;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblAniosExp() {
		return lblAniosExp;
	}

	public void setLblAniosExp(JLabel lblAniosExp) {
		this.lblAniosExp = lblAniosExp;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblIdentificador() {
		return lblIdentificador;
	}

	public void setLblIdentificador(JLabel lblIdentificador) {
		this.lblIdentificador = lblIdentificador;
	}

	public JLabel getLblTiempoAcumulado() {
		return lblTiempoAcumulado;
	}

	public void setLblTiempoAcumulado(JLabel lblTiempoAcumulado) {
		this.lblTiempoAcumulado = lblTiempoAcumulado;
	}

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public void setLblEspecialidad(JLabel lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	public JLabel getLblContextura() {
		return lblContextura;
	}

	public void setLblContextura(JLabel lblContextura) {
		this.lblContextura = lblContextura;
	}

	public JTextField getJtNombre() {
		return jtNombre;
	}

	public void setJtNombre(JTextField jtNombre) {
		this.jtNombre = jtNombre;
	}

	public JTextField getJtCedula() {
		return jtCedula;
	}

	public void setJtCedula(JTextField jtCedula) {
		this.jtCedula = jtCedula;
	}

	public JTextField getJtAniosExp() {
		return jtAniosExp;
	}

	public void setJtAniosExp(JTextField jtAniosExp) {
		this.jtAniosExp = jtAniosExp;
	}

	public JTextField getJtCorreo() {
		return jtCorreo;
	}

	public void setJtCorreo(JTextField jtCorreo) {
		this.jtCorreo = jtCorreo;
	}

	public JTextField getJtUsuario() {
		return jtUsuario;
	}

	public void setJtUsuario(JTextField jtUsuario) {
		this.jtUsuario = jtUsuario;
	}

	public JTextField getJtId() {
		return jtId;
	}

	public void setJtId(JTextField jtId) {
		this.jtId = jtId;
	}

	public JTextField getJtContrasena() {
		return jtContrasena;
	}

	public void setJtContrasena(JTextField jtContrasena) {
		this.jtContrasena = jtContrasena;
	}

	public JTextField getJtIdentificador() {
		return jtIdentificador;
	}

	public void setJtIdentificador(JTextField jtIdentificador) {
		this.jtIdentificador = jtIdentificador;
	}

	public JTextField getJtTiempoAcumulado() {
		return jtTiempoAcumulado;
	}

	public void setJtTiempoAcumulado(JTextField jtTiempoAcumulado) {
		this.jtTiempoAcumulado = jtTiempoAcumulado;
	}

	public JPanel getPnlDerecha() {
		return pnlDerecha;
	}

	public void setPnlDerecha(JPanel pnlDerecha) {
		this.pnlDerecha = pnlDerecha;
	}

	public JPanel getPnlIzquierda() {
		return pnlIzquierda;
	}

	public void setPnlIzquierda(JPanel pnlIzquierda) {
		this.pnlIzquierda = pnlIzquierda;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public VentanaUsuario getUsuarioPanel() {
		return usuarioPanel;
	}

	public void setUsuarioPanel(VentanaUsuario usuarioPanel) {
		this.usuarioPanel = usuarioPanel;
	}

	public JLabel getLblCaract1() {
		return lblCaract1;
	}

	public void setLblCaract1(JLabel lblCaract1) {
		this.lblCaract1 = lblCaract1;
	}

	public JLabel getLblCaract2() {
		return lblCaract2;
	}

	public void setLblCaract2(JLabel lblCaract2) {
		this.lblCaract2 = lblCaract2;
	}

	public JLabel getLblCaract3() {
		return lblCaract3;
	}

	public void setLblCaract3(JLabel lblCaract3) {
		this.lblCaract3 = lblCaract3;
	}

	public JLabel getLblCedulaTit() {
		return lblCedulaTit;
	}

	public void setLblCedulaTit(JLabel lblCedulaTit) {
		this.lblCedulaTit = lblCedulaTit;
	}

	public JLabel getLblAniosExpTit() {
		return lblAniosExpTit;
	}

	public void setLblAniosExpTit(JLabel lblAniosExpTit) {
		this.lblAniosExpTit = lblAniosExpTit;
	}

	public JLabel getLblCorreoTit() {
		return lblCorreoTit;
	}

	public void setLblCorreoTit(JLabel lblCorreoTit) {
		this.lblCorreoTit = lblCorreoTit;
	}

	public JLabel getLblUsuarioTit() {
		return lblUsuarioTit;
	}

	public void setLblUsuarioTit(JLabel lblUsuarioTit) {
		this.lblUsuarioTit = lblUsuarioTit;
	}

	public JLabel getLblIdTit() {
		return lblIdTit;
	}

	public void setLblIdTit(JLabel lblIdTit) {
		this.lblIdTit = lblIdTit;
	}

	public JLabel getLblContrasenaTit() {
		return lblContrasenaTit;
	}

	public void setLblContrasenaTit(JLabel lblContrasenaTit) {
		this.lblContrasenaTit = lblContrasenaTit;
	}

	public JLabel getLblGeneroTit() {
		return lblGeneroTit;
	}

	public void setLblGeneroTit(JLabel lblGeneroTit) {
		this.lblGeneroTit = lblGeneroTit;
	}

	public JLabel getLblIdentificadorTit() {
		return lblIdentificadorTit;
	}

	public void setLblIdentificadorTit(JLabel lblIdentificadorTit) {
		this.lblIdentificadorTit = lblIdentificadorTit;
	}

	public JLabel getLblTiempoAcumuladoTit() {
		return lblTiempoAcumuladoTit;
	}

	public void setLblTiempoAcumuladoTit(JLabel lblTiempoAcumuladoTit) {
		this.lblTiempoAcumuladoTit = lblTiempoAcumuladoTit;
	}

	public JLabel getLblEspecialidadTit() {
		return lblEspecialidadTit;
	}

	public void setLblEspecialidadTit(JLabel lblEspecialidadTit) {
		this.lblEspecialidadTit = lblEspecialidadTit;
	}

	public JLabel getLblContexturaTit() {
		return lblContexturaTit;
	}

	public void setLblContexturaTit(JLabel lblContexturaTit) {
		this.lblContexturaTit = lblContexturaTit;
	}

	public JLabel getLblCaract1Tit() {
		return lblCaract1Tit;
	}

	public void setLblCaract1Tit(JLabel lblCaract1Tit) {
		this.lblCaract1Tit = lblCaract1Tit;
	}

	public JLabel getLblCaract2Tit() {
		return lblCaract2Tit;
	}

	public void setLblCaract2Tit(JLabel lblCaract2Tit) {
		this.lblCaract2Tit = lblCaract2Tit;
	}

	public JLabel getLblCaract3Tit() {
		return lblCaract3Tit;
	}

	public void setLblCaract3Tit(JLabel lblCaract3Tit) {
		this.lblCaract3Tit = lblCaract3Tit;
	}

	public JTextField getJtCaract1() {
		return jtCaract1;
	}

	public void setJtCaract1(JTextField jtCaract1) {
		this.jtCaract1 = jtCaract1;
	}

	public JTextField getJtCaract2() {
		return jtCaract2;
	}

	public void setJtCaract2(JTextField jtCaract2) {
		this.jtCaract2 = jtCaract2;
	}

	public JTextField getJtCaract3() {
		return jtCaract3;
	}

	public void setJtCaract3(JTextField jtCaract3) {
		this.jtCaract3 = jtCaract3;
	}

	public JComboBox<String> getJcGenero() {
		return jcGenero;
	}

	public void setJcGenero(JComboBox<String> jcGenero) {
		this.jcGenero = jcGenero;
	}

	public JComboBox<String> getJcEspecialidad() {
		return jcEspecialidad;
	}

	public void setJcEspecialidad(JComboBox<String> jcEspecialidad) {
		this.jcEspecialidad = jcEspecialidad;
	}

	public JComboBox<String> getJcContextura() {
		return jcContextura;
	}

	public void setJcContextura(JComboBox<String> jcContextura) {
		this.jcContextura = jcContextura;
	}

	public JPanel getPnlInferior() {
		return pnlInferior;
	}

	public void setPnlInferior(JPanel pnlInferior) {
		this.pnlInferior = pnlInferior;
	}

	public boolean isImgCambio() {
		return imgCambio;
	}

	public void setImgCambio(boolean imgCambio) {
		this.imgCambio = imgCambio;
	}

	public JComboBox<String> getJcFuncion() {
		return jcFuncion;
	}

	public void setJcFuncion(JComboBox<String> jcFuncion) {
		this.jcFuncion = jcFuncion;
	}
}