package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a Data Transfer Object (DTO) for a sports team in a sports system.
 * It includes information about the team's name, career time, country, list of cyclists, massage therapist, and sports director.
 * Implements the Serializable interface to allow serialization of objects of this class.
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
	private ArrayList<CiclistaDTO> listaCiclistas;
	private MasajistaDTO masajista;
	private DirectorDeportivoDTO directorDep;

	/**
     * Default constructor for the EquipoDTO class.
     */
	
	public EquipoDTO() {
	}

	/**
     * Constructor for the EquipoDTO class that initializes all attributes of the team.
     *
     * @param nombre      The name of the team.
     * @param tiempoCarrera The career time of the team.
     * @param pais        The country of the team.
     * @param listaCiclistas The list of cyclists in the team.
     * @param masajista   The massage therapist of the team.
     * @param directorDep The sports director of the team.
     */
	
	public EquipoDTO(String nombre, double tiempoCarrera, String pais, ArrayList<CiclistaDTO> listaCiclistas,
			MasajistaDTO masajista, DirectorDeportivoDTO directorDep) {
		super();
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
		this.pais = pais;
		this.listaCiclistas = listaCiclistas;
		this.masajista = masajista;
		this.directorDep = directorDep;
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
     * Method to get the list of cyclists in the team.
     *
     * @return The list of cyclists in the team.
     */
	
	public ArrayList<CiclistaDTO> getListaCiclistas() {
		return listaCiclistas;
	}

	/**
     * Method to set the list of cyclists in the team.
     *
     * @param listaCiclistas The new list of cyclists in the team.
     */
	
	public void setListaCiclistas(ArrayList<CiclistaDTO> listaCiclistas) {
		this.listaCiclistas = listaCiclistas;
	}

	/**
     * Method to get the massage therapist of the team.
     *
     * @return The massage therapist of the team.
     */
	
	public MasajistaDTO getMasajista() {
		return masajista;
	}

	 /**
     * Method to set the massage therapist of the team.
     *
     * @param masajista The new massage therapist of the team.
     */
	
	public void setMasajista(MasajistaDTO masajista) {
		this.masajista = masajista;
	}

	 /**
     * Method to get the sports director of the team.
     *
     * @return The sports director of the team.
     */
	
	public DirectorDeportivoDTO getDirectorDep() {
		return directorDep;
	}

	/**
     * Method to set the sports director of the team.
     *
     * @param directorDep The new sports director of the team.
     */
	
	public void setDirectorDep(DirectorDeportivoDTO directorDep) {
		this.directorDep = directorDep;
	}

	/**
     * Method that returns a string representation of the EquipoDTO object,
     * including all its attributes and the information of the cyclists, massage therapist, and sports director.
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
		sb.append("\nLista Ciclistas: ");
		listaCiclistas.forEach((e) -> {
			sb.append("\n" + e.toString());
		});
		sb.append("\nMasajista: " + masajista);
		sb.append("\nDirector Deportivo: " + directorDep);
		sb.append("\n");

		return sb.toString();
	}

}
