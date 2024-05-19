package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.EquipoDTO;

public class EquipoDAO implements CRUDEquipo<EquipoDTO> {

	private ArrayList<EquipoDTO> listaEquipos;
	private final String SERIALIZED_FILE_NAME = "datos/Equipos.isuci";

	public EquipoDAO() {
		listaEquipos = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaEquipos = new ArrayList<>();
		} else {
			listaEquipos = (ArrayList<EquipoDTO>) contenido;
		}

	}

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

	@Override
	public void crear(EquipoDTO data) {
		listaEquipos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEquipos);
	}

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

	@Override
	public EquipoDTO buscarNombre(String n) {

		for (int i = 0; i < listaEquipos.size(); i++) {
			if (listaEquipos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				return listaEquipos.get(i);
			}
		}
		return null;
	}

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
