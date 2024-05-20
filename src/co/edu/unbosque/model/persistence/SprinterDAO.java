package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.SprinterDTO;
import co.edu.unbosque.model.SprinterDTO;

/**
 * This class manages the CRUD operations for SprinterDTO objects,
 * including serialization and deserialization from a file.
 * 
 * @autor Moreno.JP
 * @version 12/05/2024
 */

public class SprinterDAO implements CRUDOperation<SprinterDTO> {

	private ArrayList<SprinterDTO> listaSprinters;
	private final String SERIALIZED_FILE_NAME = "datos/Sprinter.isuci";

	public SprinterDAO() {
		listaSprinters = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
	 * Reads the serialized file and initializes the list of Sprinters.
	 */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaSprinters = new ArrayList<>();
		} else {
			listaSprinters = (ArrayList<SprinterDTO>) contenido;
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
		if (index >= listaSprinters.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaSprinters.size()
					+ " datos";
		}
		return "g";
	}

	/**
	 * Adds a new SprinterDTO to the list and serializes the updated list.
	 * 
	 * @param data the SprinterDTO to add
	 */
	
	@Override
	public void crear(SprinterDTO data) {
		listaSprinters.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaSprinters);

	}

	/**
	 * Updates an existing SprinterDTO identified by its id.
	 * 
	 * @param id the id of the SprinterDTO to update
	 * @param newData the new data for the SprinterDTO
	 * @return a message indicating the result of the update operation
	 */
	
	@Override
	public String actualizarPorCedula(long id, SprinterDTO newData) {
		String msj = "No existe un Sprinter con esa cédula";

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCedula() == id) {
				listaSprinters.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaSprinters);
				msj = "El Sprinter se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Searches for SprinterDTO objects by name.
	 * 
	 * @param n the name to search for
	 * @return a list of SprinterDTO objects matching the name
	 */
	
	@Override
	public ArrayList<SprinterDTO> buscarNombre(String n) {

		ArrayList<SprinterDTO> sprinters = null;

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				sprinters.add(listaSprinters.get(i));
			}
		}
		return sprinters;
	}

	/**
	 * Searches for a SprinterDTO by its id.
	 * 
	 * @param id the id to search for
	 * @return the matching SprinterDTO or null if not found
	 */
	
	@Override
	public SprinterDTO buscarCedula(long id) {

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCedula() == id) {
				return listaSprinters.get(i);

			}
		}
		return null;
	}

	/**
	 * Deletes a SprinterDTO identified by its id.
	 * 
	 * @param id the id of the SprinterDTO to delete
	 * @return a message indicating the result of the delete operation
	 */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Sprinter con esa cédula";

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCedula() == id) {
				listaSprinters.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaSprinters);
				msj = "El Sprinter se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}
	
	/**
	 * Returns a list of all SprinterDTO objects.
	 * 
	 * @return a list of all SprinterDTO objects
	 */
	
	@Override
	public ArrayList<SprinterDTO> mostrarTodos() {
		ArrayList<SprinterDTO> listaMostrar = new ArrayList<>();
		listaSprinters.forEach(c -> {
			SprinterDTO sprinterTemp = new SprinterDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(), c.getEquipo(),
					c.getExplosionMetrosFinales(), c.getPotenciaPromVatios(), c.getVelocidadPromSprintKm());

			listaMostrar.add(sprinterTemp);
		});

		return listaMostrar;
	}
	
	/**
	 * Verifies the user's credentials.
	 * 
	 * @param u the username
	 * @param c the password
	 * @return the matching SprinterDTO or null if not found
	 */
	
	@Override
	public SprinterDTO verificarUsuario(String u, String c) {
		for (SprinterDTO sprinter : listaSprinters) {
			if(sprinter.getUsuario().equals(u)) {
				if(sprinter.getContrasena().equals(c)) {
					return sprinter;
				}
			}
		}
		return null;
	}
	
	/**
	 * Searches for a SprinterDTO by its email.
	 * 
	 * @param g the email to search for
	 * @return the matching SprinterDTO or null if not found
	 */
	
	@Override
	public SprinterDTO buscarGmail(String g) {
		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCorreo().equals(g)) {
				return listaSprinters.get(i);

			}
		}
		return null;
	}
	
	/**
	 * Searches for a SprinterDTO by its identifier.
	 * 
	 * @param iden the identifier to search for
	 * @return the matching SprinterDTO or null if not found
	 */
	
	public SprinterDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getIdentificador() == iden) {
				return listaSprinters.get(i);

			}
		}
		return null;
	}

}