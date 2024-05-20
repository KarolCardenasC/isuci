package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.EquipoDTO;
/**
 * The EquipoDAO class implements CRUD operations for the EquipoDTO class.
 * 
 * @author Moreno.JP
 * @version 12/05/2024
 * 
 */
public class EquipoDAO implements CRUDEquipo<EquipoDTO> {

	private ArrayList<EquipoDTO> listaEquipos;
	private final String SERIALIZED_FILE_NAME = "datos/Equipos.isuci";
	
	/**
     * Constructor for the EquipoDAO class. Initializes the list of Equipos and reads the serialized file.
     */
	
	public EquipoDAO() {
		listaEquipos = new ArrayList<>();
		leerArchivoSerializado();
	}
	
	/**
     * Reads the serialized file and initializes the list of Equipos.
     */
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaEquipos = new ArrayList<>();
		} else {
			listaEquipos = (ArrayList<EquipoDTO>) contenido;
		}

	}

	 /**
     * Checks if the index is valid for the list of Equipos.
     * @param index the index to check
     * @return a message indicating the validity of the index
     */
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaEquipos.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaEquipos.size()
					+ " datos";
		}
		return "g";
	}

	 /**
     * Adds a new Equipo to the list and serializes the list.
     * @param data the Equipo to add
     */
	
	@Override
	public void crear(EquipoDTO data) {
		listaEquipos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEquipos);
	}

	/**
     * Updates the Equipo with the specified name.
     * @param n the name of the Equipo to update
     * @param newData the new data for the Equipo
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String actualizarPorNombre(String n, EquipoDTO newData) {
		String msj = "No existe un Equipo con ese nombre";

		for (int i = 0; i < listaEquipos.size(); i++) {
			if (listaEquipos.get(i).getNombre().equals(n)) {
				listaEquipos.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEquipos);
				msj = "El Equipo se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	/**
     * Searches for an Equipo by name.
     * @param n the name to search for
     * @return the Equipo with the specified name, or null if not found
     */
	
	@Override
	public EquipoDTO buscarNombre(String n) {

		for (int i = 0; i < listaEquipos.size(); i++) {
			if (listaEquipos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				return listaEquipos.get(i);
			}
		}
		return null;
	}
	
	/**
     * Searches for Equipos by country.
     * @param p the country to search for
     * @return a list of Equipos from the specified country
     */
	
	@Override
	public ArrayList<EquipoDTO> buscarPais(String p) {
		ArrayList<EquipoDTO> equipos = null;

		for (int i = 0; i < listaEquipos.size(); i++) {
			if (listaEquipos.get(i).getPais().toLowerCase().equals(p.toLowerCase())) {
				equipos.add(listaEquipos.get(i));
			}
		}
		return equipos;
	}
	
	 /**
     * Deletes an Equipo by name.
     * @param n the name of the Equipo to delete
     * @return a message indicating the result of the operation
     */
	
	@Override
	public String eliminarPorNombre(String n) {
		String msj = "No existe un Equipo con esa cédula";

		for (int i = 0; i < listaEquipos.size(); i++) {
			if (listaEquipos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				listaEquipos.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEquipos);
				msj = "El Equipo se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}
	
	 /**
     * Returns a list of all Equipos.
     * @return a list of all Equipos
     */
	
	@Override
	public ArrayList<EquipoDTO> mostrarTodos() {
		ArrayList<EquipoDTO> listaMostrar = new ArrayList<>();
		listaEquipos.forEach(e -> {
			EquipoDTO equipoTemp = new EquipoDTO(e.getNombre(), e.getTiempoCarrera(), e.getPais());

			listaMostrar.add(equipoTemp);
		});

		return listaMostrar;
	}
}
