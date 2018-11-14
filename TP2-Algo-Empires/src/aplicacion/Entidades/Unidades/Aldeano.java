package aplicacion;

import java.awt.Point;

public class Aldeano extends Unidad{
	private int alto;
	private int ancho;

	public Aldeano() {
		super(50);
		this.ancho = 1;
		this.alto = 1;
	}

	@Override
	public Point vertamanio() {
		return new Point(this.ancho, this.alto);
	}
}
