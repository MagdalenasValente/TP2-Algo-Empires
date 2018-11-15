package entidades.unidades;

import entidades.edificios.Edificio;
import excepciones.NoPuedeRepararException;

public class ArmaDeAsedio extends Unidad {
	private int vidaMaxima;


	public ArmaDeAsedio() {
		super(150);
		this.vidaMaxima = 1000;
	}

	public Unidad crear_unidad() {
		ArmaDeAsedio arma_de_asedio_nueva = new ArmaDeAsedio();
		/*coste en oro, poblacion etc*/
		return arma_de_asedio_nueva;
	}

	public void actuar(){

	}
}
