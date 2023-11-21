package TareaFinalMiriamAndrea;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GestionURL {

	List<String> listaUrlsVisitadas = new ArrayList<>();
	File archivoUrl = new File("D:\\urls.txt");

	// Creamos un método para cargar las URL del archivo y las agregamos a
	// listaUrlsVisitadas
	public void cargarUrlsDesdeArchivo() {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUrl))) {
			String linea;

			// Leemos cada línea del archivo
			while ((linea = br.readLine()) != null) {

				// Agregamos la URL a la lista
				listaUrlsVisitadas.add(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Cremos un método para abrir el navegador con la URL que le damos
	public void abrirNavegadorConUrl(String url) {
		try {

			// Verificamos si la URL ya esta en la lista
			if (!listaUrlsVisitadas.contains(url)) {

				// Si no está la agragamos
				listaUrlsVisitadas.add(url);
			}

			// Abrirmos el navegador con la URL
			Desktop.getDesktop().browse(new URI(url));

		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}

	// Creams un método para agragar la URL al fichero que hemos creado
	public void guardarUrlsEnArchivo() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUrl, true))) {

			// Recorremos la lista de URL
			for (String url : listaUrlsVisitadas) {

				// Verificarmos si la URL no esta en el archivo antes de escribirla
				if (!contieneUrl(url, archivoUrl)) {

					// Escribimos la URL y agregarmos una nueva línea
					bw.write(url);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Creamos un método para verificar si la URL ya está en el fichero
	private boolean contieneUrl(String url, File archivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			// Leemos las líneas de fichero
			while ((linea = br.readLine()) != null) {

				// Verificar si la UR es igual a la nueva
				if (linea.trim().equals(url.trim())) {
					return true; // La URL ya está en el fichero
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false; // La URL no está en el fichero
	}

}
