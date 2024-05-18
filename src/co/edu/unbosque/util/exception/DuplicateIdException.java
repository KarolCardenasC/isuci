package co.edu.unbosque.util.exception;

/**
 * Exception thrown when a duplicate identification number is encountered.
 * @author Osorio.V
 * @version 30/04/2024
 */

public class DuplicateIdException extends Exception {
	
	/**
     * Constructs a new DuplicateIdentificationException with a default detail message.
     */
	
	public DuplicateIdException() {
		super("El numero de cedula ya existe");
	}

}
