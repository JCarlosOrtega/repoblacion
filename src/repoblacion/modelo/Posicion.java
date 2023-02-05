package repoblacion.modelo;

import java.util.Objects;

public class Posicion {

	private double x=0;
	private double y=0;
	
	public Posicion (double x, double y) {
		
		setX(x);
		setY(y);

		
	}
	public Posicion (Posicion p) {
		if (p ==null) {
			throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
		}
		setX(p.getX());
		setY(p.getY());
		
	}
	
	
	
	public double distancia (Posicion posicion) {
		double distancia=0;
		if (posicion== null) {
			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
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
		x = Math.round(x)*1000/1000d;		
		return x;
	}

	public double getY() {
		y = Math.round(y)*1000/1000d;
		return y;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	@Override
	public String toString() {
		
		
		return "x=" + String.format("%.3f",getX()) + ", y=" + String.format("%.3f",getY());
	}

	
}
