package co.edu.unbosque.view;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The Consola class provides methods for reading different types of data from
 * the console and displaying messages both in the console and in pop-up
 * windows. It uses the Scanner class for console data input and JOptionPane for
 * pop-up windows.
 * 
 * @author Osorio.V
 * @version 26/04/2024
 */
public class Consola {

	private Scanner sc;

	/**
	 * Consola class constructor. Initializes the Scanner object to read from
	 * standard input.
	 */

	public Consola() {
		sc = new Scanner(System.in);
	}

	/**
	 * Reads and discards the next line of the standard input.
	 */

	public void burnLine() {
		sc.nextLine();
	}

	/**
	 * Reads a complete line of standard input.
	 * 
	 * @return the line read.
	 */

	public String readLine() {
		return sc.nextLine();
	}

	/**
	 * Reads the next word from the standard input.
	 * 
	 * @return the word read.
	 */

	public String readWord() {
		return sc.next();
	}

	/**
	 * Reads the next integer from the standard input.
	 * 
	 * @return the integer read.
	 */

	public int readInt() {
		return sc.nextInt();
	}

	/**
	 * Reads the next long from the standard input.
	 * 
	 * @return the long read.
	 */

	public long readLong() {
		return sc.nextLong();
	}

	/**
	 * Reads the next float from the standard input.
	 * 
	 * @return the float read.
	 */

	public float readFloat() {
		return sc.nextFloat();
	}

	/**
	 * Reads the next double from the standard input.
	 * 
	 * @return the double read.
	 */

	public double readDouble() {
		return sc.nextDouble();
	}

	/**
	 * Reads the next character from the standard input.
	 * 
	 * @return the character read.
	 */

	public char readChar() {
		return sc.nextLine().charAt(0);
	}

	/**
	 * Reads a line of standard input and determines whether it contains "yes"
	 * (regardless of case).
	 * 
	 * @return true if the entry contains "yes", otherwise false
	 */

	public boolean readBoolean() {

		String input = sc.nextLine();
		if (input.toLowerCase().contains("si")) {
			return true;
		}
		return false;
	}

	/**
	 * Reads a line of standard input and determines whether it contains "si"
	 * (regardless of case).
	 * 
	 * @return true if the input contains "si", otherwise false.
	 * 
	 *         public void printNewLine(String text) { System.out.println(text); }
	 * 
	 *         /** Prints a text followed by a new line in the console.
	 * 
	 * @param text the text to print.
	 */

	public void printSameLine(String text) {
		System.out.print(text);
	}

	/**
	 * Prints a text on the same line in the console.
	 * 
	 * @param text the text to print.
	 */

	public void imprimirTextoVE(String cadena) {
		JOptionPane.showMessageDialog(null, cadena);
	}

	/**
	 * Displays a confirmation pop-up window with "Yes" and "No" options.
	 * 
	 * @param cadena the message in the confirmation window.
	 * @return an integer indicating the selected option (0 for "Yes", 1 for "No").
	 */

	public int confirmarTextoVE(String cadena) {
		return JOptionPane.showConfirmDialog(null, cadena, "CONFIRMACION", JOptionPane.YES_NO_OPTION);
	}

}
