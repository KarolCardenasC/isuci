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

	public RodadorDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura, double velocidadPromPedaleo) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(int identificador, String nombre, double tiempoAcumuladoMin, double velocidadPromPedaleo) {
		super(identificador, nombre, tiempoAcumuladoMin);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura,
			double velocidadPromPedaleo) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, double velocidadPromPedaleo) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public RodadorDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
	}

	public RodadorDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super(identificador, nombre, tiempoAcumuladoMin);
	}

	public RodadorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
	}

	public RodadorDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
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
