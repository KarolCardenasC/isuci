package co.edu.unbosque.model;

import java.io.Serializable;

public class MasajistaDTO implements Serializable {
	private long cedula;
	private int aniosExperiencia;

	public MasajistaDTO() {
	}

	public MasajistaDTO(long cedula, int aniosExperiencia) {
		super();
		this.cedula = cedula;
		this.aniosExperiencia = aniosExperiencia;
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
		return "Cedula: " + cedula + "\nAños Experiencia: " + aniosExperiencia + "\n";
	}

}
