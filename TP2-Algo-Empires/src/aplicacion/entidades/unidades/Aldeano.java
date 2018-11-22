package entidades.unidades;

import entidades.edificios.Edificio;
import entidades.unidades.StateAldeano.RecolectorOro;
import entidades.unidades.StateAldeano.StateAldeano;

import java.awt.Point;

public class Aldeano extends Unidad {

	private int oro;
	private StateAldeano state;

	public Aldeano() {
		super(50, 0, 0);
		this.oro = 0;
		this.state = new RecolectorOro();
	}

	public void reparar(Edificio edificio){

		edificio.serReparado(this);
    }

	public void setState(StateAldeano state){
		this.state = state;
	}

	public void construir(Edificio edificio){

	}
    public void actuar(){
		this.oro += state.actuar( this);
	}

	public int getOro(){
		return this.oro;
	}
}
