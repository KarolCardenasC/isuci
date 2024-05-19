package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

/**
 * The FileHandler class provides static methods for handling file operations such as reading and writing files,
 * reading and writing serialized objects, loading and saving properties files, and verifying the existence of a folder
 * for storing data.
 * @author Osorio.V
 * @version 15/05/2024
 */

public class FileHandler {

	private static File archivo;
	private static Scanner lectorArchivo;
	private static PrintWriter escritorArchivo;

	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	/**
     * Verifies the existence of a folder named "datos" for storing data. If the folder does not exist, it creates one.
     */
	
	public static void verificarFolderDatos() {
		archivo = new File("datos");
		if (archivo.mkdir()) {
			System.out.println("carpeta creada por primera vez en " + archivo.toURI());
		}
	}
	
	/**
     * Opens a file for writing serialized objects. If the file does not exist, it creates a new one.
     *
     * @param url  The URL of the file.
     * @param cont The object to be written to the file.
     */

	public static void abrirEscribirSerializable(String url, Object cont) {
		archivo = new File(url);

		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(cont);

			fos.close();
			oos.close();
		} catch (IOException e) {
			System.out.println("Problemas al abrir el archivo serializado(Escritura)");
		}

	}

	/**
     * Opens a file for reading serialized objects.
     *
     * @param url The URL of the file.
     * @return The deserialized object read from the file.
     */
	
	public static Object abrirLeerSerializado(String url) {
		Object contenido = null;

		archivo = new File(url);

		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			contenido = ois.readObject();

			fis.close();
			ois.close();

		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo serializado(Entrada)");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al obtener el contenido");
			e.printStackTrace();
		}

		return contenido;
	}

	/**
     * Opens a file for reading text content.
     *
     * @param url The URL of the file.
     * @return The content read from the file as a String.
     */
	
	public static String abrirLeerArchivo(String url) {

		String contenido = "";

		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lectorArchivo = new Scanner(archivo);

			while (lectorArchivo.hasNext()) {
				contenido += lectorArchivo.nextLine() + "\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		lectorArchivo.close();

		return contenido;
	}

	/**
     * Opens a file for writing text content.
     *
     * @param url  The URL of the file.
     * @param cont The content to be written to the file.
     */
	
	public static void abrirEscribirArchivo(String url, String cont) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritorArchivo = new PrintWriter(archivo);
			escritorArchivo.print(cont);

		} catch (IOException e) {
			e.printStackTrace();
		}

		escritorArchivo.close();

	}

	/**
     * Loads properties from a properties file.
     *
     * @param url The URL of the properties file.
     * @return A Properties object containing the loaded properties.
     */
	
	public static Properties cargarArchivoPropiedades(String url) {
		Properties prop = null;
		try {

			prop = new Properties();
			prop.load(new FileInputStream(url));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo de propiedades");
			e.printStackTrace();
		}
		return prop;
	}

	/**
     * Saves properties to a properties file.
     *
     * @param url  The URL of the properties file.
     * @param prop The Properties object containing the properties to be saved.
     */
	
	public static void guardarArchivoPropiedades(String url, Properties prop) {
		try {
			prop.store(new FileWriter(url), "Escribiendo datos de propiedades");
		} catch (IOException e) {
			System.out.println("Error al guardar el archivo propiedades");
			e.printStackTrace();
		}
	}

}
