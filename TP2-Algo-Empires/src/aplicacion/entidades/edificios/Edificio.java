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

    public void serReparado(Aldeano aldeano){
        if(this.fullVida()){
            return; // exception aca!!.
        }
        aldeano.setState(new Reparador(this));

    }

	public abstract void serConstruido(Aldeano aldeano);

    public void repararse(Aldeano aldeano){
        this.repararVida(reparacion);
        if(this.fullVida()) {
            aldeano.setState(new RecolectorOro());
        }
    }
	public void setVida(int vida){
    	/*debe ser borrado*/
	    super.setVida(vida);
    }


	public void esAtacado(int unused, int ataque){
		if(vida.quitarVida(ataque)){
			/* si da true la entidad murio */
		};
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
