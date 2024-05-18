package co.edu.unbosque.controller;

/**
 * The AplMain class serves as the entry point for the application. It
 * initializes the application by creating an instance of the Controller class.
 * 
 * <p>This class provides the main method which is the starting point of the application. 
 * It creates a new instance of the Controller class to initialize and start the application.</p>
 * 
 * <p>Any command line arguments passed to the application are ignored.</p>
 * 
 * @author Osorio.V
 * @version 28/04/2024
 */

public class AplMain {

	/**
	 * The main method which serves as the entry point of the application. It
	 * creates a new instance of the Controller class to start the application.
	 *
	 * @param args command line arguments
	 */

	public static void main(String[] args) {
		new Controller();
	}
}