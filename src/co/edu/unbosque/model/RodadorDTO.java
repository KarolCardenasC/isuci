package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The RodadorDTO class extends the CiclistaDTO class and represents a data transfer object for a rouleur cyclist.
 * This class includes additional information specific to a rouleur cyclist, such as average pedaling speed.
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

public class RodadorDTO extends CiclistaDTO implements Serializable {

	private double velocidadPromPedaleo;

	/**
     * Default constructor for RodadorDTO.
     */
	
	public RodadorDTO() {
	}

	 /**
     * Constructor with average pedaling speed.
     * 
     * @param velocidadPromPedaleo the average pedaling speed
     */
	
	public RodadorDTO(double velocidadPromPedaleo) {
		super();
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	/**
     * Constructor with all attributes for a rouleur cyclist.
     * 
     * @param identificador        the identifier
     * @param aniosExperiencia     the years of experience
     * @param tiempoAcumuladoMin   the accumulated time in minutes
     * @param especialidad         the specialty
     * @param contextura           the body type
     * @param equipo               the team
     * @param velocidadPromPedaleo the average pedaling speed
     */
	
	public RodadorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, double velocidadPromPedaleo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	/**
     * Constructor with all attributes including personal information.
     * 
     * @param imagen               the image
     * @param nombre               the name
     * @param cedula               the ID number
     * @param correo               the email
     * @param usuario              the username
     * @param id                   the ID
     * @param contrasena           the password
     * @param genero               the gender
     * @param identificador        the identifier
     * @param aniosExperiencia     the years of experience
     * @param tiempoAcumuladoMin   the accumulated time in minutes
     * @param especialidad         the specialty
     * @param contextura           the body type
     * @param equipo               the team
     * @param velocidadPromPedaleo the average pedaling speed
     */
	
	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, double velocidadPromPedaleo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	/**
     * Constructor with personal information and average pedaling speed.
     * 
     * @param imagen               the image
     * @param nombre               the name
     * @param cedula               the ID number
     * @param correo               the email
     * @param usuario              the username
     * @param id                   the ID
     * @param contrasena           the password
     * @param genero               the gender
     * @param velocidadPromPedaleo the average pedaling speed
     */
	
	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double velocidadPromPedaleo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	/**
     * Constructor with cycling-specific attributes.
     * 
     * @param identificador      the identifier
     * @param aniosExperiencia   the years of experience
     * @param tiempoAcumuladoMin the accumulated time in minutes
     * @param especialidad       the specialty
     * @param contextura         the body type
     * @param equipo             the team
     */
	
	public RodadorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
     * Constructor with all attributes except average pedaling speed.
     * 
     * @param imagen             the image
     * @param nombre             the name
     * @param cedula             the ID number
     * @param correo             the email
     * @param usuario            the username
     * @param id                 the ID
     * @param contrasena         the password
     * @param genero             the gender
     * @param identificador      the identifier
     * @param aniosExperiencia   the years of experience
     * @param tiempoAcumuladoMin the accumulated time in minutes
     * @param especialidad       the specialty
     * @param contextura         the body type
     * @param equipo             the team
     */
	
	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	 /**
     * Constructor with personal information.
     * 
     * @param imagen     the image
     * @param nombre     the name
     * @param cedula     the ID number
     * @param correo     the email
     * @param usuario    the username
     * @param id         the ID
     * @param contrasena the password
     * @param genero     the gender
     */
	
	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
     * Gets the average pedaling speed.
     * 
     * @return the average pedaling speed
     */
	
	public double getVelocidadPromPedaleo() {
		return velocidadPromPedaleo;
	}

	/**
     * Sets the average pedaling speed.
     * 
     * @param velocidadPromPedaleo the average pedaling speed
     */
	
	public void setVelocidadPromPedaleo(double velocidadPromPedaleo) {
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	/**
     * Returns a string representation of the RodadorDTO object, including the average pedaling speed.
     * 
     * @return a string representation of the object
     */
	
	@Override
	public String toString() {
		return super.toString() + "Velocidad Promedio Pedaleo: " + velocidadPromPedaleo + "\n";
	}

}
