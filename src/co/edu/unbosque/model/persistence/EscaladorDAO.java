package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.EscaladorDTO;

/**
 * This class manages the CRUD operations for EscaladorDTO objects,
 * including serialization and deserialization from a file.
 * 
 * @author Moreno.JP
 * @version 12/05/2024
 */

public class EscaladorDAO implements CRUDOperation<EscaladorDTO> {

	private ArrayList<EscaladorDTO> listaEscaladores;
	private final String SERIALIZED_FILE_NAME = "datos/Escalador.isuci";

	public EscaladorDAO() {
		listaEscaladores = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
	 * Reads the serialized file and initializes the list of Escaladores.
	 */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaEscaladores = new ArrayList<>();
		} else {
			listaEscaladores = (ArrayList<EscaladorDTO>) contenido;
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
		if (index >= listaEscaladores.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaEscaladores.size()
					+ " datos";
		}
		return "g";
	}

	/**
	 * Adds a new EscaladorDTO to the list and serializes the updated list.
	 * 
	 * @param data the EscaladorDTO to add
	 */
	
	@Override
	public void crear(EscaladorDTO data) {
		listaEscaladores.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEscaladores);

	}

	/**
	 * Updates an existing EscaladorDTO identified by its id.
	 * 
	 * @param id the id of the EscaladorDTO to update
	 * @param newData the new data for the EscaladorDTO
	 * @return a message indicating the result of the update operation
	 */
	
	@Override
	public String actualizarPorCedula(long id, EscaladorDTO newData) {
		String msj = "No existe un Escalador con esa cédula";

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCedula() == id) {
				listaEscaladores.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEscaladores);
				msj = "El Escalador se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Searches for EscaladorDTO objects by name.
	 * 
	 * @param n the name to search for
	 * @return a list of EscaladorDTO objects matching the name
	 */
	
	@Override
	public ArrayList<EscaladorDTO> buscarNombre(String n) {

		ArrayList<EscaladorDTO> escaladores = null;

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				escaladores.add(listaEscaladores.get(i));
			}
		}
		return escaladores;
	}

	/**
	 * Searches for an EscaladorDTO by its id.
	 * 
	 * @param id the id to search for
	 * @return the matching EscaladorDTO or null if not found
	 */
	
	@Override
	public EscaladorDTO buscarCedula(long id) {

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCedula() == id) {
				return listaEscaladores.get(i);

			}
		}
		return null;
	}

	/**
	 * Deletes an EscaladorDTO identified by its id.
	 * 
	 * @param id the id of the EscaladorDTO to delete
	 * @return a message indicating the result of the delete operation
	 */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Escalador con esa cédula";

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCedula() == id) {
				listaEscaladores.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEscaladores);
				msj = "El Escalador se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Returns a list of all EscaladorDTO objects.
	 * 
	 * @return a list of all EscaladorDTO objects
	 */
	
	@Override
	public ArrayList<EscaladorDTO> mostrarTodos() {
		ArrayList<EscaladorDTO> listaMostrar = new ArrayList<>();
		listaEscaladores.forEach(c -> {
			EscaladorDTO escaladorTemp = new EscaladorDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getIdentificador(), c.getAniosExperiencia(), c.getTiempoAcumuladoMin(),
					c.getEspecialidad(), c.getContextura(), c.getEquipo(), c.getAceleracionPromSubida(), c.getGradoRampaSoportada());

			listaMostrar.add(escaladorTemp);
		});

		return listaMostrar;
	}
	
	/**
	 * Verifies the user's credentials.
	 * 
	 * @param u the username
	 * @param c the password
	 * @return the matching EscaladorDTO or null if not found
	 */
	
	@Override
	public EscaladorDTO verificarUsuario(String u, String c) {
		for (EscaladorDTO escalador : listaEscaladores) {
			if(escalador.getUsuario().equals(u)) {
				if(escalador.getContrasena().equals(c)) {
					return escalador;
				}
			}
		}
		return null;
	}
	
	/**
	 * Searches for an EscaladorDTO by its email.
	 * 
	 * @param g the email to search for
	 * @return the matching EscaladorDTO or null if not found
	 */
	
	@Override
	public EscaladorDTO buscarGmail(String g) {
		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCorreo().equals(g)) {
				return listaEscaladores.get(i);

			}
		}
		return null;
	}

	/**
	 * Searches for an EscaladorDTO by its identifier.
	 * 
	 * @param iden the identifier to search for
	 * @return the matching EscaladorDTO or null if not found
	 */
	
	public EscaladorDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getIdentificador() == iden) {
				return listaEscaladores.get(i);

			}
		}
		return null;
	}
}