package entidades.edificios;

import Control.InformacionDeControl;
import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.edificios.StrategyEdificioConstruible.StrategyConstruible;
import entidades.edificios.StrategyEdificioConstruible.EnConstruccion;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.StrategyAldeano.RecolectorOro;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Plaza extends Edificio implements EdificioConstruible {

    private StrategyConstruible strategy;

    public Plaza() {
        super(450, new Point(2,2), 15, 0, 0, "Plaza",0);
        strategy = new EnConstruccion(this);
        this.agregarCosteEnOro(100);
    }


    // SET STRATEGY
    public void setStrategy(StrategyConstruible strategy) { this.strategy = strategy;    }

    // FIN SET STRATEGY

    // METODOS DE CONSTRUCCION

    public boolean construido() {
        return this.strategy.construido();
    }

    public void construirse(){
        this.strategy.construirse();
    }
    // FIN METODOS DE CONSTRUCCION


    // METODO CREAR UNIDAD
    public Unidad crearAldeano() {

        return this.strategy.crearUnidad(UnidadTipo.UNIDAD_TIPO_ALDEANO);


        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }

    // FIN METODO CREAR UNIDAD






    public void actuar(){

    }
    public void informacionBasica(){
        InformacionDeControl.visorDeInformacion(this);
    }
}
