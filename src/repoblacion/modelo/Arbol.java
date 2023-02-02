package repoblacion.modelo;

public class Arbol {

	private Posicion posicion;
	private Especie especie;
	
	public Arbol (Posicion posicion, Especie especie) {
		
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
