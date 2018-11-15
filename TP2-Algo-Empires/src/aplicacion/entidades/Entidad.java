package entidades;

import java.awt.Point;

public abstract class Entidad{
    private int vida;
	private Point tamanio;
	
	public Entidad(int vida, Point tamanio) {
		this.vida = vida;
		this.tamanio = tamanio;
	}
	public int vida() {
    	return this.vida;
    }
	public Point verTamanio() {
		return this.tamanio;
	}
}