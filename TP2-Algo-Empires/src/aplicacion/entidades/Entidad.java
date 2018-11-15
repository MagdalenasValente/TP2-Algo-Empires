package entidades;

import mapa.Mapa;

import vida.Vida;

import java.awt.Point;

public abstract class Entidad{

    private Vida vida;
	private Point t6amanio;
	private Point posicion;
    private Mapa mapa;

    public Mapa getMapa(){
        return this.mapa;
    }


	public Entidad(int vida, Point tamanio) {
		this.vida = new Vida(vida);
		this.tamanio = tamanio;
	}
	public int vida() {
    	return this.vida.verVida();
    }
    public boolean fullVida(){
    	return vida.fullVida();
	}
	public Point verTamanio() {
		return this.tamanio;
	}
	public void setVida(int vida){
	    this.vida.setVida(vida);
    }

    public void repararVida(int valor){
    	this.vida.regenerarVida(valor);
	}

	public void setPosicion(Point posicion){
	    this.posicion = posicion;
    }

    public Point verPosicion(){
	    return this.posicion;
    }

    public void setMapa(Mapa mapa){
	    this.mapa = mapa;
    }

    public abstract int actuar();
}