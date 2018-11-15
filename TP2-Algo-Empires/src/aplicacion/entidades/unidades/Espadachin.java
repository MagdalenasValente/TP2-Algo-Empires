package entidades.unidades;

import entidades.unidades.Unidad;

public class Espadachin extends Unidad {
	private int vidaMaxima;

	public Espadachin() {
		super(100);
		this.vidaMaxima = 100;
	}
	public  Unidad crear_unidad() {
		Espadachin espadachin_nuevo = new Espadachin();
		/*coste en oro, poblacion etc*/
		return espadachin_nuevo;
	}
}
