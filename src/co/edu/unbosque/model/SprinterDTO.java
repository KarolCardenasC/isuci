package co.edu.unbosque.model;

import java.io.Serializable;

public class SprinterDTO extends CiclistaDTO implements Serializable {

	private double explosionMetrosFinales;
	private double potenciaPromVatios;
	private double velocidadPromSprintKm;

	public SprinterDTO() {
	}

	public SprinterDTO(double explosionMetrosFinales, double potenciaPromVatios, double velocidadPromSprintKm) {
		super();
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	public SprinterDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo, double explosionMetrosFinales, double potenciaPromVatios,
			double velocidadPromSprintKm) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo, double explosionMetrosFinales,
			double potenciaPromVatios, double velocidadPromSprintKm) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double explosionMetrosFinales, double potenciaPromVatios,
			double velocidadPromSprintKm) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	public SprinterDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, String equipo) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, String equipo) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura, equipo);
	}

	public SprinterDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public double getExplosionMetrosFinales() {
		return explosionMetrosFinales;
	}

	public void setExplosionMetrosFinales(double explosionMetrosFinales) {
		this.explosionMetrosFinales = explosionMetrosFinales;
	}

	public double getPotenciaPromVatios() {
		return potenciaPromVatios;
	}

	public void setPotenciaPromVatios(double potenciaPromVatios) {
		this.potenciaPromVatios = potenciaPromVatios;
	}

	public double getVelocidadPromSprintKm() {
		return velocidadPromSprintKm;
	}

	public void setVelocidadPromSprintKm(double velocidadPromSprintKm) {
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	@Override
	public String toString() {
		return super.toString() + "Explosion Metros Finales: " + explosionMetrosFinales
				+ "\nPotencia Promedio en Vatios: " + potenciaPromVatios + "\nVelocidad Promedio Sprint Km/h: "
				+ velocidadPromSprintKm + "\n";
	}

	public String aumentarRitmo() {
		return "EL sprinter ha aumentado el ritmo";
	}

	public String disminuirRitmo() {
		return "EL sprinter ha disminuido el ritmo";
	}

}
