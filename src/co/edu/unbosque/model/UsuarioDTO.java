package co.edu.unbosque.model;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private String correo;
	private String usuario;
	private String id;
	private String contrasena;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String correo, String usuario, String id, String contrasena) {
		super();
		this.correo = correo;
		this.usuario = usuario;
		this.id = id;
		this.contrasena = contrasena;
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

	@Override
	public String toString() {
		return "Correo: " + correo + "\nUsuario: " + usuario + "\nId: " + id + "\nContraseña=" + contrasena
				+ "\n";
	}

}
