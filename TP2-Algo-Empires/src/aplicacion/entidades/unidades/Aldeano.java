package entidades.unidades;

import java.awt.Point;

public class Aldeano extends Unidad {

	public Aldeano() {
		super(50);
	}
	
	public  Unidad crear_unidad() {
		Aldeano aldeano_nuevo = new Aldeano();
		/*coste en oro, poblacion etc*/
		return aldeano_nuevo;
	}

}
