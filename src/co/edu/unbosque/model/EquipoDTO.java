package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EquipoDTO implements Serializable {
	private String nombre;
	private double tiempoCarrera;
	private String pais;
	private ArrayList<CiclistaDTO> listaCiclistas;
	private MasajistaDTO masajista;
	private DirectorDeportivoDTO directorDep;

	public EquipoDTO() {
	}

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

	public EquipoDTO(String nombre, double tiempoCarrera, String pais, ArrayList<CiclistaDTO> listaCiclistas) {
		super();
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
		this.pais = pais;
		this.listaCiclistas = listaCiclistas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTiempoCarrera() {
		return tiempoCarrera;
	}

	public void setTiempoCarrera(double tiempoCarrera) {
		this.tiempoCarrera = tiempoCarrera;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ArrayList<CiclistaDTO> getListaCiclistas() {
		return listaCiclistas;
	}

	public void setListaCiclistas(ArrayList<CiclistaDTO> listaCiclistas) {
		this.listaCiclistas = listaCiclistas;
	}

	public MasajistaDTO getMasajista() {
		return masajista;
	}

	public void setMasajista(MasajistaDTO masajista) {
		this.masajista = masajista;
	}

	public DirectorDeportivoDTO getDirectorDep() {
		return directorDep;
	}

	public void setDirectorDep(DirectorDeportivoDTO directorDep) {
		this.directorDep = directorDep;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
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
