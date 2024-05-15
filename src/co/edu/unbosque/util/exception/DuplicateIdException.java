package co.edu.unbosque.util.exception;

public class DuplicateIdException extends Exception {
	
	public DuplicateIdException() {
		super("El numero de cedula ya existe");
	}

}
