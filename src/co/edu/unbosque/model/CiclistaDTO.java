package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaDTO extends UsuarioDTO implements Serializable {
	private int identificador;
	private String nombre;
	private double tiempoAcumuladoMin;
	private String especialidad;
	private String contextura;

	public CiclistaDTO() {
	}

	public CiclistaDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
		this.especialidad = especialidad;
		this.contextura = contextura;
	}

	public CiclistaDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
	}

	public CiclistaDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura) {
		super(imagen, correo, usuario, id, contrasena, genero);
		this.identificador = identificador;
		this.nombre = nombre;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
		this.especialidad = especialidad;
		this.contextura = contextura;
	}

	public CiclistaDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin) {
		super(imagen, correo, usuario, id, contrasena, genero);
		this.identificador = identificador;
		this.nombre = nombre;
		this.tiempoAcumuladoMin = tiempoAcumuladoMin;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return super.toString() + "identificador: " + identificador + "\nNombre: " + nombre
				+ "\nTiempo Acumulado Minutos: " + tiempoAcumuladoMin + "\nEspecialidad: " + especialidad
				+ "\nContextura: " + contextura + "\n";
	}
}
