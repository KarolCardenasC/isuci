package co.edu.unbosque.util.exception;

public class BlankFieldException extends Exception {

	public BlankFieldException(String campo) {
		super("El campo " + campo + " no puede estar vacio");
	}

}
