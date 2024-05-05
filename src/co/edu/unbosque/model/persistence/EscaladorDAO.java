package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.EscaladorDTO;

public class EscaladorDAO implements CRUDOperation<EscaladorDTO> {

	private ArrayList<EscaladorDTO> listaEscaladores;
	private final String SERIALIZED_FILE_NAME = "datos/Escalador.isuci";

	public EscaladorDAO() {
		listaEscaladores = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaEscaladores = new ArrayList<>();
		} else {
			listaEscaladores = (ArrayList<EscaladorDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaEscaladores.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaEscaladores.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(EscaladorDTO data) {
		listaEscaladores.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEscaladores);

	}

	@Override
	public String actualizarPorCedula(long id, EscaladorDTO newData) {
		String msj = "No existe un Escalador con esa cédula";

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCedula() == id) {
				listaEscaladores.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEscaladores);
				msj = "El Escalador se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<EscaladorDTO> buscarNombre(String n) {

		ArrayList<EscaladorDTO> Escaladors = null;

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				Escaladors.add(listaEscaladores.get(i));
			}
		}
		return Escaladors;
	}

	@Override
	public EscaladorDTO buscarCedula(long id) {

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCedula() == id) {
				return listaEscaladores.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Escalador con esa cédula";

		for (int i = 0; i < listaEscaladores.size(); i++) {
			if (listaEscaladores.get(i).getCedula() == id) {
				listaEscaladores.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaEscaladores);
				msj = "El Escalador se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<EscaladorDTO> mostrarTodos() {
		ArrayList<EscaladorDTO> listaMostrar = new ArrayList<>();
		listaEscaladores.forEach(c -> {
			EscaladorDTO EscaladorTemp = new EscaladorDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(), c.getUsuario(), c.getId(),
					c.getContrasena(), c.getGenero(), c.getIdentificador(), c.getAniosExperiencia(), c.getTiempoAcumuladoMin(),
					c.getEspecialidad(), c.getContextura(), c.getAceleracionPromSubida(), c.getGradoRampaSoportada());

			listaMostrar.add(EscaladorTemp);
		});

		return listaMostrar;
	}

}