package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.UsuarioDTO;

public class UsuarioDAO implements CRUDOperation<UsuarioDTO> {

	private ArrayList<UsuarioDTO> listaUsuarios;
	private final String SERIALIZED_FILE_NAME = "datos/Usuario.isuci";

	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaUsuarios = new ArrayList<>();
		} else {
			listaUsuarios = (ArrayList<UsuarioDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaUsuarios.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaUsuarios.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(UsuarioDTO data) {
		listaUsuarios.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);

	}

	@Override
	public String actualizarPorCedula(long id, UsuarioDTO newData) {
		String msj = "No existe un Usuario con esa cédula";

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				listaUsuarios.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
				msj = "El Usuario se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<UsuarioDTO> buscarNombre(String n) {

		ArrayList<UsuarioDTO> Usuarios = null;

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				Usuarios.add(listaUsuarios.get(i));
			}
		}
		return Usuarios;
	}

	@Override
	public UsuarioDTO buscarCedula(long id) {

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				return listaUsuarios.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Usuario con esa cédula";

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				listaUsuarios.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
				msj = "El Usuario se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<UsuarioDTO> mostrarTodos() {
		ArrayList<UsuarioDTO> listaMostrar = new ArrayList<>();
		listaUsuarios.forEach(c -> {
			UsuarioDTO UsuarioTemp = new UsuarioDTO(c.getImagen(), c.getNombre(), c.getCedula(),
					c.getCorreo(), c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero());

			listaMostrar.add(UsuarioTemp);
		});

		return listaMostrar;
	}

}
