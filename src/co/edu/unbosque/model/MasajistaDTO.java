package co.edu.unbosque.model;

import java.io.Serializable;

public class MasajistaDTO extends UsuarioDTO implements Serializable {
	
	private long cedula;
	private int aniosExperiencia;

	public MasajistaDTO() {
	}

	public MasajistaDTO(long cedula, int aniosExperiencia) {
		super();
		this.cedula = cedula;
		this.aniosExperiencia = aniosExperiencia;
	}

	public MasajistaDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			long cedula, int aniosExperiencia) {
		super(imagen, correo, usuario, id, contrasena, genero);
		this.cedula = cedula;
		this.aniosExperiencia = aniosExperiencia;
	}

	public MasajistaDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero) {
		super(imagen, correo, usuario, id, contrasena, genero);
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return super.toString() + "Cedula: " + cedula + "\nAños Experiencia: " + aniosExperiencia + "\n";
	}

}
