package entidades.edificios;

import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Cuartel extends Edificio {
    private int vidaMaxima;
    
    public Cuartel() {
        super(250, new Point(2,2));
        this.vidaMaxima = 250;
    }


    public Unidad crearArquero() {

        Unidad arquero=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARQUERO);

        return arquero;

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }
    public Unidad crearEspadachin() {

        Unidad espadachin=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ESPADACHIN);

        return espadachin;

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }

    @Override
    public void serReparado(){
        int vidaTrasReparacion = this.vida() + 50;
        if(vidaTrasReparacion > this.vidaMaxima){
            super.setVida(vidaMaxima);
            return;
        }
        super.setVida(vidaTrasReparacion);
    }

}
