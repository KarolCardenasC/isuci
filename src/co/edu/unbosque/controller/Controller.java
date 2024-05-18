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
import co.edu.unbosque.util.exception.BlankFieldException;
import co.edu.unbosque.util.exception.DuplicateGmailException;
import co.edu.unbosque.util.exception.DuplicateIdException;
import co.edu.unbosque.util.exception.DuplicateIdentificationException;
import co.edu.unbosque.util.EnvioCorreo;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ViewFacade vf;
	private ModelFacade mf;
	private EnvioCorreo _correo;

	public Controller() {
		_correo = new EnvioCorreo();
		vf = new ViewFacade();
		mf = new ModelFacade();
		vf.getvL().setVisible(true);

		asignarClic();
	}

	public void asignarClic() {
		vf.getvL().getPnlLogin().getBtnIniciarSesion().addActionListener(this);
		vf.getvL().getPnlRol().getBtnRegistro().addActionListener(this);

		vf.getvU().getPnlCiclista().getBtnGuardar().addActionListener(this);
		vf.getvU().getPnlMasajista().getBtnGuardar().addActionListener(this);
		vf.getvU().getPnlDirector().getBtnGuardar().addActionListener(this);

		vf.getvU().getPnlCiclista().getBtnEliminar().addActionListener(this);
		vf.getvU().getPnlMasajista().getBtnEliminar().addActionListener(this);
		vf.getvU().getPnlDirector().getBtnEliminar().addActionListener(this);

		vf.getvU().getPnlCiclista().getBtnCerrar().addActionListener(this);
		vf.getvU().getPnlMasajista().getBtnCerrar().addActionListener(this);
		vf.getvU().getPnlDirector().getBtnCerrar().addActionListener(this);

	}

	/*
	 * INICIO DE EXCEPCIONES
	 */
	public void verificarCampoBlanco(String n, String campo) throws BlankFieldException {
		if (n == null || n.equals("")) {
			throw new BlankFieldException(campo);
		}
	}

	public void verificarCampoBlancoItem(int n, String campo) throws BlankFieldException {
		if (n < 0) {
			throw new BlankFieldException(campo);
		}
	}

	public void verificarCedulaDuplicada(long n) throws DuplicateIdException {
		UsuarioDTO admin = mf.getUsuarioDAO().buscarCedula(n);
		MasajistaDTO masajista = mf.getMasajistaDAO().buscarCedula(n);
		DirectorDeportivoDTO director = mf.getDirectorDeportivoDAO().buscarCedula(n);
		CiclistaDTO ciclista = mf.getCiclistaDAO().buscarCedula(n);
		ClasicomanoDTO clasicomano = mf.getClasicomanoDAO().buscarCedula(n);
		ContrarrelojeroDTO contrarrelojero = mf.getContrarrelojeroDAO().buscarCedula(n);
		EscaladorDTO escalador = mf.getEscaladorDAO().buscarCedula(n);
		GregarioDTO gregario = mf.getGregarioDAO().buscarCedula(n);
		RodadorDTO rodador = mf.getRodadorDAO().buscarCedula(n);
		SprinterDTO sprinter = mf.getSprinterDAO().buscarCedula(n);

		if (admin != null || masajista != null || director != null || ciclista != null) {

			throw new DuplicateIdException();

		} else if (clasicomano != null || contrarrelojero != null || escalador != null || gregario != null
				|| rodador != null || sprinter != null) {

			throw new DuplicateIdException();

		}
	}

	public void verificarGmailDuplicado(String g) throws DuplicateGmailException {
		UsuarioDTO admin = mf.getUsuarioDAO().buscarGmail(g);
		MasajistaDTO masajista = mf.getMasajistaDAO().buscarGmail(g);
		DirectorDeportivoDTO director = mf.getDirectorDeportivoDAO().buscarGmail(g);
		CiclistaDTO ciclista = mf.getCiclistaDAO().buscarGmail(g);
		ClasicomanoDTO clasicomano = mf.getClasicomanoDAO().buscarGmail(g);
		ContrarrelojeroDTO contrarrelojero = mf.getContrarrelojeroDAO().buscarGmail(g);
		EscaladorDTO escalador = mf.getEscaladorDAO().buscarGmail(g);
		GregarioDTO gregario = mf.getGregarioDAO().buscarGmail(g);
		RodadorDTO rodador = mf.getRodadorDAO().buscarGmail(g);
		SprinterDTO sprinter = mf.getSprinterDAO().buscarGmail(g);

		if (admin != null || masajista != null || director != null || ciclista != null) {

			throw new DuplicateGmailException();

		} else if (clasicomano != null || contrarrelojero != null || escalador != null || gregario != null
				|| rodador != null || sprinter != null) {

			throw new DuplicateGmailException();

		}
	}

	public void verificarIdentificadorDuplicado(int n) throws DuplicateIdentificationException {

		CiclistaDTO ciclista = mf.getCiclistaDAO().buscarIdentificador(n);
		ClasicomanoDTO clasicomano = mf.getClasicomanoDAO().buscarIdentificador(n);
		ContrarrelojeroDTO contrarrelojero = mf.getContrarrelojeroDAO().buscarIdentificador(n);
		EscaladorDTO escalador = mf.getEscaladorDAO().buscarIdentificador(n);
		GregarioDTO gregario = mf.getGregarioDAO().buscarIdentificador(n);
		RodadorDTO rodador = mf.getRodadorDAO().buscarIdentificador(n);
		SprinterDTO sprinter = mf.getSprinterDAO().buscarIdentificador(n);

		if (ciclista != null || clasicomano != null || contrarrelojero != null || escalador != null || gregario != null
				|| rodador != null || sprinter != null) {

			throw new DuplicateIdentificationException();

		}
	}

	/*
	 * FINAL DE EXCEPCIONES
	 */

	public void registro() {
		try {
			verificarCampoBlanco(vf.getvL().getPnlRol().getJtNombre().getText(), "Nombre");
			verificarCampoBlanco(vf.getvL().getPnlRol().getJtCedula().getText(), "Cedula");
			verificarCampoBlanco(vf.getvL().getPnlRol().getJtCorreo().getText(), "Correo");
			verificarCampoBlanco(vf.getvL().getPnlRol().getJtContrasena().getText(), "Contraseña");
			verificarCampoBlancoItem(vf.getvL().getPnlRol().getJcGenero().getSelectedIndex(), "Genero");

			String nombre = vf.getvL().getPnlRol().getJtNombre().getText();
			long cedula = Long.parseLong(vf.getvL().getPnlRol().getJtCedula().getText());
			verificarCedulaDuplicada(cedula);
			String correo = vf.getvL().getPnlRol().getJtCorreo().getText();
			verificarGmailDuplicado(correo);
			String usuario = vf.getvL().getPnlRol().getJtCorreo().getText();
			String id = vf.getvL().getPnlRol().getJtCorreo().getText();
			String contrasena = vf.getvL().getPnlRol().getJtContrasena().getText();
			String genero = vf.getvL().getPnlRol().getJcGenero().getSelectedItem().toString();

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere crear al ciclista " + nombre + "?") == 0) {

				switch (vf.getvL().getPnlRol().getOpcion()) {
				case "ciclista":
					verificarCampoBlanco(vf.getvL().getPnlRol().getJtIdentificador().getText(), "Identificador");
					verificarCampoBlanco(vf.getvL().getPnlRol().getJtAniosExperiencia().getText(), "Años Experiencia");
					verificarCampoBlancoItem(vf.getvL().getPnlRol().getJcEspecialidad().getSelectedIndex(),
							"Especialidad");
					verificarCampoBlancoItem(vf.getvL().getPnlRol().getJcContextura().getSelectedIndex(), "Contextura");

					int identificador = Integer.parseInt(vf.getvL().getPnlRol().getJtIdentificador().getText());
					verificarIdentificadorDuplicado(identificador);
					int experiencia = Integer.parseInt(vf.getvL().getPnlRol().getJtAniosExperiencia().getText());
					String especialidad = vf.getvL().getPnlRol().getJcEspecialidad().getSelectedItem().toString();
					String contextura = vf.getvL().getPnlRol().getJcContextura().getSelectedItem().toString();

					switch (especialidad) {
					case "Ninguna":
						mf.getCiclistaDAO().crear(new CiclistaDTO("ciclista.png", nombre, cedula, correo, usuario, id,
								contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					case "Clasicomano":
						mf.getClasicomanoDAO().crear(new ClasicomanoDTO("ciclista.png", nombre, cedula, correo, usuario,
								id, contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					case "Contrarrelojero":
						mf.getContrarrelojeroDAO()
								.crear(new ContrarrelojeroDTO("ciclista.png", nombre, cedula, correo, usuario, id,
										contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					case "Escalador":
						mf.getEscaladorDAO().crear(new EscaladorDTO("ciclista.png", nombre, cedula, correo, usuario, id,
								contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					case "Gregario":
						mf.getGregarioDAO()
								.crear(new GregarioDTO("ciclista.png", nombre, cedula, correo, usuario, id, contrasena,
										genero, identificador, experiencia, 0, especialidad, contextura, "Ninguna"));
						break;
					case "Rodador":
						mf.getRodadorDAO().crear(new RodadorDTO("ciclista.png", nombre, cedula, correo, usuario, id,
								contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					case "Sprinter":
						mf.getSprinterDAO().crear(new SprinterDTO("ciclista.png", nombre, cedula, correo, usuario, id,
								contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					default:
						mf.getCiclistaDAO().crear(new CiclistaDTO("ciclista.png", nombre, cedula, correo, usuario, id,
								contrasena, genero, identificador, experiencia, 0, especialidad, contextura));
						break;
					}

					vf.getvL().getPnlRol().getJtIdentificador().setText("");
					vf.getvL().getPnlRol().getJtAniosExperiencia().setText("");
					vf.getvL().getPnlRol().getJcContextura().setSelectedItem(1);
					vf.getvL().getPnlRol().getJcEspecialidad().setSelectedItem(1);

					break;

				case "masajista":
					verificarCampoBlanco(vf.getvL().getPnlRol().getJtAniosExperiencia().getText(), "Años Experiencia");

					int experienciaMsj = Integer.parseInt(vf.getvL().getPnlRol().getJtAniosExperiencia().getText());

					mf.getMasajistaDAO().crear(new MasajistaDTO("masajista.png", nombre, cedula, correo, usuario, id,
							contrasena, genero, experienciaMsj));

					vf.getvL().getPnlRol().getJtAniosExperiencia().setText("");

					break;

				case "director":
					verificarCampoBlanco(vf.getvL().getPnlRol().getJtNacionalidad().getText(), "Nacionalidad");

					String nacionalidad = vf.getvL().getPnlRol().getJtNacionalidad().getText();
					mf.getDirectorDeportivoDAO().crear(new DirectorDeportivoDTO("director.png", nombre, cedula, correo,
							usuario, id, contrasena, genero, nacionalidad));

					vf.getvL().getPnlRol().getJtNacionalidad().setText("");

					break;
				}

				// Proceso de envio del correo
				_correo.enviaCfd(correo, "Registro Usuario ISUCI", "Gracias por registrar su usuario: " + nombre
						+ ", puede hacer uso de la herramienta con la contrasena registrada.", null);
				vf.getCon().imprimirTextoVE("Se ha registrado a " + nombre + " exitosamente");

				vf.getvL().getPnlRol().getJtNombre().setText("");
				vf.getvL().getPnlRol().getJtCedula().setText("");
				vf.getvL().getPnlRol().getJcGenero().setSelectedItem(-1);
				vf.getvL().getPnlRol().getJtCorreo().setText("");
				vf.getvL().getPnlRol().getJtContrasena().setText("");

				vf.getvL().getPnlRol().getMainPanel().panelLogin();
			}

		} catch (BlankFieldException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		} catch (DuplicateIdentificationException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		} catch (DuplicateIdException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		} catch (DuplicateGmailException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
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
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblImagen.perfil", admin.getImagen());
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblNombre.perfil", admin.getNombre());
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblCedula.perfil",
					Long.toString(admin.getCedula()));
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblCorreo.perfil", admin.getCorreo());
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblUsuario.perfil", admin.getUsuario());
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblId.perfil", admin.getId());
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblContrasena.perfil", admin.getContrasena());
			vf.getvU().getPnlAdministrador().getProperties().setProperty("lblGenero.perfil", admin.getGenero());

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

			vf.getvU().getPnlMasajista().iniciarPanelDerecho();
			vf.getvU().getPnlMasajista().getPnlIzquierda().remove(vf.getvU().getPnlMasajista().getLblImagenPerfil());
			vf.getvU().getPnlMasajista().getPnlIzquierda().remove(vf.getvU().getPnlMasajista().getLblNombrePerfil());
			vf.getvU().getPnlMasajista().getPnlIzquierda().remove(vf.getvU().getPnlMasajista().getLblRol());
			vf.getvU().getPnlMasajista().iniciarPanelIzquierdo();

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

			vf.getvU().getPnlDirector().iniciarPanelDerecho();
			vf.getvU().getPnlDirector().getPnlIzquierda().remove(vf.getvU().getPnlDirector().getLblImagenPerfil());
			vf.getvU().getPnlDirector().getPnlIzquierda().remove(vf.getvU().getPnlDirector().getLblNombrePerfil());
			vf.getvU().getPnlDirector().getPnlIzquierda().remove(vf.getvU().getPnlDirector().getLblRol());
			vf.getvU().getPnlDirector().iniciarPanelIzquierdo();

		} else if (ciclista != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = ciclista;

		} else if (clasicomano != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = clasicomano;

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblClasicosGanados.perfil",
					Integer.toString(clasicomano.getNumeroClasicosganados()));

		} else if (contrarrelojero != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = contrarrelojero;

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadMaxima.perfil",
					Double.toString(contrarrelojero.getVelocidadMaxima()));

		} else if (escalador != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = escalador;

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblAceleracionSubida.perfil",
					Double.toString(escalador.getAceleracionPromSubida()));
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblRampaSoportada.perfil",
					Double.toString(escalador.getGradoRampaSoportada()));

		} else if (gregario != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = gregario;

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblFuncionPeloton.perfil",
					gregario.getFuncionPeloton());

		} else if (rodador != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = rodador;

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadPedaleo.perfil",
					Double.toString(rodador.getVelocidadPromPedaleo()));

		} else if (sprinter != null) {

			vf.getvU().setRol("ciclista");
			ciclistaProps = sprinter;

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblExplosion.perfil",
					Double.toString(sprinter.getExplosionMetrosFinales()));
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblPotenciaVatios.perfil",
					Double.toString(sprinter.getPotenciaPromVatios()));
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadSprint.perfil",
					Double.toString(sprinter.getVelocidadPromSprintKm()));

		} else {
			vf.getvU().setRol("incorrecto");
			vf.getCon().imprimirTextoVE("Usuario o Contraseña incorrectos");
		}

		vf.getvL().getPnlLogin().getJtUsuario().setText("");
		vf.getvL().getPnlLogin().getJtContrasena().setText("");

		if (vf.getvU().getRol().equals("ciclista")) {

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblImagen.perfil", ciclistaProps.getImagen());
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
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblEspecialidad.perfil",
					ciclistaProps.getEspecialidad());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblContextura.perfil",
					ciclistaProps.getContextura());

			vf.getvU().getPnlCiclista().iniciarPanelDerecho();
			vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblImagenPerfil());
			vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblNombrePerfil());
			vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblRol());
			vf.getvU().getPnlCiclista().iniciarPanelIzquierdo();

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

		try {
			verificarCampoBlanco(vf.getvU().getPnlDirector().getJtNombre().getText(), "Nombre");
			verificarCampoBlanco(vf.getvU().getPnlDirector().getJtCedula().getText(), "Cedula");
			verificarCampoBlanco(vf.getvU().getPnlDirector().getJtCorreo().getText(), "Correo");
			verificarCampoBlanco(vf.getvU().getPnlDirector().getJtContrasena().getText(), "Contraseña");
			verificarCampoBlancoItem(vf.getvU().getPnlDirector().getJcGenero().getSelectedIndex(), "Genero");
			verificarCampoBlanco(vf.getvU().getPnlDirector().getJtNacionalidad().getText(), "Nacionalidad");

			String img;
			if (vf.getvU().getPnlDirector().isImgCambio()) {
				img = vf.getvU().getPnlDirector().getImagen();
			} else {
				img = vf.getvU().getPnlDirector().getProperties().getProperty("lblImagen.perfil");
			}
			String nombre = vf.getvU().getPnlDirector().getJtNombre().getText();
			long cedula = Long.parseLong(vf.getvU().getPnlDirector().getJtCedula().getText());
			String usuario = vf.getvU().getPnlDirector().getJtUsuario().getText();
			String correo = vf.getvU().getPnlDirector().getJtCorreo().getText();
			System.out.println(correo + ", " + usuario);
			if (!correo.contains(usuario)) {
				verificarGmailDuplicado(correo);
			}
			String contrasena = vf.getvU().getPnlDirector().getJtContrasena().getText();
			String genero = vf.getvU().getPnlDirector().getJcGenero().getSelectedItem().toString();
			String nacionalidad = vf.getvU().getPnlDirector().getJtNacionalidad().getText();

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere actualizar al director "
					+ vf.getvU().getPnlDirector().getProperties().getProperty("lblNombre.perfil") + "?") == 0) {

				vf.getCon().imprimirTextoVE(
						mf.getDirectorDeportivoDAO().actualizarPorCedula(cedula, new DirectorDeportivoDTO(img, nombre,
								cedula, correo, correo, correo, contrasena, genero, nacionalidad)));

				DirectorDeportivoDTO director = mf.getDirectorDeportivoDAO().buscarCedula(cedula);

				vf.getvU().getPnlDirector().getProperties().setProperty("lblImagen.perfil", director.getImagen());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblNombre.perfil", director.getNombre());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblCedula.perfil",
						Long.toString(director.getCedula()));
				vf.getvU().getPnlDirector().getProperties().setProperty("lblCorreo.perfil", director.getCorreo());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblUsuario.perfil", director.getUsuario());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblId.perfil", director.getId());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblContrasena.perfil",
						director.getContrasena());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblGenero.perfil", director.getGenero());
				vf.getvU().getPnlDirector().getProperties().setProperty("lblNacionalidad.perfil",
						director.getNacionalidad());

				vf.getvU().getPnlDirector().getPnlIzquierda().remove(vf.getvU().getPnlDirector().getLblImagenPerfil());
				vf.getvU().getPnlDirector().getPnlIzquierda().remove(vf.getvU().getPnlDirector().getLblNombrePerfil());
				vf.getvU().getPnlDirector().getPnlIzquierda().remove(vf.getvU().getPnlDirector().getLblRol());
				vf.getvU().getPnlDirector().iniciarPanelDerecho();
				vf.getvU().getPnlDirector().iniciarPanelIzquierdo();
			}
		} catch (BlankFieldException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		} catch (DuplicateGmailException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		}

	}

	public void actualizarMasajista() {

		try {
			verificarCampoBlanco(vf.getvU().getPnlMasajista().getJtNombre().getText(), "Nombre");
			verificarCampoBlanco(vf.getvU().getPnlMasajista().getJtCedula().getText(), "Cedula");
			verificarCampoBlanco(vf.getvU().getPnlMasajista().getJtCorreo().getText(), "Correo");
			verificarCampoBlanco(vf.getvU().getPnlMasajista().getJtContrasena().getText(), "Contraseña");
			verificarCampoBlancoItem(vf.getvU().getPnlMasajista().getJcGenero().getSelectedIndex(), "Genero");
			verificarCampoBlanco(vf.getvU().getPnlMasajista().getJtAniosExp().getText(), "Años Experiencia");

			String img;
			if (vf.getvU().getPnlMasajista().isImgCambio()) {
				img = vf.getvU().getPnlMasajista().getImagen();
			} else {
				img = vf.getvU().getPnlMasajista().getProperties().getProperty("lblImagen.perfil");
			}
			String nombre = vf.getvU().getPnlMasajista().getJtNombre().getText();
			long cedula = Long.parseLong(vf.getvU().getPnlMasajista().getJtCedula().getText());
			String usuario = vf.getvU().getPnlMasajista().getJtCorreo().getText();
			String correo = vf.getvU().getPnlMasajista().getJtCorreo().getText();
			if (!correo.contains(usuario)) {
				verificarGmailDuplicado(correo);
			}
			String contrasena = vf.getvU().getPnlMasajista().getJtContrasena().getText();
			String genero = vf.getvU().getPnlMasajista().getJcGenero().getSelectedItem().toString();
			int anios = Integer.parseInt(vf.getvU().getPnlMasajista().getJtAniosExp().getText());

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere actualizar al masajista "
					+ vf.getvU().getPnlMasajista().getProperties().getProperty("lblNombre.perfil") + "?") == 0) {

				vf.getCon().imprimirTextoVE(mf.getMasajistaDAO().actualizarPorCedula(cedula,
						new MasajistaDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero, anios)));

				MasajistaDTO masajista = mf.getMasajistaDAO().buscarCedula(cedula);

				vf.getvU().getPnlMasajista().getProperties().setProperty("lblImagen.perfil", masajista.getImagen());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblNombre.perfil", masajista.getNombre());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblCedula.perfil",
						Long.toString(masajista.getCedula()));
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblCorreo.perfil", masajista.getCorreo());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblUsuario.perfil", masajista.getUsuario());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblId.perfil", masajista.getId());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblContrasena.perfil",
						masajista.getContrasena());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblGenero.perfil", masajista.getGenero());
				vf.getvU().getPnlMasajista().getProperties().setProperty("lblAniosExperiencia.perfil",
						Integer.toString(masajista.getAniosExperiencia()));

				vf.getvU().getPnlMasajista().getPnlIzquierda()
						.remove(vf.getvU().getPnlMasajista().getLblImagenPerfil());
				vf.getvU().getPnlMasajista().getPnlIzquierda()
						.remove(vf.getvU().getPnlMasajista().getLblNombrePerfil());
				vf.getvU().getPnlMasajista().getPnlIzquierda().remove(vf.getvU().getPnlMasajista().getLblRol());
				vf.getvU().getPnlMasajista().iniciarPanelDerecho();
				vf.getvU().getPnlMasajista().iniciarPanelIzquierdo();
			}

		} catch (BlankFieldException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		} catch (DuplicateGmailException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		}

	}

	public void actualizarCiclista() {

		try {
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtNombre().getText(), "Nombre");
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCedula().getText(), "Cedula");
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCorreo().getText(), "Correo");
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtContrasena().getText(), "Contraseña");
			verificarCampoBlancoItem(vf.getvU().getPnlCiclista().getJcGenero().getSelectedIndex(), "Genero");
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtAniosExp().getText(), "Años Experiencia");
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtIdentificador().getText(), "Identificador");
			verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtTiempoAcumulado().getText(), "Tiempo Acumulado");
			verificarCampoBlancoItem(vf.getvU().getPnlCiclista().getJcEspecialidad().getSelectedIndex(),
					"Especialidad");
			verificarCampoBlancoItem(vf.getvU().getPnlCiclista().getJcContextura().getSelectedIndex(), "Contextura");

			String img;
			if (vf.getvU().getPnlCiclista().isImgCambio()) {
				img = vf.getvU().getPnlCiclista().getImagen();
			} else {
				img = vf.getvU().getPnlCiclista().getProperties().getProperty("lblImagen.perfil");
			}
			String nombre = vf.getvU().getPnlCiclista().getJtNombre().getText();
			long cedula = Long.parseLong(vf.getvU().getPnlCiclista().getJtCedula().getText());
			String usuario = vf.getvU().getPnlCiclista().getJtCorreo().getText();
			String correo = vf.getvU().getPnlCiclista().getJtCorreo().getText();
			if (!correo.contains(usuario)) {
				verificarGmailDuplicado(correo);
			}
			String contrasena = vf.getvU().getPnlCiclista().getJtContrasena().getText();
			String genero = vf.getvU().getPnlCiclista().getJcGenero().getSelectedItem().toString();
			int anios = Integer.parseInt(vf.getvU().getPnlCiclista().getJtAniosExp().getText());
			int identificador = Integer.parseInt(vf.getvU().getPnlCiclista().getJtIdentificador().getText());
			double tiempo = Double.parseDouble(vf.getvU().getPnlCiclista().getJtTiempoAcumulado().getText());
			String especialidad = vf.getvU().getPnlCiclista().getJcEspecialidad().getSelectedItem().toString();
			String contextura = vf.getvU().getPnlCiclista().getJcContextura().getSelectedItem().toString();

			CiclistaDTO ciclistaProps = new CiclistaDTO();

			if (vf.getCon().confirmarTextoVE("Esta seguro que quiere actualizar al ciclista "
					+ vf.getvU().getPnlCiclista().getProperties().getProperty("lblNombre.perfil") + "?") == 0) {

				if (especialidad
						.contains(vf.getvU().getPnlCiclista().getProperties().getProperty("lblEspecialidad.perfil"))) {

					switch (especialidad) {
					case "Ninguna":
						vf.getCon()
								.imprimirTextoVE(mf.getCiclistaDAO().actualizarPorCedula(cedula,
										new CiclistaDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero,
												identificador, anios, tiempo, especialidad, contextura)));

						CiclistaDTO ciclista = mf.getCiclistaDAO().buscarCedula(cedula);
						ciclistaProps = ciclista;
						break;

					case "Clasicomano":
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Clasicos Ganados");
						int clasicos = Integer.parseInt(vf.getvU().getPnlCiclista().getJtCaract1().getText());

						vf.getCon()
								.imprimirTextoVE(mf.getClasicomanoDAO().actualizarPorCedula(cedula,
										new ClasicomanoDTO(img, nombre, cedula, correo, correo, correo, contrasena,
												genero, identificador, anios, tiempo, especialidad, contextura,
												clasicos)));

						ClasicomanoDTO clasicomano = mf.getClasicomanoDAO().buscarCedula(cedula);
						ciclistaProps = clasicomano;

						vf.getvU().getPnlCiclista().getProperties().setProperty("lblClasicosGanados.perfil",
								Integer.toString(clasicomano.getNumeroClasicosganados()));
						break;

					case "Contrarrelojero":
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Velocidad Máxima");
						double velocidadMax = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());

						vf.getCon()
								.imprimirTextoVE(mf.getContrarrelojeroDAO().actualizarPorCedula(cedula,
										new ContrarrelojeroDTO(img, nombre, cedula, correo, correo, correo, contrasena,
												genero, identificador, anios, tiempo, especialidad, contextura,
												velocidadMax)));

						ContrarrelojeroDTO contrarrelojero = mf.getContrarrelojeroDAO().buscarCedula(cedula);
						ciclistaProps = contrarrelojero;

						vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadMaxima.perfil",
								Double.toString(contrarrelojero.getVelocidadMaxima()));
						break;

					case "Escalador":
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(),
								"Aceleración Subida");
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract2().getText(),
								"Grado Rampa Soportada");
						double acelSubida = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());
						double rampa = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract2().getText());

						vf.getCon()
								.imprimirTextoVE(mf.getEscaladorDAO().actualizarPorCedula(cedula,
										new EscaladorDTO(img, nombre, cedula, correo, correo, correo, contrasena,
												genero, identificador, anios, tiempo, especialidad, contextura,
												acelSubida, rampa)));

						EscaladorDTO escalador = mf.getEscaladorDAO().buscarCedula(cedula);
						ciclistaProps = escalador;

						vf.getvU().getPnlCiclista().getProperties().setProperty("lblAceleracionSubida.perfil",
								Double.toString(escalador.getAceleracionPromSubida()));
						vf.getvU().getPnlCiclista().getProperties().setProperty("lblRampaSoportada.perfil",
								Double.toString(escalador.getGradoRampaSoportada()));
						break;

					case "Gregario":
						verificarCampoBlancoItem(vf.getvU().getPnlCiclista().getJcFuncion().getSelectedIndex(),
								"Funcion Peloton");
						String funcion = vf.getvU().getPnlCiclista().getJcFuncion().getSelectedItem().toString();

						vf.getCon()
								.imprimirTextoVE(mf.getGregarioDAO().actualizarPorCedula(cedula,
										new GregarioDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero,
												identificador, anios, tiempo, especialidad, contextura, funcion)));

						GregarioDTO gregario = mf.getGregarioDAO().buscarCedula(cedula);
						ciclistaProps = gregario;

						vf.getvU().getPnlCiclista().getProperties().setProperty("lblFuncionPeloton.perfil",
								gregario.getFuncionPeloton());
						break;

					case "Rodador":
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Velocidad Pedaleo");
						double velocidadPedaleo = Double
								.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());

						vf.getCon()
								.imprimirTextoVE(mf.getRodadorDAO().actualizarPorCedula(cedula,
										new RodadorDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero,
												identificador, anios, tiempo, especialidad, contextura,
												velocidadPedaleo)));

						RodadorDTO rodador = mf.getRodadorDAO().buscarCedula(cedula);
						ciclistaProps = rodador;

						vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadPedaleo.perfil",
								Double.toString(rodador.getVelocidadPromPedaleo()));
						break;

					case "Sprinter":
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Explosion");
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract2().getText(), "Potencia Vatios");
						verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract3().getText(), "Velocidad Sprint");
						double metrosFinales = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());
						double potenciaVatios = Double
								.parseDouble(vf.getvU().getPnlCiclista().getJtCaract2().getText());
						double velocidadSprint = Double
								.parseDouble(vf.getvU().getPnlCiclista().getJtCaract3().getText());

						vf.getCon()
								.imprimirTextoVE(mf.getSprinterDAO().actualizarPorCedula(cedula,
										new SprinterDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero,
												identificador, anios, tiempo, especialidad, contextura, metrosFinales,
												potenciaVatios, velocidadSprint)));

						SprinterDTO sprinter = mf.getSprinterDAO().buscarCedula(cedula);
						ciclistaProps = sprinter;

						vf.getvU().getPnlCiclista().getProperties().setProperty("lblExplosion.perfil",
								Double.toString(sprinter.getExplosionMetrosFinales()));
						vf.getvU().getPnlCiclista().getProperties().setProperty("lblPotenciaVatios.perfil",
								Double.toString(sprinter.getPotenciaPromVatios()));
						vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadSprint.perfil",
								Double.toString(sprinter.getVelocidadPromSprintKm()));
						break;
					}

					vf.getvU().getPnlCiclista().getProperties().setProperty("lblImagen.perfil",
							ciclistaProps.getImagen());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblNombre.perfil",
							ciclistaProps.getNombre());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblCedula.perfil",
							Long.toString(ciclistaProps.getCedula()));
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblCorreo.perfil",
							ciclistaProps.getCorreo());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblUsuario.perfil",
							ciclistaProps.getUsuario());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblId.perfil", ciclistaProps.getId());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblContrasena.perfil",
							ciclistaProps.getContrasena());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblGenero.perfil",
							ciclistaProps.getGenero());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblAniosExperiencia.perfil",
							Integer.toString(ciclistaProps.getAniosExperiencia()));
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblIdentificador.perfil",
							Integer.toString(ciclistaProps.getIdentificador()));
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblTiempoAcumuladoMin.perfil",
							Double.toString(ciclistaProps.getTiempoAcumuladoMin()));
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblEspecialidad.perfil",
							ciclistaProps.getEspecialidad());
					vf.getvU().getPnlCiclista().getProperties().setProperty("lblContextura.perfil",
							ciclistaProps.getContextura());

					vf.getvU().getPnlCiclista().getPnlIzquierda()
							.remove(vf.getvU().getPnlCiclista().getLblImagenPerfil());
					vf.getvU().getPnlCiclista().getPnlIzquierda()
							.remove(vf.getvU().getPnlCiclista().getLblNombrePerfil());
					vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblRol());
					vf.getvU().getPnlCiclista().iniciarPanelDerecho();
					vf.getvU().getPnlCiclista().iniciarPanelIzquierdo();

				} else {
					eliminarCrearCiclista(
							vf.getvU().getPnlCiclista().getProperties().getProperty("lblEspecialidad.perfil"), cedula,
							especialidad, img, nombre, correo, contrasena, genero, identificador, anios, tiempo,
							contextura);
				}
			}

		} catch (BlankFieldException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		} catch (DuplicateGmailException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
		}
	}

	public void eliminarCrearCiclista(String especialidadEliminar, long cedula, String especialidadCrear, String img,
			String nombre, String correo, String contrasena, String genero, int identificador, int anios, double tiempo,
			String contextura) {
		try {

			CiclistaDTO ciclistaProps = new CiclistaDTO();
			String mensaje = "no";

			switch (especialidadCrear) {
			case "Ninguna":
				mf.getCiclistaDAO().crear(new CiclistaDTO(img, nombre, cedula, correo, correo, correo, contrasena,
						genero, identificador, anios, tiempo, especialidadCrear, contextura));

				CiclistaDTO ciclista = mf.getCiclistaDAO().buscarCedula(cedula);
				ciclistaProps = ciclista;
				mensaje = "si";
				break;

			case "Clasicomano":
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Clasicos Ganados");
				int clasicos = Integer.parseInt(vf.getvU().getPnlCiclista().getJtCaract1().getText());

				mf.getClasicomanoDAO().crear(new ClasicomanoDTO(img, nombre, cedula, correo, correo, correo, contrasena,
						genero, identificador, anios, tiempo, especialidadCrear, contextura, clasicos));

				ClasicomanoDTO clasicomano = mf.getClasicomanoDAO().buscarCedula(cedula);
				ciclistaProps = clasicomano;

				vf.getvU().getPnlCiclista().getProperties().setProperty("lblClasicosGanados.perfil",
						Integer.toString(clasicomano.getNumeroClasicosganados()));

				mensaje = "si";
				break;

			case "Contrarrelojero":
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Velocidad Máxima");
				double velocidadMax = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());

				mf.getContrarrelojeroDAO().crear(new ContrarrelojeroDTO(img, nombre, cedula, correo, correo, correo,
						contrasena, genero, identificador, anios, tiempo, especialidadCrear, contextura, velocidadMax));

				ContrarrelojeroDTO contrarrelojero = mf.getContrarrelojeroDAO().buscarCedula(cedula);
				ciclistaProps = contrarrelojero;

				vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadMaxima.perfil",
						Double.toString(contrarrelojero.getVelocidadMaxima()));

				mensaje = "si";
				break;

			case "Escalador":
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Aceleración Subida");
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract2().getText(), "Grado Rampa Soportada");
				double acelSubida = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());
				double rampa = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract2().getText());

				mf.getEscaladorDAO().crear(new EscaladorDTO(img, nombre, cedula, correo, correo, correo, contrasena,
						genero, identificador, anios, tiempo, especialidadCrear, contextura, acelSubida, rampa));

				EscaladorDTO escalador = mf.getEscaladorDAO().buscarCedula(cedula);
				ciclistaProps = escalador;

				vf.getvU().getPnlCiclista().getProperties().setProperty("lblAceleracionSubida.perfil",
						Double.toString(escalador.getAceleracionPromSubida()));
				vf.getvU().getPnlCiclista().getProperties().setProperty("lblRampaSoportada.perfil",
						Double.toString(escalador.getGradoRampaSoportada()));

				mensaje = "si";
				break;

			case "Gregario":
				verificarCampoBlancoItem(vf.getvU().getPnlCiclista().getJcFuncion().getSelectedIndex(),
						"Funcion Peloton");
				String funcion = vf.getvU().getPnlCiclista().getJcFuncion().getSelectedItem().toString();

				mf.getGregarioDAO().crear(new GregarioDTO(img, nombre, cedula, correo, correo, correo, contrasena,
						genero, identificador, anios, tiempo, especialidadCrear, contextura, funcion));

				GregarioDTO gregario = mf.getGregarioDAO().buscarCedula(cedula);
				ciclistaProps = gregario;

				vf.getvU().getPnlCiclista().getProperties().setProperty("lblFuncionPeloton.perfil",
						gregario.getFuncionPeloton());

				mensaje = "si";
				break;

			case "Rodador":
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Velocidad Pedaleo");
				double velocidadPedaleo = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());

				mf.getRodadorDAO().crear(new RodadorDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero,
						identificador, anios, tiempo, especialidadCrear, contextura, velocidadPedaleo));

				RodadorDTO rodador = mf.getRodadorDAO().buscarCedula(cedula);
				ciclistaProps = rodador;

				vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadPedaleo.perfil",
						Double.toString(rodador.getVelocidadPromPedaleo()));

				mensaje = "si";
				break;

			case "Sprinter":
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract1().getText(), "Explosion");
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract2().getText(), "Potencia Vatios");
				verificarCampoBlanco(vf.getvU().getPnlCiclista().getJtCaract3().getText(), "Velocidad Sprint");
				double metrosFinales = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract1().getText());
				System.out.println(metrosFinales);
				double potenciaVatios = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract2().getText());
				double velocidadSprint = Double.parseDouble(vf.getvU().getPnlCiclista().getJtCaract3().getText());

				mf.getSprinterDAO()
						.crear(new SprinterDTO(img, nombre, cedula, correo, correo, correo, contrasena, genero,
								identificador, anios, tiempo, especialidadCrear, contextura, metrosFinales,
								potenciaVatios, velocidadSprint));

				SprinterDTO sprinter = mf.getSprinterDAO().buscarCedula(cedula);
				ciclistaProps = sprinter;

				vf.getvU().getPnlCiclista().getProperties().setProperty("lblExplosion.perfil",
						Double.toString(sprinter.getExplosionMetrosFinales()));
				vf.getvU().getPnlCiclista().getProperties().setProperty("lblPotenciaVatios.perfil",
						Double.toString(sprinter.getPotenciaPromVatios()));
				vf.getvU().getPnlCiclista().getProperties().setProperty("lblVelocidadSprint.perfil",
						Double.toString(sprinter.getVelocidadPromSprintKm()));

				mensaje = "si";
				break;
			}

			vf.getvU().getPnlCiclista().getProperties().setProperty("lblImagen.perfil", ciclistaProps.getImagen());
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
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblEspecialidad.perfil",
					ciclistaProps.getEspecialidad());
			vf.getvU().getPnlCiclista().getProperties().setProperty("lblContextura.perfil",
					ciclistaProps.getContextura());

			vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblImagenPerfil());
			vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblNombrePerfil());
			vf.getvU().getPnlCiclista().getPnlIzquierda().remove(vf.getvU().getPnlCiclista().getLblRol());
			vf.getvU().getPnlCiclista().iniciarPanelDerecho();
			vf.getvU().getPnlCiclista().iniciarPanelIzquierdo();

			switch (especialidadEliminar) {
			case "Ninguna":
				mf.getCiclistaDAO().eliminarPorCedula(cedula);
				break;
			case "Clasicomano":
				mf.getClasicomanoDAO().eliminarPorCedula(cedula);
				break;

			case "Contrarrelojero":
				mf.getContrarrelojeroDAO().eliminarPorCedula(cedula);
				break;

			case "Escalador":
				mf.getEscaladorDAO().eliminarPorCedula(cedula);
				break;

			case "Gregario":
				mf.getGregarioDAO().eliminarPorCedula(cedula);
				break;

			case "Rodador":
				mf.getRodadorDAO().eliminarPorCedula(cedula);
				break;

			case "Sprinter":
				mf.getSprinterDAO().eliminarPorCedula(cedula);
				break;
			}

			if (mensaje.contains("si")) {
				vf.getCon().imprimirTextoVE("Se ha actualizado el ciclista con éxito");
			}

		} catch (

		BlankFieldException e) {
			vf.getCon().imprimirTextoVE(e.getMessage());
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

		case "guardardirector":
			actualizarDirector();
			break;
		case "guardarmasajista":
			actualizarMasajista();
			break;

		case "guardarciclista":
			actualizarCiclista();
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
