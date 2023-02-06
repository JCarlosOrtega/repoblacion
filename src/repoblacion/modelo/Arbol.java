package repoblacion.modelo;

public class Arbol {

	private Posicion posicion;
	private Especie especie;
	
	public Arbol (Especie especie, Posicion posicion) {
		if (especie ==null)
			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		if (posicion==null)
			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		setEspecie(especie);
		setPosicion(posicion);
		
	}

	public Arbol (Arbol a) {
		if (a == null)
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
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
		if (especie==null)
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
		return "especie="+ getEspecie() +", posicion=(" + getPosicion()+")";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
