package co.edu.unbosque.view;

public class ViewFacade {

	private VentanaInicial vL;
	private Consola con;
	
	public ViewFacade() {
		
		vL = new VentanaInicial();
		con = new Consola();
		
	}


	public VentanaInicial getvL() {
		return vL;
	}


	public void setvL(VentanaInicial vL) {
		this.vL = vL;
	}


	public Consola getCon() {
		return con;
	}


	public void setCon(Consola con) {
		this.con = con;
	}
	
	
}
