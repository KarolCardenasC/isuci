package co.edu.unbosque.model;

import java.io.Serializable;

public class MasajistaDTO extends UsuarioDTO implements Serializable {

	private int aniosExperiencia;
	private String equipo;

	/**
	 * Default constructor for MasajistaDTO.
	 */
	public MasajistaDTO() {
	}

	/**
	 * Constructor with parameters for all fields except years of experience.
	 * 
	 * @param imagen     The imagen URL of the massage therapist.
	 * @param nombre     The nombre of the massage therapist.
	 * @param cedula     The cedula of the massage therapist.
	 * @param correo     The correo address of the massage therapist.
	 * @param usuario    The usuario of the massage therapist.
	 * @param id         The ID of the massage therapist.
	 * @param contrasena The contrasena of the massage therapist.
	 * @param genero     The genero of the massage therapist.
	 */
	public MasajistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with parameters for all fields.
	 * 
	 * @param imagen           The imagen URL of the massage therapist.
	 * @param nombre           The nombre of the massage therapist.
	 * @param cedula           The cedula of the massage therapist.
	 * @param correo           The correo address of the massage therapist.
	 * @param usuario          The usuario of the massage therapist.
	 * @param id               The ID of the massage therapist.
	 * @param contrasena       The contrasena of the massage therapist.
	 * @param genero           The genero of the massage therapist.
	 * @param aniosExperiencia The aniosExperiencia of the massage therapist.
	 * @param equipo           The equipo of the Sports Director.
	 */
	public MasajistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int aniosExperiencia, String equipo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.aniosExperiencia = aniosExperiencia;
		this.equipo = equipo;
	}

	/**
	 * Constructor with parameter for years of experience.
	 * 
	 * @param aniosExperiencia The years of experience of the massage therapist.
	 * @param equipo           The equipo of the Sports Director.
	 * 
	 */
	public MasajistaDTO(int aniosExperiencia, String equipo) {
		super();
		this.aniosExperiencia = aniosExperiencia;
		this.equipo = equipo;
	}

	/**
	 * Get the years of experience of the massage therapist.
	 * 
	 * @return The aniosExperiencia.
	 */
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * Set the years of experience of the massage therapist.
	 * 
	 * @param aniosExperiencia The aniosExperiencia to set.
	 */

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Method to get the equipo of the Sports Director.
	 *
	 * @return The equipo of the Sports Director.
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * Method to set the equipo of the Sports Director.
	 *
	 * @param nacionalidad The new equipo of the Sports Director.
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return super.toString() + "AÃ±os Experiencia: " + aniosExperiencia + "\nEquipo: " + equipo + "\n";
	}

}