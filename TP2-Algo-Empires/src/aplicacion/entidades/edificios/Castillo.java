package entidades.edificios;


import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;

import entidades.unidades.Unidad;

import java.awt.Point;

public class Castillo extends Edificio{

    // se puede abstraer en un factory, o al instanciar la clase.
    public Castillo() {
    	super(1000, new Point(4,4), 15);

    }


    public Unidad crearAsedio() {

        Unidad asedio=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARMA_DE_ASEDIO);

        return asedio;

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }



    public void serConstruido(Aldeano aldeano) {

    }

    public int actuar(){
        return 0;

    }


}
