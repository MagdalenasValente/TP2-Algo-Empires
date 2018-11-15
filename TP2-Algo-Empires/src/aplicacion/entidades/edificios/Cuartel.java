package entidades.edificios;

import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Cuartel extends Edificio {
    
    public Cuartel() {
        super(250, new Point(2,2));
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

}
