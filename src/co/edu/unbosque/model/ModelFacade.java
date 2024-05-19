package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CiclistaDAO;
import co.edu.unbosque.model.persistence.ClasicomanoDAO;
import co.edu.unbosque.model.persistence.ContrarrelojeroDAO;
import co.edu.unbosque.model.persistence.DirectorDeportivoDAO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.EscaladorDAO;
import co.edu.unbosque.model.persistence.GregarioDAO;
import co.edu.unbosque.model.persistence.MasajistaDAO;
import co.edu.unbosque.model.persistence.RodadorDAO;
import co.edu.unbosque.model.persistence.SprinterDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;

/**
 * The ModelFacade class acts as a facade to access the various DAO (Data Access Objects)
 * in the system. It provides methods to get and set instances of these DAOs,
 * facilitating the management and access to data for different entities.
 * 
 * @author Osorio.V
 * @version 10/05/2024
 */

public class ModelFacade {
	private CiclistaDAO ciclistaDAO;
	private ClasicomanoDAO clasicomanoDAO;
	private ContrarrelojeroDAO contrarrelojeroDAO;
	private DirectorDeportivoDAO directorDeportivoDAO;
	private EquipoDAO equipoDAO;
	private EscaladorDAO escaladorDAO;
	private GregarioDAO gregarioDAO;
	private MasajistaDAO masajistaDAO;
	private RodadorDAO rodadorDAO;
	private SprinterDAO sprinterDAO;
	private UsuarioDAO usuarioDAO;

	/**
     * Constructor of the ModelFacade class. Initializes instances of all DAOs.
     */
	
	public ModelFacade() {
		ciclistaDAO = new CiclistaDAO();
		clasicomanoDAO = new ClasicomanoDAO();
		contrarrelojeroDAO = new ContrarrelojeroDAO();
		directorDeportivoDAO = new DirectorDeportivoDAO();
		equipoDAO = new EquipoDAO();
		escaladorDAO = new EscaladorDAO();
		gregarioDAO = new GregarioDAO();
		masajistaDAO = new MasajistaDAO();
		rodadorDAO = new RodadorDAO();
		sprinterDAO = new SprinterDAO();
		usuarioDAO = new UsuarioDAO();
	}

	/**
     * Gets the instance of CiclistaDAO.
     * 
     * @return the instance of CiclistaDAO
     */
	
	public CiclistaDAO getCiclistaDAO() {
		return ciclistaDAO;
	}

	/**
     * Sets a new instance of CiclistaDAO.
     * 
     * @param ciclistaDAO the new instance of CiclistaDAO
     */
	
	public void setCiclistaDAO(CiclistaDAO ciclistaDAO) {
		this.ciclistaDAO = ciclistaDAO;
	}

	/**
     * Gets the instance of ClasicomanoDAO.
     * 
     * @return the instance of ClasicomanoDAO
     */
	
	public ClasicomanoDAO getClasicomanoDAO() {
		return clasicomanoDAO;
	}

	/**
     * Sets a new instance of ClasicomanoDAO.
     * 
     * @param clasicomanoDAO the new instance of ClasicomanoDAO
     */
	
	public void setClasicomanoDAO(ClasicomanoDAO clasicomanoDAO) {
		this.clasicomanoDAO = clasicomanoDAO;
	}

	/**
     * Gets the instance of ContrarrelojeroDAO.
     * 
     * @return the instance of ContrarrelojeroDAO
     */
	
	public ContrarrelojeroDAO getContrarrelojeroDAO() {
		return contrarrelojeroDAO;
	}

	/**
     * Sets a new instance of ContrarrelojeroDAO.
     * 
     * @param contrarrelojeroDAO the new instance of ContrarrelojeroDAO
     */
	
	public void setContrarrelojeroDAO(ContrarrelojeroDAO contrarrelojeroDAO) {
		this.contrarrelojeroDAO = contrarrelojeroDAO;
	}

