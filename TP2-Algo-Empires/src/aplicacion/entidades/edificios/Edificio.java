package entidades.edificios;

import entidades.Entidad;
import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.InvalidUnidadTipoException;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.Unidad;
import java.awt.Point;

public abstract class Edificio extends Entidad {
	public Edificio(int vida, Point tamanio) {
		super(vida, tamanio);
	}

	public Unidad crearAldeano(){
		throw new InvalidUnidadTipoException();
	}
	public Unidad crearAsedio(){
		throw new InvalidUnidadTipoException();
	}
	public Unidad crearArquero(){
		throw new InvalidUnidadTipoException();
	}
	public Unidad crearEspadachin(){
		throw new InvalidUnidadTipoException();
	}

}
