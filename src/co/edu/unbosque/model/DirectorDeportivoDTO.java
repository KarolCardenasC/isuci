package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * This class represents a Data Transfer Object (DTO) for a Sports Director in a
 * sports system. It inherits from the UsuarioDTO class and includes additional
 * information specific to a Sports Director, such as their nacionalidad. It
 * implements the Serializable interface to allow serialization of objects of
 * this class.
 * 
 * @author Cardenas.K
 * @version 10/05/2024
 * @see UsuarioDTO
 *
 */

public class DirectorDeportivoDTO extends UsuarioDTO implements Serializable {
	private String nacionalidad;
	private String equipo;

	/**
	 * Default constructor for the DirectorDeportivoDTO class.
	 */
	public DirectorDeportivoDTO() {

	}

	/**
	 * Constructor for the DirectorDeportivoDTO class that initializes the
	 * nacionalidad of the Sports Director.
	 * 
	 * @param nacionalidad The nacionalidad of the Sports Director.
	 * @param equipo       The equipo of the Sports Director.
	 */
	public DirectorDeportivoDTO(String nacionalidad, String equipo) {
		super();
		this.nacionalidad = nacionalidad;
		this.equipo = equipo;
	}

	/**
	 * Constructor for the DirectorDeportivoDTO class that initializes all
	 * attributes, including the nacionalidad of the Sports Director.
	 *
	 * @param imagen       The imagen of the Sports Director.
	 * @param nombre       The nombre of the Sports Director.
	 * @param cedula       The ID card number of the Sports Director.
	 * @param correo       The correo address of the Sports Director.
	 * @param usuario      The usuario of the Sports Director.
	 * @param id           The identifier of the Sports Director.
	 * @param contrasena   The contrasena of the Sports Director.
	 * @param genero       The genero of the Sports Director.
	 * @param nacionalidad The nacionalidad of the Sports Director.
	 * @param equipo       The equipo of the Sports Director.
	 */
	public DirectorDeportivoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, String nacionalidad, String equipo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.nacionalidad = nacionalidad;
		this.equipo = equipo;
	}

	/**
	 * Constructor for the DirectorDeportivoDTO class that initializes all
	 * attributes except the nacionalidad of the Sports Director.
	 *
	 * @param image      The image of the Sports Director.
	 * @param nombre     The nombre of the Sports Director.
	 * @param cedula     The ID card number of the Sports Director.
	 * @param correo     The correo address of the Sports Director.
	 * @param usuario    The usuario of the Sports Director.
	 * @param id         The identifier of the Sports Director.
	 * @param contrasena The contrasena of the Sports Director.
	 * @param genero     The genero of the Sports Director.
	 */
	public DirectorDeportivoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to get the nacionalidad of the Sports Director.
	 *
	 * @return The nacionalidad of the Sports Director.
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * Method to set the nacionalidad of the Sports Director.
	 *
	 * @param nacionalidad The new nacionalidad of the Sports Director.
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
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

	/**
	 * Method that returns a string representation of the DirectorDeportivoDTO
	 * object, including all its attributes, the nacionalidad and equipo of the
	 * Sports Director.
	 *
	 * @return A string representation of the DirectorDeportivoDTO object.
	 */
	@Override
	public String toString() {
		return super.toString() + "Nacionalidad es: " + nacionalidad + "\nEquipo: " + equipo + "\n";
	}

}