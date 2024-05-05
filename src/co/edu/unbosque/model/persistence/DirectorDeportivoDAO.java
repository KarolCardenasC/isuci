package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.DirectorDeportivoDTO;

public class DirectorDeportivoDAO implements CRUDOperation<DirectorDeportivoDTO> {

	private ArrayList<DirectorDeportivoDTO> listaDirectorDeportivos;
	private final String SERIALIZED_FILE_NAME = "datos/DirectorDeportivo.isuci";

	public DirectorDeportivoDAO() {
		listaDirectorDeportivos = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaDirectorDeportivos = new ArrayList<>();
		} else {
			listaDirectorDeportivos = (ArrayList<DirectorDeportivoDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaDirectorDeportivos.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaDirectorDeportivos.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(DirectorDeportivoDTO data) {
		listaDirectorDeportivos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectorDeportivos);

	}

	@Override
	public String actualizarPorCedula(long id, DirectorDeportivoDTO newData) {
		String msj = "No existe un Director Deportivo con esa cédula";

		for (int i = 0; i < listaDirectorDeportivos.size(); i++) {
			if (listaDirectorDeportivos.get(i).getCedula() == id) {
				listaDirectorDeportivos.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectorDeportivos);
				msj = "El Director Deportivo se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<DirectorDeportivoDTO> buscarNombre(String n) {

		ArrayList<DirectorDeportivoDTO> DirectorDeportivos = null;

		for (int i = 0; i < listaDirectorDeportivos.size(); i++) {
			if (listaDirectorDeportivos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				DirectorDeportivos.add(listaDirectorDeportivos.get(i));
			}
		}
		return DirectorDeportivos;
	}

	@Override
	public DirectorDeportivoDTO buscarCedula(long id) {

		for (int i = 0; i < listaDirectorDeportivos.size(); i++) {
			if (listaDirectorDeportivos.get(i).getCedula() == id) {
				return listaDirectorDeportivos.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Director Deportivo con esa cédula";

		for (int i = 0; i < listaDirectorDeportivos.size(); i++) {
			if (listaDirectorDeportivos.get(i).getCedula() == id) {
				listaDirectorDeportivos.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectorDeportivos);
				msj = "El Director Deportivo se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<DirectorDeportivoDTO> mostrarTodos() {
		ArrayList<DirectorDeportivoDTO> listaMostrar = new ArrayList<>();
		listaDirectorDeportivos.forEach(c -> {
			DirectorDeportivoDTO DirectorDeportivoTemp = new DirectorDeportivoDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getNacionalidad());

			listaMostrar.add(DirectorDeportivoTemp);
		});

		return listaMostrar;
	}

}
