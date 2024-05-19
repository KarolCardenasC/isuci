package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a Data Transfer Object (DTO) for a sports team in a
 * sports system. It includes information about the team's name, career time,
 * and country. Implements the Serializable interface to allow serialization of
 * objects of this class.
 * 
 * @author Cardenas.K
 * @version 10/05/2024
 * @see UsuarioDTO
 * 
 */

public class EquipoDTO implements Serializable {

	private String nombre;
	private double tiempoCarrera;
	private String pais;

	/**
	 * Default constructor for the EquipoDTO class.
	 */

	public EquipoDTO() {
	}

	/**
	 * Constructor for the EquipoDTO class that initializes all attributes of the
	 * team.
	 *
	 * @param nombre        The name of the team.
	 * @param tiempoCarrera The career time of the team.
	 * @param pais          The country of the team.
	 */

	public EquipoDTO(String nombre, double tiempoCarrera, String pais) {
		super();
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
		this.pais = pais;
	}

	/**
	 * Method to get the name of the team.
	 *
	 * @return The name of the team.
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Method to set the name of the team.
	 *
	 * @param nombre The new name of the team.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Method to get the career time of the team.
	 *
	 * @return The career time of the team.
	 */

	public double getTiempoCarrera() {
		return tiempoCarrera;
	}

	/**
	 * Method to set the career time of the team.
	 *
	 * @param tiempoCarrera The new career time of the team.
	 */

	public void setTiempoCarrera(double tiempoCarrera) {
		this.tiempoCarrera = tiempoCarrera;
	}

	/**
	 * Method to get the country of the team.
	 *
	 * @return The country of the team.
	 */

	public String getPais() {
		return pais;
	}

	/**
	 * Method to set the country of the team.
	 *
	 * @param pais The new country of the team.
	 */

	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Method that returns a string representation of the EquipoDTO object.
	 *
	 * @return A string representation of the EquipoDTO object.
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Nombre: " + nombre);
		sb.append("\nTiempo Carrera: " + tiempoCarrera);
		sb.append("\nPais: " + pais);
		sb.append("\n");

		return sb.toString();
	}

}
