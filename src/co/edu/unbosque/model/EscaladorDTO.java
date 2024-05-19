package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * EscaladorDTO is a data transfer object representing a cyclist specialized in
 * time trials. It extends CiclistaDTO and implements the Serializable interface
 * for object serialization. This class includes a property for the average
 * acceleration on climb, and supported degree of ramp.
 * 
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

public class EscaladorDTO extends CiclistaDTO implements Serializable {

	private double aceleracionPromSubida;
	private double gradoRampaSoportada;

	/**
	 * Default constructor for EscaladorDTO.
	 */

	public EscaladorDTO() {
	}

	/**
	 * Constructor with the average acceleration on climb, and supported degree of
	 * ramp.
	 * 
	 * @param aceleracionPromSubida The average acceleration that the climber has on
	 *                              the climb
	 * @param gradoRampaSoportada   The degree of ramp that the climber supports
	 */

	public EscaladorDTO(double aceleracionPromSubida, double gradoRampaSoportada) {
		super();
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	/**
	 * Constructor with parameters for all properties of the CiclistaDTO class,
	 * average acceleration on climb, and supported degree of ramp.
	 * 
	 * @param identificador         The identifier.
	 * @param aniosExperiencia      The years of experience.
	 * @param tiempoAcumuladoMin    The accumulated time (in minutes).
	 * @param especialidad          The specialty.
	 * @param contextura            The build.
	 * @param equipo                The team.
	 * @param aceleracionPromSubida The average acceleration on climb
	 * @param gradoRampaSoportada   The supported degree of ramp
	 */

	public EscaladorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, double aceleracionPromSubida, double gradoRampaSoportada) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	/**
	 * Constructor with parameters for all properties.
	 * 
	 * @param imagen                The image URL.
	 * @param nombre                The name.
	 * @param cedula                The ID number.
	 * @param correo                The email address.
	 * @param usuario               The username.
	 * @param id                    The ID.
	 * @param contrasena            The password.
	 * @param genero                The gender.
	 * @param identificador         The identifier.
	 * @param aniosExperiencia      The years of experience.
	 * @param tiempoAcumuladoMin    The accumulated time (in minutes).
	 * @param especialidad          The specialty.
	 * @param contextura            The build.
	 * @param equipo                The team.
	 * @param aceleracionPromSubida The average acceleration on climb
	 * @param gradoRampaSoportada   The supported degree of ramp
	 */

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, double aceleracionPromSubida,
			double gradoRampaSoportada) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	/**
	 * Constructor with parameters for all properties except identifier, years of
	 * experience, accumulated time (in minutes), specialty, build, and team.
	 * 
	 * @param imagen                The image URL.
	 * @param nombre                The name.
	 * @param cedula                The ID number.
	 * @param correo                The email address.
	 * @param usuario               The username.
	 * @param id                    The ID.
	 * @param contrasena            The password.
	 * @param genero                The gender.
	 * @param aceleracionPromSubida The average acceleration on climb
	 * @param gradoRampaSoportada   The supported degree of ramp
	 */

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double aceleracionPromSubida, double gradoRampaSoportada) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
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

	public EscaladorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
	 * Constructor with parameters for all properties except average acceleration on
	 * climb, and supported degree of ramp.
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

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
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

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
	 * Gets the average acceleration on climb.
	 * 
	 * @return The average acceleration on climb
	 */

	public double getAceleracionPromSubida() {
		return aceleracionPromSubida;
	}

	/**
	 * Sets the average acceleration on climb.
	 * 
	 * @param aceleracionPromSubida
	 */

	public void setAceleracionPromSubida(double aceleracionPromSubida) {
		this.aceleracionPromSubida = aceleracionPromSubida;
	}

	/**
	 * Gets the supported degree of ramp.
	 * 
	 * @return The supported degree of ramp
	 */

	public double getGradoRampaSoportada() {
		return gradoRampaSoportada;
	}

	/**
	 * Sets the supported degree of ramp.
	 * 
	 * @param gradoRampaSoportada
	 */

	public void setGradoRampaSoportada(double gradoRampaSoportada) {
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	/**
	 * Provides a string representation of the EscaladorDTO object.
	 * 
	 * @return A string representation including all properties of the object.
	 */

	@Override
	public String toString() {
		return super.toString() + "Aceleracion Promedio Subida: " + aceleracionPromSubida + "\n Grado Rampa Soportada: "
				+ gradoRampaSoportada + "\n";
	}

	/**
	 * Simulates the cyclist´s action of pedaling while seated
	 * @return A string with the sitting simulation
	 */

	public String pedalearSentado() {
		return "El escalador está pedaleando sentado";
	}

	/**
	 * Simulates the cyclist´s action of pedaling standing up
	 * @return A string with the standing simulation
	 */

	public String pedalearParado() {
		return "El escalador está pedaleando de pie";
	}
}
