package entidades.unidades;

import entidades.edificios.Edificio;
import excepciones.NoPuedeRepararException;

public class ArmaDeAsedio extends Unidad {
	private int vidaMaxima;


	public ArmaDeAsedio() {
		super(150);
		this.vidaMaxima = 1000;
	}


	public void actuar(){

	}
}
