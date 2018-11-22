package entidades.unidades;

import entidades.edificios.Castillo;



public class Arquero extends Unidad {
	private int vidaMaxima;

	public Arquero() {
		super(75, 15, 10);
		this.vidaMaxima = 75;
	}


	public int actuar(){
		return 0;
	}

}
