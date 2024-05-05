package co.edu.unbosque.model;

import java.io.Serializable;

public class DirectorDeportivoDTO extends UsuarioDTO implements Serializable {

	private String nacionalidad;

	public DirectorDeportivoDTO() {
	}

	public DirectorDeportivoDTO(String nacionalidad) {
		super();
		this.nacionalidad = nacionalidad;
	}

	public DirectorDeportivoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, String nacionalidad) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.nacionalidad = nacionalidad;
	}

	public DirectorDeportivoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return super.toString() + "Nacionalidad: " + nacionalidad + "\n";
	}

}
