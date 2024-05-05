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

	public EscaladorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, double aceleracionPromSubida, double gradoRampaSoportada) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, double aceleracionPromSubida, double gradoRampaSoportada) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double aceleracionPromSubida, double gradoRampaSoportada) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public EscaladorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
	}

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
	}

	public EscaladorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
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
	
	public String pedalearSentado() {
		return "El escalador está pedaleando sentado";
	}
	
	public String pedalearParado() {
		return "El escalador está pedaleando de pie";
	}
}
