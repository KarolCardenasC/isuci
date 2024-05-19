package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;

/**
 * The CRUDEquipo interface provides methods for performing CRUD operations
 * (Create, Read, Update, Delete) on objects of type E, representing equipment.
 * 
 * @author Moreno.JP
 * @version 15/05/2024
 * 
 * @param <E> the type of equipment objects
 */

public interface CRUDEquipo<E> {

	/**
	 * Creates a new equipment object.
	 *
	 * @param data the data of the equipment to be created
	 */

	public void crear(E data);

	/**
	 * Updates an equipment object based on its name.
	 *
	 * @param n       the name of the equipment to be updated
	 * @param newData the new data for the equipment
	 * @return a message indicating the result of the update operation
	 */

	public String actualizarPorNombre(String n, E newData);

	/**
	 * Searches for an equipment object by its name.
	 *
	 * @param n the name of the equipment to search for
	 * @return the equipment object with the specified name, or null if not found
	 */

	public E buscarNombre(String n);

	/**
	 * Searches for equipment objects by their country.
	 *
	 * @param p the country of the equipment to search for
	 * @return a list of equipment objects belonging to the specified country
	 */

	public ArrayList<E> buscarPais(String p);

	/**
	 * Deletes an equipment object based on its name.
	 *
	 * @param n the name of the equipment to be deleted
	 * @return a message indicating the result of the deletion operation
	 */

	public String eliminarPorNombre(String n);

	/**
	 * Retrieves all equipment objects.
	 *
	 * @return a list containing all equipment objects
	 */

	public ArrayList<E> mostrarTodos();

}
