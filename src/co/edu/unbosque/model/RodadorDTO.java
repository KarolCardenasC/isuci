package co.edu.unbosque.model;

import java.io.Serializable;

public class RodadorDTO extends CiclistaDTO implements Serializable {

	private double velocidadPromPedaleo;

	public RodadorDTO() {
	}

	public RodadorDTO(double velocidadPromPedaleo) {
		super();
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, double velocidadPromPedaleo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, double velocidadPromPedaleo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double velocidadPromPedaleo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
	}

	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
	}

	public RodadorDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public double getVelocidadPromPedaleo() {
		return velocidadPromPedaleo;
	}

	public void setVelocidadPromPedaleo(double velocidadPromPedaleo) {
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	@Override
	public String toString() {
		return super.toString() + "Velocidad Promedio Pedaleo: " + velocidadPromPedaleo + "\n";
	}

}
