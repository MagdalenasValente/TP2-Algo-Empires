package entidades.unidades;

import entidades.Entidad;
import entidades.edificios.Edificio;
import excep.DireccionInvalidaException;
import excepciones.NoPuedeRepararException;
import mapa.Mapa;

import java.awt.Point;

public abstract class Unidad extends Entidad {
    private Mapa mapa;
    private Point coordenadas;

	public Unidad(int vida) {
		super(vida, new Point(1,1	));
	}
	void desplazarse(Point direccion) {
	}//se podria crear una clase direccion


	public void desplazarse(Point direccion) {
	    if(!direccionUnitariaEsValida(direccion)){
	        throw new DireccionInvalidaException();
        }
        super.getMapa().mover(this, super.verPosicion(), direccion);


	}

    public void reparar(Edificio edificio) {
        throw new NoPuedeRepararException();
    }


    private boolean direccionUnitariaEsValida(Point direccion){
	    return (-1 <= direccion.getX() && direccion.getX() <= 1 && -1 <= direccion.getY() && direccion.getY() <= 1);
    }
}
