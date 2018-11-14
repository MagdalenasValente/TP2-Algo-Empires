package aplicacion;

import java.awt.Point;

public abstract class Unidad extends Entidad{

	public Unidad(int vida) {
		super(vida);
	}
	void desplazarse(Point direccion) {
	}//se podria crear una clase direccion
}
