package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * ContrarrelojeroDTO is a data transfer object representing a cyclist
 * specialized in time trials. It extends CiclistaDTO and implements the
 * Serializable interface for object serialization. This class includes a
 * property for the maximum speed.
 * 
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

public class ContrarrelojeroDTO extends CiclistaDTO implements Serializable {

	private double velocidadMaxima;

	/**
	 * Default constructor for ContrarrelojeroDTO.
	 */

	public ContrarrelojeroDTO() {
	}

	/**
	 * Constructor with the maximum speed.
	 * 
	 * @param velocidadMaxima The maximum speed.
	 */

	public ContrarrelojeroDTO(double velocidadMaxima) {
		super();
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Constructor with parameters for all properties of the CiclistaDTO class and maximum speed.
	 * 
	 * @param identificador      The identifier.
	 * @param aniosExperiencia   The years of experience.
	 * @param tiempoAcumuladoMin The accumulated time (in minutes).
	 * @param especialidad       The specialty.
	 * @param contextura         The build.
	 * @param equipo             The team.
	 * @param velocidadMaxima    The maximum speed.
	 */

	public ContrarrelojeroDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, double velocidadMaxima) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Constructor with parameters for all properties.
	 * 
	 * @param imagen             The image URL.
	 * @param nombre             The name.
	 * @param cedula             The ID number.
	 * @param correo             The email address.
	 * @param usuario            The username.
	 * @param id                 The ID.
	 * @param contrasena         The password.
	 * @param genero             The gender.
	 * @param identificador      The identifier.
	 * @param aniosExperiencia   The years of experience.
	 * @param tiempoAcumuladoMin The accumulated time (in minutes).
	 * @param especialidad       The specialty.
	 * @param contextura         The build.
	 * @param equipo             The team.
	 * @param velocidadMaxima    The maximum speed.
	 */

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, double velocidadMaxima) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Constructor with parameters for all properties except identifier, years of
	 * experience, accumulated time (in minutes), specialty, build, and team.
	 * 
	 * @param imagen          The image URL.
	 * @param nombre          The name.
	 * @param cedula          The ID number.
	 * @param correo          The email address.
	 * @param usuario         The username.
	 * @param id              The ID.
	 * @param contrasena      The password.
	 * @param genero          The gender.
	 * @param velocidadMaxima The maximum speed.
	 */

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double velocidadMaxima) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Constructor with parameters for all properties of CiclistaDTO.
	 * 
	 * @param identificador      The identifier.
	 * @param aniosExperiencia   The years of experience.
	 * @param tiempoAcumuladoMin The accumulated time (in minutes).
	 * @param especialidad       The specialty.
	 * @param contextura         The build.
	 * @param equipo             The team.
	 */

	public ContrarrelojeroDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
	 * Constructor with parameters for all properties except maximum speed.
	 * 
	 * @param imagen             The image URL.
	 * @param nombre             The name.
	 * @param cedula             The ID number.
	 * @param correo             The email address.
	 * @param usuario            The username.
	 * @param id                 The ID.
	 * @param contrasena         The password.
	 * @param genero             The gender.
	 * @param identificador      The identifier.
	 * @param aniosExperiencia   The years of experience.
	 * @param tiempoAcumuladoMin The accumulated time (in minutes).
	 * @param especialidad       The specialty.
	 * @param contextura         The build.
	 * @param equipo             The team.
	 */

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
	 * Constructor with parameters for all properties of the UsuarioDTO class.
	 * 
	 * @param imagen     The image URL.
	 * @param nombre     The name.
	 * @param cedula     The ID number.
	 * @param correo     The email address.
	 * @param usuario    The username.
	 * @param id         The ID.
	 * @param contrasena The password.
	 * @param genero     The gender.
	 */

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
	 * Retrieves the maximum speed.
	 * 
	 * @return The maximum speed.
	 */

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * Sets the maximum speed.
	 * 
	 * @param velocidadMaxima The maximum speed.
	 */

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Provides a string representation of the ContrarrelojeroDTO object.
	 * 
	 * @return A string representation including all properties of the object.
	 */

	@Override
	public String toString() {
		return super.toString() + "Velocidad Maxima: " + velocidadMaxima + "\n";
	}

	/**
	 * Simulates the visualization action of the time trial cyclist.
	 * 
	 * @return A string indicating the visualization action.
	 */

	public String visualizar() {
		return "El contrarrelojero está visulizando";
	}

	/**
	 * Simulates the concentration action of the time trial cyclist.
	 * 
	 * @return A string indicating the concentration action.
	 */

	public String concentrar() {
		return "El contrarrelojero se está concentrando";
	}

	/**
	 * Simulates the regulation action of the time trial cyclist.
	 * 
	 * @return A string indicating the regulation action.
	 */

	public String regular() {
		return "El contrarrelojero se está regulando";
	}

}
