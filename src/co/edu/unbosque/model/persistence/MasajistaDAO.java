package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.MasajistaDTO;

public class MasajistaDAO implements CRUDOperation<MasajistaDTO> {

	private ArrayList<MasajistaDTO> listaMasajistas;
	private final String SERIALIZED_FILE_NAME = "datos/Masajista.isuci";

	public MasajistaDAO() {
		listaMasajistas = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaMasajistas = new ArrayList<>();
		} else {
			listaMasajistas = (ArrayList<MasajistaDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaMasajistas.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaMasajistas.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(MasajistaDTO data) {
		listaMasajistas.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaMasajistas);

	}

	@Override
	public String actualizarPorCedula(long id, MasajistaDTO newData) {
		String msj = "No existe un Masajista con esa cédula";

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCedula() == id) {
				listaMasajistas.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaMasajistas);
				msj = "El Masajista se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<MasajistaDTO> buscarNombre(String n) {

		ArrayList<MasajistaDTO> masajistas = null;

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				masajistas.add(listaMasajistas.get(i));
			}
		}
		return masajistas;
	}

	@Override
	public MasajistaDTO buscarCedula(long id) {

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCedula() == id) {
				return listaMasajistas.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Masajista con esa cédula";

		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCedula() == id) {
				listaMasajistas.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaMasajistas);
				msj = "El Masajista se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<MasajistaDTO> mostrarTodos() {
		ArrayList<MasajistaDTO> listaMostrar = new ArrayList<>();
		listaMasajistas.forEach(c -> {
			MasajistaDTO masajistaTemp = new MasajistaDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getAniosExperiencia());

			listaMostrar.add(masajistaTemp);
		});

		return listaMostrar;
	}
	
	@Override
	public MasajistaDTO verificarUsuario(String u, String c) {
		for (MasajistaDTO masajista : listaMasajistas) {
			if(masajista.getUsuario().equals(u)) {
				if(masajista.getContrasena().equals(c)) {
					return masajista;
				}
			}
		}
		return null;
	}
	
	@Override
	public MasajistaDTO buscarGmail(String g) {
		for (int i = 0; i < listaMasajistas.size(); i++) {
			if (listaMasajistas.get(i).getCorreo().contains(g)) {
				return listaMasajistas.get(i);

			}
		}
		return null;
	}

}
