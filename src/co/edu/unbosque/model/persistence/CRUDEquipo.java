package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;

public interface CRUDEquipo <E> {
	
	public void crear(E data);

	public String actualizarPorNombre(String n, E newData);

	public E buscarNombre(String n);

	public ArrayList<E> buscarPais(String p);

	public String eliminarPorNombre (String n);

	public ArrayList<E> mostrarTodos();
	
	// Ciclistas
	
	public void agregarCiclista(String equipo, CiclistaDTO data);

	public String actualizarCiclistaPorCedula(String equipo, long id, CiclistaDTO newData);

	public String eliminarCiclistaPorCedula (String equipo, long id);

	public ArrayList<CiclistaDTO> mostrarCiclistas(String equipo);

}
