package entidades.edificios;

import entidades.unidades.Aldeano;
import entidades.unidades.Arquero;
import entidades.unidades.Espadachin;
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

        //Unidad arquero=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARQUERO);

        return (new Arquero());

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }
    public Unidad crearEspadachin() {

       // Unidad espadachin=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ESPADACHIN);

        return (new Espadachin());

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }


    public void actuar(){


    }

    public void serConstruido(Aldeano aldeano) {

    }

}
