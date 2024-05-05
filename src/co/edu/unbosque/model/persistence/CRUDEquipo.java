package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDEquipo <E> {
	public void crear(E data);

	public String actualizarPorNombre(String n, E newData);

	public ArrayList<E> buscarNombre(String n);

	public E buscarPais(String p);

	public String eliminarPorNombre (String n);

	public ArrayList<E> mostrarTodos();

}
