package repoblacion.modelo;

public enum Especie {

	ALAMO("Álamo"), ENCINA("Encina"), CASTANO("Castaño"), CIPRES("Ciprés"), PINO("Pino"), ROBLE("Roble mediterráneo"),
	OLIVO("Olivo");
	
	
	public String cadenaAMostrar;
	
	private Especie(String cadenaMostrada) {
		
		this.cadenaAMostrar = cadenaMostrada;
		
	}

	@Override
	public String toString() {
		
		return cadenaAMostrar;
	}
	
	
	
}
