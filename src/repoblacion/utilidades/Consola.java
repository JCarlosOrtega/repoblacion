package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {

	}

	public static int leerAnchura() {

		System.out.println("Introduce una anchura para tu bosque mayor o igual que 10: ");
		int ancho = Entrada.entero();

		return ancho;
	}

	public static int leerAltura() {

		System.out.println("Introduce una altura para tu bosque mayor o igual que 10: ");
		int alto = Entrada.entero();

		return alto;
	}

	public static int leerPoblacion() {

		System.out.println("Introduce un número para población de especies que entre en tu bosque: ");
		int poblacion = Entrada.entero();

		return poblacion;
	}

}
