package repoblacion.modelo;

public class Arbol {

	private Posicion posicion;
	private Especie especie;
	
	public Arbol (Especie especie, Posicion posicion) {
		if (especie ==null)
			throw new NullPointerException();
		if (posicion==null)
			throw new NullPointerException();
		setEspecie(especie);
		setPosicion(posicion);
		
	}

	public Arbol (Arbol a) {
		setEspecie(a.getEspecie());
		setPosicion(a.getPosicion());
	}
	
	
	
	//Métodos Getters and setters
	
	
	private void setPosicion(Posicion posicion) {
		if (posicion==null)
			throw new NullPointerException("ERROR: la posición no puede ser nula");
		
		this.posicion = posicion;
	}

	private void setEspecie(Especie especie) {
		if (posicion==null)
			throw new NullPointerException("ERROR: la especie no puede ser nula");
		
		this.especie = especie;
	}


	public Posicion getPosicion() {
		return posicion;
	}

	public Especie getEspecie() {
		return especie;
	}

	@Override
	public String toString() {
		return "arbol: especie= (" + getEspecie()+") ," + getPosicion();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
