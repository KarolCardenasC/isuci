package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.ClasicomanoDTO;

public class ClasicomanoDAO implements CRUDOperation<ClasicomanoDTO> {

	private ArrayList<ClasicomanoDTO> listaClasicomanos;
	private final String SERIALIZED_FILE_NAME = "datos/Clasicomano.isuci";

	public ClasicomanoDAO() {
		listaClasicomanos = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaClasicomanos = new ArrayList<>();
		} else {
			listaClasicomanos = (ArrayList<ClasicomanoDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaClasicomanos.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaClasicomanos.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(ClasicomanoDTO data) {
		listaClasicomanos.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaClasicomanos);

	}

	@Override
	public String actualizarPorCedula(long id, ClasicomanoDTO newData) {
		String msj = "No existe un Clasicomano con esa cédula";

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCedula() == id) {
				listaClasicomanos.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaClasicomanos);
				msj = "El Clasicomano se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<ClasicomanoDTO> buscarNombre(String n) {

		ArrayList<ClasicomanoDTO> clasicomanos = null;

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				clasicomanos.add(listaClasicomanos.get(i));
			}
		}
		return clasicomanos;
	}

	@Override
	public ClasicomanoDTO buscarCedula(long id) {

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCedula() == id) {
				return listaClasicomanos.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Clasicomano con esa cédula";

		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCedula() == id) {
				listaClasicomanos.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaClasicomanos);
				msj = "El Clasicomano se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<ClasicomanoDTO> mostrarTodos() {
		ArrayList<ClasicomanoDTO> listaMostrar = new ArrayList<>();
		listaClasicomanos.forEach(c -> {
			ClasicomanoDTO clasicomanoTemp = new ClasicomanoDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getIdentificador(), c.getAniosExperiencia(), c.getTiempoAcumuladoMin(),
					c.getEspecialidad(), c.getContextura(), c.getEquipo(), c.getNumeroClasicosganados());

			listaMostrar.add(clasicomanoTemp);
		});

		return listaMostrar;
	}

	@Override
	public ClasicomanoDTO verificarUsuario(String u, String c) {
		for (ClasicomanoDTO clasicomano : listaClasicomanos) {
			if(clasicomano.getUsuario().equals(u)) {
				if(clasicomano.getContrasena().equals(c)) {
					return clasicomano;
				}
			}
		}
		return null;
	}
	
	@Override
	public ClasicomanoDTO buscarGmail(String g) {
		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getCorreo().contains(g)) {
				return listaClasicomanos.get(i);

			}
		}
		return null;
	}
	
	public ClasicomanoDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaClasicomanos.size(); i++) {
			if (listaClasicomanos.get(i).getIdentificador() == iden) {
				return listaClasicomanos.get(i);

			}
		}
		return null;
	}
}
