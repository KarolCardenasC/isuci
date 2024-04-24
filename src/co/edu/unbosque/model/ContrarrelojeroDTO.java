package co.edu.unbosque.model;

import java.io.Serializable;

public class ContrarrelojeroDTO extends CiclistaDTO implements Serializable {
	private double velocidadMaxima;

	public ContrarrelojeroDTO() {
	}

	public ContrarrelojeroDTO(double velocidadMaxima) {
		super();
		this.velocidadMaxima = velocidadMaxima;
	}

	public ContrarrelojeroDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura, double velocidadMaxima) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
		this.velocidadMaxima = velocidadMaxima;
	}

	public ContrarrelojeroDTO(int identificador, String nombre, double tiempoAcumuladoMin, double velocidadMaxima) {
		super(identificador, nombre, tiempoAcumuladoMin);
		this.velocidadMaxima = velocidadMaxima;
	}

	public ContrarrelojeroDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
	}

	public ContrarrelojeroDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super(identificador, nombre, tiempoAcumuladoMin);
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	@Override
	public String toString() {
		return super.toString() + "Velocidad Maxima: " + velocidadMaxima + "\n";
	}

}
