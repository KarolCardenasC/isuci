package co.edu.unbosque.util.exception;

/**
 * Exception thrown when a required field is found to be blank.
 *
 * @author Osorio.V
 * @version 30/04/2024
 */

public class BlankFieldException extends Exception {

	 /**
     * Constructs a new BlankFieldException with a specified detail message.
     * 
     * @param campo the name of the field that is blank
     */

	public BlankFieldException(String campo) {
		super("El campo " + campo + " no puede estar vacio");
	}

}
