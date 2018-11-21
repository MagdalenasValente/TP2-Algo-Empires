package entidades.edificios;

import entidades.Entidad;
import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.InvalidUnidadTipoException;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.InvalidUnidadTipoException;
import entidades.unidades.StateAldeano.RecolectorOro;
import entidades.unidades.StateAldeano.Reparador;
import entidades.unidades.Unidad;
import java.awt.Point;

public abstract class Edificio extends Entidad {

    private int reparacion;

	public Edificio(int vida, Point tamanio, int reparacion) {
		super(vida, tamanio);
		this.reparacion = reparacion;
	}


    public void repararse(){
        this.repararVida(reparacion);
    }
	public void setVida(int vida){
	    super.setVida(vida);
    }


}
