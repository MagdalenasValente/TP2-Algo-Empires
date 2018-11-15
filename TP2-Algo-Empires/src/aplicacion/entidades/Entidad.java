package entidades;

import vida.Vida;

import java.awt.Point;

public abstract class Entidad{
    private Vida vida;
	private Point tamanio;
	
	public Entidad(int vida, Point tamanio) {
		this.vida = new Vida(vida);
		this.tamanio = tamanio;
	}
	public int vida() {
    	return this.vida.verVida();
    }
	public Point verTamanio() {
		return this.tamanio;
	}
	public void setVida(int vida){
	    this.vida.setVida(vida);
    }

    public abstract void actuar();
}