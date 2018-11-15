package entidades.edificios;


import entidades.unidades.FactoryUnidades.InvalidUnidadTipoException;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

import java.awt.Point;

import static entidades.unidades.FactoryUnidades.UnidadTipo.UNIDAD_TIPO_ARMA_DE_ASEDIO;

public class Castillo extends Edificio{

    public Castillo() {
    	super(1000, new Point(4,4));
    }


    public Unidad crearAsedio() {

        Unidad asedio=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARMA_DE_ASEDIO);

        return asedio;

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }
}
