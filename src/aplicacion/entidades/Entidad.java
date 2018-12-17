package entidades;

import entidades.edificios.Edificio;
import entidades.unidades.Unidad;
import habilidades.Habilidad;
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
	private int rango;
    private String nombre;//talvez borrar en refactor
	private int costeEnOro;

    public Mapa getMapa(){
        return this.mapa;
    }


	public Entidad(int vida, Point tamanio, int danioAUnidades, int danioAEdificios, String nombre, int rango) {
		this.vida = new Vida(vida);
		this.tamanio = tamanio;
		this.danioAUnidades = danioAUnidades;
		this.danioAEdificios = danioAEdificios;
		this.rango = rango;
		this.nombre = nombre;
		this.costeEnOro = 0;
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
    	if (this.vida.quitarVida(cantidad)){
			mapa.entidadHaMuerto(this);
		}
	}

	public void atacar(Edificio edificio){
    	edificio.quitarVida(danioAEdificios);
	}

	public void atacar(Unidad unidad){
		unidad.quitarVida(danioAUnidades);
	}

	public String getNombre(){
		return nombre;
	}

	public int getDanioAEdificios() {
		return danioAEdificios;
	}

	public int getDanioAUnidades() {
		return danioAUnidades;
	}

	public int getRango() {
		return rango;
	}

	public abstract void informacionBasica();

    protected void agregarCosteEnOro(int costeEnOros){
		this.costeEnOro = costeEnOro;
	}
	public int costo(){
    	return costeEnOro;
	}
}