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

public class PanelCiclista extends MainPanel implements ActionListener {
	
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
	private JLabel lblIdentificador;
	private JLabel lblTiempoAcumulado;
	private JLabel lblEspecialidad;
	private JLabel lblContextura;
	
	private JTextField jtNombre;
	private JTextField jtCedula;
	private JTextField jtAniosExp;
	private JTextField jtCorreo;
	private JTextField jtUsuario;
	private JTextField jtId;
	private JTextField jtContrasena;
	private JTextField jtGenero;
	private JTextField jtIdentificador;
	private JTextField jtTiempoAcumulado;
	private JTextField jtEspecialidad;
	private JTextField jtContextura;
	
	private JPanel pnlDerecha;
	private JPanel pnlIzquierda;
	
	private String imagen = "ciclista.png";
	private String opcion = "perfilinicial";
	
	
	private VentanaUsuario usuarioPanel;

	
	public PanelCiclista(VentanaUsuario inicial) {
		
		this.setProperties(FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/ventanaUsuario.properties")) ;
		usuarioPanel = inicial;
		setLayout(null);
		initComponents();
		
	}
	
	public void initComponents() {
		removeAll();
		iniciarPanelDerecho();
		iniciarPanelIzquierdo();

	}
	
	public void iniciarPanelIzquierdo() {
		
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.vertical")),Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.ancho")), Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlIzquierda.alto")));
		pnlIzquierda.setLayout(null);
		
		lblImagenPerfil = this.crearLabel("", new Rectangle(55, 50, 150, 150), imagen);
		pnlIzquierda.add(lblImagenPerfil);
		
		lblNombrePerfil = this.crearLabel("lblNombre.perfil", 25, 210);
		pnlIzquierda.add(lblNombrePerfil);
		
		lblRol = this.crearLabel("lblRol.ciclista", 25, 240);
		pnlIzquierda.add(lblRol);

		btnPerfil = this.crearBoton("Perfil Ciclista", 20, 350, "");
		pnlIzquierda.add(btnPerfil);

		btnActualizar = this.crearBoton("Actualizar Perfil Ciclista", 20, 400, "");
		pnlIzquierda.add(btnActualizar);
		
		btnEliminar = this.crearBoton("Eliminar Perfil Ciclista", 20, 450, "");
		pnlIzquierda.add(btnEliminar);
		
		btnCerrar = this.crearBoton("Cerrar Sesión Ciclista", 20, 600, "");
		pnlIzquierda.add(btnCerrar);
		
		add(pnlIzquierda);
	}
	
	public void iniciarPanelDerecho() {
		pnlDerecha = new JPanel();
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.horizontal")),
		Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.vertical")),Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.ancho")), Integer.parseInt(this.getProperties().getProperty("panelDirector.pnlDerecha.alto")));
		pnlDerecha.setLayout(null);
		
		
		switch (opcion) {
		
		case "perfilinicial":
			lblImagen = this.crearLabel("", new Rectangle(200, 20, 600, 600), "ciclistaIni.png");
			pnlDerecha.add(lblImagen);
			break;
		
		case "perfilciclista":
			
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
			
			lblIdentificador = this.crearLabel("lblIdentificador.perfil", 600, 300);
			pnlDerecha.add(lblIdentificador);
			
			lblTiempoAcumulado = this.crearLabel("lblTiempoAcumuladoMin.perfil", 600, 350);
			pnlDerecha.add(lblTiempoAcumulado);
			
			lblEspecialidad = this.crearLabel("lblEspecialidad.perfil", 600, 400);
			pnlDerecha.add(lblEspecialidad);
			
			lblContextura = this.crearLabel("lblContextura.perfil", 600, 450);
			pnlDerecha.add(lblContextura);
			
			break;
			
		case "actualizarperfilciclista":
			
			lblImagen = this.crearLabel("", new Rectangle(425, 20, 150, 150), "actualizarImagen.png");
			btnImagen = this.crearBoton("Imagen Ciclista", 400, 180, "");
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
			
			
			lblIdentificador = this.crearLabel("lblIdentificador.titulo", 550, 250);
			jtIdentificador = this.crearTextField("", 720, 250);
			pnlDerecha.add(lblIdentificador);
			pnlDerecha.add(jtIdentificador);
			
			lblTiempoAcumulado = this.crearLabel("lblTiempoAcumuladoMin.titulo", 550, 300);
			jtTiempoAcumulado = this.crearTextField("", 720, 300);
			pnlDerecha.add(lblTiempoAcumulado);
			pnlDerecha.add(jtTiempoAcumulado);
			
			lblEspecialidad = this.crearLabel("lblEspecialidad.titulo", 550, 350);
			jtEspecialidad = this.crearTextField("", 720, 350);
			pnlDerecha.add(lblEspecialidad);
			pnlDerecha.add(jtEspecialidad);
			
			lblContextura = this.crearLabel("lblContextura.titulo", 550, 400);
			jtContextura = this.crearTextField("", 720, 400);
			pnlDerecha.add(lblContextura);
			pnlDerecha.add(jtContextura);
			
			
			btnGuardar = this.crearBoton("Guardar", 750, 600, "");
			pnlDerecha.add(btnGuardar);
			
			break;
		}
		
		add(pnlDerecha);
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
			}
			
			iniciarPanelIzquierdo();
			pnlIzquierda.repaint();
			break;
		
		case "perfilciclista":
			
		case "actualizarperfilciclista":
			
		case "eliminarperfilciclista":
			opcion = e.getActionCommand();
			pnlDerecha.removeAll();
			iniciarPanelDerecho();
			pnlDerecha.repaint();
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

	public JTextField getJtGenero() {
		return jtGenero;
	}

	public void setJtGenero(JTextField jtGenero) {
		this.jtGenero = jtGenero;
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

	public JTextField getJtEspecialidad() {
		return jtEspecialidad;
	}

	public void setJtEspecialidad(JTextField jtEspecialidad) {
		this.jtEspecialidad = jtEspecialidad;
	}

	public JTextField getJtContextura() {
		return jtContextura;
	}

	public void setJtContextura(JTextField jtContextura) {
		this.jtContextura = jtContextura;
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
}