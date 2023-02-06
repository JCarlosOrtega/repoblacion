package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;





public class Bosque {

	private Arbol[] arboles;
	
	public final static int MAX_ALTURA=500;
	public final static int MINIMO=10;
	public final static int MAX_ANCHURA=1000;
	public final int MAX_ESPECIES=4;
	
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador= new Random();
	private int ancho=0;
	private int alto=0;

	
	public Bosque(int ancho, int alto, int poblacion) {
		if (ancho < 10)
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		if (alto < 10)
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		if (poblacion <= 0)
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		setAlto(alto);
		setAncho(ancho);
		checkPoblacion(poblacion);
		arboles = new Arbol[poblacion];
		repoblar();
	}
	
	public Arbol[] duplicaBosque() {
		Arbol[] duplicaBosque = new Arbol[arboles.length];
		for (int i = 0; i < arboles.length; i++) {
			if (arboles[i] != null)
				duplicaBosque[i] = new Arbol(arboles[i]);
		}
		return duplicaBosque;
	}

	public void checkPoblacion(int poblacion) {
		if (poblacion > 2*(ancho+alto)) {
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
		
		
		
	}
	
	
	private void repoblar() {
		int[] ordenEspecies = new int[arboles.length];
		int arbolAleatorio=0;
		//0 - Alamo (2 - castaño, 3 - cipres y 6 - olivo)
		//1 - Encina, 2 - Castaño, 3 - cipres, 4 - pino, 5 - roble
		//6 - Olvido (0- Alamo y 1 - encina)
		
			for (int i=0; i < arboles.length; i++) {
				
				arbolAleatorio = generador.nextInt(0, 6);
				

				if (i > 0) {
					if (ordenEspecies[i - 1] == 0) {

						while (arbolAleatorio == 2 || arbolAleatorio == 3 || arbolAleatorio == 6) {
							arbolAleatorio = generador.nextInt(0, 6);
						}
						
					} else if (ordenEspecies[i - 1] == 6) {
						while (arbolAleatorio == 0 || arbolAleatorio == 1) {
							arbolAleatorio = generador.nextInt(0, 6);
						}
					}
				}
				//maximoEspecies(arbolAleatorio);
				ordenEspecies[i] = arbolAleatorio;
			}

			
			for (int j=0; j < arboles.length; j++) {
				switch (ordenEspecies[j]) {
				case 0:
					arboles[j]= new Arbol(Especie.ALAMO, posicionAleatoria());
					break;
				case 1:
					arboles[j]= new Arbol(Especie.ENCINA, posicionAleatoria());
					break;
				case 2:
					arboles[j]= new Arbol(Especie.CASTANO, posicionAleatoria());
					break;
				case 3:
					arboles[j]= new Arbol(Especie.CIPRES, posicionAleatoria());
					break;
				case 4:
					arboles[j]= new Arbol(Especie.PINO, posicionAleatoria());
					break;
				case 5:
					arboles[j]= new Arbol(Especie.ROBLE, posicionAleatoria());
					break;
				case 6:
					arboles[j]= new Arbol(Especie.OLIVO, posicionAleatoria());
					break;
				default:
					throw new IllegalArgumentException("Error: no se ha asignado una especie.");
					
				}

			}
				
	}

	// No estoy seguro de que me funcione, creo que se salta las restricciones
//	public int maximoEspecies(int arbol) {
//		int[] maxEspecies = new int[MAX_ESPECIES];
//		maxEspecies[0]= arbol;
//		if (maxEspecies[0] == arbol) {
//			return arbol;
//		}
//		else {
//			for (int i = 0; i < maxEspecies.length; i++) {
//			if ((maxEspecies[i] != arbol)|| (maxEspecies[i-1] != arbol)|| (maxEspecies[i-2]!= arbol) || (maxEspecies[i-3]!= arbol)) {
//			maxEspecies[i]=arbol;
//			}else {
//				arbol=generador.nextInt(0, 6);
//			}
//			
//			}
//		}
//		return arbol;
//	}

	public Posicion posicionAleatoria() {
		double posicionX= generador.nextDouble(-ancho/2, ancho/2);
		double posicionY= generador.nextDouble(-alto/2, alto/2);
		Posicion posicionAleatoria = new Posicion(posicionX, posicionY);
		
	
		
		
		return posicionAleatoria;
		
	}
		
	public void realizarCalculos() {
		Posicion centro = new Posicion(0,0);
		Posicion posicionLejos = new Posicion(1,1);
		Posicion posicionMasLejos = new Posicion(3,3);
		Posicion posicionCerca = new Posicion(10,10);
	
		for (int i=0; i< arboles.length;i++) {
			if (arboles[i].getPosicion().distancia(centro)>0) {
			 
				posicionLejos = arboles[i].getPosicion();
			
			if (posicionMasLejos.distancia(centro) < posicionLejos.distancia(centro)) {
				posicionMasLejos = posicionLejos;
				arbolMasAlejado = new Arbol(arboles[i]);
			}
			if (posicionLejos.distancia(centro) < posicionCerca.distancia(centro)) {
				posicionCerca = posicionLejos;
				arbolMasCentrado = new Arbol(arboles[i]);
			}
			}
		}
		
		
		
	}
	
	public Arbol getArbolMasAlejado() {
		realizarCalculos();
		return arbolMasAlejado;
	}
	public Arbol getArbolMasCentrado() {
		realizarCalculos();
		return arbolMasCentrado;
	}
	
	
	
	//Métodos setters and getters
	
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		if (ancho < MINIMO)
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		if (ancho > MAX_ANCHURA)
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		if (alto < MINIMO)
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		if (alto > MAX_ALTURA)
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		this.alto = alto;
	}

	@Override
	public String toString() {
		return "Bosque, ancho=" + ancho + ", alto=" + alto + ", arboles= " + Arrays.toString(arboles)+"]";
	}

	
	
}
