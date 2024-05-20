package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * The UsuarioDAO class implements CRUD operations for the UsuarioDTO class.
 * 
 * @author Moreno.JP
 * @version 12/05/2024
 */

public class UsuarioDAO implements CRUDOperation<UsuarioDTO> {

	private ArrayList<UsuarioDTO> listaUsuarios;
	private static ArrayList<UsuarioDTO> listaTodos;
	private final String SERIALIZED_FILE_NAME = "datos/Usuario.isuci";

	 /**
     * Constructor for the UsuarioDAO class. Initializes the list of Users and reads the serialized file.
     */
	
	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
		listaTodos = new ArrayList<>();

		leerArchivoSerializado();
	}

	/**
     * Reads the serialized file and initializes the list of Users.
     */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaUsuarios = new ArrayList<>();
		} else {
			listaUsuarios = (ArrayList<UsuarioDTO>) contenido;
		}

	}

	/**
     * Checks if the index is valid for the list of Users.
     * @param index the index to check
     * @return a message indicating the validity of the index
     */
	
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

	/**
     * Adds a new User to the list and serializes the list.
     * @param data the User to add
     */
	
	@Override
	public void crear(UsuarioDTO data) {
		listaUsuarios.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);

	}

	 /**
     * Updates the User with the specified ID.
     * @param id the ID of the User to update
     * @param newData the new data for the User
     * @return a message indicating the result of the operation
     */
	
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

	 /**
     * Searches for Users by name.
     * @param n the name to search for
     * @return a list of Users with the specified name
     */
	
	@Override
	public ArrayList<UsuarioDTO> buscarNombre(String n) {

		ArrayList<UsuarioDTO> usuarios = null;

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				usuarios.add(listaUsuarios.get(i));
			}
		}
		return usuarios;
	}

	  /**
     * Searches for a User by ID.
     * @param id the ID to search for
     * @return the User with the specified ID, or null if not found
     */
	
	@Override
	public UsuarioDTO buscarCedula(long id) {

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				return listaUsuarios.get(i);

			}
		}
		return null;
	}

	 /**
     * Deletes a User by ID.
     * @param id the ID of the User to delete
     * @return a message indicating the result of the operation
     */
	
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

	/**
     * Returns a list of all Users.
     * @return a list of all Users
     */
	
	@Override
	public ArrayList<UsuarioDTO> mostrarTodos() {
		ArrayList<UsuarioDTO> listaMostrar = new ArrayList<>();

		listaUsuarios.forEach(u -> {
			UsuarioDTO usuarioTemp = new UsuarioDTO(u.getImagen(), u.getNombre(), u.getCedula(), u.getCorreo(),
					u.getUsuario(), u.getId(), u.getContrasena(), u.getGenero());

			listaMostrar.add(usuarioTemp);
		});

		return listaMostrar;
	}

	/**
     * Returns a list of Users based on their role.
     * @param rol the role of the Users to retrieve
     * @return a list of Users with the specified role
     */
	
	public static ArrayList<UsuarioDTO> listaUsurios(String rol) {
		CiclistaDAO ciclistas = new CiclistaDAO();
		
		switch (rol) {
		case "MASAJISTA":
			obtenerMasajista();
			break;
		case "DIRECTOR":
			obtenerDirector();
			break;
		case "CICLISTA":
			listaTodos.addAll(ciclistas.listaCiclistas("Ninguna", ""));
			break;

		default:
			listaTodos.addAll(ciclistas.listaCiclistas("", ""));
			obtenerMasajista();
			obtenerDirector();
			break;
		}

		return listaTodos;
	}

	/**
     * Retrieves the Directors from the database.
     */
	
	private static void obtenerDirector() {

		DirectorDeportivoDAO DirectorDAO = new DirectorDeportivoDAO();
		DirectorDAO.mostrarTodos().forEach(p -> {
			Predicate<UsuarioDTO> byDirec = skill -> (skill.getId() == p.getId());
			var result = listaTodos.stream().filter(byDirec).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Director");
				listaTodos.add(p);
			}

		});

	}

	/**
     * Retrieves the Masseurs from the database.
     */
	private static void obtenerMasajista() {
		MasajistaDAO MasajistaDAO = new MasajistaDAO();
		MasajistaDAO.mostrarTodos().forEach(p -> {
			Predicate<UsuarioDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = listaTodos.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Masajista");
				listaTodos.add(p);
			}

		});
	}

	/**
	 * Verifies if a user with the given username and password exists.
	 * 
	 * @param u The username to verify.
	 * @param c The password to verify.
	 * @return The UserDTO object if the user is found, otherwise null.
	 */
	@Override
	public UsuarioDTO verificarUsuario(String u, String c) {
		for (UsuarioDTO usuario : listaUsuarios) {
			if (usuario.getUsuario().equals(u)) {
				if (usuario.getContrasena().equals(c)) {
					return usuario;
				}
			}
		}
		return null;
	}

	/**
	 * Searches for a user with the given email address.
	 * 
	 * @param g The email address to search for.
	 * @return The UserDTO object if found, otherwise null.
	 */
	@Override
	public UsuarioDTO buscarGmail(String g) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCorreo().equals(g)) {
				return listaUsuarios.get(i);

			}
		}
		return null;
	}

}