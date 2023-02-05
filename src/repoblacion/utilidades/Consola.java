package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {

	}

	public static int leerAnchura() {

		System.out.println("Introduce la anchura del bosque: ");
		int ancho = Entrada.entero();

		return ancho;
	}

	public static int leerAltura() {

		System.out.println("Introduce la altura del bosque: ");
		int alto = Entrada.entero();

		return alto;
	}

	public static int leerPoblacion() {

		System.out.println("Introduce el número de la población de especies: ");
		int poblacion = Entrada.entero();

		return poblacion;
	}

}
