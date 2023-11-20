package AndreaMiriam2;

import java.util.Scanner;

public class ProcesoHijoEje2 {

	public static boolean esPalindrome(String str) {
		// Eliminamos los espacios en blanco de la cadena
		str = str.replaceAll(" ", "");

		// Convertimos la cadena a minúsculas
		str = str.toLowerCase();

		// Invertirmos la cadena
		String reversedStr = new StringBuilder(str).reverse().toString();

		// Comparar la cadena original con la invertida
		return str.equals(reversedStr);
	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String cadena = lector.nextLine();

		
		while (cadena != null) {
			if (!cadena.equalsIgnoreCase("fin")) {

				if (esPalindrome(cadena)) {
					System.out.println(cadena + " es palídromo");
				} else {
					System.out.println(cadena + " no es palídromo");
				}

				cadena = lector.nextLine();
			}
			else{
				System.out.println("Proceso finalizado");}
			}
		
	}
}
