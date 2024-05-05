package co.edu.unbosque.model;

import java.io.Serializable;

public class MasajistaDTO extends UsuarioDTO implements Serializable {

	private int aniosExperiencia;

	public MasajistaDTO() {
	}

	public MasajistaDTO(int aniosExperiencia) {
		super();
		this.aniosExperiencia = aniosExperiencia;
	}

	public MasajistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int aniosExperiencia) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.aniosExperiencia = aniosExperiencia;
	}

	public MasajistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return super.toString() + "Años Experiencia: " + aniosExperiencia + "\n";
	}

}
