package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.RodadorDTO;
import co.edu.unbosque.model.RodadorDTO;

/**
 * This class manages the CRUD operations for RodadorDTO objects,
 * including serialization and deserialization from a file.
 * 
 * @autor Moreno.JP
 * @version 12/05/2024
 */

public class RodadorDAO implements CRUDOperation<RodadorDTO> {

	private ArrayList<RodadorDTO> listaRodadores;
	private final String SERIALIZED_FILE_NAME = "datos/Rodador.isuci";

	public RodadorDAO() {
		listaRodadores = new ArrayList<>();
		leerArchivoSerializado();
	}
	
	/**
	 * Reads the serialized file and initializes the list of Rodadores.
	 */
	

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaRodadores = new ArrayList<>();
		} else {
			listaRodadores = (ArrayList<RodadorDTO>) contenido;
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
		if (index >= listaRodadores.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaRodadores.size()
					+ " datos";
		}
		return "g";
	}

	/**
	 * Adds a new RodadorDTO to the list and serializes the updated list.
	 * 
	 * @param data the RodadorDTO to add
	 */
	
	@Override
	public void crear(RodadorDTO data) {
		listaRodadores.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaRodadores);

	}

	/**
	 * Updates an existing RodadorDTO identified by its id.
	 * 
	 * @param id the id of the RodadorDTO to update
	 * @param newData the new data for the RodadorDTO
	 * @return a message indicating the result of the update operation
	 */
	
	@Override
	public String actualizarPorCedula(long id, RodadorDTO newData) {
		String msj = "No existe un Rodador con esa cédula";

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCedula() == id) {
				listaRodadores.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaRodadores);
				msj = "El Rodador se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Searches for RodadorDTO objects by name.
	 * 
	 * @param n the name to search for
	 * @return a list of RodadorDTO objects matching the name
	 */
	
	@Override
	public ArrayList<RodadorDTO> buscarNombre(String n) {

		ArrayList<RodadorDTO> rodadores = null;

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				rodadores.add(listaRodadores.get(i));
			}
		}
		return rodadores;
	}

	/**
	 * Searches for a RodadorDTO by its id.
	 * 
	 * @param id the id to search for
	 * @return the matching RodadorDTO or null if not found
	 */
	
	@Override
	public RodadorDTO buscarCedula(long id) {

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCedula() == id) {
				return listaRodadores.get(i);

			}
		}
		return null;
	}

	/**
	 * Deletes a RodadorDTO identified by its id.
	 * 
	 * @param id the id of the RodadorDTO to delete
	 * @return a message indicating the result of the delete operation
	 */
	
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Rodador con esa cédula";

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCedula() == id) {
				listaRodadores.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaRodadores);
				msj = "El Rodador se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	/**
	 * Returns a list of all RodadorDTO objects.
	 * 
	 * @return a list of all RodadorDTO objects
	 */
	
	@Override
	public ArrayList<RodadorDTO> mostrarTodos() {
		ArrayList<RodadorDTO> listaMostrar = new ArrayList<>();
		listaRodadores.forEach(c -> {
			RodadorDTO rodadorTemp = new RodadorDTO(c.getImagen(), c.getNombre(), c.getCedula(),
					c.getCorreo(), c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(), c.getEquipo(),
					c.getVelocidadPromPedaleo());

			listaMostrar.add(rodadorTemp);
		});

		return listaMostrar;
	}
	
	/**
	 * Verifies the user's credentials.
	 * 
	 * @param u the username
	 * @param c the password
	 * @return the matching RodadorDTO or null if not found
	 */
	
	@Override
	public RodadorDTO verificarUsuario(String u, String c) {
		for (RodadorDTO rodador : listaRodadores) {
			if(rodador.getUsuario().equals(u)) {
				if(rodador.getContrasena().equals(c)) {
					return rodador;
				}
			}
		}
		return null;
	}
	
	/**
	 * Searches for a RodadorDTO by its email.
	 * 
	 * @param g the email to search for
	 * @return the matching RodadorDTO or null if not found
	 */
	
	@Override
	public RodadorDTO buscarGmail(String g) {
		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCorreo().equals(g)) {
				return listaRodadores.get(i);

			}
		}
		return null;
	}
	
	/**
	 * Searches for a RodadorDTO by its identifier.
	 * 
	 * @param iden the identifier to search for
	 * @return the matching RodadorDTO or null if not found
	 */
	
	public RodadorDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getIdentificador() == iden) {
				return listaRodadores.get(i);

			}
		}
		return null;
	}

}