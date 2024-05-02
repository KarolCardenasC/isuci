/**
 * The CRUDOperation interface defines the basic CRUD (Create, Read, Update, Delete) operations for managing data. Create search operation by identification and name.
 * @param <E> the type of data on which the CRUD operations will be performed
 * 
 * @author  
 * @version  
 */

package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation<E> {

	/**
	 * Creates a new entry for the provided data.
	 * 
	 * @param data the data to be created
	 */

	public void crear(E data);

	public String actualizarPorIdentificador(int id, E newData);

	public ArrayList<E> buscarNombre(String n);

	public E buscarIdentificador(int id);

	public String eliminarPorIdentificador(int id);

	public ArrayList<E> mostrarTodos();

}
