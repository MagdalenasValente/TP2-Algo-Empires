package aplicacion;

import java.awt.Point;

public abstract class Entidad{
    private int vida;
	private Point tamaño;
	
	public Entidad(int vida) {
		this.vida = vida;
	}
	public int vida() {
    	return this.vida;
    }
	public Point verTamaño() {
		return this.tamaño;
	}
}