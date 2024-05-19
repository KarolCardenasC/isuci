package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.ContrarrelojeroDTO;

public class ContrarrelojeroDAO implements CRUDOperation<ContrarrelojeroDTO> {

	private ArrayList<ContrarrelojeroDTO> listaContrarrelojeros;
	private final String SERIALIZED_FILE_NAME = "datos/Contrarrelojero.isuci";

	public ContrarrelojeroDAO() {
		listaContrarrelojeros = new ArrayList<>();
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaContrarrelojeros = new ArrayList<>();
		} else {
			listaContrarrelojeros = (ArrayList<ContrarrelojeroDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaContrarrelojeros.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: "
					+ listaContrarrelojeros.size() + " datos";
		}
		return "g";
	}

	@Override
	public void crear(ContrarrelojeroDTO data) {
		listaContrarrelojeros.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaContrarrelojeros);

	}

	@Override
	public String actualizarPorCedula(long id, ContrarrelojeroDTO newData) {
		String msj = "No existe un Contrarrelojero con esa cédula";

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCedula() == id) {
				listaContrarrelojeros.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaContrarrelojeros);
				msj = "El Contrarrelojero se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<ContrarrelojeroDTO> buscarNombre(String n) {

		ArrayList<ContrarrelojeroDTO> contrarrelojeros = null;

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				contrarrelojeros.add(listaContrarrelojeros.get(i));
			}
		}
		return contrarrelojeros;
	}

	@Override
	public ContrarrelojeroDTO buscarCedula(long id) {

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCedula() == id) {
				return listaContrarrelojeros.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Contrarrelojero con esa cédula";

		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCedula() == id) {
				listaContrarrelojeros.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaContrarrelojeros);
				msj = "El Contrarrelojero se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<ContrarrelojeroDTO> mostrarTodos() {
		ArrayList<ContrarrelojeroDTO> listaMostrar = new ArrayList<>();
		listaContrarrelojeros.forEach(c -> {
			ContrarrelojeroDTO contrarrelojeroTemp = new ContrarrelojeroDTO(c.getImagen(), c.getNombre(), c.getCedula(),
					c.getCorreo(), c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(), c.getEquipo(),
					c.getVelocidadMaxima());

			listaMostrar.add(contrarrelojeroTemp);
		});

		return listaMostrar;
	}
	
	@Override
	public ContrarrelojeroDTO verificarUsuario(String u, String c) {
		for (ContrarrelojeroDTO contrarrelojero : listaContrarrelojeros) {
			if(contrarrelojero.getUsuario().equals(u)) {
				if(contrarrelojero.getContrasena().equals(c)) {
					return contrarrelojero;
				}
			}
		}
		return null;
	}
	
	@Override
	public ContrarrelojeroDTO buscarGmail(String g) {
		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getCorreo().contains(g)) {
				return listaContrarrelojeros.get(i);

			}
		}
		return null;
	}
	
	public ContrarrelojeroDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaContrarrelojeros.size(); i++) {
			if (listaContrarrelojeros.get(i).getIdentificador() == iden) {
				return listaContrarrelojeros.get(i);

			}
		}
		return null;
	}
	
}