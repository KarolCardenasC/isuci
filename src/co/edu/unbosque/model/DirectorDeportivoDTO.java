package co.edu.unbosque.model;

import java.io.Serializable;

public class DirectorDeportivoDTO implements Serializable {
	private long cedula;
	private String nacionalidad;

	public DirectorDeportivoDTO() {
	}

	public DirectorDeportivoDTO(long cedula, String nacionalidad) {
		super();
		this.cedula = cedula;
		this.nacionalidad = nacionalidad;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Cedula: " + cedula + "\nNacionalidad: " + nacionalidad + "\n";
	}

}
