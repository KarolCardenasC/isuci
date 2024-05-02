package co.edu.unbosque.model;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private String imagen;
	private String correo;
	private String usuario;
	private String id;
	private String contrasena;
	private String genero;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String imagen, String correo, String usuario, String id, String contrasena, String genero) {
		super();
		this.imagen = imagen;
		this.correo = correo;
		this.usuario = usuario;
		this.id = id;
		this.contrasena = contrasena;
		this.genero = genero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Imagen: " + imagen + "\nCorreo: " + correo + "\nUsuario: " + usuario + "\nId: " + id
				+ "\nContraseña: " + contrasena + "\nGenero: " + genero + "\n";
	}

}
