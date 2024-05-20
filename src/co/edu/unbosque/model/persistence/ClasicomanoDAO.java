package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.ClasicomanoDTO;
/**
 * The ClasicomanoDAO class implements CRUD operations for the ClasicomanoDTO class.
 * 
 * @author Moreno.JP
 * @version 12/05/2024
 * 
 */
public class ClasicomanoDAO implements CRUDOperation<ClasicomanoDTO> {

	private ArrayList<ClasicomanoDTO> listaClasicomanos;
	private final String SERIALIZED_FILE_NAME = "datos/Clasicomano.isuci";
	 
	/**
     * Constructor for the ClasicomanoDAO class. Initializes the list of Clasicomanos and reads the serialized file.
     */

	public ClasicomanoDAO() {
		listaClasicomanos = new ArrayList<>();
		leerArchivoSerializado();
	}
	/**
     * Reads the serialized file and initializes the list of Clasicomanos.
     */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaClasicomanos = new ArrayList<>();
		} else {
			listaClasicomanos = (ArrayList<ClasicomanoDTO>) contenido;
		}

	}

	/**
     * Checks if the index is valid for the list of Clasicomanos.
     * @param index the index to check
     * @return a message indicating the validity of the index
     */
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaClasicomanos.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaClasicomanos.size()
					+ " datos";
		}
		return "g";
	}

	/**
     * Adds a new Clasicomano to the list and serializes the list.
     * @param data the Clasicomano to add
     */
	
	@Override
	public void crear(ClasicomanoDTO data) {
		listaClasicomanos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaClasicomanos);

	}

	 /**
     * Updates the Clasicomano with the specified ID.
     * @param id the ID of the Clasicomano to update
     * @param newData the new data for the Clasicomano
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String actualizarPorCedula(long id, ClasicomanoDTO newData) {
		String msj = "No existe un Clasicomano con esa cédula";

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCedula() == id) {
				listaClasicomanos.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaClasicomanos);
				msj = "El Clasicomano se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	  /**
     * Searches for Clasicomanos by name.
     * @param n the name to search for
     * @return a list of Clasicomanos with the specified name
     */
	
	@Override
	public ArrayList<ClasicomanoDTO> buscarNombre(String n) {

		ArrayList<ClasicomanoDTO> clasicomanos = null;

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				clasicomanos.add(listaClasicomanos.get(i));
			}
		}
		return clasicomanos;
	}

	
	/**
     * Searches for a Clasicomano by ID.
     * @param id the ID to search for
     * @return the Clasicomano with the specified ID, or null if not found
     */
	
	@Override
	public ClasicomanoDTO buscarCedula(long id) {

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCedula() == id) {
				return listaClasicomanos.get(i);

			}
		}
		return null;
	}

	/**
     * Deletes a Clasicomano by ID.
     * @param id the ID of the Clasicomano to delete
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Clasicomano con esa cédula";

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCedula() == id) {
				listaClasicomanos.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaClasicomanos);
				msj = "El Clasicomano se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	/**
     * Returns a list of all Clasicomanos.
     * @return a list of all Clasicomanos
     */
	
	@Override
	public ArrayList<ClasicomanoDTO> mostrarTodos() {
		ArrayList<ClasicomanoDTO> listaMostrar = new ArrayList<>();
		listaClasicomanos.forEach(c -> {
			ClasicomanoDTO clasicomanoTemp = new ClasicomanoDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getIdentificador(), c.getAniosExperiencia(), c.getTiempoAcumuladoMin(),
					c.getEspecialidad(), c.getContextura(), c.getEquipo(), c.getNumeroClasicosganados());

			listaMostrar.add(clasicomanoTemp);
		});

		return listaMostrar;
	}

	/**
     * Verifies the user's credentials.
     * @param u the username
     * @param c the password
     * @return the Clasicomano with the specified credentials, or null if not found
     */
	
	@Override
	public ClasicomanoDTO verificarUsuario(String u, String c) {
		for (ClasicomanoDTO clasicomano : listaClasicomanos) {
			if(clasicomano.getUsuario().equals(u)) {
				if(clasicomano.getContrasena().equals(c)) {
					return clasicomano;
				}
			}
		}
		return null;
	}
	
	/**
     * Searches for a Clasicomano by email.
     * @param g the email to search for
     * @return the Clasicomano with the specified email, or null if not found
     */
	
	@Override
	public ClasicomanoDTO buscarGmail(String g) {
		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCorreo().equals(g)) {
				return listaClasicomanos.get(i);

			}
		}
		return null;
	}
	
	/**
     * Searches for a Clasicomano by identifier.
     * @param iden the identifier to search for
     * @return the Clasicomano with the specified identifier, or null if not found
     */
	
	public ClasicomanoDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getIdentificador() == iden) {
				return listaClasicomanos.get(i);

			}
		}
		return null;
	}
}
