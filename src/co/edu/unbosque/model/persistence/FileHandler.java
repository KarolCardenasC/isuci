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

public class FileHandler {

	// =================== A PARTIR DE AQUI SON DE TEXTO ==================
	private static File archivo;
	private static Scanner lectorArchivo;
	private static PrintWriter escritorArchivo;

	// =================== A PARTIR DE AQUI SON DE SERIALIZABLE ==================
	private static FileInputStream fis; // Ir a buscar el archivo
	private static ObjectInputStream ois; // Lee un objeto completo encontrado en un archivo por fis
	private static FileOutputStream fos; // Va y busca el archivo
	private static ObjectOutputStream oos; // Escribe en el archivo encontrado por fos

	public static void verificarFolderDatos() {
		archivo = new File("datos");
		if (archivo.mkdir()) {
			System.out.println("carpeta creada por primera vez en " + archivo.toURI()); // Verificar si la carpeta
																						// existe
		}
	}

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
	//Valores claves a la derecha
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
		public static void guardarArchivoPropiedades(String url, Properties prop) {
			try {
				prop.store(new FileWriter(url), "Escribiendo datos de propiedades");
			} catch (IOException e) {
				System.out.println("Error al guardar el archivo propiedades");
				e.printStackTrace();
			}
		}
	
}

