package co.edu.unbosque.model;

/**
 * ClasicomanoDTO is a data transfer object that represents a cyclist specialized in classic races. 
 * It extends CiclistaDTO and implements Serializable interface for object serialization.
 * This class includes a property for the number of classic races won.
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

import java.io.Serializable;

public class ClasicomanoDTO extends CiclistaDTO implements Serializable {

	private int numeroClasicosganados;

	/**
	 * Default constructor for ClasicomanoDTO.
	 */

	public ClasicomanoDTO() {
	}

	/**
	 * Constructor with the number of classic races won.
	 * 
	 * @param numeroClasicosganados The number of classic races won.
	 */

	public ClasicomanoDTO(int numeroClasicosganados) {
		super();
		this.numeroClasicosganados = numeroClasicosganados;
	}

	/**
	 * Constructor with parameters for all properties of the ClasicomanoDTO class and classic races won.
	 * 
	 * @param identificador         The identifier.
	 * @param aniosExperiencia      The years of experience.
	 * @param tiempoAcumuladoMin    The accumulated time (in minutes).
	 * @param especialidad          The specialty.
	 * @param contextura            The build.
	 * @param equipo                The team.
	 * @param numeroClasicosganados The number of classic races won.
	 */

	public ClasicomanoDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, int numeroClasicosganados) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.numeroClasicosganados = numeroClasicosganados;
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
	 * @param numeroClasicosganados The number of classic races won.
	 */

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, int numeroClasicosganados) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.numeroClasicosganados = numeroClasicosganados;
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
	 * @param numeroClasicosganados The number of classic races won.
	 */

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int numeroClasicosganados) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	/**
	 * Constructor with parameters for all properties of CiclistaDTO class.
	 * 
	 * @param identificador      The identifier.
	 * @param aniosExperiencia   The years of experience.
	 * @param tiempoAcumuladoMin The accumulated time (in minutes).
	 * @param especialidad       The specialty.
	 * @param contextura         The build.
	 * @param equipo             The team.
	 */

	public ClasicomanoDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	/**
	 * Constructor with parameters for all properties except number of classic races won.
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

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
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

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	/**
	 * Retrieves the number of classic races won.
	 * 
	 * @return The number of classic races won.
	 */

	public int getNumeroClasicosganados() {
		return numeroClasicosganados;
	}

	/**
	 * Sets the number of classic races won.
	 * 
	 * @param numeroClasicosganados The number of classic races won.
	 */

	public void setNumeroClasicosganados(int numeroClasicosganados) {
		this.numeroClasicosganados = numeroClasicosganados;
	}

	/**
	 * Provides a string representation of the ClasicomanoDTO object.
	 * 
	 * @return A string representation including all properties of the object.
	 */

	@Override
	public String toString() {
		return super.toString() + "Numero Clasicos ganados: " + numeroClasicosganados + "\n";
	}

}
