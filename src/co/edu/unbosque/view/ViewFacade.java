package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

/**
 * The ViewFacade class is a facade for managing different views in the
 * application. It encapsulates the interaction with the VentanaInicial,
 * VentanaUsuario, and Consola classes, providing a simplified interface for
 * controlling these views.
 * 
 * @author Osorio.V
 * @version 26/04/2024
 * 
 */

public class ViewFacade {

	private VentanaInicial vL;
	private VentanaUsuario vU;
	private Consola con;

	/**
	 * Constructs a new ViewFacade and initializes the VentanaInicial,
	 * VentanaUsuario, and Consola views.
	 */

	public ViewFacade() {

		vL = new VentanaInicial();
		vU = new VentanaUsuario();
		con = new Consola();
	}

	/**
	 * Returns the VentanaInicial instance.
	 *
	 * @return the VentanaInicial instance
	 */

	public VentanaInicial getvL() {
		return vL;
	}

	/**
	 * Sets the VentanaInicial instance.
	 *
	 * @param vL the VentanaInicial instance to set
	 */

	public void setvL(VentanaInicial vL) {
		this.vL = vL;
	}

	/**
	 * Returns the VentanaUsuario instance.
	 *
	 * @return the VentanaUsuario instance
	 */

	public VentanaUsuario getvU() {
		return vU;
	}

	/**
	 * Sets the VentanaUsuario instance.
	 *
	 * @param vU the VentanaUsuario instance to set
	 */

	public void setvU(VentanaUsuario vU) {
		this.vU = vU;
	}

	/**
	 * Returns the Consola instance.
	 *
	 * @return the Consola instance
	 */

	public Consola getCon() {
		return con;
	}

	/**
	 * Sets the Consola instance.
	 *
	 * @param con the Consola instance to set
	 */

	public void setCon(Consola con) {
		this.con = con;
	}

}
