package entidades.unidades;

import java.awt.Point;

public class Aldeano extends Unidad {
	private int alto;
	private int ancho;

	public Aldeano() {
		super(50);
		this.ancho = 1;
		this.alto = 1;
	}


	public Point vertamanio() {
		return new Point(this.ancho, this.alto);
	}

	public  Unidad crear_unidad() {
		Aldeano aldeano_nuevo = new Aldeano();
		/*coste en oro, poblacion etc*/
		return aldeano_nuevo;
	}

}
