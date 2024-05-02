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

	public GregarioDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura, String funcionPeloton) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(int identificador, String nombre, double tiempoAcumuladoMin, String funcionPeloton) {
		super(identificador, nombre, tiempoAcumuladoMin);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura,
			String funcionPeloton) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String funcionPeloton) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
		this.funcionPeloton = funcionPeloton;
	}

	public GregarioDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
	}

	public GregarioDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super(identificador, nombre, tiempoAcumuladoMin);
	}

	public GregarioDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
	}

	public GregarioDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
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
