package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.UsuarioDTO;

public class UsuarioDAO implements CRUDOperation<UsuarioDTO> {

	private ArrayList<UsuarioDTO> listaUsuarios;
	private static ArrayList<UsuarioDTO> listaTodos;
	private final String SERIALIZED_FILE_NAME = "datos/Usuario.isuci";

	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
		listaTodos = new ArrayList<>();
		
		leerArchivoSerializado();
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaUsuarios = new ArrayList<>();
		} else {
			listaUsuarios = (ArrayList<UsuarioDTO>) contenido;
		}

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaUsuarios.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaUsuarios.size()
					+ " datos";
		}
		return "g";
	}

	@Override
	public void crear(UsuarioDTO data) {
		listaUsuarios.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);

	}

	@Override
	public String actualizarPorCedula(long id, UsuarioDTO newData) {
		String msj = "No existe un Usuario con esa cédula";

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				listaUsuarios.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
				msj = "El Usuario se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<UsuarioDTO> buscarNombre(String n) {

		ArrayList<UsuarioDTO> usuarios = null;

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				usuarios.add(listaUsuarios.get(i));
			}
		}
		return usuarios;
	}

	@Override
	public UsuarioDTO buscarCedula(long id) {

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				return listaUsuarios.get(i);

			}
		}
		return null;
	}

	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Usuario con esa cédula";

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCedula() == id) {
				listaUsuarios.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
				msj = "El Usuario se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<UsuarioDTO> mostrarTodos() {
		CiclistaDAO ciclistas = new CiclistaDAO();
		listaTodos.addAll(ciclistas.listaCiclistas(""));
		obtenerMasajista();
		obtenerDirector();
		
		return listaTodos;
	}
	
	private void obtenerDirector() {
		
		DirectorDeportivoDAO DirectorDAO = new DirectorDeportivoDAO();
		DirectorDAO.mostrarTodos().forEach(p -> {
			Predicate<UsuarioDTO> byDirec = skill -> (skill.getId() == p.getId());
			var result = listaTodos.stream().filter(byDirec).collect(Collectors.toList());
			if (result.size() == 0) {
				listaTodos.add(p);
			}

		});
		
	}

	private void obtenerMasajista() {
		MasajistaDAO MasajistaDAO = new MasajistaDAO();
		MasajistaDAO.mostrarTodos().forEach(p -> {
			Predicate<UsuarioDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = listaTodos.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				listaTodos.add(p);
			}

		});
	}

	@Override
	public UsuarioDTO verificarUsuario(String u, String c) {
		for (UsuarioDTO usuario : listaUsuarios) {
			if(usuario.getUsuario().equals(u)) {
				if(usuario.getContrasena().equals(c)) {
					return usuario;
				}
			}
		}
		return null;
	}
	
	@Override
	public UsuarioDTO buscarGmail(String g) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getCorreo().contains(g)) {
				return listaUsuarios.get(i);

			}
		}
		return null;
	}
	

}
