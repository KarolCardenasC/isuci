package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.edu.unbosque.model.CiclistaDTO;
/** 
 *  The CiclistaDAO class implements CRUD operations for the CiclistaDTO class.
 * @author Moreno.JP
 * @version 12/05/2024
 */
public class CiclistaDAO implements CRUDOperation<CiclistaDTO> {
	/**
	 * The CiclistaDAO class implements CRUD operations for the CiclistaDTO class.
	 */
	private ArrayList<CiclistaDTO> listaCiclistas;
	private static ArrayList<CiclistaDTO> generalCiclista;
	private static ArrayList<CiclistaDTO> filtrarCiclistas;
	private final String SERIALIZED_FILE_NAME = "datos/Ciclista.isuci";
	/**
     * Constructor for the CiclistaDAO class. Initializes the cyclist lists and reads the serialized file.
     */
	public CiclistaDAO() {
		listaCiclistas = new ArrayList<>();
		generalCiclista = new ArrayList<>();
		filtrarCiclistas = new ArrayList<>();
		leerArchivoSerializado();
	}
	/**
     * Reads the serialized file and initializes the cyclist list.
     */
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);

		if (contenido == null) {
			listaCiclistas = new ArrayList<>();
		} else {
			listaCiclistas = (ArrayList<CiclistaDTO>) contenido;
		}

	}
	/**
     * Checks if the index is valid for the cyclist list.
     * @param index the index to check
     * @return a message indicating the validity of the index
     */
	public String checkIndex(int index) {
		if (index < 0) {
			return "La posición no puede tomar valores negativos";
		}
		if (index >= listaCiclistas.size()) {
			return "La posición no puede ser mayor al tamaño de la lista, tamaño actual: " + listaCiclistas.size()
					+ " datos";
		}
		return "g";
	}
	/**
     * Adds a new cyclist to the list and serializes the list.
     * @param data the cyclist to add
     */
	@Override
	public void crear(CiclistaDTO data) {
		listaCiclistas.add(data);
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaCiclistas);

	}
	 /**
     * Updates the cyclist with the specified ID.
     * @param id the ID of the cyclist to update
     * @param newData the new data for the cyclist
     * @return a message indicating the result of the operation
     */
	@Override
	public String actualizarPorCedula(long id, CiclistaDTO newData) {
		String msj = "No existe un Ciclista con esa cédula";

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getCedula() == id) {
				listaCiclistas.set(i, newData);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaCiclistas);
				msj = "El Ciclista se ha actualizado con exito";
				break;
			}
		}

		return msj;
	}
	 /**
     * Searches for cyclists by name.
     * @param n the name to search for
     * @return a list of cyclists with the specified name
     */
	@Override
	public ArrayList<CiclistaDTO> buscarNombre(String n) {

		ArrayList<CiclistaDTO> ciclistas = null;

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getNombre().toLowerCase().equals(n.toLowerCase())) {
				ciclistas.add(listaCiclistas.get(i));
			}
		}
		return ciclistas;
	}
	/**
     * Searches for a cyclist by ID.
     * @param id the ID to search for
     * @return the cyclist with the specified ID, or null if not found
     */
	@Override
	public CiclistaDTO buscarCedula(long id) {

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getCedula() == id) {
				return listaCiclistas.get(i);

			}
		}
		return null;
	}
	/**
     * Deletes a cyclist by ID.
     * @param id the ID of the cyclist to delete
     * @return a message indicating the result of the operation
     */
	@Override
	public String eliminarPorCedula(long id) {
		String msj = "No existe un Ciclista con esa cédula";

		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getCedula() == id) {
				listaCiclistas.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listaCiclistas);
				msj = "El Ciclista se ha eliminado con éxito";
				break;
			}
		}

		return msj;
	}
	 /**
     * Returns a list of all cyclists.
     * @return a list of all cyclists
     */
	@Override
	public ArrayList<CiclistaDTO> mostrarTodos() {
		ArrayList<CiclistaDTO> listaMostrar = new ArrayList<>();
		listaCiclistas.forEach(c -> {
			CiclistaDTO ciclistaTemp = new CiclistaDTO(c.getImagen(), c.getNombre(), c.getCedula(), c.getCorreo(),
					c.getUsuario(), c.getId(), c.getContrasena(), c.getGenero(), c.getIdentificador(),
					c.getAniosExperiencia(), c.getTiempoAcumuladoMin(), c.getEspecialidad(), c.getContextura(),
					c.getEquipo());

			listaMostrar.add(ciclistaTemp);
		});

		return listaMostrar;
	}
	 /**
     * Verifies the user's credentials.
     * @param u the username
     * @param c the password
     * @return the cyclist with the specified credentials, or null if not found
     */
	@Override
	public CiclistaDTO verificarUsuario(String u, String c) {
		for (CiclistaDTO ciclista : listaCiclistas) {
			if (ciclista.getUsuario().equals(u)) {
				if (ciclista.getContrasena().equals(c)) {
					return ciclista;
				}
			}
		}
		return null;
	}
	/**
     * Searches for a cyclist by email.
     * @param g the email to search for
     * @return the cyclist with the specified email, or null if not found
     */
	@Override
	public CiclistaDTO buscarGmail(String g) {
		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getCorreo().equals(g)) {
				return listaCiclistas.get(i);

			}
		}
		return null;
	}
	 /**
     * Searches for a cyclist by identifier.
     * @param iden the identifier to search for
     * @return the cyclist with the specified identifier, or null if not found
     */
	public CiclistaDTO buscarIdentificador(int iden) {
		for (int i = 0; i < listaCiclistas.size(); i++) {
			if (listaCiclistas.get(i).getIdentificador() == iden) {
				return listaCiclistas.get(i);

			}
		}
		return null;
	}
	/**
     * Returns a list of cyclists based on their specialty and team.
     * @param especialidad the specialty to filter by
     * @param equipo the team to filter by
     * @return a filtered list of cyclists
     */
	public static ArrayList<CiclistaDTO> listaCiclistas(String especialidad,String equipo ) {
		switch (especialidad) {
		case "Clasicomano":
			obtenerClasicomano();
		break;
		case "Contrarrelojeroa":
			obtenerContrarrelojero();
			break;
		case "Escalador":
			obtenerEscalador();
			break;
		case "Gregario":
			obtenerGregario();
			break;
		case "Rodador":
			obtenerRodador();
			break;
		case "Sprinter":
			obtenerSprinter();
			break;
		case "Ninguna":
			obtenerSin();
		break;
		default:
			obtenerClasicomano();
			obtenerContrarrelojero();
			obtenerEscalador();
			obtenerGregario();
			obtenerRodador();
			obtenerSprinter();
			break;
			 	        
		}
		if (!equipo.equals("")) {
			filtrarCiclistas = new ArrayList<>();
			generalCiclista.forEach(c ->{
				if (c.getEquipo().equals(equipo)) {
					filtrarCiclistas.add(c);
				}
			});
			generalCiclista = filtrarCiclistas;
		}
		return generalCiclista;
	}
	/**
     * Obtains cyclists with the specialty "Sprinter".
     */
	private static void obtenerSprinter() {
		// TODO Auto-generated method stub
		SprinterDAO SprinterDAO = new SprinterDAO();
		SprinterDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}
	/**
     * Obtains cyclists with the specialty "Rodador".
     */
	private static void obtenerRodador() {
		// TODO Auto-generated method stub
		RodadorDAO RodadorDAO = new RodadorDAO();
		RodadorDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}
	/**
     * Obtains cyclists with the specialty "Gregario".
     */
	private static void obtenerGregario() {
		// TODO Auto-generated method stub
		GregarioDAO GregarioDAO = new GregarioDAO();
		GregarioDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}
	 /**
     * Obtains cyclists with the specialty "Escalador".
     */
	private static void obtenerEscalador() {
		// TODO Auto-generated method stub
		EscaladorDAO EscaladorDAO = new EscaladorDAO();
		EscaladorDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}
	 /**
     * Obtains cyclists with the specialty "Contrarrelojero".
     */
	private static void obtenerContrarrelojero() {
		// TODO Auto-generated method stub
		ContrarrelojeroDAO ContrarrelojeroDAO = new ContrarrelojeroDAO();
		ContrarrelojeroDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}
	/**
     * Obtains cyclists with the specialty "Clasicomano".
     */
	private static void obtenerClasicomano() {
		// TODO Auto-generated method stub
		ClasicomanoDAO clasicomanoDAO = new ClasicomanoDAO();
		clasicomanoDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}
	 /**
     * Obtains cyclists without a specified specialty.
     */
	private static void obtenerSin() {
		// TODO Auto-generated method stub
		CiclistaDAO CiclistaDAO = new CiclistaDAO();
		CiclistaDAO.mostrarTodos().forEach(p -> {
			Predicate<CiclistaDTO> byCiclis = skill -> (skill.getId() == p.getId());
			var result = generalCiclista.stream().filter(byCiclis).collect(Collectors.toList());
			if (result.size() == 0) {
				p.setRol("Ciclista");
				generalCiclista.add(p);
			}

		});
	}

}
