package entidades.edificios;

import entidades.Entidad;
import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.InvalidUnidadTipoException;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.InvalidUnidadTipoException;
import entidades.unidades.StrategyAldeano.RecolectorOro;
import entidades.unidades.StrategyAldeano.Reparador;
import entidades.unidades.Unidad;
import java.awt.Point;

public abstract class Edificio extends Entidad implements EdificioReparable{

    private int reparacion;

	public Edificio(int vida, Point tamanio, int reparacion, int danioAUnidades, int danioAEdificios, String nombre, int rango) {
		super(vida, tamanio, danioAUnidades, danioAEdificios, nombre, rango);
		this.reparacion = reparacion;
	}


	public boolean reparado(){
	    return this.fullVida();
    }
    public void repararse(){
        this.repararVida(this.reparacion);
    }
	public void setVida(int vida){
    	/*debe ser borrado*/
	    super.setVida(vida);
    }

    public void quitarVida(int cantidad){
        super.quitarVida(cantidad);
    }

}
