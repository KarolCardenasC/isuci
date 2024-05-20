package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import co.edu.unbosque.model.DirectorDeportivoDTO;

/**
 * The DirectorDeportivoDAO class implements CRUD operations for the DirectorDeportivoDTO class.
 * 
 * @autor Moreno.JP
 * @version 12/05/2024
 */

public class DirectorDeportivoDAO implements CRUDOperation<DirectorDeportivoDTO> {

	private ArrayList<DirectorDeportivoDTO> listaDirectoresDeportivos;
	private final String SERIALIZED_FILE_NAME = "datos/DirectorDeportivo.isuci";
	
	/**
     * Constructor for the DirectorDeportivoDAO class. Initializes the list of Directors and reads the serialized file.
     */
	
	public DirectorDeportivoDAO() {
		listaDirectoresDeportivos = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
     * Reads the serialized file and initializes the list of Directors.
     */
	
	@SuppressWarnings("unchecked")
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaDirectoresDeportivos = new ArrayList<>();
		} else {
			listaDirectoresDeportivos = (ArrayList<DirectorDeportivoDTO>) contenido;
		}

	}

	 /**
     * Checks if the index is valid for the list of Directors.
     * @param index the index to check
     * @return a message indicating the validity of the index
     */
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaDirectoresDeportivos.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaDirectoresDeportivos.size()
					+ " datos";
		}
		return "g";
	}

	 /**
     * Adds a new Director to the list and serializes the list.
     * @param data the Director to add
     */
	
	@Override
	public void crear(DirectorDeportivoDTO data) {
		listaDirectoresDeportivos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectoresDeportivos);

	}

	 /**
     * Updates the Director with the specified ID.
     * @param id the ID of the Director to update
     * @param newData the new data for the Director
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String actualizarPorCedula(long id, DirectorDeportivoDTO newData) {
		String msj = "No existe un Director Deportivo con esa cédula";

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCedula() == id) {
				listaDirectoresDeportivos.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectoresDeportivos);
				msj = "El Director Deportivo se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	 /**
     * Searches for Directors by name.
     * @param n the name to search for
     * @return a list of Directors with the specified name
     */
	
	@Override
	public ArrayList<DirectorDeportivoDTO> buscarNombre(String n) {

		ArrayList<DirectorDeportivoDTO> directoresDeportivos = null;

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				directoresDeportivos.add(listaDirectoresDeportivos.get(i));
			}
		}
		return directoresDeportivos;
	}

	 /**
     * Searches for a Director by ID.
     * @param id the ID to search for
     * @return the Director with the specified ID, or null if not found
     */
	
	@Override
	public DirectorDeportivoDTO buscarCedula(long id) {

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCedula() == id) {
				return listaDirectoresDeportivos.get(i);

			}
		}
		return null;
	}

	/**
     * Deletes a Director by ID.
     * @param id the ID of the Director to delete
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Director Deportivo con esa cédula";

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCedula() == id) {
				listaDirectoresDeportivos.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectoresDeportivos);
				msj = "El Director Deportivo se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	/**
     * Returns a list of all Directors.
     * @return a list of all Directors
     */
	
	@Override
	public ArrayList<DirectorDeportivoDTO> mostrarTodos() {
		ArrayList<DirectorDeportivoDTO> listaMostrar = new ArrayList<>();
		listaDirectoresDeportivos.forEach(c -> {
			DirectorDeportivoDTO directorDeportivoTemp = new DirectorDeportivoDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getNacionalidad(),c.getEquipo());

			listaMostrar.add(directorDeportivoTemp);
		});

		return listaMostrar;
	}
	
	/**
     * Verifies the user's credentials.
     * @param u the username
     * @param c the password
     * @return the Director if the credentials are correct, null otherwise
     */
	
	@Override
	public DirectorDeportivoDTO verificarUsuario(String u, String c) {
		for (DirectorDeportivoDTO directorDeportivo : listaDirectoresDeportivos) {
			if(directorDeportivo.getUsuario().equals(u)) {
				if(directorDeportivo.getContrasena().equals(c)) {
					return directorDeportivo;
				}
			}
		}
		return null;
	}
	
	 /**
     * Searches for a Director by email.
     * @param g the email to search for
     * @return the Director with the specified email, or null if not found
     */
	
	@Override
	public DirectorDeportivoDTO buscarGmail(String g) {
		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCorreo().equals(g)) {
				return listaDirectoresDeportivos.get(i);

			}
		}
		return null;
	}

}