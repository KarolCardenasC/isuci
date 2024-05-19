package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.SprinterDTO;
import co.edu.unbosque.model.SprinterDTO;

public class SprinterDAO implements CRUDOperation<SprinterDTO> {

	private ArrayList<SprinterDTO> listaSprinters;
	private final String SERIALIZED_FILE_NAME = "datos/Sprinter.isuci";

	public SprinterDAO() {
		listaSprinters = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaSprinters = new ArrayList<>();
		} else {
			listaSprinters = (ArrayList<SprinterDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaSprinters.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaSprinters.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(SprinterDTO data) {
		listaSprinters.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaSprinters);

	}

	@Override
	public String actualizarPorCedula(long id, SprinterDTO newData) {
		String msj = "No existe un Sprinter con esa cédula";

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCedula() == id) {
				listaSprinters.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaSprinters);
				msj = "El Sprinter se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<SprinterDTO> buscarNombre(String n) {

		ArrayList<SprinterDTO> sprinters = null;

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				sprinters.add(listaSprinters.get(i));
			}
		}
		return sprinters;
	}

	@Override
	public SprinterDTO buscarCedula(long id) {

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCedula() == id) {
				return listaSprinters.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Sprinter con esa cédula";

		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCedula() == id) {
				listaSprinters.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaSprinters);
				msj = "El Sprinter se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<SprinterDTO> mostrarTodos() {
		ArrayList<SprinterDTO> listaMostrar = new ArrayList<>();
		listaSprinters.forEach(c -> {
			SprinterDTO sprinterTemp = new SprinterDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(), c.getEquipo(),
					c.getExplosionMetrosFinales(), c.getPotenciaPromVatios(), c.getVelocidadPromSprintKm());

			listaMostrar.add(sprinterTemp);
		});

		return listaMostrar;
	}
	
	@Override
	public SprinterDTO verificarUsuario(String u, String c) {
		for (SprinterDTO sprinter : listaSprinters) {
			if(sprinter.getUsuario().equals(u)) {
				if(sprinter.getContrasena().equals(c)) {
					return sprinter;
				}
			}
		}
		return null;
	}
	
	@Override
	public SprinterDTO buscarGmail(String g) {
		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getCorreo().contains(g)) {
				return listaSprinters.get(i);

			}
		}
		return null;
	}
	
	public SprinterDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaSprinters.size(); i++) {
			if (listaSprinters.get(i).getIdentificador() == iden) {
				return listaSprinters.get(i);

			}
		}
		return null;
	}

}