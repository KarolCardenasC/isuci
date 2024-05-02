package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;

public class CiclistaDAO implements CRUDOperation<CiclistaDTO> {

	private ArrayList<CiclistaDTO> listaCiclistas;
	private final String SERIALIZED_FILE_NAME = "datos/Ciclista.isuci";

	public CiclistaDAO() {
		listaCiclistas = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaCiclistas = new ArrayList<>();
		} else {
			listaCiclistas = (ArrayList<CiclistaDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaCiclistas.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaCiclistas.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(CiclistaDTO data) {
		listaCiclistas.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaCiclistas);

	}

	@Override
	public String actualizarPorIdentificador(int id, CiclistaDTO newData) {
		String msj = "No existe un Ciclista con ese identificador";

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getIdentificador() == id) {
				listaCiclistas.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaCiclistas);
				msj = "El Ciclista se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<CiclistaDTO> buscarNombre(String n) {

		ArrayList<CiclistaDTO> ciclistas = null;

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				ciclistas.add(listaCiclistas.get(i));
			}
		}
		return ciclistas;
	}

	@Override
	public CiclistaDTO buscarIdentificador(int id) {

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getIdentificador() == id) {
				return listaCiclistas.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorIdentificador(int id) {
		String msj = "No existe un Ciclista con ese identificador";

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getIdentificador() == id) {
				listaCiclistas.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaCiclistas);
				msj = "El Ciclista se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<CiclistaDTO> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
