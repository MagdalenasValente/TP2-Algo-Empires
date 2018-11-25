package entidades.unidades;

import entidades.Entidad;
import entidades.edificios.Edificio;
import excepciones.DireccionInvalidaException;
import excepciones.NoPuedeRepararException;
import mapa.Mapa;

import java.awt.Point;

public abstract class Unidad extends Entidad {
    private Point coordenadas;

	public Unidad(int vida, int danioAUnidades, int danioAEdificios, String nombre) {
		super(vida, new Point(1,1	), danioAUnidades, danioAEdificios, nombre);
	}

	public void desplazarse(Point direccion) {
	    if(!direccionUnitariaEsValida(direccion)){
	        throw new DireccionInvalidaException();
        }
        super.getMapa().mover(this, super.verPosicion(), direccion);


	}

    private boolean direccionUnitariaEsValida(Point direccion){
	    return (-1 <= direccion.getX() && direccion.getX() <= 1 && -1 <= direccion.getY() && direccion.getY() <= 1);
    }
}
