package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The SprinterDTO class extends the CiclistaDTO class and represents a data transfer object for a sprinter cyclist.
 * This class includes additional information specific to a sprinter cyclist, such as final meters explosion,
 * average power in watts, and average sprint speed in km/h.
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

public class SprinterDTO extends CiclistaDTO implements Serializable {

	private double explosionMetrosFinales;
	private double potenciaPromVatios;
	private double velocidadPromSprintKm;

	 /**
     * Default constructor for SprinterDTO.
     */
	
	public SprinterDTO() {
	}

	/**
     * Constructor with specific attributes for a sprinter cyclist.
     * 
     * @param explosionMetrosFinales the explosion in the final meters
     * @param potenciaPromVatios the average power in watts
     * @param velocidadPromSprintKm the average sprint speed in km/h
     */
	
	public SprinterDTO(double explosionMetrosFinales, double potenciaPromVatios, double velocidadPromSprintKm) {
		super();
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	/**
     * Constructor with all attributes for a sprinter cyclist.
     * 
     * @param identificador the identifier
     * @param aniosExperiencia the years of experience
     * @param tiempoAcumuladoMin the accumulated time in minutes
     * @param especialidad the specialty
     * @param contextura the body type
     * @param equipo the team
     * @param explosionMetrosFinales the explosion in the final meters
     * @param potenciaPromVatios the average power in watts
     * @param velocidadPromSprintKm the average sprint speed in km/h
     */
	
	public SprinterDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, double explosionMetrosFinales, double potenciaPromVatios,
			double velocidadPromSprintKm) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	/**
     * Constructor with all attributes including personal information.
     * 
     * @param imagen the image
     * @param nombre the name
     * @param cedula the ID number
     * @param correo the email
     * @param usuario the username
     * @param id the ID
     * @param contrasena the password
     * @param genero the gender
     * @param identificador the identifier
     * @param aniosExperiencia the years of experience
     * @param tiempoAcumuladoMin the accumulated time in minutes
     * @param especialidad the specialty
     * @param contextura the body type
     * @param equipo the team
     * @param explosionMetrosFinales the explosion in the final meters
     * @param potenciaPromVatios the average power in watts
     * @param velocidadPromSprintKm the average sprint speed in km/h
     */
	
	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, double explosionMetrosFinales,
			double potenciaPromVatios, double velocidadPromSprintKm) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	/**
     * Constructor with personal information and specific sprinter attributes.
     * 
     * @param imagen the image
     * @param nombre the name
     * @param cedula the ID number
     * @param correo the email
     * @param usuario the username
     * @param id the ID
     * @param contrasena the password
     * @param genero the gender
     * @param explosionMetrosFinales the explosion in the final meters
     * @param potenciaPromVatios the average power in watts
     * @param velocidadPromSprintKm the average sprint speed in km/h
     */
	
	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double explosionMetrosFinales, double potenciaPromVatios,
			double velocidadPromSprintKm) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	 /**
     * Constructor with cycling-specific attributes.
     * 
     * @param identificador the identifier
     * @param aniosExperiencia the years of experience
     * @param tiempoAcumuladoMin the accumulated time in minutes
     * @param especialidad the specialty
     * @param contextura the body type
     * @param equipo the team
     */
	
	public SprinterDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
     * Constructor with all attributes except specific sprinter attributes.
     * 
     * @param imagen the image
     * @param nombre the name
     * @param cedula the ID number
     * @param correo the email
     * @param usuario the username
     * @param id the ID
     * @param contrasena the password
     * @param genero the gender
     * @param identificador the identifier
     * @param aniosExperiencia the years of experience
     * @param tiempoAcumuladoMin the accumulated time in minutes
     * @param especialidad the specialty
     * @param contextura the body type
     * @param equipo the team
     */
	
	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
     * Constructor with personal information.
     * 
     * @param imagen the image
     * @param nombre the name
     * @param cedula the ID number
     * @param correo the email
     * @param usuario the username
     * @param id the ID
     * @param contrasena the password
     * @param genero the gender
     */
	
	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
     * Gets the explosion in the final meters.
     * 
     * @return the explosion in the final meters
     */
	
	public double getExplosionMetrosFinales() {
		return explosionMetrosFinales;
	}

	/**
     * Sets the explosion in the final meters.
     * 
     * @param explosionMetrosFinales the explosion in the final meters
     */
	
	public void setExplosionMetrosFinales(double explosionMetrosFinales) {
		this.explosionMetrosFinales = explosionMetrosFinales;
	}

	/**
     * Gets the average power in watts.
     * 
     * @return the average power in watts
     */
	
	public double getPotenciaPromVatios() {
		return potenciaPromVatios;
	}

	/**
     * Sets the average power in watts.
     * 
     * @param potenciaPromVatios the average power in watts
     */
	
	public void setPotenciaPromVatios(double potenciaPromVatios) {
		this.potenciaPromVatios = potenciaPromVatios;
	}

	 /**
     * Gets the average sprint speed in km/h.
     * 
     * @return the average sprint speed in km/h
     */
	
	public double getVelocidadPromSprintKm() {
		return velocidadPromSprintKm;
	}

	/**
     * Sets the average sprint speed in km/h.
     * 
     * @param velocidadPromSprintKm the average sprint speed in km/h
     */
	
	public void setVelocidadPromSprintKm(double velocidadPromSprintKm) {
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	/**
     * Returns a string representation of the Sprinter object, including
     * final explosion meters, average power in watts, and average sprint speed in km/h.
     *
     * @return A string representation of the Sprinter object.
     */
	
	@Override
	public String toString() {
		return super.toString() + "Explosion Metros Finales: " + explosionMetrosFinales
				+ "\nPotencia Promedio en Vatios: " + potenciaPromVatios + "\nVelocidad Promedio Sprint Km/h: "
				+ velocidadPromSprintKm + "\n";
	}

	/**
     * Increases the sprinter's pace.
     *
     * @return A string indicating the sprinter has increased the pace.
     */
	
	public String aumentarRitmo() {
		return "EL sprinter ha aumentado el ritmo";
	}

	/**
     * Decreases the sprinter's pace.
     *
     * @return A string indicating the sprinter has decreased the pace.
     */
	
	public String disminuirRitmo() {
		return "EL sprinter ha disminuido el ritmo";
	}

}
