package entidades.unidades;

import entidades.edificios.Edificio;

import java.awt.Point;

public class Aldeano extends Unidad {
	private int vidaMaxima;


	public Aldeano() {
		super(50);
		this.vidaMaxima = 50;
	}

	public void reparar(Edificio edificio){
	    edificio.serReparado();
    }

}
