package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * This class represents a Data Transfer Object (DTO) for a Sports Director in a sports system.
 * It inherits from the UsuarioDTO class and includes additional information specific to a Sports Director, such as their nationality.
 * It implements the Serializable interface to allow serialization of objects of this class.
 * @author Cardenas.K
 * @version 10/05/2024
 * @see UsuarioDTO
 *
 */

public class DirectorDeportivoDTO extends UsuarioDTO implements Serializable {

	private String nacionalidad;

	/**
     * Default constructor for the DirectorDeportivoDTO class.
     */
	
	public DirectorDeportivoDTO() {
	}

	/**
     * Constructor for the DirectorDeportivoDTO class that initializes the nationality of the Sports Director.
     *
     * @param nationality The nationality of the Sports Director.
     */
	
	public DirectorDeportivoDTO(String nacionalidad) {
		super();
		this.nacionalidad = nacionalidad;
	}

	 /**
     * Constructor for the DirectorDeportivoDTO class that initializes all attributes, including the nationality of the Sports Director.
     *
     * @param image       The image of the Sports Director.
     * @param name        The name of the Sports Director.
     * @param idCard      The ID card number of the Sports Director.
     * @param email       The email address of the Sports Director.
     * @param username    The username of the Sports Director.
     * @param id          The identifier of the Sports Director.
     * @param password    The password of the Sports Director.
     * @param gender      The gender of the Sports Director.
     * @param nationality The nationality of the Sports Director.
     */
	
	public DirectorDeportivoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, String nacionalidad) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.nacionalidad = nacionalidad;
	}

	/**
     * Constructor for the DirectorDeportivoDTO class that initializes all attributes except the nationality of the Sports Director.
     *
     * @param image    The image of the Sports Director.
     * @param name     The name of the Sports Director.
     * @param idCard   The ID card number of the Sports Director.
     * @param email    The email address of the Sports Director.
     * @param username The username of the Sports Director.
     * @param id       The identifier of the Sports Director.
     * @param password The password of the Sports Director.
     * @param gender   The gender of the Sports Director.
     */
	
	public DirectorDeportivoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
     * Method to get the nationality of the Sports Director.
     *
     * @return The nationality of the Sports Director.
     */
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
     * Method to set the nationality of the Sports Director.
     *
     * @param nationality The new nationality of the Sports Director.
     */
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	 /**
     * Method that returns a string representation of the DirectorDeportivoDTO object,
     * including all its attributes and the nationality of the Sports Director.
     *
     * @return A string representation of the DirectorDeportivoDTO object.
     */
	
	@Override
	public String toString() {
		return super.toString() + "Nacionalidad: " + nacionalidad + "\n";
	}

}
