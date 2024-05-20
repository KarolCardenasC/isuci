package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.GregarioDTO;

/**
 * This class manages the CRUD operations for GregarioDTO objects,
 * including serialization and deserialization from a file.
 * 
 * @author Moreno.JP
 * @version 12/05/2024
 */

public class GregarioDAO implements CRUDOperation<GregarioDTO> {

	private ArrayList<GregarioDTO> listaGregarios;
	private final String SERIALIZED_FILE_NAME = "datos/Gregario.isuci";

	
	public GregarioDAO() {
		listaGregarios = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
	 * Reads the serialized file and initializes the list of Gregarios.
	 */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaGregarios = new ArrayList<>();
		} else {
			listaGregarios = (ArrayList<GregarioDTO>) contenido;
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
		if (index >= listaGregarios.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaGregarios.size()
					+ " datos";
		}
		return "g";
	}

	/**
	 * Adds a new GregarioDTO to the list and serializes the updated list.
	 * 
	 * @param data the GregarioDTO to add
	 */
	
	@Override
	public void crear(GregarioDTO data) {
		listaGregarios.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaGregarios);

	}

	/**
	 * Updates an existing GregarioDTO identified by its id.
	 * 
	 * @param id the id of the GregarioDTO to update
	 * @param newData the new data for the GregarioDTO
	 * @return a message indicating the result of the update operation
	 */
	
	@Override
	public String actualizarPorCedula(long id, GregarioDTO newData) {
		String msj = "No existe un Gregario con esa cédula";

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCedula() == id) {
				listaGregarios.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaGregarios);
				msj = "El Gregario se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Searches for GregarioDTO objects by name.
	 * 
	 * @param n the name to search for
	 * @return a list of GregarioDTO objects matching the name
	 */
	
	@Override
	public ArrayList<GregarioDTO> buscarNombre(String n) {

		ArrayList<GregarioDTO> gregarios = null;

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				gregarios.add(listaGregarios.get(i));
			}
		}
		return gregarios;
	}

	/**
	 * Searches for a GregarioDTO by its id.
	 * 
	 * @param id the id to search for
	 * @return the matching GregarioDTO or null if not found
	 */
	
	@Override
	public GregarioDTO buscarCedula(long id) {

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCedula() == id) {
				return listaGregarios.get(i);

			}
		}
		return null;
	}

	/**
	 * Deletes a GregarioDTO identified by its id.
	 * 
	 * @param id the id of the GregarioDTO to delete
	 * @return a message indicating the result of the delete operation
	 */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Gregario con esa cédula";

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCedula() == id) {
				listaGregarios.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaGregarios);
				msj = "El Gregario se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Returns a list of all GregarioDTO objects.
	 * 
	 * @return a list of all GregarioDTO objects
	 */
	
	@Override
	public ArrayList<GregarioDTO> mostrarTodos() {
		ArrayList<GregarioDTO> listaMostrar = new ArrayList<>();
		listaGregarios.forEach(c -> {
			GregarioDTO gregarioTemp = new GregarioDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(),
					c.getFuncionPeloton());

			listaMostrar.add(gregarioTemp);
		});

		return listaMostrar;
	}
	
	/**
	 * Verifies the user's credentials.
	 * 
	 * @param u the username
	 * @param c the password
	 * @return the matching GregarioDTO or null if not found
	 */
	
	@Override
	public GregarioDTO verificarUsuario(String u, String c) {
		for (GregarioDTO gregario : listaGregarios) {
			if(gregario.getUsuario().equals(u)) {
				if(gregario.getContrasena().equals(c)) {
					return gregario;
				}
			}
		}
		return null;
	}
	
	/**
	 * Searches for a GregarioDTO by its email.
	 * 
	 * @param g the email to search for
	 * @return the matching GregarioDTO or null if not found
	 */
	
	@Override
	public GregarioDTO buscarGmail(String g) {
		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCorreo().equals(g)) {
				return listaGregarios.get(i);

			}
		}
		return null;
	}
	
	/**
	 * Searches for a GregarioDTO by its identifier.
	 * 
	 * @param iden the identifier to search for
	 * @return the matching GregarioDTO or null if not found
	 */
	
	public GregarioDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getIdentificador() == iden) {
				return listaGregarios.get(i);

			}
		}
		return null;
	}

}