package entidades.edificios;

import entidades.StrategyConstruible.Construido;
import entidades.StrategyConstruible.StrategyConstruible;
import entidades.StrategyConstruible.EnConstruccion;
import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Cuartel extends Edificio implements Construible{

    private StrategyConstruible strategy;


    public Cuartel() {
        super(250, new Point(2,2),50);
        this.strategy = new EnConstruccion(this);
    }

    public void setStrategy(StrategyConstruible strategy) { this.strategy = strategy;    }


    @Override
    public boolean construido() {
        return this.strategy.construido();
    }

    public void construirse(){
        this.strategy.construirse();
    }

    public Unidad crearArquero() {

        return this.strategy.crearUnidad(UnidadTipo.UNIDAD_TIPO_ARQUERO);


        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }
    public Unidad crearEspadachin() {

        return this.strategy.crearUnidad(UnidadTipo.UNIDAD_TIPO_ESPADACHIN);


        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }


    public void actuar(){

    }

    public void serConstruido(Aldeano aldeano) {

    }

}
