package co.edu.unbosque.model;

import java.io.Serializable;

public class ClasicomanoDTO extends CiclistaDTO implements Serializable {

	private int numeroClasicosganados;

	public ClasicomanoDTO() {
	}

	public ClasicomanoDTO(int numeroClasicosganados) {
		super();
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura, int numeroClasicosganados) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura, int numeroClasicosganados) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int numeroClasicosganados) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(int identificador, int aniosExperiencia, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, aniosExperiencia, tiempoAcumuladoMin, especialidad, contextura);
	}

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero, int identificador, int aniosExperiencia, double tiempoAcumuladoMin,
			String especialidad, String contextura) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero, identificador, aniosExperiencia,
				tiempoAcumuladoMin, especialidad, contextura);
	}

	public ClasicomanoDTO(String imagen, String nombre, long cedula, String correo, String usuario, String id,
			String contrasena, String genero) {
		super(imagen, nombre, cedula, correo, usuario, id, contrasena, genero);
	}

	public int getNumeroClasicosganados() {
		return numeroClasicosganados;
	}

	public void setNumeroClasicosganados(int numeroClasicosganados) {
		this.numeroClasicosganados = numeroClasicosganados;
	}

	@Override
	public String toString() {
		return super.toString() + "Numero Clasicos ganados: " + numeroClasicosganados + "\n";
	}

}