	/**
	 * Gets the instance of DirectorDeportivoDAO.
	 * 
	 * @return the instance of DirectorDeportivoDAO
	 */

	public DirectorDeportivoDAO getDirectorDeportivoDAO() {
		return directorDeportivoDAO;
	}

	/**
	 * Sets a new instance of DirectorDeportivoDAO.
	 * 
	 * @param directorDeportivoDAO the new instance of DirectorDeportivoDAO
	 */

	public void setDirectorDeportivoDAO(DirectorDeportivoDAO directorDeportivoDAO) {
		this.directorDeportivoDAO = directorDeportivoDAO;
	}

	/**
	 * Gets the instance of EquipoDAO.
	 * 
	 * @return the instance of EquipoDAO
	 */

	public EquipoDAO getEquipoDAO() {
		return equipoDAO;
	}

	/**
	 * Sets a new instance of EquipoDAO.
	 * 
	 * @param equipoDAO the new instance of EquipoDAO
	 */

	public void setEquipoDAO(EquipoDAO equipoDAO) {
		this.equipoDAO = equipoDAO;
	}

	/**
	 * Gets the instance of EscaladorDAO.
	 * 
	 * @return the instance of EscaladorDAO
	 */

	public EscaladorDAO getEscaladorDAO() {
		return escaladorDAO;
	}

	/**
	 * Sets a new instance of EscaladorDAO.
	 * 
	 * @param escaladorDAO the new instance of EscaladorDAO
	 */

	public void setEscaladorDAO(EscaladorDAO escaladorDAO) {
		this.escaladorDAO = escaladorDAO;
	}

	/**
	 * Gets the instance of GregarioDAO.
	 * 
	 * @return the instance of GregarioDAO
	 */

	public GregarioDAO getGregarioDAO() {
		return gregarioDAO;
	}

	/**
	 * Sets a new instance of GregarioDAO.
	 * 
	 * @param gregarioDAO the new instance of GregarioDAO
	 */

	public void setGregarioDAO(GregarioDAO gregarioDAO) {
		this.gregarioDAO = gregarioDAO;
	}

	/**
	 * Gets the instance of MasajistaDAO.
	 * 
	 * @return the instance of MasajistaDAO
	 */

	public MasajistaDAO getMasajistaDAO() {
		return masajistaDAO;
	}

	/**
	 * Sets a new instance of MasajistaDAO.
	 * 
	 * @param masajistaDAO the new instance of MasajistaDAO
	 */

	public void setMasajistaDAO(MasajistaDAO masajistaDAO) {
		this.masajistaDAO = masajistaDAO;
	}

	/**
	 * Gets the instance of RodadorDAO.
	 * 
	 * @return the instance of RodadorDAO
	 */

	public RodadorDAO getRodadorDAO() {
		return rodadorDAO;
	}

	/**
	 * Sets a new instance of RodadorDAO.
	 * 
	 * @param rodadorDAO the new instance of RodadorDAO
	 */

	public void setRodadorDAO(RodadorDAO rodadorDAO) {
		this.rodadorDAO = rodadorDAO;
	}

	/**
	 * Gets the instance of SprinterDAO.
	 * 
	 * @return the instance of SprinterDAO
	 */

	public SprinterDAO getSprinterDAO() {
		return sprinterDAO;
	}

	/**
	 * Sets a new instance of SprinterDAO.
	 * 
	 * @param sprinterDAO the new instance of SprinterDAO
	 */

	public void setSprinterDAO(SprinterDAO sprinterDAO) {
		this.sprinterDAO = sprinterDAO;
	}

	/**
	 * Gets the instance of UsuarioDAO.
	 * 
	 * @return the instance of UsuarioDAO
	 */

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * Sets a new instance of UsuarioDAO.
	 * 
	 * @param usuarioDAO the new instance of UsuarioDAO
	 */

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
