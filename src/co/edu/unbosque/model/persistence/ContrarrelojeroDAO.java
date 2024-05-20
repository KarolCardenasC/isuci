package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.ContrarrelojeroDTO;

/**
 * The ContrarrelojeroDAO class implements CRUD operations for the ContrarrelojeroDTO class.
 * 
 * @autor Moreno.JP
 * @version 12/05/2024
 */

public class ContrarrelojeroDAO implements CRUDOperation<ContrarrelojeroDTO> {

	private ArrayList<ContrarrelojeroDTO> listaContrarrelojeros;
	private final String SERIALIZED_FILE_NAME = "datos/Contrarrelojero.isuci";
	
	/**
     * Constructor for the ContrarrelojeroDAO class. Initializes the list of Contrarrelojeros and reads the serialized file.
     */
	
	public ContrarrelojeroDAO() {
		listaContrarrelojeros = new ArrayList<>();
		leerArchivoSerializado();
	}
	
	/**
     * Reads the serialized file and initializes the list of Contrarrelojeros.
     */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaContrarrelojeros = new ArrayList<>();
		} else {
			listaContrarrelojeros = (ArrayList<ContrarrelojeroDTO>) contenido;
		}

	}

	 /**
     * Checks if the index is valid for the list of Contrarrelojeros.
     * @param index the index to check
     * @return a message indicating the validity of the index
     */
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaContrarrelojeros.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: "
					+ listaContrarrelojeros.size() + " datos";
		}
		return "g";
	}

	/**
     * Adds a new Contrarrelojero to the list and serializes the list.
     * @param data the Contrarrelojero to add
     */
	
	@Override
	public void crear(ContrarrelojeroDTO data) {
		listaContrarrelojeros.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaContrarrelojeros);

	}

	/**
     * Updates the Contrarrelojero with the specified ID.
     * @param id the ID of the Contrarrelojero to update
     * @param newData the new data for the Contrarrelojero
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String actualizarPorCedula(long id, ContrarrelojeroDTO newData) {
		String msj = "No existe un Contrarrelojero con esa cédula";

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCedula() == id) {
				listaContrarrelojeros.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaContrarrelojeros);
				msj = "El Contrarrelojero se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
     * Searches for Contrarrelojeros by name.
     * @param n the name to search for
     * @return a list of Contrarrelojeros with the specified name
     */
	
	@Override
	public ArrayList<ContrarrelojeroDTO> buscarNombre(String n) {

		ArrayList<ContrarrelojeroDTO> contrarrelojeros = null;

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				contrarrelojeros.add(listaContrarrelojeros.get(i));
			}
		}
		return contrarrelojeros;
	}

	 /**
     * Searches for a Contrarrelojero by ID.
     * @param id the ID to search for
     * @return the Contrarrelojero with the specified ID, or null if not found
     */
	
	@Override
	public ContrarrelojeroDTO buscarCedula(long id) {

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCedula() == id) {
				return listaContrarrelojeros.get(i);

			}
		}
		return null;
	}

	 /**
     * Deletes a Contrarrelojero by ID.
     * @param id the ID of the Contrarrelojero to delete
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Contrarrelojero con esa cédula";

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCedula() == id) {
				listaContrarrelojeros.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaContrarrelojeros);
				msj = "El Contrarrelojero se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	 /**
     * Returns a list of all Contrarrelojeros.
     * @return a list of all Contrarrelojeros
     */
	
	@Override
	public ArrayList<ContrarrelojeroDTO> mostrarTodos() {
		ArrayList<ContrarrelojeroDTO> listaMostrar = new ArrayList<>();
		listaContrarrelojeros.forEach(c -> {
			ContrarrelojeroDTO contrarrelojeroTemp = new ContrarrelojeroDTO(c.getImagen(), c.getNombre(), c.getCedula(),
					c.getCorreo(), c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(), c.getEquipo(),
					c.getVelocidadMaxima());

			listaMostrar.add(contrarrelojeroTemp);
		});

		return listaMostrar;
	}
	
	/**
     * Verifies the user's credentials.
     * @param u the username
     * @param c the password
     * @return the Contrarrelojero if the credentials are correct, null otherwise
     */
	
	@Override
	public ContrarrelojeroDTO verificarUsuario(String u, String c) {
		for (ContrarrelojeroDTO contrarrelojero : listaContrarrelojeros) {
			if(contrarrelojero.getUsuario().equals(u)) {
				if(contrarrelojero.getContrasena().equals(c)) {
					return contrarrelojero;
				}
			}
		}
		return null;
	}
	
	/**
     * Searches for a Contrarrelojero by email.
     * @param g the email to search for
     * @return the Contrarrelojero with the specified email, or null if not found
     */
	
	@Override
	public ContrarrelojeroDTO buscarGmail(String g) {
		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCorreo().equals(g)) {
				return listaContrarrelojeros.get(i);

			}
		}
		return null;
	}
	
	/**
     * Searches for a Contrarrelojero by identifier.
     * @param iden the identifier to search for
     * @return the Contrarrelojero with the specified identifier, or null if not found
     */
	
	public ContrarrelojeroDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getIdentificador() == iden) {
				return listaContrarrelojeros.get(i);

			}
		}
		return null;
	}
	
}