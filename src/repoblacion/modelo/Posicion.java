package repoblacion.modelo;

public class Posicion {

	private double x=0;
	private double y=0;
	
	public Posicion (double x, double y) {
		
		setX(x);
		setY(y);

		
	}
	public Posicion (Posicion p) {
		setX(p.getX());
		setY(p.getY());
		
	}
	
	
	
	public double distancia (Posicion posicion) {
		double distancia=0;
		if (posicion== null) {
			throw new NullPointerException("ERROR: la posicion no puede ser nula");
		}
		else 

			distancia = Math.sqrt(Math.pow(posicion.x-getX(), 2)+Math.pow(posicion.y-getY(), 2));
		
		return distancia;
		
	}
	
	
	
	
	// Métodos Setters and Getters


	
	private void setX(double x) {
		this.x = x;
	}

	private void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return Math.round(x*1000)/1000d;
	}

	public double getY() {
		return Math.round(y*1000)/1000d;
	}
	
	@Override
	public String toString() {
		return "posición=(x=" + getX() + ", y=" + getY()+")";
	}

	
}
