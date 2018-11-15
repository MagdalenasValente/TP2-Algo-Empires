package entidades.edificios;


import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Castillo extends Edificio{

    private int vidaMaxima;

    public Castillo() {
    	super(1000, new Point(4,4));
    	this.vidaMaxima = 1000;
    }


    public Unidad crearAsedio() {

        Unidad asedio=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARMA_DE_ASEDIO);

        return asedio;

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }

    @Override
    public void serReparado(){
        int vidaTrasReparacion = this.vida() + 15;
        if(vidaTrasReparacion > this.vidaMaxima){
            super.setVida(vidaMaxima);
            return;
        }
        super.setVida(vidaTrasReparacion);
    }
}
