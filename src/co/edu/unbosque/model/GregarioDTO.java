package co.edu.unbosque.model;

import java.io.Serializable;

public class GregarioDTO extends CiclistaDTO implements Serializable {

	private String funcionPeloton;

	public GregarioDTO() {
	}

	public GregarioDTO(String funcionPeloton) {
		super();
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String funcionPeloton) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String funcionPeloton) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, String funcionPeloton) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
	}

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
	}

	public GregarioDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public String getFuncionPeloton() {
		return funcionPeloton;
	}

	public void setFuncionPeloton(String funcionPeloton) {
		this.funcionPeloton = funcionPeloton;
	}

	@Override
	public String toString() {
		return super.toString() + "Funcion Peloton: " + funcionPeloton + "\n";
	}

}
