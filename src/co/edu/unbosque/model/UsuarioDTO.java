package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * UsuarioDTO is a class that represents the user data in the system.
 * It implements Serializable to allow the serialization of its instances.
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

public class UsuarioDTO implements Serializable {
	
	private String imagen;
	private String nombre;
	private long cedula;
	private String correo;
	private String usuario;
	private String id;
	private String contrasena;
	private String genero;

	/**
     * Default constructor for the UsuarioDTO class.
     */
	
	public UsuarioDTO() {
	}

	/**
     * Constructor with parameters for the UsuarioDTO class.
     *
     * @param imagen     The user's image.
     * @param nombre     The user's name.
     * @param cedula     The user's ID number.
     * @param correo     The user's email.
     * @param usuario    The username.
     * @param id         The user's ID.
     * @param contrasena The user's password.
     * @param genero     The user's gender.
     */
	
	public UsuarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.usuario = usuario;
		this.id = id;
		this.contrasena = contrasena;
		this.genero = genero;
	}

	/**
     * Gets the user's image.
     *
     * @return The user's image.
     */
	
	public String getImagen() {
		return imagen;
	}

	/**
     * Sets the user's image.
     *
     * @param imagen The image to set.
     */
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
     * Gets the user's name.
     *
     * @return The user's name.
     */
	
	public String getNombre() {
		return nombre;
	}

	/**
     * Sets the user's name.
     *
     * @param nombre The name to set.
     */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * Gets the user's ID number.
     *
     * @return The user's ID number.
     */
	
	public long getCedula() {
		return cedula;
	}

	/**
     * Sets the user's ID number.
     *
     * @param cedula The ID number to set.
     */
	
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	/**
     * Gets the user's email.
     *
     * @return The user's email.
     */
	
	public String getCorreo() {
		return correo;
	}

	/**
     * Sets the user's email.
     *
     * @param correo The email to set.
     */
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
     * Gets the username.
     *
     * @return The username.
     */
	
	public String getUsuario() {
		return usuario;
	}

	/**
     * Sets the username.
     *
     * @param usuario The username to set.
     */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
     * Gets the user's ID.
     *
     * @return The user's ID.
     */
	
	public String getId() {
		return id;
	}

	/**
     * Sets the user's ID.
     *
     * @param id The ID to set.
     */
	
	public void setId(String id) {
		this.id = id;
	}

	/**
     * Gets the user's password.
     *
     * @return The user's password.
     */
	
	public String getContrasena() {
		return contrasena;
	}

	 /**
     * Sets the user's password.
     *
     * @param contrasena The password to set.
     */
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
     * Gets the user's gender.
     *
     * @return The user's gender.
     */
	
	public String getGenero() {
		return genero;
	}

	/**
     * Sets the user's gender.
     *
     * @param genero The gender to set.
     */
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	 /**
     * Returns a string representation of the user's information.
     *
     * @return A string with the user's information.
     */
	
	@Override
	public String toString() {
		return "Imagen: " + imagen + "\nNombre: " + nombre + "\nCedula: " + cedula + "\nCorreo: " + correo
				+ "\nUsuario: " + usuario + "\nId: " + id + "\nContraseña: " + contrasena + "\nGenero: " + genero
				+ "\n";
	}

}
