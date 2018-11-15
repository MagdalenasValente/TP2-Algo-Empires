package entidades.edificios;

import entidades.Entidad;
import entidades.unidades.Unidad;
import java.awt.Point;

public abstract class Edificio extends Entidad {
	public Edificio(int vida, Point tamanio) {
		super(vida, tamanio);
	}
	public abstract Unidad reclutar_unidad(Unidad unidad);
	
}
