package co.edu.unbosque.model;

import java.io.Serializable;

public class EscaladorDTO extends CiclistaDTO implements Serializable {

	private double aceleracionPromSubida;
	private double gradoRampaSoportada;

	public EscaladorDTO() {
	}

	public EscaladorDTO(double aceleracionPromSubida, double gradoRampaSoportada) {
		super();
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura, double aceleracionPromSubida, double gradoRampaSoportada) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(int identificador, String nombre, double tiempoAcumuladoMin, double aceleracionPromSubida,
			double gradoRampaSoportada) {
		super(identificador, nombre, tiempoAcumuladoMin);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura,
			double aceleracionPromSubida, double gradoRampaSoportada) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, double aceleracionPromSubida,
			double gradoRampaSoportada) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
	}

	public EscaladorDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super(identificador, nombre, tiempoAcumuladoMin);
	}

	public EscaladorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
	}

	public EscaladorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
	}

	public double getAceleracionPromSubida() {
		return aceleracionPromSubida;
	}

	public void setAceleracionPromSubida(double aceleracionPromSubida) {
		this.aceleracionPromSubida = aceleracionPromSubida;
	}

	public double getGradoRampaSoportada() {
		return gradoRampaSoportada;
	}

	public void setGradoRampaSoportada(double gradoRampaSoportada) {
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	@Override
	public String toString() {
		return super.toString() + "Aceleracion Promedio Subida: " + aceleracionPromSubida + "\n Grado Rampa Soportada: "
				+ gradoRampaSoportada + "\n";
	}
}
