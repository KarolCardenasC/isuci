package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * CiclistaDTO is a data transfer object that represents a cyclist. It extends
 * UsuarioDTO and implements Serializable interface for object serialization.
 * This class includes properties such as identifier, years of experience,
 * accumulated time, specialty, and body type.
 * 
 * @author Cardenas.K
 * @version 10/05/2024
 * @see UsuarioDTO
 */

public class CiclistaDTO extends UsuarioDTO implements Serializable {

	private int identificador;
	private int aniosExperiencia;
	private double tiempoAcumuladoMin;
	private String especialidad;
	private String contextura;

	/**
	 * Default constructor for creating an empty CiclistaDTO object.
	 */

	public CiclistaDTO() {
	}

	/**
	 * Constructor for creating a CiclistaDTO object with specific attributes.
	 * 
	 * @param identificador      the identifier of the cyclist
	 * @param aniosExperiencia   the years of experience of the cyclist
	 * @param tiempoAcumuladoMin the accumulated time in minutes
	 * @param especialidad       the specialty of the cyclist
	 * @param contextura         the body type of the cyclist
	 */

	public CiclistaDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super();
		this.identificador = identificador;
		this.aniosExperiencia = aniosExperiencia;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
		this.especialidad = especialidad;
		this.contextura = contextura;
	}

	/**
	 * Constructor for creating a CiclistaDTO object with attributes inherited from
	 * UsuarioDTO and additional attributes specific to CiclistaDTO.
	 * 
	 * @param imagen             the image of the cyclist
	 * @param nombre             the name of the cyclist
	 * @param cedula             the ID of the cyclist
	 * @param correo             the email of the cyclist
	 * @param usuario            the username of the cyclist
	 * @param id                 the ID of the cyclist
	 * @param contrasena         the password of the cyclist
	 * @param genero             the gender of the cyclist
	 * @param identificador      the identifier of the cyclist
	 * @param aniosExperiencia   the years of experience of the cyclist
	 * @param tiempoAcumuladoMin the accumulated time in minutes
	 * @param especialidad       the specialty of the cyclist
	 * @param contextura         the body type of the cyclist
	 */

	public CiclistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.identificador = identificador;
		this.aniosExperiencia = aniosExperiencia;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
		this.especialidad = especialidad;
		this.contextura = contextura;
	}

	/**
	 * Constructor for creating a CiclistaDTO object with attributes inherited from
	 * UsuarioDTO.
	 * 
	 * @param imagen     the image of the cyclist
	 * @param nombre     the name of the cyclist
	 * @param cedula     the ID of the cyclist
	 * @param correo     the email of the cyclist
	 * @param usuario    the username of the cyclist
	 * @param id         the ID of the cyclist
	 * @param contrasena the password of the cyclist
	 * @param genero     the gender of the cyclist
	 */

	public CiclistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
	 * Gets the identifier of the cyclist.
	 * 
	 * @return the identifier
	 */

	public int getIdentificador() {
		return identificador;
	}

	/**
	 * Sets the identifier of the cyclist.
	 * 
	 * @param identificador the identifier to set
	 */

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * Gets the years of experience of the cyclist.
	 * 
	 * @return the years of experience
	 */

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * Sets the years of experience of the cyclist.
	 * 
	 * @param aniosExperiencia the years of experience to set
	 */

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Gets the accumulated time in minutes.
	 * 
	 * @return the accumulated time in minutes
	 */

	public double getTiempoAcumuladoMin() {
		return tiempoAcumuladoMin;
	}

	/**
	 * Sets the accumulated time in minutes.
	 * 
	 * @param tiempoAcumuladoMin the accumulated time to set
	 */

	public void setTiempoAcumuladoMin(double tiempoAcumuladoMin) {
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
	}

	/**
	 * Gets the specialty of the cyclist.
	 * 
	 * @return the specialty
	 */

	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * Sets the specialty of the cyclist.
	 * 
	 * @param especialidad the specialty to set
	 */

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * Gets the body type of the cyclist.
	 * 
	 * @return the body type
	 */

	public String getContextura() {
		return contextura;
	}

	/**
	 * Sets the body type of the cyclist.
	 * 
	 * @param contextura the body type to set
	 */

	public void setContextura(String contextura) {
		this.contextura = contextura;
	}

	/**
	 * Returns a string representation of the CiclistaDTO object, including
	 * inherited attributes and additional attributes.
	 * 
	 * @return a string representation of the CiclistaDTO object
	 */

	@Override
	public String toString() {
		return super.toString() + "identificador: " + identificador + "\nAños Experiencia: " + aniosExperiencia
				+ "\nTiempo Acumulado Minutos: " + tiempoAcumuladoMin + "\nEspecialidad: " + especialidad
				+ "\nContextura: " + contextura + "\n";
	}

	/**
	 * Simulates the pedaling cadence of the cyclist.
	 * 
	 * @param pedaleos the number of pedal strokes per minute (RPM)
	 * @return a string describing the pedaling cadence
	 */

	public String pedalear(int pedaleos) {
		return "El ciclista tiene una cadencia de pedaleo de " + pedaleos + " RPM";
	}
}
