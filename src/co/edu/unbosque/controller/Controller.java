package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.ClasicomanoDTO;
import co.edu.unbosque.model.ContrarrelojeroDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;
import co.edu.unbosque.model.EscaladorDTO;
import co.edu.unbosque.model.GregarioDTO;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.RodadorDTO;
import co.edu.unbosque.model.SprinterDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ViewFacade vf;
	private ModelFacade mf;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		vf.getvL().setVisible(true);

		asignarClic();
	}

	public void asignarClic() {
		vf.getvL().getPnlLogin().getBtnIniciarSesion().addActionListener(this);
		vf.getvL().getPnlRol().getBtnRegistro().addActionListener(this);

		vf.getvU().getPnlDirector().getBtnGuardar().addActionListener(this);

		vf.getvU().getPnlCiclista().getBtnEliminar().addActionListener(this);
		vf.getvU().getPnlMasajista().getBtnEliminar().addActionListener(this);
		vf.getvU().getPnlDirector().getBtnEliminar().addActionListener(this);
		
		vf.getvU().getPnlCiclista().getBtnCerrar().addActionListener(this);
		vf.getvU().getPnlMasajista().getBtnCerrar().addActionListener(this);
		vf.getvU().getPnlDirector().getBtnCerrar().addActionListener(this);

	}

	public void registro() {
		String nombre = vf.getvL().getPnlRol().getJtNombre().getText();
		long cedula = Long.parseLong(vf.getvL().getPnlRol().getJtCedula().getText());
		String correo = vf.getvL().getPnlRol().getJtCorreo().getText();
		String usuario = vf.getvL().getPnlRol().getJtCorreo().getText();
		String id = vf.getvL().getPnlRol().getJtCorreo().getText();
		String contrasena = vf.getvL().getPnlRol().getJtContrasena().getText();
		String genero = vf.getvL().getPnlRol().getJcGenero().getSelectedItem().toString();

		switch (vf.getvL().getPnlRol().getOpcion()) {
		case "ciclista":
			int identificador = Integer.parseInt(vf.getvL().getPnlRol().getJtIdentificador().getText());
			int experiencia = Integer.parseInt(vf.getvL().getPnlRol().getJtAniosExperiencia().getText());
			double tiempo = Double.parseDouble(vf.getvL().getPnlRol().getJtTiempoAcumuladoMin().getText());
			String especialidad = vf.getvL().getPnlRol().getJcEspecialidad().getSelectedItem().toString();
			String contextura = vf.getvL().getPnlRol().getJcContextura().getSelectedItem().toString();

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere crear al ciclista " + nombre + "?") == 0) {
				switch (especialidad) {
				case "":
					mf.getCiclistaDAO().crear(new CiclistaDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				case "Clasicomano":
					mf.getClasicomanoDAO().crear(new ClasicomanoDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				case "Contrarrelojero":
					mf.getContrarrelojeroDAO()
							.crear(new ContrarrelojeroDTO("ciclista.png", nombre, cedula, correo, usuario, id,
									contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				case "Escalador":
					mf.getEscaladorDAO().crear(new EscaladorDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				case "Gregario":
					mf.getGregarioDAO().crear(new GregarioDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				case "Rodador":
					mf.getRodadorDAO().crear(new RodadorDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				case "Sprinter":
					mf.getSprinterDAO().crear(new SprinterDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				default:
					mf.getCiclistaDAO().crear(new CiclistaDTO("ciclista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, identificador, experiencia, tiempo, especialidad, contextura));
					break;
				}

				vf.getCon().imprimirTextoVE("Se ha registrado a " + nombre + " exitosamente");

				vf.getvL().getPnlRol().getJtNombre().setText("");
				vf.getvL().getPnlRol().getJtCedula().setText("");
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtCorreo().getText();
				vf.getvL().getPnlRol().getJtContrasena().setText("");
				vf.getvL().getPnlRol().getJcGenero().setSelectedItem(-1);
				vf.getvL().getPnlRol().getJtIdentificador().setText("");
				vf.getvL().getPnlRol().getJtAniosExperiencia().setText("");
				vf.getvL().getPnlRol().getJtTiempoAcumuladoMin().setText("");
				vf.getvL().getPnlRol().getJcEspecialidad().setSelectedItem(1);
				vf.getvL().getPnlRol().getJcContextura().setSelectedItem(1);

				vf.getvL().getPnlRol().getMainPanel().panelLogin();
			}
			break;

		case "masajista":
			int experienciaMsj = Integer.parseInt(vf.getvL().getPnlRol().getJtAniosExperiencia().getText());

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere crear al masajista " + nombre + "?") == 0) {
				mf.getMasajistaDAO().crear(new MasajistaDTO("masajista.png", nombre, cedula, correo, usuario, id,
						contrasena, genero, experienciaMsj));

				vf.getCon().imprimirTextoVE("Se ha registrado a " + nombre + " exitosamente");

				vf.getvL().getPnlRol().getJtNombre().setText("");
				vf.getvL().getPnlRol().getJtCedula().setText("");
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtCorreo().getText();
				vf.getvL().getPnlRol().getJtContrasena().setText("");
				vf.getvL().getPnlRol().getJcGenero().setSelectedItem(-1);
				vf.getvL().getPnlRol().getJtAniosExperiencia().setText("");

				vf.getvL().getPnlRol().getMainPanel().panelLogin();
			}
			break;

		case "director":
			String nacionalidad = vf.getvL().getPnlRol().getJtNacionalidad().getText();

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere crear al director " + nombre + "?") == 0) {
				mf.getDirectorDeportivoDAO().crear(new DirectorDeportivoDTO("director.png", nombre, cedula, correo,
						usuario, id, contrasena, genero, nacionalidad));

				vf.getCon().imprimirTextoVE("Se ha registrado a " + nombre + " exitosamente");

				vf.getvL().getPnlRol().getJtNombre().setText("");
				vf.getvL().getPnlRol().getJtCedula().setText("");
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtCorreo().getText();
				vf.getvL().getPnlRol().getJtContrasena().setText("");
				vf.getvL().getPnlRol().getJcGenero().setSelectedItem(-1);
				vf.getvL().getPnlRol().getJtNacionalidad().setText("");

				vf.getvL().getPnlRol().getMainPanel().panelLogin();
			}
			break;
		}

	}

	public void iniciarSesion() {
		String usuario = vf.getvL().getPnlLogin().getJtUsuario().getText();
		String contrasena = vf.getvL().getPnlLogin().getJtContrasena().getText();

		UsuarioDTO admin = mf.getUsuarioDAO().verificarUsuario(usuario, contrasena);
		MasajistaDTO masajista = mf.getMasajistaDAO().verificarUsuario(usuario, contrasena);
		DirectorDeportivoDTO director = mf.getDirectorDeportivoDAO().verificarUsuario(usuario, contrasena);
		CiclistaDTO ciclista = mf.getCiclistaDAO().verificarUsuario(usuario, contrasena);
		ClasicomanoDTO clasicomano = mf.getClasicomanoDAO().verificarUsuario(usuario, contrasena);
		ContrarrelojeroDTO contrarrelojero = mf.getContrarrelojeroDAO().verificarUsuario(usuario, contrasena);
		EscaladorDTO escalador = mf.getEscaladorDAO().verificarUsuario(usuario, contrasena);
		GregarioDTO gregario = mf.getGregarioDAO().verificarUsuario(usuario, contrasena);
		RodadorDTO rodador = mf.getRodadorDAO().verificarUsuario(usuario, contrasena);
		SprinterDTO sprinter = mf.getSprinterDAO().verificarUsuario(usuario, contrasena);

		CiclistaDTO ciclistaProps = ciclista;

		if (admin != null) {

			vf.getvU().setRol("administrador");
			vf.getCon().imprimirTextoVE("El rol es: " + vf.getvU().getRol());

		} else if (masajista != null) {

			vf.getvU().setRol("masajista");

			vf.getvU().getPnlMasajista().getProperties().setProperty("lblImagen.perfil", masajista.getImagen());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblNombre.perfil", masajista.getNombre());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblCedula.perfil",
					Long.toString(masajista.getCedula()));
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblCorreo.perfil", masajista.getCorreo());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblUsuario.perfil", masajista.getUsuario());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblId.perfil", masajista.getId());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblContrasena.perfil", masajista.getContrasena());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblGenero.perfil", masajista.getGenero());
			vf.getvU().getPnlMasajista().getProperties().setProperty("lblAniosExperiencia.perfil",
					Integer.toString(masajista.getAniosExperiencia()));

			//vf.getvU().getPnlMasajista().initComponents();

		} else if (director != null) {

			vf.getvU().setRol("director");

			vf.getvU().getPnlDirector().getProperties().setProperty("lblImagen.perfil", director.getImagen());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblNombre.perfil", director.getNombre());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblCedula.perfil",
					Long.toString(director.getCedula()));
			vf.getvU().getPnlDirector().getProperties().setProperty("lblCorreo.perfil", director.getCorreo());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblUsuario.perfil", director.getUsuario());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblId.perfil", director.getId());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblContrasena.perfil", director.getContrasena());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblGenero.perfil", director.getGenero());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblNacionalidad.perfil",
					director.getNacionalidad());

			//vf.getvU().getPnlDirector().initComponents();

		} else if (ciclista != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = ciclista;

		} else if (clasicomano != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = clasicomano;

		} else if (contrarrelojero != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = contrarrelojero;

		} else if (escalador != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = escalador;

		} else if (gregario != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = gregario;

		} else if (rodador != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = rodador;

		} else if (sprinter != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = sprinter;

		} else {
			vf.getvU().setRol("incorrecto");
			vf.getCon().imprimirTextoVE("Usuario o Contraseña incorrectos");
		}

		vf.getvL().getPnlLogin().getJtUsuario().setText("");
		vf.getvL().getPnlLogin().getJtContrasena().setText("");

		if (vf.getvU().getRol().equals("ciclista")) {

			vf.getvU().getPnlCiclista().setImagen(ciclistaProps.getImagen());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblNombre.perfil", ciclistaProps.getNombre());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblCedula.perfil",
					Long.toString(ciclistaProps.getCedula()));
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblCorreo.perfil", ciclistaProps.getCorreo());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblUsuario.perfil", ciclistaProps.getUsuario());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblId.perfil", ciclistaProps.getId());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblContrasena.perfil",
					ciclistaProps.getContrasena());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblGenero.perfil", ciclistaProps.getGenero());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblAniosExperiencia.perfil",
					Integer.toString(ciclistaProps.getAniosExperiencia()));
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblIdentificador.perfil",
					Integer.toString(ciclistaProps.getIdentificador()));
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblTiempoAcumuladoMin.perfil",
					Double.toString(ciclistaProps.getTiempoAcumuladoMin()));

			System.out.println(ciclistaProps.getEspecialidad());

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblEspecialidad.perfil",
					ciclistaProps.getEspecialidad());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblContextura.perfil",
					ciclistaProps.getContextura());

			//vf.getvU().getPnlCiclista().initComponents();
		}

		if (vf.getvU().getRol() != "incorrecto") {
			vf.getvL().setVisible(false);
			vf.getvU().escogerRol();
			vf.getvU().setVisible(true);
		}
	}

	public void eliminar() {

		String rol = vf.getvU().getRol();
		String especialidad = vf.getvU().getPnlCiclista().getProperties().getProperty("lblEspecialidad.perfil");
		long cedulaCic = Long.parseLong(vf.getvU().getPnlCiclista().getProperties().getProperty("lblCedula.perfil"));
		long cedulaDir = Long.parseLong(vf.getvU().getPnlDirector().getProperties().getProperty("lblCedula.perfil"));
		long cedulaMas = Long.parseLong(vf.getvU().getPnlMasajista().getProperties().getProperty("lblCedula.perfil"));

		if (vf.getCon().confirmarTextoVE("Esta seguro que quiere eliminar al " + rol + "?") == 0) {
			switch (rol) {
			case "ciclista":
				switch (especialidad) {
				case "Clasicomano":
					vf.getCon().imprimirTextoVE(mf.getClasicomanoDAO().eliminarPorCedula(cedulaCic));
					break;

				case "Contrarrelojero":
					vf.getCon().imprimirTextoVE(mf.getContrarrelojeroDAO().eliminarPorCedula(cedulaCic));
					break;

				case "Escalador":
					vf.getCon().imprimirTextoVE(mf.getEscaladorDAO().eliminarPorCedula(cedulaCic));
					break;

				case "Gregario":
					vf.getCon().imprimirTextoVE(mf.getGregarioDAO().eliminarPorCedula(cedulaCic));
					break;

				case "Rodador":
					vf.getCon().imprimirTextoVE(mf.getRodadorDAO().eliminarPorCedula(cedulaCic));
					break;

				case "Sprinter":
					vf.getCon().imprimirTextoVE(mf.getSprinterDAO().eliminarPorCedula(cedulaCic));
					break;

				default:
					vf.getCon().imprimirTextoVE(mf.getCiclistaDAO().eliminarPorCedula(cedulaCic));
					break;
				}
				break;

			case "masajista":
				vf.getCon().imprimirTextoVE(mf.getMasajistaDAO().eliminarPorCedula(cedulaMas));
				break;

			case "director":
				vf.getCon().imprimirTextoVE(mf.getDirectorDeportivoDAO().eliminarPorCedula(cedulaDir));
				break;
			}

			vf.getvU().setVisible(false);
			vf.getvL().setVisible(true);
		}
	}

	public void actualizarDirector() {

		if (vf.getCon().confirmarTextoVE("Esta seguro que quiere actualizar al director "
				+ vf.getvU().getPnlDirector().getProperties().getProperty("lblNombre.perfil") + "?") == 0) {

			String img;
			if(vf.getvU().getPnlDirector().isImgCambio()) {
				img = vf.getvU().getPnlDirector().getImagen();
			}else {
				img = vf.getvU().getPnlDirector().getProperties().getProperty("lblImagen.perfil");
			}
			String nombre = vf.getvU().getPnlDirector().getJtNombre().getText();
			long cedula = Long.parseLong(vf.getvU().getPnlDirector().getJtCedula().getText());
			String correo = vf.getvU().getPnlDirector().getJtCorreo().getText();
			String usuario = vf.getvU().getPnlDirector().getJtCorreo().getText();
			String id = vf.getvU().getPnlDirector().getJtCorreo().getText();
			String contrasena = vf.getvU().getPnlDirector().getJtContrasena().getText();
			String genero = vf.getvU().getPnlDirector().getJcGenero().getSelectedItem().toString();
			String nacionalidad = vf.getvU().getPnlDirector().getJtNacionalidad().getText();

			vf.getCon().imprimirTextoVE(
					mf.getDirectorDeportivoDAO().actualizarPorCedula(cedula, new DirectorDeportivoDTO(img, nombre,
							cedula, correo, usuario, id, contrasena, genero, nacionalidad)));

			DirectorDeportivoDTO director = mf.getDirectorDeportivoDAO().buscarCedula(cedula);

			vf.getvU().getPnlDirector().getProperties().setProperty("lblImagen.perfil", director.getImagen());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblNombre.perfil", director.getNombre());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblCedula.perfil",
					Long.toString(director.getCedula()));
			vf.getvU().getPnlDirector().getProperties().setProperty("lblCorreo.perfil", director.getCorreo());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblUsuario.perfil", director.getUsuario());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblId.perfil", director.getId());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblContrasena.perfil", director.getContrasena());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblGenero.perfil", director.getGenero());
			vf.getvU().getPnlDirector().getProperties().setProperty("lblNacionalidad.perfil",
					director.getNacionalidad());
			
			vf.getvU().getPnlDirector().iniciarPanelIzquierdo();
			vf.getvU().getPnlDirector().getPnlIzquierda().repaint();
		}

	}

	public void cerrarSesion() {
		String rol = vf.getvU().getRol();

		if (vf.getCon().confirmarTextoVE("Esta seguro que quiere cerrar sesión?") == 0) {
			switch (rol) {
			case "ciclista":
				vf.getvU().getPnlCiclista().setOpcion("perfilinicial");
				break;

			case "masajista":
				vf.getvU().getPnlMasajista().setOpcion("perfilinicial");
				break;

			case "director":
				vf.getvU().getPnlDirector().setOpcion("perfilinicial");
				break;
			}

			vf.getvU().setVisible(false);
			vf.getvL().setVisible(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "login":
			iniciarSesion();
			break;

		case "registro":
			registro();
			break;

		case "guardar":
			actualizarDirector();
			break;

		case "eliminarperfilciclista":
		case "eliminarperfilmasajista":
		case "eliminarperfildirector":
			eliminar();
			break;
			
		case "cerrarsesiónciclista":
		case "cerrarsesiónmasajista":
		case "cerrarsesióndirector":
			cerrarSesion();
			break;

		default:
			break;
		}

	}
}
