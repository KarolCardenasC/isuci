package co.edu.unbosque.util.exception;

public class DuplicateIdentificationException extends Exception {
	
	public DuplicateIdentificationException() {
		super("Este número de identificación ya está en uso");
	}

}
