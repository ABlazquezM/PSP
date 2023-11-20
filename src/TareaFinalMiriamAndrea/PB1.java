package TareaFinalMiriamAndrea;
import java.io.IOException;

public class PB1 {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		//Se crea una instancia de ProcessBuilder configurada para ejecutar el comando "NOTEPAD". Esto significa que cuando se inicia el programa, se abrirá el Bloc de notas.
		
		// ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR C:");
//		No se obtiene ninguna salida, porque la 
//		salida de nuestro programa se redirige a nuestro programa Java, no
//		a la pantalla
		
		
		try {
			Process p = pb.start();
			//Se intenta iniciar el proceso utilizando pb.start(). Esto ejecutará el comando configurado en ProcessBuilder. Si el proceso se inicia con éxito, se obtendrá una instancia de Process que puede usarse para interactuar con el proceso, aunque en este caso, no se hace nada con esta instancia.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
