package entidades.unidades;

import entidades.Entidad;
import entidades.edificios.Edificio;
import excepciones.DireccionInvalidaException;
import excepciones.NoPuedeRepararException;
import mapa.Mapa;

import java.awt.Point;

public abstract class Unidad extends Entidad {
    //private Mapa mapa;
    private Point coordenadas;

	public Unidad(int vida) {
		super(vida, new Point(1,1	));
	}

	public void desplazarse(Point direccion) {
	    if(!direccionUnitariaEsValida(direccion)){
	        throw new DireccionInvalidaException();
        }
        super.getMapa().mover(this, super.verPosicion(), direccion);


	}

    public void reparar(Edificio edificio) {
        throw new NoPuedeRepararException();
    }

    @Override
    public void esAtacado(int ataque,int unused){
	    boolean esta_muerto = this.vida.quitarVida(ataque);
	    if(esta_muerto){
            mapa.entidadHaMuerto(this);
        }
	    return;
    }

    private boolean direccionUnitariaEsValida(Point direccion){
	    return (-1 <= direccion.getX() && direccion.getX() <= 1 && -1 <= direccion.getY() && direccion.getY() <= 1);
    }
}
