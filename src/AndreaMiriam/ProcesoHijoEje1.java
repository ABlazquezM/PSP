package AndreaMiriam;

import java.util.Scanner;

public class ProcesoHijoEje1 {

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);
		String cadena = lector.nextLine();

		while (cadena != null) {
			if (!cadena.equalsIgnoreCase("fin")) {
			// Generamos un número aleatorio entre 0 y 10
			int aleatorios = (int) (Math.random() * (10)) + 0;

			// Imprimimos el número aleatorio
			System.out.println(aleatorios);

			// Leemos la siguiente cadena de texto
			cadena = lector.nextLine();
		}
			else{
				System.out.println("Proceso finalizado");}
			}

	}

}
