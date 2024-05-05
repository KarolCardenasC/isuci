package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaDTO extends UsuarioDTO implements Serializable {

	private int identificador;
	private int aniosExperiencia;
	private double tiempoAcumuladoMin;
	private String especialidad;
	private String contextura;

	public CiclistaDTO() {
	}

	public CiclistaDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super();
		this.identificador = identificador;
		this.aniosExperiencia = aniosExperiencia;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
		this.especialidad = especialidad;
		this.contextura = contextura;
	}

	public CiclistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.identificador = identificador;
		this.aniosExperiencia = aniosExperiencia;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
		this.especialidad = especialidad;
		this.contextura = contextura;
	}

	public CiclistaDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public double getTiempoAcumuladoMin() {
		return tiempoAcumuladoMin;
	}

	public void setTiempoAcumuladoMin(double tiempoAcumuladoMin) {
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getContextura() {
		return contextura;
	}

	public void setContextura(String contextura) {
		this.contextura = contextura;
	}

	@Override
	public String toString() {
		return super.toString() + "identificador: " + identificador + "\nAños Experiencia: " + aniosExperiencia
				+ "\nTiempo Acumulado Minutos: " + tiempoAcumuladoMin + "\nEspecialidad: " + especialidad
				+ "\nContextura: " + contextura + "\n";
	}
	
	public String pedalear(int pedaleos) {
		return "El ciclista tiene una cadencia de pedaleo de " + pedaleos + " RPM";
	}
}
