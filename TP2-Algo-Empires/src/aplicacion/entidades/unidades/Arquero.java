package entidades.unidades;

import entidades.unidades.Unidad;



public class Arquero extends Unidad {
	private int vidaMaxima;

	public Arquero() {
		super(75);
		this.vidaMaxima = 75;
	}

	public  Unidad crear_unidad() {
		Arquero arquero_nuevo = new Arquero();
		/*coste en oro, poblacion etc*/
		return arquero_nuevo;
	}

}
