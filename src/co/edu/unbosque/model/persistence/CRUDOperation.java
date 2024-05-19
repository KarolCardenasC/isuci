/**
 * The CRUDOperation interface defines the basic CRUD (Create, Read, Update, Delete) operations for managing data. Create search operation by identification and name.
 * @param <E> the type of data on which the CRUD operations will be performed
 * 
 * @author  
 * @version  
 */

package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * This interface defines basic CRUD (Create, Read, Update, Delete) operations for a generic type E.
 * Implementations of this interface should provide methods for creating, updating, searching, and deleting data of type E.
 *
 * @author Moreno.JP
 * @version 15/05/2024
 * @param <E> the type of data to be handled by the CRUD operations
 */

public interface CRUDOperation<E> {

	/**
     * Creates a new entry with the provided data.
     *
     * @param data the data to be created
     */
	
	public void crear(E data);

	/**
     * Updates an existing entry with the provided new data, identified by the given ID.
     *
     * @param id     the ID of the entry to be updated
     * @param newData the new data to replace the existing entry
     * @return a message indicating the result of the update operation
     */
	
	public String actualizarPorCedula(long id, E newData);

	/**
     * Searches for entries with a matching name.
     *
     * @param n the name to search for
     * @return a list of entries with matching names
     */
	
	public ArrayList<E> buscarNombre(String n);

	  /**
     * Searches for an entry with the provided ID.
     *
     * @param id the ID to search for
     * @return the entry with the matching ID, if found; otherwise, null
     */
	
	public E buscarCedula(long id);
	
	/**
     * Searches for an entry with the provided Gmail address.
     *
     * @param g the Gmail address to search for
     * @return the entry with the matching Gmail address, if found; otherwise, null
     */
	
	public E buscarGmail(String g);

	 /**
     * Deletes an entry with the provided ID.
     *
     * @param id the ID of the entry to be deleted
     * @return a message indicating the result of the delete operation
     */
	
	public String eliminarPorCedula(long id);

	 /**
     * Retrieves all entries.
     *
     * @return a list containing all entries
     */
	
	public ArrayList<E> mostrarTodos();

	 /**
     * Verifies the existence of a user with the provided username and password.
     *
     * @param u the username to verify
     * @param c the password to verify
     * @return the user entry if the username and password match; otherwise, null
     */
	
	public E verificarUsuario(String u, String c);
}
