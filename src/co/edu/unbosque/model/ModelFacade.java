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

	public CiclistaDAO getCiclistaDAO() {
		return ciclistaDAO;
	}

	public void setCiclistaDAO(CiclistaDAO ciclistaDAO) {
		this.ciclistaDAO = ciclistaDAO;
	}

	public ClasicomanoDAO getClasicomanoDAO() {
		return clasicomanoDAO;
	}

	public void setClasicomanoDAO(ClasicomanoDAO clasicomanoDAO) {
		this.clasicomanoDAO = clasicomanoDAO;
	}

	public ContrarrelojeroDAO getContrarrelojeroDAO() {
		return contrarrelojeroDAO;
	}

	public void setContrarrelojeroDAO(ContrarrelojeroDAO contrarrelojeroDAO) {
		this.contrarrelojeroDAO = contrarrelojeroDAO;
	}

	public DirectorDeportivoDAO getDirectorDeportivoDAO() {
		return directorDeportivoDAO;
	}

	public void setDirectorDeportivoDAO(DirectorDeportivoDAO directorDeportivoDAO) {
		this.directorDeportivoDAO = directorDeportivoDAO;
	}

	public EquipoDAO getEquipoDAO() {
		return equipoDAO;
	}

	public void setEquipoDAO(EquipoDAO equipoDAO) {
		this.equipoDAO = equipoDAO;
	}

	public EscaladorDAO getEscaladorDAO() {
		return escaladorDAO;
	}

	public void setEscaladorDAO(EscaladorDAO escaladorDAO) {
		this.escaladorDAO = escaladorDAO;
	}

	public GregarioDAO getGregarioDAO() {
		return gregarioDAO;
	}

	public void setGregarioDAO(GregarioDAO gregarioDAO) {
		this.gregarioDAO = gregarioDAO;
	}

	public MasajistaDAO getMasajistaDAO() {
		return masajistaDAO;
	}

	public void setMasajistaDAO(MasajistaDAO masajistaDAO) {
		this.masajistaDAO = masajistaDAO;
	}

	public RodadorDAO getRodadorDAO() {
		return rodadorDAO;
	}

	public void setRodadorDAO(RodadorDAO rodadorDAO) {
		this.rodadorDAO = rodadorDAO;
	}

	public SprinterDAO getSprinterDAO() {
		return sprinterDAO;
	}

	public void setSprinterDAO(SprinterDAO sprinterDAO) {
		this.sprinterDAO = sprinterDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
