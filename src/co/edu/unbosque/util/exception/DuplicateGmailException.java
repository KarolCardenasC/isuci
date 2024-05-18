package co.edu.unbosque.util.exception;

/**
 * Exception thrown when a duplicate Gmail address is encountered.
 * 
 * @author Osorio.V
 * @version 30/04/2024
 */

public class DuplicateGmailException extends Exception {
	
	/**
     * Constructs a new DuplicateGmailException with a default detail message.
     */
	
	public DuplicateGmailException() {
		super("Este Gmail ya está en uso");
	}

}
