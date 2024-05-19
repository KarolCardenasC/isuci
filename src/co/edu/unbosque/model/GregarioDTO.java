package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * GregarioDTO is a data transfer object representing a cyclist specialized in
 * time trials. It extends CiclistaDTO and implements the Serializable interface
 * for object serialization. This class includes a property for the role in the team.
 * 
 * @author Cardenas.K
 * @version 10/05/2024
 * @see CiclistaDTO
 */

public class GregarioDTO extends CiclistaDTO implements Serializable {

	private String funcionPeloton;
	
	/**
	 * Default constructor for GregarioDTO.
	 */

	public GregarioDTO() {
	}
	
	/**
	 * Constructor with the role in the team.
	 * 
	 * @param funcionPeloton
	 */

	public GregarioDTO(String funcionPeloton) {
		super();
		this.funcionPeloton = funcionPeloton;
	}
	
	/**
	 * Constructor with parameters for all properties of the CiclistaDTO class,
	 * role in the team.
	 * 
	 * @param identificador         The identifier.
	 * @param aniosExperiencia      The years of experience.
	 * @param tiempoAcumuladoMin    The accumulated time (in minutes).
	 * @param especialidad          The specialty.
	 * @param contextura            The build.
	 * @param equipo                The team.
	 * @param funcionPeloton        The role in the team.
	 */

	public GregarioDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, String funcionPeloton) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.funcionPeloton = funcionPeloton;
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
	 * @param funcionPeloton        The role in the team.
	 */

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, String funcionPeloton) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.funcionPeloton = funcionPeloton;
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
	 * @param funcionPeloton        The role in the team.
	 */

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, String funcionPeloton) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.funcionPeloton = funcionPeloton;
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

	public GregarioDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}
	
	/**
	 * Constructor with parameters for all properties except role in the team.
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

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
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

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}
	
	/**
	 * Gets the role in the team.
	 * 
	 * @return The role in the team
	 */

	public String getFuncionPeloton() {
		return funcionPeloton;
	}
	
	/**
	 * Sets the role in the team.
	 * 
	 * @param funcionPeloton
	 */

	public void setFuncionPeloton(String funcionPeloton) {
		this.funcionPeloton = funcionPeloton;
	}
	
	/**
	 * Provides a string representation of the GregarioDTO object.
	 * 
	 * @return A string representation including all properties of the object.
	 */

	@Override
	public String toString() {
		return super.toString() + "Funcion Peloton: " + funcionPeloton + "\n";
	}

}
