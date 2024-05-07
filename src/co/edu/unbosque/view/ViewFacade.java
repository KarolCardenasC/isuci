package co.edu.unbosque.view;

public class ViewFacade {

	private VentanaInicial vL;
	private VentanaUsuario vU;	
	private Consola con;
	
	public ViewFacade() {
		
		vL = new VentanaInicial();
		vU = new VentanaUsuario();		
		con = new Consola();
		
	}


	public VentanaInicial getvL() {
		return vL;
	}


	public void setvL(VentanaInicial vL) {
		this.vL = vL;
	}


	public VentanaUsuario getvU() {
		return vU;
	}


	public void setvU(VentanaUsuario vU) {
		this.vU = vU;
	}


	public Consola getCon() {
		return con;
	}


	public void setCon(Consola con) {
		this.con = con;
	}
	
	
}
