package entidades.unidades;

import java.awt.Point;

public class Aldeano extends Unidad {
	private int vidaMaxima;


	public Aldeano() {
		super(50);
		this.vidaMaxima = 50;
	}

	public  Unidad crear_unidad() {
		Aldeano aldeano_nuevo = new Aldeano();
		/*coste en oro, poblacion etc*/
		return aldeano_nuevo;
	}

}
