package entidades.edificios;


import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.StateAldeano.RecolectorOro;
import entidades.unidades.StateAldeano.Reparador;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Castillo extends Edificio {

    // se puede abstraer en un factory, o al instanciar la clase.
    public Castillo() {
    	super(1000, new Point(4,4), 15, 20, 20);

    }


    public Unidad crearAsedio() {

        return UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARMA_DE_ASEDIO);

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }



    public void serConstruido(Aldeano aldeano) {

    }

    public void actuar(){

    }


}
