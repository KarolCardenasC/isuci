package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import co.edu.unbosque.model.DirectorDeportivoDTO;

public class DirectorDeportivoDAO implements CRUDOperation<DirectorDeportivoDTO> {

	private ArrayList<DirectorDeportivoDTO> listaDirectoresDeportivos;
	private final String SERIALIZED_FILE_NAME = "datos/DirectorDeportivo.isuci";

	public DirectorDeportivoDAO() {
		listaDirectoresDeportivos = new ArrayList<>();
		leerArchivoSerializado();
	}

	@SuppressWarnings("unchecked")
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaDirectoresDeportivos = new ArrayList<>();
		} else {
			listaDirectoresDeportivos = (ArrayList<DirectorDeportivoDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaDirectoresDeportivos.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaDirectoresDeportivos.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(DirectorDeportivoDTO data) {
		listaDirectoresDeportivos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectoresDeportivos);

	}

	@Override
	public String actualizarPorCedula(long id, DirectorDeportivoDTO newData) {
		String msj = "No existe un Director Deportivo con esa cédula";

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCedula() == id) {
				listaDirectoresDeportivos.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectoresDeportivos);
				msj = "El Director Deportivo se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<DirectorDeportivoDTO> buscarNombre(String n) {

		ArrayList<DirectorDeportivoDTO> directoresDeportivos = null;

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				directoresDeportivos.add(listaDirectoresDeportivos.get(i));
			}
		}
		return directoresDeportivos;
	}

	@Override
	public DirectorDeportivoDTO buscarCedula(long id) {

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCedula() == id) {
				return listaDirectoresDeportivos.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Director Deportivo con esa cédula";

		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCedula() == id) {
				listaDirectoresDeportivos.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaDirectoresDeportivos);
				msj = "El Director Deportivo se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<DirectorDeportivoDTO> mostrarTodos() {
		ArrayList<DirectorDeportivoDTO> listaMostrar = new ArrayList<>();
		listaDirectoresDeportivos.forEach(c -> {
			DirectorDeportivoDTO directorDeportivoTemp = new DirectorDeportivoDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getNacionalidad(),c.getEquipo());

			listaMostrar.add(directorDeportivoTemp);
		});

		return listaMostrar;
	}
	
	@Override
	public DirectorDeportivoDTO verificarUsuario(String u, String c) {
		for (DirectorDeportivoDTO directorDeportivo : listaDirectoresDeportivos) {
			if(directorDeportivo.getUsuario().equals(u)) {
				if(directorDeportivo.getContrasena().equals(c)) {
					return directorDeportivo;
				}
			}
		}
		return null;
	}
	
	@Override
	public DirectorDeportivoDTO buscarGmail(String g) {
		for (int i = 0; i < listaDirectoresDeportivos.size(); i++) {
			if (listaDirectoresDeportivos.get(i).getCorreo().equals(g)) {
				return listaDirectoresDeportivos.get(i);

			}
		}
		return null;
	}

}