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

	public ContrarrelojeroDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, double velocidadMaxima) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
		this.velocidadMaxima = velocidadMaxima;
	}

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, double velocidadMaxima) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
		this.velocidadMaxima = velocidadMaxima;
	}

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, double velocidadMaxima) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.velocidadMaxima = velocidadMaxima;
	}

	public ContrarrelojeroDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
	}

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
	}

	public ContrarrelojeroDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
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
	
	public String visualizar() {
		return "El contrarrelojero está visulizando";
	}
	
	public String concentrar() {
		return "El contrarrelojero se está concentrando";
	}
	
	public String regular() {
		return "El contrarrelojero se está regulando";
	}

}
