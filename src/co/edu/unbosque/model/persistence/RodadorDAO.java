package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.RodadorDTO;
import co.edu.unbosque.model.RodadorDTO;

public class RodadorDAO implements CRUDOperation<RodadorDTO> {

	private ArrayList<RodadorDTO> listaRodadores;
	private final String SERIALIZED_FILE_NAME = "datos/Rodador.isuci";

	public RodadorDAO() {
		listaRodadores = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaRodadores = new ArrayList<>();
		} else {
			listaRodadores = (ArrayList<RodadorDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaRodadores.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaRodadores.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(RodadorDTO data) {
		listaRodadores.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaRodadores);

	}

	@Override
	public String actualizarPorCedula(long id, RodadorDTO newData) {
		String msj = "No existe un Rodador con esa cédula";

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCedula() == id) {
				listaRodadores.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaRodadores);
				msj = "El Rodador se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<RodadorDTO> buscarNombre(String n) {

		ArrayList<RodadorDTO> rodadores = null;

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				rodadores.add(listaRodadores.get(i));
			}
		}
		return rodadores;
	}

	@Override
	public RodadorDTO buscarCedula(long id) {

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getIdentificador() == id) {
				return listaRodadores.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Rodador con esa cédula";

		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCedula() == id) {
				listaRodadores.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaRodadores);
				msj = "El Rodador se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<RodadorDTO> mostrarTodos() {
		ArrayList<RodadorDTO> listaMostrar = new ArrayList<>();
		listaRodadores.forEach(c -> {
			RodadorDTO rodadorTemp = new RodadorDTO(c.getImagen(), c.getNombre(), c.getCedula(),
					c.getCorreo(), c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(),
					c.getVelocidadPromPedaleo());

			listaMostrar.add(rodadorTemp);
		});

		return listaMostrar;
	}
	
	@Override
	public RodadorDTO verificarUsuario(String u, String c) {
		for (RodadorDTO rodador : listaRodadores) {
			if(rodador.getUsuario().equals(u)) {
				if(rodador.getContrasena().equals(c)) {
					return rodador;
				}
			}
		}
		return null;
	}
	
	@Override
	public RodadorDTO buscarGmail(String g) {
		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getCorreo().contains(g)) {
				return listaRodadores.get(i);

			}
		}
		return null;
	}
	
	public RodadorDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaRodadores.size(); i++) {
			if (listaRodadores.get(i).getIdentificador() == iden) {
				return listaRodadores.get(i);

			}
		}
		return null;
	}

}