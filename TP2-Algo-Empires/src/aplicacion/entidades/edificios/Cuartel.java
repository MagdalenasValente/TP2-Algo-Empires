package entidades.edificios;

import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Cuartel extends Edificio {
    private int vidaMaxima;



    public Cuartel() {
        super(250, new Point(2,2),50);
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


    public int actuar(){
        return 0;

    }

    public void serConstruido(Aldeano aldeano) {

    }

}
