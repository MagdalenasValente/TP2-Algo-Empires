package entidades.unidades;

import entidades.unidades.Unidad;



public class Arquero extends Unidad {
	private int vidaMaxima;

	public Arquero() {
		super(75);
		this.vidaMaxima = 75;
	}


	public int actuar(){
		return 0;
	}

}
