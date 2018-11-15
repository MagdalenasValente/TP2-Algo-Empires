package entidades.edificios;

import entidades.Entidad;
import entidades.unidades.Unidad;

public abstract class Edificio extends Entidad {
	public Edificio(int vida) {
		super(vida);
	}
	public abstract Unidad reclutar_unidad(Unidad unidad);
	
}
