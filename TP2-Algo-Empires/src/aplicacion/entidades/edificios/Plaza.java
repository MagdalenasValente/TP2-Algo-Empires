package entidades.edificios;

import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.edificios.StrategyEdificioConstruible.StrategyConstruible;
import entidades.edificios.StrategyEdificioConstruible.EnConstruccion;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.StateAldeano.RecolectorOro;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Plaza extends Edificio implements Construible {

    private StrategyConstruible strategy;

    public Plaza() {
        super(450, new Point(2,2), 15, 0, 0);
        strategy = new EnConstruccion(this);
    }

    public void construirse(){}

    public Unidad crearAldeano() {

        return this.strategy.crearUnidad(UnidadTipo.UNIDAD_TIPO_ALDEANO);


        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }

    public boolean construido() {
        return this.strategy.construido();
    }

    public void setStrategy(StrategyConstruible strategy) { this.strategy = strategy;    }




    public int actuar(){
        return 0;
    }
    
}
