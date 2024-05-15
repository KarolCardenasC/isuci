package co.edu.unbosque.util.exception;

public class DuplicateGmailException extends Exception {
	
	public DuplicateGmailException() {
		super("Este Gmail ya está en uso");
	}

}
