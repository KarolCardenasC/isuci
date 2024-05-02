package co.edu.unbosque.model;

import java.io.Serializable;

public class DirectorDeportivoDTO extends UsuarioDTO implements Serializable {
	private long cedula;
	private String nacionalidad;

	public DirectorDeportivoDTO() {
	}

	public DirectorDeportivoDTO(long cedula, String nacionalidad) {
		super();
		this.cedula = cedula;
		this.nacionalidad = nacionalidad;
	}

	public DirectorDeportivoDTO(String imagen, String correo, String usuario, String id, String contrasena,
			String genero, long cedula, String nacionalidad) {
		super(imagen, correo, usuario, id, contrasena, genero);
		this.cedula = cedula;
		this.nacionalidad = nacionalidad;
	}

	public DirectorDeportivoDTO(String imagen, String correo, String usuario, String id, String contrasena,
			String genero) {
		super(imagen, correo, usuario, id, contrasena, genero);
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
		return super.toString() + "Cedula: " + cedula + "\nNacionalidad: " + nacionalidad + "\n";
	}

}
