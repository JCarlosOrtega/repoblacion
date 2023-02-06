package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {
	private Bosque bosque;

	public static void main(String[] args) {

		int anchura = 0;
		int altura = 0;
		int poblacion = 0;
		System.out.println("Bienvenido/a a la aplicación de creación de Bosques.");
		try {
			do {
				anchura = Consola.leerAnchura();

			} while (anchura < Bosque.MINIMO || anchura > Bosque.MAX_ANCHURA);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		try {
			do {
				altura = Consola.leerAltura();

			} while (altura < Bosque.MINIMO || altura > Bosque.MAX_ALTURA);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		try {
			do {
				poblacion = Consola.leerPoblacion();

			} while (poblacion <= 0 || poblacion > (2 * (anchura + altura)));
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		Bosque bosque = new Bosque(anchura, altura, poblacion);
		System.out.println("-------------------");
		System.out.println("Árbol más cercano: " + bosque.getArbolMasCentrado());
		System.out.println("Árbol más alejado: " + bosque.getArbolMasAlejado());
		System.out.println("-------------------");

	}

}
