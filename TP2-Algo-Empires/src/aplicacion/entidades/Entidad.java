package entidades;

import entidades.edificios.Edificio;
import entidades.unidades.Unidad;
import mapa.Mapa;

import vida.Vida;

import java.awt.Point;

public abstract class Entidad{

    private Vida vida;
	private Point tamanio;
	private Point posicion;
    private Mapa mapa;
    private int danioAUnidades;
    private int danioAEdificios;

    public Mapa getMapa(){
        return this.mapa;
    }


	public Entidad(int vida, Point tamanio, int danioAUnidades, int danioAEdificios) {
		this.vida = new Vida(vida);
		this.tamanio = tamanio;
		this.danioAUnidades = danioAUnidades;
		this.danioAEdificios = danioAEdificios;
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

    public abstract void actuar();

    public void quitarVida(int cantidad){
    	this.vida.quitarVida(cantidad);
	}

	public void atacar(Edificio edificio){
    	edificio.quitarVida(danioAEdificios);
	}

	public void atacar(Unidad unidad){
		unidad.quitarVida(danioAUnidades);
	}
}