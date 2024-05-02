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

	public ClasicomanoDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura, int numeroClasicosganados) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(int identificador, String nombre, double tiempoAcumuladoMin, int numeroClasicosganados) {
		super(identificador, nombre, tiempoAcumuladoMin);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura,
			int numeroClasicosganados) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, int numeroClasicosganados) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
		this.numeroClasicosganados = numeroClasicosganados;
	}

	public ClasicomanoDTO(int identificador, String nombre, double tiempoAcumuladoMin, String especialidad,
			String contextura) {
		super(identificador, nombre, tiempoAcumuladoMin, especialidad, contextura);
	}

	public ClasicomanoDTO(int identificador, String nombre, double tiempoAcumuladoMin) {
		super(identificador, nombre, tiempoAcumuladoMin);
	}

	public ClasicomanoDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin, String especialidad, String contextura) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin, especialidad,
				contextura);
	}

	public ClasicomanoDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero,
			int identificador, String nombre, double tiempoAcumuladoMin) {
		super(imagen, correo, usuario, id, contrasena, genero, identificador, nombre, tiempoAcumuladoMin);
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
