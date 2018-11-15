package entidades.unidades;

import entidades.unidades.Unidad;



public class Arquero extends Unidad {

	public Arquero() {
		super(75);
	}

	public  Unidad crear_unidad() {
		Arquero arquero_nuevo = new Arquero();
		/*coste en oro, poblacion etc*/
		return arquero_nuevo;
	}

}
