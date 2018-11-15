package entidades.unidades;

import entidades.Entidad;

import java.awt.Point;

public abstract class Unidad extends Entidad {

	public Unidad(int vida) {
		super(vida, new Point(1,1	));
	}
	void desplazarse(Point direccion) {
	}//se podria crear una clase direccion
	public abstract Unidad crear_unidad();
}
