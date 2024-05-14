package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.GregarioDTO;

public class GregarioDAO implements CRUDOperation<GregarioDTO> {

	private ArrayList<GregarioDTO> listaGregarios;
	private final String SERIALIZED_FILE_NAME = "datos/Gregario.isuci";

	public GregarioDAO() {
		listaGregarios = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaGregarios = new ArrayList<>();
		} else {
			listaGregarios = (ArrayList<GregarioDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaGregarios.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaGregarios.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(GregarioDTO data) {
		listaGregarios.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaGregarios);

	}

	@Override
	public String actualizarPorCedula(long id, GregarioDTO newData) {
		String msj = "No existe un Gregario con esa cédula";

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCedula() == id) {
				listaGregarios.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaGregarios);
				msj = "El Gregario se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<GregarioDTO> buscarNombre(String n) {

		ArrayList<GregarioDTO> gregarios = null;

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				gregarios.add(listaGregarios.get(i));
			}
		}
		return gregarios;
	}

	@Override
	public GregarioDTO buscarCedula(long id) {

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCedula() == id) {
				return listaGregarios.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Gregario con esa cédula";

		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCedula() == id) {
				listaGregarios.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaGregarios);
				msj = "El Gregario se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<GregarioDTO> mostrarTodos() {
		ArrayList<GregarioDTO> listaMostrar = new ArrayList<>();
		listaGregarios.forEach(c -> {
			GregarioDTO gregarioTemp = new GregarioDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(),
					c.getFuncionPeloton());

			listaMostrar.add(gregarioTemp);
		});

		return listaMostrar;
	}
	
	@Override
	public GregarioDTO verificarUsuario(String u, String c) {
		for (GregarioDTO gregario : listaGregarios) {
			if(gregario.getUsuario().equals(u)) {
				if(gregario.getContrasena().equals(c)) {
					return gregario;
				}
			}
		}
		return null;
	}
	
	@Override
	public GregarioDTO buscarGmail(String g) {
		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getCorreo().contains(g)) {
				return listaGregarios.get(i);

			}
		}
		return null;
	}
	
	public GregarioDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaGregarios.size(); i++) {
			if (listaGregarios.get(i).getIdentificador() == iden) {
				return listaGregarios.get(i);

			}
		}
		return null;
	}

}