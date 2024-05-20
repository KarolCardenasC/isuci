package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.MasajistaDTO;

/**
 * This class manages the CRUD operations for MasajistaDTO objects,
 * including serialization and deserialization from a file.
 * 
 * @autor Moreno.JP
 * @version 12/05/2024
 */

public class MasajistaDAO implements CRUDOperation<MasajistaDTO> {

	private ArrayList<MasajistaDTO> listaMasajistas;
	private final String SERIALIZED_FILE_NAME = "datos/Masajista.isuci";

	public MasajistaDAO() {
		listaMasajistas = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
	 * Reads the serialized file and initializes the list of Masajistas.
	 */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaMasajistas = new ArrayList<>();
		} else {
			listaMasajistas = (ArrayList<MasajistaDTO>) contenido;
		}

	}

	/**
	 * Checks if the provided index is valid.
	 * 
	 * @param index the index to check
	 * @return a message indicating if the index is valid or not
	 */
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaMasajistas.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaMasajistas.size()
					+ " datos";
		}
		return "g";
	}

	/**
	 * Adds a new MasajistaDTO to the list and serializes the updated list.
	 * 
	 * @param data the MasajistaDTO to add
	 */
	
	@Override
	public void crear(MasajistaDTO data) {
		listaMasajistas.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaMasajistas);

	}

	/**
	 * Updates an existing MasajistaDTO identified by its id.
	 * 
	 * @param id the id of the MasajistaDTO to update
	 * @param newData the new data for the MasajistaDTO
	 * @return a message indicating the result of the update operation
	 */
	
	@Override
	public String actualizarPorCedula(long id, MasajistaDTO newData) {
		String msj = "No existe un Masajista con esa cédula";

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCedula() == id) {
				listaMasajistas.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaMasajistas);
				msj = "El Masajista se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Searches for MasajistaDTO objects by name.
	 * 
	 * @param n the name to search for
	 * @return a list of MasajistaDTO objects matching the name
	 */
	
	@Override
	public ArrayList<MasajistaDTO> buscarNombre(String n) {

		ArrayList<MasajistaDTO> masajistas = null;

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				masajistas.add(listaMasajistas.get(i));
			}
		}
		return masajistas;
	}

	/**
	 * Searches for a MasajistaDTO by its id.
	 * 
	 * @param id the id to search for
	 * @return the matching MasajistaDTO or null if not found
	 */
	
	@Override
	public MasajistaDTO buscarCedula(long id) {

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCedula() == id) {
				return listaMasajistas.get(i);

			}
		}
		return null;
	}

	/**
	 * Deletes a MasajistaDTO identified by its id.
	 * 
	 * @param id the id of the MasajistaDTO to delete
	 * @return a message indicating the result of the delete operation
	 */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Masajista con esa cédula";

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCedula() == id) {
				listaMasajistas.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaMasajistas);
				msj = "El Masajista se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Returns a list of all MasajistaDTO objects.
	 * 
	 * @return a list of all MasajistaDTO objects
	 */
	
	@Override
	public ArrayList<MasajistaDTO> mostrarTodos() {
		ArrayList<MasajistaDTO> listaMostrar = new ArrayList<>();
		listaMasajistas.forEach(c -> {
			MasajistaDTO masajistaTemp = new MasajistaDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getAniosExperiencia(),c.getEquipo());

			listaMostrar.add(masajistaTemp);
		});

		return listaMostrar;
	}
	
	/**
	 * Verifies the user's credentials.
	 * 
	 * @param u the username
	 * @param c the password
	 * @return the matching MasajistaDTO or null if not found
	 */
	
	@Override
	public MasajistaDTO verificarUsuario(String u, String c) {
		for (MasajistaDTO masajista : listaMasajistas) {
			if(masajista.getUsuario().equals(u)) {
				if(masajista.getContrasena().equals(c)) {
					return masajista;
				}
			}
		}
		return null;
	}
	
	/**
	 * Searches for a MasajistaDTO by its email.
	 * 
	 * @param g the email to search for
	 * @return the matching MasajistaDTO or null if not found
	 */
	
	@Override
	public MasajistaDTO buscarGmail(String g) {
		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCorreo().equals(g)) {
				return listaMasajistas.get(i);

			}
		}
		return null;
	}

}