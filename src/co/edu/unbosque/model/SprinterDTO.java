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

	public SprinterDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura, double explosionMetrosFinales, double potenciaPromVatios, double velocidadPromSprintKm) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	public SprinterDTO(int identificador, String nombre, double tiempoAcumuladoMin, double explosionMetrosFinales,
			double potenciaPromVatios, double velocidadPromSprintKm) {
		super(identificador, nombre, tiempoAcumuladoMin);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaPromVatios = potenciaPromVatios;
		this.velocidadPromSprintKm = velocidadPromSprintKm;
	}

	public SprinterDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
	}

	public SprinterDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super(identificador, nombre, tiempoAcumuladoMin);
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

}
